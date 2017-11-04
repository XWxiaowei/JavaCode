package com.zcy.openapi.zoss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.zcy.openapi.ZcyOpenClient;
import com.zcy.openapi.ZcyOpenRequest;
import com.zcy.openapi.http.HttpClient;
import com.zcy.openapi.http.HttpMethod;
import com.zcy.openapi.zoss.model.*;
import com.zcy.openapi.zoss.util.JsonUtil;
import com.zcy.openapi.zoss.util.ZossUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by changle on 16/8/3.
 * 商品图片上传完毕&回传文件信息
 */
public class ZcyOssClientUtil {
    private static final Logger log = LoggerFactory.getLogger(ZcyOssClientUtil.class);
    private boolean isCheckParam = false;

    private static final String fileTokenUri = "/open/zcy.zoss.filetoken.get";
    private static final String fileInfoCallBack = "/open/zcy.zoss.filemeta.upload";
    /**
     * 商品图片上传-仅支持单个文件上传
     * */
    public ZcyResponse<String> putItemImg(ZcyItemRequest zcyOssRequest){
        if(isCheckParam){
            String checkResult = null;
            try {
                checkResult = ZossUtil.checkItemParams(zcyOssRequest);
            } catch (IOException e) {
                log.error("checked params happened IOException!",e);
                return ZcyResponse.fail("校验参数zcyOssRequest发生IO异常,请确保文件inputStream不为空并且文件大小大于1");
            }
            if(!checkResult.startsWith("success")){
                return ZcyResponse.fail(checkResult);
            }
        }
        //1.请求zcy-oss-stsToken
        String zcyStsTokenInfo = null;
        try {
            zcyStsTokenInfo = getZcyItemOssToken(1,zcyOssRequest);
        } catch (Exception e) {
            log.error("request zcy-sts-tokens error!",e);
            return ZcyResponse.fail("获取Zcy-sts-tokens失败!");
        }
        //2.上传文件至OSS,OSS上传成功会将IO关闭
        ZcyResponse<String> response = putOne(zcyOssRequest.getFileInfo(),zcyStsTokenInfo);
        if(response.isSuccess()){
            //3.上传文件成功,回传附件信息至ZCY
            String fileId = response.getResult();
            String filePath = fileId.substring(0,fileId.lastIndexOf("/"));
            try {
                String callBackResp = callBackDcApi(zcyOssRequest,response.getResult(),filePath);
                JSONObject jsonObject = JSONObject.fromObject(callBackResp);
                if(null==jsonObject.get(CommonStaticParams.data_response)){
                    if(null!=jsonObject.get(CommonStaticParams.error_response)){
                        //业务返回异常
                        JSONObject errorResponse = (JSONObject)jsonObject.get(CommonStaticParams.error_response);
                        return ZcyResponse.fail("upload Item file failed! detail Result:"+errorResponse.toString());
                    }
                    if(null!=jsonObject.get(CommonStaticParams.errorMessage)){
                        //开放平台返回异常
                        String errorMessage = jsonObject.get(CommonStaticParams.errorMessage).toString();
                        return ZcyResponse.fail("upload zItem file failed!"+errorMessage);
                    }
                }
                JSONObject dataResponse = (JSONObject)jsonObject.get(CommonStaticParams.data_response);
                if("false".equals(dataResponse.get(CommonStaticParams.success).toString())){
                    return ZcyResponse.fail("upload zcy item-img file failed!"+dataResponse.getString(CommonStaticParams.error));
                }
            } catch (Exception e) {
                log.error("request callback fileInfo error!", e);
                return ZcyResponse.fail("callback fileInfo error!");
            }
        }
        return response;
    }

    private ZcyResponse<String[]> putMore(ZcyItemRequest zcyOssRequest){
        //1.请求zcy-oss-stsToken
        String zcyStsTokenInfo = null;
        try {
            zcyStsTokenInfo = getZcyItemOssToken(1, zcyOssRequest);
        } catch (Exception e) {
            log.error("request zcy-sts-tokens error!", e);
            return ZcyResponse.fail("获取Zcy-sts-tokens失败!");
        }

        //2.上传文件至OSS
        ZcyResponse<String[]> response = putMore(new FileInfo[]{zcyOssRequest.getFileInfo()}, zcyStsTokenInfo);
        //3.回传附件信息至ZCY
        String[] fileIds = response.getResult();
        String fileId = fileIds[0];
        String filePath = fileId.substring(0,fileId.lastIndexOf("/"));
        try {
            callBackDcApi(zcyOssRequest,fileId,filePath);
        } catch (Exception e) {
            log.error("request zcy-sts-tokens error!", e);
            return ZcyResponse.fail("获取Zcy-sts-tokens失败!");
        }
        return response;
    }

    private OSSClient initClient(CredentialsEx credentialsEx) {
        OSSClient client = new OSSClient(credentialsEx.getEndPoint(), credentialsEx.getAccessKeyId(),
                credentialsEx.getAccessKeySecret(),credentialsEx.getSecurityToken());
        return client;
    }

    private String getZcyItemOssToken(int fileNum,ZcyItemRequest zcyOssRequest) throws Exception {
        String zcyStsTokenInfo = null;
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("quatity", ""+fileNum);
        bodyMap.put("_data_", jsonObject.toString());

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(zcyOssRequest.getAppKey(),zcyOssRequest.getAppSecret(),zcyOssRequest.getGateWay());
        zcyOpenRequest.setMethod(HttpMethod.POST);
        zcyOpenRequest.setUri(fileTokenUri);
        zcyOpenRequest.setParamMap(bodyMap);

        String resp = ZcyOpenClient.excute(zcyOpenRequest);
        //解析返回报文
        String[] respes = resp.split("\n");
        zcyStsTokenInfo = respes[respes.length-1];//默认取最后一行数据
        return zcyStsTokenInfo;
    }

    private String callBackDcApi(ZcyItemRequest request,String id,String path) throws Exception {
        String callBackInfo = null;
        SimpleDateFormat dateFormater= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        //构建回传报文
        List<DocumentMetaEntity> ens = new ArrayList<DocumentMetaEntity>();//预留:支持扩展多文件信息上传.
        DocumentMetaEntity documentMetaEntity = new DocumentMetaEntity();

        FileInfo fileInfo = request.getFileInfo();
        documentMetaEntity.setId(id);
        documentMetaEntity.setDescription(fileInfo.getDescription());
        documentMetaEntity.setFileName(fileInfo.getFileName());
        documentMetaEntity.setPath(path);
        documentMetaEntity.setSize(fileInfo.getSize());
        documentMetaEntity.setUploadTime(dateFormater.format(new Date()));
        documentMetaEntity.setType(fileInfo.getFileContentType());
        if(fileInfo.getUserId()!=null){
            String[] dirs = path.split("/");
            String userId =dirs[dirs.length-1];
            documentMetaEntity.setUserId(Long.valueOf(userId));
        }
        ens.add(documentMetaEntity);

        jsonObject.put("documentMetas",ens);
        bodyMap.put("_data_", jsonObject.toString());

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(request.getAppKey(),request.getAppSecret(),request.getGateWay());
        zcyOpenRequest.setMethod(HttpMethod.POST);
        zcyOpenRequest.setUri(fileInfoCallBack);
        zcyOpenRequest.setParamMap(bodyMap);

        String resp = ZcyOpenClient.excute(zcyOpenRequest);
        //解析返回报文
        String[] respes = resp.split("\n");
        callBackInfo = respes[respes.length-1];//默认取最后一行数据
        return callBackInfo;
    }

    /**
     * @param fileInfo 文件信息,包含输入流
     * */
    private ZcyResponse<String> putOne(FileInfo fileInfo,String zcyTokens) {
        return putObject(zcyTokens,false,ZcyResponse.class,fileInfo);
    }


    private ZcyResponse<String[]> putMore(FileInfo[] fileInfos,String zcyTokens) {
        return putObject(zcyTokens,true,ZcyResponse.class,fileInfos);
    }

    private ZcyResponse<String> putOne(FileInfo fileInfo,CredentialsEx credentialsEx,OSSClient client) {
        ZcyResponse<String> response;
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentLength(fileInfo.getInputStream().available());
            meta.setContentType(fileInfo.getFileContentType());
            //get file suffix
            String fileName = fileInfo.getFileName();
            String suffix;
            if(fileName.lastIndexOf(".")>-1) {
                suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            }else{
                suffix = "";
            }
            credentialsEx.getData()[0]=credentialsEx.getData()[0]+suffix;
            PutObjectResult result = client.putObject(credentialsEx.getBucket(), credentialsEx.getData()[0], fileInfo.getInputStream(), meta);
            if(result==null||result.getETag()==null){
                log.warn("OSS putObject() return result is null or eTag is null,fileId:{}",credentialsEx.getData()[0]);
            }
            response = ZcyResponse.ok(credentialsEx.getData()[0]);
            return response;
        } catch (IOException e) {
            log.error("put Object file to OSS {} failed,IOException,", e);
            response = ZcyResponse.fail("上传文件发生IOException异常");
        }
        return response;
    }


    private ZcyResponse<String[]> putMore(FileInfo[] fileInfos,CredentialsEx credentialsEx,OSSClient client) {
        ZcyResponse<String[]> response;
        try {
            String[] fileNams = new String[credentialsEx.getData().length];
            for(int i=0; i<credentialsEx.getData().length; i++){
                ObjectMetadata meta = new ObjectMetadata();
                meta.setContentLength(fileInfos[i].getInputStream().available());
                meta.setContentType(fileInfos[i].getFileContentType());
                PutObjectResult result = client.putObject(credentialsEx.getBucket(), credentialsEx.getData()[i], fileInfos[i].getInputStream(), meta);
                if(result==null||result.getETag()==null){
                    log.warn("OSS putObject() return result is null or eTag is null,fileId:{}",credentialsEx.getData()[i]);
                }
                fileNams[i] = credentialsEx.getData()[i];
            }
            response = ZcyResponse.ok(fileNams);
            return response;
        } catch (IOException e) {
            log.error("put Object file to OSS {} failed,IOException,", e);
            response = ZcyResponse.fail("上传文件发生IOException异常");
        }
        return response;
    }

    private <T> T putObject(String zcyTokens,Boolean moreFlag,Class<T> clazz,FileInfo... fileInfos) {
        T resp = null;
        OSSClient client = null;
        try {
            CredentialsEx credentialsEx = buildCre(zcyTokens);

            if(!ZossUtil.checkValidToken(credentialsEx)){
                return (T)ZcyResponse.fail("OSS Token为空或解析出错!");
            }
            client = initClient(credentialsEx);
            if(moreFlag){
                resp = (T) putMore(fileInfos,credentialsEx,client);
            }else{
                resp = (T) putOne(fileInfos[0],credentialsEx,client);
            }
            return resp;
        } catch (OSSException oe) {
            log.error("OSS upload failed! Error Message:{} Error Code:{} Request ID:{} Host ID:{}",
                    oe.getErrorMessage(), oe.getErrorCode(), oe.getRequestId(), oe.getHostId(), oe);
            resp = (T) ZcyResponse.fail("上传文件发生OSSException异常");
        } catch (ClientException ce) {
            log.error("OSS client creating failed! Error Message:{} Error Code:{},requestId:{}",
                    ce.getErrorMessage(), ce.getErrorCode(), ce.getRequestId(), ce);
            resp = (T) ZcyResponse.fail("上传文件发生ClientException异常");
        } catch (Exception e) {
            log.error("put Object file to OSS {} failed,Exception", e);
            resp = (T) ZcyResponse.fail("上传文件发生Exception异常");
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
        return resp;
    }

    private CredentialsEx buildCre(String zcyTokens){
        JSONObject jsonObject = JSONObject.fromObject(zcyTokens);
        CredentialsEx credentialsEx = null;
        if(jsonObject.get(CommonStaticParams.data_response)!=null){
            credentialsEx = JsonUtil.JSON_NON_DEFAULT_MAPPER.fromJson(((JSONObject)jsonObject.get(CommonStaticParams.data_response)).get(CommonStaticParams.result).toString(),CredentialsEx.class);
        }
        return credentialsEx;
    }


    private boolean checkFileIsExist(OSSClient client,String bucket,String key){
        try{
            OSSObject ossObject = client.getObject(bucket, key);
            if(ossObject!=null){
                return true;
            }
           return false;
        }catch(OSSException e){
            return false;//不存在一定会抛错
        }
    }

    private static class HttpClientHolder{
        private static final HttpClient INSTANCE = new HttpClient();
    }

    public static HttpClient getHttpClient(){
        return HttpClientHolder.INSTANCE;
    }

    public boolean isCheckParam() {
        return isCheckParam;
    }

    public void setIsCheckParam(boolean isCheckParam) {
        this.isCheckParam = isCheckParam;
    }

}

package com.zcy.openapi.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ServiceException;
import com.zcy.openapi.ZcyOpenClient;
import com.zcy.openapi.ZcyOpenRequest;
import com.zcy.openapi.constant.ZcyConstant;
import com.zcy.openapi.http.HttpMethod;
import com.zcy.openapi.service.ZcyGoodService;
import com.zcy.openapi.zoss.ZcyOssClientUtil;
import com.zcy.openapi.zoss.model.FileContentType;
import com.zcy.openapi.zoss.model.FileInfo;
import com.zcy.openapi.zoss.model.ZcyItemRequest;
import com.zcy.openapi.zoss.model.ZcyResponse;
import model.Attrs;
import model.RequestData;
import model.Sku;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author xiang.wei
 * @create 2017/11/2 9:31
 */
public class ZcyGoodServiceImpl implements ZcyGoodService {
    private Logger log = Logger.getLogger("order_log");
    private static final ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(
            ZcyConstant.getAppKey(), ZcyConstant.getSecret(), ZcyConstant.getApiGateway());

    @Override
    public List<Attrs> getCategoryAttrs(String categoryId) throws ServiceException {
        List<Attrs> attrList = new ArrayList<Attrs>();
        if (StringUtils.isBlank(categoryId)) {
            log.info("参数categoryId为空");
            return null;
        }
        try {
            zcyOpenRequest.setUri(ZcyConstant.getGetAttrsUrl());
            zcyOpenRequest.setMethod(HttpMethod.POST);
            Map<String, Object> bodyMap = new HashMap<String, Object>();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("categoryId", categoryId);
            bodyMap.put("_data_", jsonObject.toString());
            zcyOpenRequest.setParamMap(bodyMap);
            log.info("政采云查询类目属性接口请求参数为={}"+jsonObject.toString());
            /*发送http request*/
            String result = ZcyOpenClient.excute(zcyOpenRequest);
            log.info("政采云查询类目属性接口返回结果为={}"+result);
            JSONObject resultJson = JSONObject.parseObject(result);
            //接口返回错误
            if (StringUtils.isNotBlank(resultJson.getString("error_response"))) {
                log.error("政采云查询类目属性接口返回错误={}"+resultJson.getString("resultMsg"));
                return null;
            }
            attrList = JSON.parseArray(resultJson.getString("data_response"), Attrs.class);
            if (CollectionUtils.isEmpty(attrList)) {
                return null;
            }
            //只返回必填属性
            Iterator iterator = attrList.iterator();
            while (iterator.hasNext()) {
                Attrs attrs = (Attrs) iterator.next();
                if (!attrs.getAttrMetas().isRequired()) {
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            log.error("ZcyGoodServiceImpl getCategoryAttrs调用政采云查询类目属性接口出错={}"+e.getMessage());
            return null;
        }
        return attrList;
    }

    @Override
    public boolean saveZcyGoodItem(RequestData requestData) throws ServiceException {

        return false;
    }

    @Override
    public String uploadZcyGoodItem(RequestData requestData) throws ServiceException {
         /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        String result = null;
        try {
            jsonObject.put("data", JSON.toJSONString(requestData).replace("\\\"", "'"));
            zcyOpenRequest.setUri(ZcyConstant.getAddGoodsUrl());
            zcyOpenRequest.setMethod(HttpMethod.POST);
            bodyMap.put("_data_", jsonObject.toString());
            log.info("政采云创建商品接口请求参数为={}"+jsonObject.toString());
            zcyOpenRequest.setParamMap(bodyMap);
            result = ZcyOpenClient.excute(zcyOpenRequest);
            log.info("政采云创建商品接口返回为={}"+result);
            JSONObject resultJson = JSON.parseObject(result);
            Boolean success = resultJson.getBoolean("success");
            if (success != null && success) {
                return "success";
            } else {
                return resultJson.getString("error");
            }
        } catch (Exception e) {
            log.info("调用政采云创建商品接口出错"+e.getMessage());
            return "调用接口出错";
        }
    }

    @Override
    public boolean uploadZcyGoodImage(String imagePath, FileInfo fileInfo) throws ServiceException, IOException {
        ZcyOssClientUtil zcyOssClientUtil = new ZcyOssClientUtil();
        ZcyItemRequest zcyOssRequest = new ZcyItemRequest(ZcyConstant.getAppKey(), ZcyConstant.getSecret(), ZcyConstant.getApiGateway());
        //返回结果
        JSONObject result = new JSONObject();
        InputStream fileInputStream = null;
        //文件输入流
        try {
            File file = new File(imagePath);
            fileInputStream = new FileInputStream(file);
            //构建文件信息1
            fileInfo.setFileContentType(FileContentType.image_jpg.getContentType());
            fileInfo.setInputStream(fileInputStream);
            fileInfo.setSize(Long.valueOf(fileInputStream.available()));
            zcyOssRequest.setFileInfo(fileInfo);
            log.info("上传图片请求参数:"+JSON.toJSONString(zcyOssRequest));
            //顺利执行完毕,OSS会自动关闭InputStream,但为了防止异常情况下IO未能及时关闭,请用户自行实现IO资源关闭.
            ZcyResponse<String> response = zcyOssClientUtil.putItemImg(zcyOssRequest);
            result.put("response:", response);
            log.info("上传图片返回参数为："+result.toString());
        } catch (IOException e) {
            log.error("调用图片上传接口出现异常={}"+e.getMessage());
            return false;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
        return false;
    }

    @Override
    public boolean uploadShopImage(String imagePath) throws ServiceException {
        return false;
    }

    @Override
    public boolean updateZcyGoodItem(RequestData requestData) throws ServiceException {
        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        //TODO  必填参数校验
        String result = null;
        try {
            jsonObject.put("data", JSON.toJSONString(requestData).replace("\\\"", "'"));
            zcyOpenRequest.setUri(ZcyConstant.getUpdateGoodsUrl());
            zcyOpenRequest.setMethod(HttpMethod.POST);
            bodyMap.put("_data_", jsonObject.toString());
            log.info("政采云更新商品接口请求参数为={}"+jsonObject.toString());
            zcyOpenRequest.setParamMap(bodyMap);
            result = ZcyOpenClient.excute(zcyOpenRequest);
            log.info("政采云更新商品接口返回为={}"+result);
            JSONObject resultJson = JSON.parseObject(result);
            //成功标识
            Boolean success = resultJson.getBoolean("success");
            if (success != null && success) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.info("调用政采云更新商品接口出错"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateZcySku(List<Sku> skus) throws ServiceException {
        //TODO  必填参数校验
        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        String result = null;
        try {
            jsonObject.put("data", skus);
            zcyOpenRequest.setUri(ZcyConstant.getUpdateStockUrl());
            zcyOpenRequest.setMethod(HttpMethod.POST);
            bodyMap.put("_data_", jsonObject.toString());
            log.info("政采云更新库存接口请求参数为={}"+jsonObject.toString());
            zcyOpenRequest.setParamMap(bodyMap);
            result = ZcyOpenClient.excute(zcyOpenRequest);
            log.info("政采云更新库存接口返回为={}"+result);
            JSONObject resultJson = JSON.parseObject(result);
            Boolean success = resultJson.getBoolean("success");
            if (success != null && success) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.info("调用政采云更新库存接口出错"+e.getMessage());
            return false;
        }
    }
}

package com.zcy.openapi;

import com.zcy.openapi.http.HttpMethod;
import com.zcy.openapi.zoss.ZcyOssClientUtil;
import com.zcy.openapi.zoss.model.*;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 * @Desc 政采云上传商品图片/上传附件调用demo
 * 简介:
 *    政采云上传商品图片文件使用阿里云OSS作为存储服务
 *    为了简化用户对接阿里云OSS上传文件流程
 *    在此针对 上传商品图片功能,提供简化版接入demo
 *
 */
public class ZossFileUploadDemo {
    private static final String API_GATEWAY = "http://121.196.217.18:9002/";
    private static final String SECRET  = "F4Cbc4nnKMJg";
    private static final String APP_KEY = "354232";

    public static void main(String[] args) throws Exception {
        doPutItemImgOne();//上传商品图片,返回值:商品图片id
        //doPostMutipart();//上传政采云附件,返回值:附件图片id
    }

    /**
     * 上传商品图片demo
     * 上传商品图片依赖阿里云OSS SDK,为了简化用户调用封装
     * */
    public static void doPutItemImgOne() throws IOException {
        ZcyOssClientUtil zcyOssClientUtil = new ZcyOssClientUtil();
        ZcyItemRequest zcyOssRequest = new ZcyItemRequest(APP_KEY,SECRET,API_GATEWAY);
        //文件输入流
        File file = new File("/var/tmp/mytest.png");
        InputStream fileInputStream = new FileInputStream(file);
        //构建文件信息1
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName("测试文件Name.png");
        fileInfo.setFileContentType(FileContentType.image_png.getContentType());
        fileInfo.setInputStream(fileInputStream);
        fileInfo.setSize(Long.valueOf(fileInputStream.available()));
        fileInfo.setDescription("测试文件");

        zcyOssRequest.setFileInfo(fileInfo);
        //顺利执行完毕,OSS会自动关闭InputStream,但为了防止异常情况下IO未能及时关闭,请用户自行实现IO资源关闭.
        ZcyResponse<String> response = zcyOssClientUtil.putItemImg(zcyOssRequest);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("response:", response);
        System.out.println(jsonObject.toString());
    }

    /**
     * 上传附件调用demo
     * */
    private static void doPostMutipart() throws Exception {
        String uri = "/open/zcy.zoss.file.upload";//上传附件

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY,SECRET,API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST_MUTIPART);

        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        org.json.JSONObject jsonObject = new org.json.JSONObject();
        jsonObject.put("fileName", "redis使用范例.png");
        jsonObject.put("bizCode", ZcyOssBusiEnum.Others.getBusiCode());//附件类型:必须在可选枚举值内,传入其它值将上传失败
        jsonObject.put("type","application/octet-stream");
        jsonObject.put("description","redis使用范例.png");
        bodyMap.put("_data_", jsonObject.toString());

        zcyOpenRequest.setParamMap(bodyMap);

        /*构建文件输入流,POST_MUTIPART方式上传文件,文件输入流必填*/
        File file = new File("/var/tmp/redis使用范例.png");
        InputStream fileInputStream = new FileInputStream(file);

        zcyOpenRequest.setInputStream(fileInputStream);

        /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);

        /*打印返回结果*/
        System.out.println(result);
    }
}

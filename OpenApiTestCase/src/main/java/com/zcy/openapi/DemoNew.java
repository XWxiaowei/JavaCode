package com.zcy.openapi;


import com.alibaba.fastjson.JSONObject;
import com.zcy.openapi.http.HttpMethod;
import com.zcy.openapi.zoss.model.ZcyOssBusiEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 *   政采云开放平台api调用demo
 *   新版本:政采云推荐您使用本调用方式
 * update on 20160920
 */
public class DemoNew {
    private static final String API_GATEWAY = "xxxx";
    private static final String SECRET = "xxx";
    private static final String APP_KEY = "xxxx";

    public static void main(String[] args) throws Exception {
//        doGet();
//        doPost();
        //doPostBinary();
//        doPostMutipart();
        doPostCatalog();
    }
    private static void doGet() throws Exception {
        String uri = "/test/category.back.tree?root=0&depth=3";

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY,SECRET,API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.GET);
        /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);
        /*打印返回结果*/
        System.out.println(result);
    }

    private static void doPostCatalog() throws Exception {
        String uri = "/open/zcy.category.attrs.get";
        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY, SECRET, API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST);
        /*组装body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryId", 992);
        bodyMap.put("_data_", jsonObject.toString());
        zcyOpenRequest.setParamMap(bodyMap);
          /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);
        System.out.println(result);

    }

    private static void doPost() throws Exception {
        String uri = "/test/category.back.tree";

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY,SECRET,API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST);

        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("root", 0);
        jsonObject.put("depth",1);
        bodyMap.put("_data_", jsonObject.toString());
        zcyOpenRequest.setParamMap(bodyMap);

        /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);

        /*打印返回结果*/
        System.out.println(result);
    }

    private static void doPostBinary() throws Exception {
        String uri = "/test/category.back.tree";

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY,SECRET,API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST_BINARY);
        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("root", 0);
        jsonObject.put("depth", 1);
        bodyMap.put("_data_", jsonObject.toString());

        zcyOpenRequest.setParamMap(bodyMap);

        /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);

        /*打印返回结果*/
        System.out.println(result);
    }

    private static void doPostMutipart() throws Exception {
        String uri = "/open/zcy.zoss.file.upload";//上传附件

        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY,SECRET,API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST_MUTIPART);

        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileName", "redis使用范例.png");
        jsonObject.put("bizCode", ZcyOssBusiEnum.Others.getBusiCode());//附件类型:必须在可选枚举值内,传入其它值将上传失败
        jsonObject.put("type","application/octet-stream");
        jsonObject.put("description","redis使用范例.png");
        bodyMap.put("_data_", jsonObject.toString());

        zcyOpenRequest.setParamMap(bodyMap);

        /*构建文件输入流,POST_MUTIPART方式上传文件,文件输入流必填*/
        File file = new File("D:\\usr\\redis使用范例.png");
        InputStream fileInputStream = new FileInputStream(file);

        zcyOpenRequest.setInputStream(fileInputStream);

        /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);

        /*打印返回结果*/
        System.out.println(result);
    }

}

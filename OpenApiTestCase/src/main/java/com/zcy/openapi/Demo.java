package com.zcy.openapi;

import com.zcy.openapi.auth.ShaHmac256;
import com.zcy.openapi.auth.Signer;
import com.zcy.openapi.http.HttpClient;
import com.zcy.openapi.util.Md5Util;
import com.zcy.openapi.util.SignUtil;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 * @Deprecated
 * 老版本调用方式
 * 政采云推荐您使用DemoNew.java中新版本的调用方式
 * * update on 20160920
 */
@Deprecated
public class Demo {
    private static final String API_GATEWAY = "http://121.196.217.18:9002";
    private static final String SECRET  = "F4Cbc4nnKMJg";
    private static final String APP_KEY = "354232";


    public static void main(String[] args) throws Exception {
        //doGet();
        doPost();
        //doPostBinary();
    }

    private static void doGet() throws Exception {
        String uri = "/test/category.back.tree?root=0&depth=3";

        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", APP_KEY);
        headers.put("X-Ca-Format", "json2");

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(uri, headers, null, "GET");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(SECRET, stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpGet(API_GATEWAY + uri, "utf-8", headers);

        /*打印返回结果*/
        System.out.println(result);
    }

    private static void doPost() throws Exception {
        String uri = "/test/category.back.tree";

        /*组装Body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("root", 0);
        jsonObject.put("depth", 3);
        bodyMap.put("_data_", jsonObject.toString());

        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", APP_KEY);
        headers.put("X-Ca-Format", "json2");

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(uri, headers, bodyMap, "POST");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(SECRET, stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpPost(API_GATEWAY + uri, "utf-8", headers, bodyMap);

        /*打印返回结果*/
        System.out.println(result);
    }

    private static void doPostBinary() throws Exception {
        String uri = "/test/category.back.tree";

        /*组装Body参数*/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("root", 0);
        jsonObject.put("depth", 3);
        String body = "_data_" + jsonObject.toString();

        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/octet-stream; charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", APP_KEY);
        headers.put("X-Ca-Format", "json2");

        /*Content-MD5是指Body的MD5值，只有当Body为Stream时才计算MD5*/
        headers.put("Content-MD5", Md5Util.md5(body));

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(uri, headers, null, "POST");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(SECRET, stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpPost(API_GATEWAY + uri, "utf-8", headers, body);

        /*打印返回结果*/
        System.out.println(result);
    }
}

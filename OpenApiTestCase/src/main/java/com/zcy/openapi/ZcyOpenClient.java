package com.zcy.openapi;

import com.zcy.openapi.auth.ShaHmac256;
import com.zcy.openapi.auth.Signer;
import com.zcy.openapi.http.HttpClient;
import com.zcy.openapi.util.Md5Util;
import com.zcy.openapi.util.SignUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 *  政采云开放平台客户端
 */
public class ZcyOpenClient {
    public static String excute(ZcyOpenRequest zcyOpenRequest) throws Exception {
        switch (zcyOpenRequest.getMethod()) {
            case GET:
                return doGet(zcyOpenRequest);
            case POST:
                return doPost(zcyOpenRequest);
            case POST_MUTIPART:
                return doPostMutipart(zcyOpenRequest);
            case POST_BINARY:
                return doPostBinary(zcyOpenRequest);
            default:
                throw new IllegalArgumentException(String.format("unsupported method:%s", zcyOpenRequest.getMethod()));
        }
    }
    private static String doGet(ZcyOpenRequest zcyOpenRequest) throws Exception {
        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", zcyOpenRequest.getAppKey());
        headers.put("X-Ca-Format", "json2");

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(zcyOpenRequest.getUri(), headers, null, "GET");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(zcyOpenRequest.getAppSecret(), stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpGet(zcyOpenRequest.getGateWay() + zcyOpenRequest.getUri(), "utf-8", headers);

        return result;
    }

    private static String doPost(ZcyOpenRequest zcyOpenRequest) throws Exception {
        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", zcyOpenRequest.getAppKey());
        headers.put("X-Ca-Format", "json2");

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(zcyOpenRequest.getUri(), headers, zcyOpenRequest.getParamMap(), "POST");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(zcyOpenRequest.getAppSecret(), stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpPost(zcyOpenRequest.getGateWay() + zcyOpenRequest.getUri(), "utf-8", headers, zcyOpenRequest.getParamMap());

        return result;
    }

    private static String doPostBinary(ZcyOpenRequest zcyOpenRequest) throws Exception {
        String body = "_data_" + zcyOpenRequest.getParamMap().get("_data_");

        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/octet-stream; charset=utf-8");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", zcyOpenRequest.getAppKey());
        headers.put("X-Ca-Format", "json2");

        /*Content-MD5是指Body的MD5值，只有当Body为Stream时才计算MD5*/
        headers.put("Content-MD5", Md5Util.md5(body));

        /*组织参与签名的字符串。
          组织过程中有将"X-Ca-Signature-Headers设置到header中"*/
        String stringToSign = SignUtil.buildStringToSign(zcyOpenRequest.getUri(), headers, null, "POST");

        /*HmacSHA256签名*/
        Signer signer = new ShaHmac256();
        String signature = signer.sign(zcyOpenRequest.getAppSecret(), stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);

        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpPost(zcyOpenRequest.getGateWay() + zcyOpenRequest.getUri(), "utf-8", headers, body);

        return result;
    }

    public static String doPostMutipart(ZcyOpenRequest request) throws Exception {
        /*组装系统级Header Key-Value*/
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "multipart/form-data; charset=utf-8;");
        headers.put("Accept", "application/json");
        headers.put("X-Ca-Timestamp", String.valueOf(new Date().getTime()));
        headers.put("X-Ca-Key", request.getAppKey());
        headers.put("X-Ca-Format", "json2");

        String stringToSign = SignUtil.buildStringToSign(request.getUri(), headers, request.getParamMap(), "POST");

        Signer signer = new ShaHmac256();
        String signature = signer.sign(request.getAppSecret(), stringToSign, "utf-8");

        /*将签名设置到header中*/
        headers.put("X-Ca-Signature", signature);
        HttpClient httpClient = new HttpClient();
        httpClient.setAllowedRetry(false);
        httpClient.setConnTimeOutMilSeconds(30000);
        httpClient.setTimeOutMilSeconds(30000);
        httpClient.start();

        /*发送http request*/
        String result = httpClient.httpPost(request.getGateWay() + request.getUri(), "utf-8", headers,
                request.getParamMap(),request.getInputStream(),"docFileName");
        return result;
    }
}

package com.zcy.openapi;

import com.zcy.openapi.http.HttpMethod;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 * 政采云开放平台调用统一request
 */
public class ZcyOpenRequest {
    private static final long serialVersionUID = -7520298658714618L;
    /**
     * 必传:由政采云开放平台分配的appKey
     * */
    private String appKey;
    /**
     * 必传:由政采云开放平台分配appKey对应密钥
     * */
    private String appSecret;
    /**
     * 必传:政采云开放平台网关地址,有线上和demo测试环境之分.
     * */
    private String gateWay;
    /**
     * 必传:请求资源路径,请带上请求 namespace,比如:命名空间=open,资源路径=category.back.tree
     * 示例值:"/open/category.back.tree"
     * 如果method=GET,请将参数拼接在该uri后,如下值:
     * GET请求方式,示例值:"/open/category.back.tree?pageNum=1&userId=101"
     * */
    private String uri;

    /**
     * 发起Http Request请求方式
     * 必传:请求使用何种方式,目前可选POST,GET,POST_MUTIPART,POST_BINARY
     * */
    private HttpMethod method;

    /**
     * 请求资源需要传递的业务参数串,Map<String,Object>
     *  固定模式:存放两个键值对
     *  <"_data_","业务参数键值对json串化">
     *  Method=GET时,该值请传空
     * */
    private Map<String,Object> paramMap;

    /**
     * 附件IO输入流
     * Method=POST_MUTIPART 时,必传
     * */
    private InputStream inputStream;


    public ZcyOpenRequest(){

    }

    public ZcyOpenRequest(String appKey, String appSecret, String gateWay){
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.gateWay = gateWay;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getGateWay() {
        return gateWay;
    }

    public void setGateWay(String gateWay) {
        this.gateWay = gateWay;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

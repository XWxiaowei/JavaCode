package com.zcy.openapi.zoss.model;

import java.io.Serializable;

/**
 * Created by changle on 16/8/5.
 * 上传商品图片请求request
 */
public class ZcyItemRequest implements Serializable{
    private static final long serialVersionUID = -759852013658714618L;

    private String appKey;//必传:由政采云开放平台分配的appKey

    private String appSecret;//必传:由政采云开放平台分配appKey对应密钥

    private String gateWay;//必传:政采云开放平台网关地址,有线上和demo测试环境之分.

    private FileInfo fileInfo;//必传:上传文件信息

    public ZcyItemRequest(){

    }

    public ZcyItemRequest(String appKey, String appSecret, String gateWay){
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.gateWay = gateWay;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
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

}

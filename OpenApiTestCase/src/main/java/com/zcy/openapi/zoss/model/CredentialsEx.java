package com.zcy.openapi.zoss.model;

import java.io.Serializable;

/**
 * Created by changle on 16/8/3.
 */
public class CredentialsEx implements Serializable {

    private static final long serialVersionUID = -759890833658714618L;

    private String securityToken;

    private String accessKeySecret;

    private String accessKeyId;

    private String expiration;

    private String bucket;

    private String[] data;

    private String endPoint = "http://oss-cn-hangzhou.aliyuncs.com";

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}

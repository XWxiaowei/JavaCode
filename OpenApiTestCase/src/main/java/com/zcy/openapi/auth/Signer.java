package com.zcy.openapi.auth;

public interface Signer {
    /**
     * 
     * @param secret，签名密钥
     * @param source，参与签名的字符串
     * @param chartset，字符编码格式
     * @return
     */
    public String sign(String secret, String source, String chartset);
}

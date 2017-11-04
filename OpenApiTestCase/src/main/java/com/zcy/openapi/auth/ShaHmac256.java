package com.zcy.openapi.auth;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class ShaHmac256 implements Signer {
    private static final String HMAC_SHA256 = "HmacSHA256";

    @Override
    public String sign(String secret, String source, String chartset) {
        try {
            Mac hmacSha256 = Mac.getInstance(HMAC_SHA256);
            byte[] keyBytes = secret.getBytes(chartset);
            hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, HMAC_SHA256));

            return new String(Base64.encodeBase64(hmacSha256.doFinal(source.getBytes(chartset))), chartset);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

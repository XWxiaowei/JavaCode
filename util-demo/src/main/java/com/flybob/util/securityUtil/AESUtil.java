package com.flybob.util.securityUtil;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * AES工具类
 * 使用base64AndaesEncrypt加密
 * 使用base64AndaesDecrypt解密
 * @author xiang.wei
 * @Type com.flybob.util.securityUtil
 * @Desc
 * @date 2017/6/4 17:00
 */

public class AESUtil {
    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM="AES";
    public static void main(String[] args){

    }
    /**
     * AES加密
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密串
     * @date 2017/6/5 9:45
     * @author xiang.wei
     */
    public static String base64AndEncrypt(String content, String encryptKey){
        return Base64.encodeBase64URLSafeString(encryptToBytes(content,encryptKey));
    }
    /**
     * AES解密
     * @param encryptStr 待解密的内容
     * @param decryptKey 解密密钥
     * @return 解密串
     * @date 2017/6/5 9:54
     * @author xiang.wei
     */
    public static String base64AndDecrypt(String encryptStr, String decryptKey){
        return (encryptStr==null||"".equals(encryptStr))? null:decryptByBytes(Base64.decodeBase64(encryptStr.getBytes()),decryptKey);
    }

    private static byte[] encryptToBytes(String content,String encryptKey){
        return encryptToBytes(content.getBytes(),encryptKey);
    }
    private static byte[] encryptToBytes(byte[] encryptContent, String encryptKey){
        try {
            return aesByMode(encryptContent,encryptKey, Cipher.ENCRYPT_MODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static byte[] aesByMode(byte[] content, String key,Integer mode) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(key.getBytes());
        //生成128位的key
        kgen.init(128,secureRandom);
        Cipher cipher=Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(mode,new SecretKeySpec(kgen.generateKey().getEncoded(),KEY_ALGORITHM));
        return cipher.doFinal(content);
    }
    public static String decryptByBytes(byte[] encryptBytes, String decryptKey){
        try {
            byte[] decryptBytes = aesByMode(encryptBytes,decryptKey,Cipher.DECRYPT_MODE);
            return new String(decryptBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

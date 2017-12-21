package com.flybob.util.securityUtil;

import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author xiang.wei
 * @Type com.flybob.util.securityUtil
 * @Desc RSA 加密工具类
 * @date 2017/6/4 16:10
 */

public class RSAUtil {
    /**
     * 密钥算法
     */
    private static final String RSA = "RSA";
    private static String ENCODE = "UTF-8"; //编码格式
    private static String SIGNATURE_ALGORITHM = "MD5withRSA"; //签名算法

    /**
     *用私钥因子priEx与模数mod对字符串src做签名
     * @param signSrc 普通字符串
     * @param prikey 私钥base64字符串
     * @return java.lang.String
     * @date 2017/6/4 20:53
     * @author xiang.wei
     */
    public static String sign(String signSrc, String prikey) {

        try {
            //将明文数据转换成byte数组
            byte[] data = signSrc.getBytes(ENCODE);
            //获取私钥对象
            RSAPrivateKey rsaPriKey = createRSAPrivateKey(prikey);
            //实例化signature
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            //初始化signature
            signature.initSign(rsaPriKey);
            //更新
            try {
                signature.update(data);
                byte[] signB = signature.sign();
                return StringUtil.byte2hex(signB);
            } catch (SignatureException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException |
                NoSuchAlgorithmException |
                InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 生成公钥
     * @param pubkey base64字符串
     * @return java.security.interfaces.RSAPublicKey
     * @date 2017/6/4 20:57
     * @author xiang.wei
     */
    public static RSAPublicKey createPublicKey(String pubkey) {

        byte[] keyBytes = Base64.decode(pubkey);
        // 加密由base64编码的公钥，构造PX509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        //指定签名算法
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 生成私钥
     * @param prikey 私钥
     * @return java.security.interfaces.RSAPrivateKey
     * @date 2017/6/4 20:58
     * @author xiang.wei
     */
    public static RSAPrivateKey createRSAPrivateKey(String prikey) {
        byte[] keyBytes = Base64.decode(prikey);
        // 解密由base64编码的私钥，构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        try {
            //指定密钥算法
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            //获取私钥对象
            return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 检验数字签名
     * @param signSrc 签名原文
     * @param sign 签名者传入的签名值
     * @param pubkey 公钥
     * @return boolean
     * @date 2017/6/4 20:59
     * @author xiang.wei
     */
    public static boolean verify(String signSrc, String sign, String pubkey) {

        //将明文数据转化为byte数组
        try {
            byte[] data = signSrc.getBytes(signSrc);
            //将签名数据转成byte数组
            byte[] signByte = StringUtil.hex2byte(sign);
            //获取公钥对象
            RSAPublicKey rsaPublicKey = createPublicKey(pubkey);
            //实例化signature
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            //初始化signature
            signature.initVerify(rsaPublicKey);
            //更新
            signature.update(data);
            return signature.verify(signByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}

/*
 * Project: MD5RSASignDemo
 * 
 * File Created at 2016年12月7日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package sign;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @Type Rsa.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月7日 下午8:00:33
 * @version 
 */
public class RSAUtil {
    private static String ENCODE="UTF-8"; //编码格式
    private static String SIGNATURE_ALGORITHM = "MD5withRSA";
    /**
     * 用私钥因子priEx与模数mod对字符串src做签名
     * 
     * @param signSrc
     *            - 普通字符串
     * @param priKey
     *            - 私钥base64字符串
     * @return String - hex字符串
     * @throws UnsupportedEncodingException
     * @throws Base64DecodingException 
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws SignatureException
     */
    public static String sign(String signSrc,String prikey) throws UnsupportedEncodingException, Base64DecodingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException{
        //将明文数据转换成byte数组
        byte[] data=signSrc.getBytes(ENCODE);
        //获得私钥对象
        RSAPrivateKey priKey=createRSAPrivateKey(prikey);
        //实例化Signature
        Signature signature=Signature.getInstance(SIGNATURE_ALGORITHM);
        //初始化Signature
        signature.initSign(priKey);
        //更新
        signature.update(data);
        
        byte[] signB=signature.sign();
        return StringUtil.byte2hex(signB);
        
    }
    /**
     * @param pubkey
     *          -base64字符串
     * @return
     *  功能说明：创建公钥对象
     * @throws Exception 
     */
    public static RSAPublicKey creaPublicKey(String pubkey) throws Exception{
        byte[] keyBytes=Base64.decode(pubkey);
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);
        //指定签名算法 
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        return (RSAPublicKey)keyFactory.generatePublic(keySpec);
        
    }
    
    /**
     * @param prikey
     *          -base64字符串
     * @return
     *  功能说明：创建私钥对象
     * @throws Base64DecodingException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     */
    public static RSAPrivateKey createRSAPrivateKey(String prikey) throws Base64DecodingException, NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] keyBytes=Base64.decode(prikey);
        // 解密由base64编码的私钥，构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(keyBytes);
        // 指定加密算法
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        // 取私钥匙对象
        return (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
    }
    /**
     * @param signsrc 签名原文
     * @param sign  签名者传入的签名值
     * @param pubKey 公钥
     * @return
     * 功能说明：检验数字签名
     * @throws Exception 
     */
    public static boolean verify(String signsrc,String sign,String pubKey) throws Exception{
        //将明文数据转成byte数组
        byte[] data=signsrc.getBytes("UTF-8");
        //将签名数据转成byte数组
        byte[] signByte=StringUtil.hex2byte(sign);
        //产生公钥
        RSAPublicKey rSApubKey=creaPublicKey(pubKey);
        //实例化signature
        Signature signature=Signature.getInstance(SIGNATURE_ALGORITHM);
        //初始化signature
        signature.initVerify(rSApubKey);
        //更新
        signature.update(data);
        //验证
        return signature.verify(signByte);   
        
    }
}



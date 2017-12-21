/*
 * Project: MD5RSASignDemo
 * 
 * File Created at 2016年12月8日
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
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

/**
 * @Type Rsa.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月8日 下午2:41:34
 * @version 1.0
 * 
 * 生成签名与验签流程
生成签名方：首先对参数放入一个字符串数组signFields，把参数和值放入一个对象或map中，使用JSONObject把这个对象转化成json对象。
然后构建签名原文，在构建签名原文时，我们需把参数按照字典（比如a,b,c）顺序排序，具体排序方法直接调java的Arrays.sort方法。 然后使用RSA
的私钥对签名原文进行签名。
验签方：和生产签名方一样先生成签名原文，然后使用RSA的公钥、生成签名方传入的签名及签名原文对生成签名方传入的签名进行验证，验
证结果为true说明验证成功，否则为未通过。
 */
public class RSA {
    public static String signRSA(Map<String, Object> map, String prikey) throws InvalidKeyException, UnsupportedEncodingException, Base64DecodingException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        String[] signFields = CommonUtil.getSignField();
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
        //签名原文
        String signSrc=CommonUtil.orgSignsrc(signFields, jsonObject);
        //生成签名
        String genSign=RSAUtil.sign(signSrc, prikey);
        return genSign;
    }
    public static void vlidateRSAsign(Map<String, Object> map,String sign,String pubKey) throws Exception{
        String[] signFields = CommonUtil.getSignField();
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(map);
        //签名原文
        String signsrc=CommonUtil.orgSignsrc(signFields, jsonObject);
        //调用工具类生成验签
        boolean bool=RSAUtil.verify(signsrc, sign, pubKey);
        System.out.println("验证签名生成的签名与原签名是否一致： true?false:" + bool);  
    }
}

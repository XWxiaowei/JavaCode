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

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Type MD5.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月7日 下午4:22:33
 * @version
 * 
 *  
 *  一、MD5签名与验签
1.MD5介绍
 MD5全名Message-Digest Algorithm 5（信息-摘要算法）是一种不可逆的加密算法。
 MD5算法具有以下特点：
1、压缩性：任意长度的数据，算出的MD5值长度都是固定的。
2、容易计算：从原数据计算出MD5值很容易。
3、抗修改性：对原数据进行任何改动，哪怕只修改1个字节，所得到的MD5值都有很大区别。
4、强抗碰撞：已知原数据和其MD5值，想找到一个具有相同MD5值的数据（即伪造数据）是非常困难的。
MD5生成签名和验签需要MD5 key，这个key值就是一段字符串没有任何限制比如：123456ADSEF
2.签名与验签流程
1、首先参数放入一个字符串数组，参数和值放在一个对象或者map中，利用JSONObjec将map数据转化成json对象
---》2、构建签名原文，构建签名原文之前需要将key按照字典顺序排序，具体排序方法可以调用Arrays.sort()方法
---》3、然后按照key=value的方式把所有参数组成一个字符串， 多个参数直接以"&"来隔开。 然后把MD5 key拼接在签名原文最后。
---》4、调用MD5Encrypt.getMessageDigest(signOrg)生成签名
验证签名方式就是按照上面的签名流程生成的签名与传入的签名对比，如果相等则验签成功
 */
public class MD5Util {
    
    public static String signMD5(Map<String, Object> map,String key){
        String[] signFields=CommonUtil.getSignField();
        JSONObject jsonObject=(JSONObject) JSONObject.toJSON(map);
        //待签数据
        String signOrg=CommonUtil.orgSignsrc(signFields, jsonObject);
        //MD5签名原文
        signOrg=signOrg+key;
        //生成签名
        String genSign=DigestUtils.md5Hex(signOrg);
        return genSign;
    }
    
    
    public static boolean verify(String text,String sign,String inputCharset){
        //生成签名
        String mySign=DigestUtils.md5Hex(sign);
        System.out.println("本次签名"+mySign+"传入签名"+text);
        if (StringUtils.equals(text, mySign)) {
           return true;
        }
        return false;
    }
    
}



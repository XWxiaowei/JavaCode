package com.flybob.util.securityUtil;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author xiang.wei
 * @Type com.flybob.util.securityUtil
 * @Desc MD5签名工具类
 * @date 2017/6/4 16:11
 */

public class MD5Util {

    /**
     * 签名字符串
     *
     * @param text         需要签名的字符串
     * @param key          密钥
     * @param inputCharset 编码格式
     * @return 签名串
     * @date 2017/6/4 16:50
     * @author xiang.wei
     */
    public static String sign(String text, String key, String inputCharset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
    }

    /**
     * 验证签名串
     *
     * @param text         待签名字符串
     * @param sign         待验证的签名
     * @param key          密钥
     * @param inputCharset 编码格式
     * @return 验证结果
     * @date 2017/6/4 16:55
     * @author xiang.wei
     */
    public static boolean verify(String text, String sign, String key, String inputCharset) {

        text = text + key;
        String mySign = DigestUtils.md5Hex(getContentBytes(text, inputCharset));
        return mySign.equals(sign);
    }

    public static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

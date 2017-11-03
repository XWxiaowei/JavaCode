package com.jay.ssh.util;

import java.security.MessageDigest;

/**
 * MD5 签名校验
 * 
 */
public class MD5Util {
//	protected static final Logger log = LogManager.getLogger(MD5Util.class);
	private static final String CHARACTER_ENCODEING = "UTF-8";

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            被加密的字符串，默认utf-8编码
	 * @return
	 */
	public static String encode(String data) {
		return encode(data, CHARACTER_ENCODEING);
	}

	/**
	 * 使用制定编码加密
	 * 
	 * @param data 需要加密的数据
	 * @param encode 编码
	 * @return
	 */
	public static String encode(String data, String encode) {
//		Assert.notNull(data, "数据不能为空");
//		Assert.notNull(encode, "编码不能为空");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data.getBytes(encode));
			byte[] b = md.digest();
			int i;
			StringBuilder buf = new StringBuilder();
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0) {
					i = i + 256;
				}
				if (i < 16) {
					buf.append("0");
				}
				buf.append(Integer.toHexString(i));
			}
			data = buf.toString();
		} catch (Exception e) {
//			log.warn("md5签名失败,可能数据无效", e);
		}

		return data.toLowerCase();
	}

	/**
	 * MD5数字签名验证
	 * 
	 * @param data
	 *            被加密的数据
	 * @param sign
	 *            签名字符串
	 * @return
	 */
	public static boolean checkMD5Signature(String data, String sign) {
		boolean flag = false;
		String encryptStr = encode(data.trim());
		if (encryptStr.equals(sign)) {
			flag = true;
		}

		return flag;
	}
}

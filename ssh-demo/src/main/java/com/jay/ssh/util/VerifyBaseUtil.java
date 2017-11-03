package com.jay.ssh.util;

public class VerifyBaseUtil {
    private static  String SKEY = "781e5e245d69b566979b86e28d23f2c7";  //MD5加密key

    private static String t;
    public static String getT() {
        return t=String.valueOf(System.currentTimeMillis());
    }
    public static String getToken() {
        return  MD5Util.encode(t + SKEY);
    }
}

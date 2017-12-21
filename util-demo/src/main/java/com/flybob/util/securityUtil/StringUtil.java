package com.flybob.util.securityUtil;


import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class StringUtil {
    private StringUtil() {

    }

    public static final String[] LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static final String[] NUMS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static final String[] LETTERNUMS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c",
            "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static final String[] NUMSLETTER_A_F = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B",
            "C", "D", "E", "F"};

    private static final String ENCODE = "UTF-8";

    /**
     * 反格式化byte[压缩字符串]s的长度必须是偶数
     *
     * @param s
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static byte[] hex2byte(String s) throws UnsupportedEncodingException {
        byte[] src = s.toLowerCase().getBytes(ENCODE);
        byte[] ret = new byte[src.length / 2];
        for (int i = 0; i < src.length; i += 2) {
            byte hi = src[i];
            byte low = src[i + 1];
            hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a') : hi - '0');
            low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a') : low - '0');
            ret[i / 2] = (byte) (hi << 4 | low);
        }
        return ret;
    }

    /**
     * 格式化byte
     *
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] out = new char[b.length * 2];
        for (int i = 0; i < b.length; i++) {
            byte c = b[i];
            out[i * 2] = digit[(c >>> 4) & 0X0F];
            out[i * 2 + 1] = digit[c & 0X0F];
        }

        return new String(out);
    }

    public static String getRandomNumAndLetterAF(int len) {
        String s = "";
        s.toCharArray();
        return getRandom(len, NUMSLETTER_A_F);
    }

    public static String getRandomLetter(int len) {
        return getRandom(len, LETTERS);
    }

    public static String getRandomNum(int len) {
        return getRandom(len, NUMS);
    }

    public static String getRandomLetterAndNum(int len) {
        return getRandom(len, LETTERNUMS);
    }

    public static String getRandom(int len, String[] arr) {
        String s = "";
        if (len <= 0 || arr == null || arr.length < 0) {
            return s;
        }
        Random ra = new Random();
        int arrLen = arr.length;
        for (int i = 0; i < len; i++) {
            s += arr[ra.nextInt(arrLen)];
        }
        return s;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String null2String(String str) {
        return ((str == null) ? ("") : (str.trim()));
    }

    /**
     * 所有字段是否为空
     *
     * @param field
     * @return 为空则返回false
     */
    public static boolean isNotEmpty(String... field) {
        if (field == null || field.length < 1) {
            return false;
        }
        for (String f : field) {
            if (isEmpty(f)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 所有字段是否为空
     *
     * @param keys
     * @param json
     * @return 为空则返回false
     * @date 2017/6/4 20:31
     * @author xiang.wei
     */
    public static boolean isNotEmpty(String[] keys, JSONObject json) {

        if (keys == null || keys.length < 1 || json == null || json.size() < 1) {
            return false;
        }
        for (String k : keys) {
            if (isEmpty(json.getString(k))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 所有字段是否为空
     * @param keys
     * @param json
     * @return 为空则返回false
     * @date 2017/6/4 20:32
     * @author xiang.wei
     */
    public static boolean isNotEmpty(List<String> keys, JSONObject json) {
        if (keys == null || keys.size() < 1 || json == null || json.size() < 1) {
            return false;
        }
        for (String k : keys) {
            if (isEmpty(json.getString(k))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 所有字段是否为空
     *
     * @param json 所有字段均不能为空
     * @return 为空则返回false
     */
    public static boolean isNotEmpty(JSONObject json) {
        if (json == null || json.size() < 1) {
            return false;
        }
        Set<String> keys = json.keySet();
        if (keys == null || keys.isEmpty()) {
            return false;
        }
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            if (isEmpty(json.getString(key))) {
                return false;
            }
        }

        return true;
    }

    public static String getNewString(String str) throws UnsupportedEncodingException {
        if (null == str || "".equals(str)) {
            return "";
        }
        return new String(str.getBytes("ISO-8859-1"), "UTF-8");
    }
}

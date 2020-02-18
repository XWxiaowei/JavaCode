package com.jay.optional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author xiang.wei
 * @date 2020/2/18 4:30 PM
 */
public class OptionalTest3 {
    public static void main(String[] args) {
        String orgResult = "{\"result\":\"success\",\n" +
                "\"CUid\":\"12131\"}";
        System.out.println("getOrgUid获取CUid=" + getOrgUid(orgResult));
        System.out.println("getNewUid获取Cuid=" + getNewUid(orgResult));

        orgResult = null;
        System.out.println("getOrgUid获取CUid=" + getOrgUid(orgResult));
        System.out.println("getNewUid获取Cuid=" + getNewUid(orgResult));

        orgResult = "{}";
        System.out.println("getOrgUid获取CUid=" + getOrgUid(orgResult));
        System.out.println("getNewUid获取Cuid=" + getNewUid(orgResult));

        orgResult = "{\"result\":\"fail\",\n" +
                "\"CUid\":\"12131\"}";
        System.out.println("getOrgUid获取CUid=" + getOrgUid(orgResult));
        System.out.println("getNewUid获取Cuid=" + getNewUid(orgResult));
    }

    public static String getOrgUid(String orgResult) {
        if (StringUtils.isBlank(orgResult)) {
            return null;
        }
        JSONObject jsonObject = JSON.parseObject(orgResult);
        if (jsonObject == null) {
            return null;
        }
        if ("success".equals(jsonObject.getString("result"))) {
            return jsonObject.getString("CUid");
        }
        return null;
    }

    public static String getNewUid(String orgResult) {
        String orElse = Optional.ofNullable(orgResult)
                .map(n -> JSONObject.parseObject(n))
                .map(a -> {
                    if ("success".equals(a.getString("result"))) {
                        return a.getString("CUid");
                    }
                    return null;
                }).orElse(null);
        return orElse;
    }
}

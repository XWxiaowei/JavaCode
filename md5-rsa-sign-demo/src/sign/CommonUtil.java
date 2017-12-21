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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Type CommonUtil.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月8日 下午2:37:44
 * @version 
 */
public class CommonUtil {
   
    public static String[] getSignField(){
        String[] signField=new String[5];
        signField[0]="name";
        signField[1]="age";
        signField[2]="sex";
        signField[3]="school";
        signField[4]="address";
        return signField;
    }
    
    public static Map<String, Object> getSignMap(){
        Map<String ,Object> map=new HashMap<String,Object>();  
        map.put("name", "小明");  
        map.put("age", 12);  
        map.put("sex", "男");  
        map.put("school", "xxx中学");  
        map.put("address", "xxx小区");  
        return map;
    }
    /**
     * @param signField
     * @param jsonObject
     * @return
     * 功能说明：生成签名原文
     */
    public static String orgSignsrc(String[] signFields,JSONObject param){
        if (signFields!=null) {
           /* List<String> signList=Arrays.asList(signFields);
            Collections.sort(signList);*/
            Arrays.sort(signFields);    
        }
        int i=0;
        StringBuffer stringBuffer=new StringBuffer();
        for (String field : signFields) {
            stringBuffer.append(field);
            stringBuffer.append("=");
            stringBuffer.append(StringUtils.isEmpty(param.getString(field))?"":param.getString(field));
            if (i<(signFields.length-1)) {
                stringBuffer.append("&");
            }
            i++;
        }
        return stringBuffer.toString();
    }

}



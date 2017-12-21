package sign;



import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;



/**
 * @Type Test.java
 * @Desc 
 * @author  xiang.wei
 * @date 2016年12月7日 下午4:23:26
 * @version 
 */
public class Test {

    public static void main(String[] args) {
        
       Map<String, Object> map=CommonUtil.getSignMap();
//       String key="aaaaxx1221";
       String[] signField=CommonUtil.getSignField();
       JSONObject jsonObject=(JSONObject) JSONObject.toJSON(map);
       String signSrc=CommonUtil.orgSignsrc(signField, jsonObject);
//       String genSign= MD5Util.signMD5(map, key); //生成签名
//       signSrc=signSrc+key;
//       MD5Util.verify(genSign,signSrc, "UTF-8");
       
       //RSA签名测试
        try {
            String prikey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOq30rck7L3FshHVYWJK59sTToGMAn7WfYdrFN60AmPPyiMcIFXe3ZAxf7SWNbaQOPUz/xYr+oAXUBK17bykS/E2+Xa74wdN2VNbc7cZIggAjP9tGN0qhYTclbtC3pchcU8TVccrlVUN2lzJDLBHhPBDBFXzsQx9Vwtm2qjf2GcrAgMBAAECgYEAsHnz4aXOpkTNRSFVbiz5tLsIbNjTS4CDs1ysvWFE5rzls45DNa0yk2bUKPhDfHdli99DbO02FDbzCo5lKE+zlEHaC/WTp6guEe7jj5dwMl3shBZmgITCTk1/MQ46gGRG4RRADbQT/Y7tENp/GF3y9oJyJ+LmHFvfdEjSuY1/QzECQQD6aKqYFO8wuhLhy1fTvjMwlzok0szT9wTp+l6E7Ct9+csvdwaYjJrGsr6kUv+6YUwieSJ41lVtGnRy1oXEQG2TAkEA7/V35kYG+FMwYq/DOrBNaomRQGJVAOLzGRoK2dkjAkpoUAfzk4TTQ0KdJJ3T6mzF/6IQY+1oFDD42kNKJklfCQJARiya0i/bsC4VKI3RuRcuRUm8E6G3oRcym1d8sYd10MH1/QFAKfQNU+23m1lfLR4jNe34iSCXpBGr3JrdtdfQXQJAXgWRkGHZ800tRU3XMlTIULlMd6zP38QNOsWwgMGK7SfYjZs//opp+Q3N4v4QfedXAZ4vy+fHAzpZF7SMBkpzeQJALlMaKKeqKvPr8abXSRjW8u6s8tHaHX6CRV/1fGDX1bkUByqdFMO5CqIHn7isK2dHXI42bJVz63/d2Aax3lTbkA==";
            String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDqt9K3JOy9xbIR1WFiSufbE06BjAJ+1n2HaxTetAJjz8ojHCBV3t2QMX+0ljW2kDj1M/8WK/qAF1ASte28pEvxNvl2u+MHTdlTW3O3GSIIAIz/bRjdKoWE3JW7Qt6XIXFPE1XHK5VVDdpcyQywR4TwQwRV87EMfVcLZtqo39hnKwIDAQAB";
            String rsaSign = RSA.signRSA(map, prikey);
            System.out.println("生成的的签名是："+rsaSign);
            RSA.vlidateRSAsign(map, rsaSign, pubkey);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       
       
       }

}



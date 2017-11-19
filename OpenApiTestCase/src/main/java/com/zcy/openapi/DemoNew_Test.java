package com.zcy.openapi;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zcy.openapi.http.HttpMethod;
import model.Attrs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by ZCY政采云网络有限公司
 * 政采云开放平台api调用demo
 * 新版本:政采云推荐您使用本调用方式
 * update on 20160920
 */
public class DemoNew_Test {
//    private static final String API_GATEWAY = "xxxx";
//    private static final String SECRET = "xxx";
//    private static final String APP_KEY = "xxxx";

    private static final String API_GATEWAY = "http://sandbox.zcy.gov.cn/";
    private static final String SECRET = "ZHFE50VtUuku";
    private static final String APP_KEY = "659913";

    public static void main(String[] args) throws Exception {
        doPostCatalog();
    }


    private static void doPostCatalog() throws Exception {
        String uri = "/open/zcy.category.attrs.get";
        ZcyOpenRequest zcyOpenRequest = new ZcyOpenRequest(APP_KEY, SECRET, API_GATEWAY);
        zcyOpenRequest.setUri(uri);
        zcyOpenRequest.setMethod(HttpMethod.POST);
        /*组装body参数*/
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryId", 992);
        bodyMap.put("_data_", jsonObject.toString());
        zcyOpenRequest.setParamMap(bodyMap);
          /*发送http request*/
        String result = ZcyOpenClient.excute(zcyOpenRequest);
        System.out.println(result);
        JSONObject resultJson = JSONObject.parseObject(result);
        List<Attrs> attrsList = JSON.parseArray(resultJson.getString("data_response"), Attrs.class);
        System.out.println("删除前!"+attrsList.size());
        //只返回必填属性
        Iterator iterator = attrsList.iterator();
        while (iterator.hasNext()) {
            Attrs attrs = (Attrs) iterator.next();
            if (!attrs.getAttrMetas().isRequired()) {
                iterator.remove();
            }
        }
        System.out.println("删除后!"+attrsList.size());
        System.out.println("删除后!"+JSON.toJSONString(attrsList));
    }



}

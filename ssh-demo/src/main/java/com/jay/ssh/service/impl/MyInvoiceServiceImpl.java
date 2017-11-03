package com.jay.ssh.service.impl;


import com.alibaba.fastjson.JSON;
import com.jay.ssh.pojo.MyInvoice;
import com.jay.ssh.service.MyInvoiceService;
import com.jay.ssh.util.DistrictReturnNum;
import com.jay.ssh.util.HttpUtil;
import com.jay.ssh.util.UrlConfig;
import com.jay.ssh.util.VerifyBaseUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author  xiang.wei
 */
@Service("myInvoiceService")
public class MyInvoiceServiceImpl implements MyInvoiceService {
    /**
     * 基础信息系统项目地址
     */
    private static String baseDataUrl="http://localhost:9090/base_rpc";


    @Override
    public List<MyInvoice> getMyInvoice(String buyerId) {
        if (StringUtils.isBlank(buyerId)) {
            return null;
        }
        List<MyInvoice> myInvoices = new ArrayList<MyInvoice>();
        String url = baseDataUrl + UrlConfig.GET_MYINVOICE_URL + "?t=" + VerifyBaseUtil.getT()
                + "&token=" + VerifyBaseUtil.getToken() + "&buyerId=" + buyerId;
        System.out.println("MyInvoiceServiceImpl getMyInvoice接口请求参数为：" + url);
        try {
            String responseInfo = HttpUtil.getHttp(url);
            System.out.println("MyInvoiceServiceImpl getMyInvoice接口返回结果为：" + responseInfo);
            Map<String, Object> result = JSON.parseObject(responseInfo, Map.class);
            if (DistrictReturnNum.SUCCESS.getValue().equals(result.get("code"))) {
                myInvoices = JSON.parseArray(JSON.toJSONString(result.get("result")), MyInvoice.class);
                return myInvoices;
            }
        } catch (Exception e) {
            System.out.println("MyInvoiceServiceImpl getMyInvoice 程序出错,查询发票失败"+e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public String saveMyInvoice(MyInvoice myInvoice) {
        //参数校验
        if (!verify_param(myInvoice)) {
            return null;
        }
        String request_url = baseDataUrl + UrlConfig.INSERT_INVOICE_URL;
        Map<String, Object> result= post_common(myInvoice, request_url);
        if (result == null || !DistrictReturnNum.SUCCESS.getValue().equals(result.get("code"))) {
            return null;
        }
        return String.valueOf(result.get("data"));
    }

    /**
     * 校验必填参数
     *
     * @param myInvoice
     * @return
     */
    private boolean verify_param(MyInvoice myInvoice) {
        if (StringUtils.isBlank(myInvoice.getBuyerId())) {
            return false;
        }
        if (StringUtils.isBlank(myInvoice.getInvoiceType())) {
            return false;
        }
        if (StringUtils.isBlank(myInvoice.getIsDefault())) {
            return false;
        }
        return true;
    }

    /**
     * 新增和修改公共的post请求方法
     *
     * @param myInvoice
     * @param request_url
     * @return
     */
    private Map<String, Object> post_common(MyInvoice myInvoice, String request_url) {
        try {
            myInvoice.setAddDate(null); //后台生成
            myInvoice.setEditDate(null); //后台生成
            myInvoice.setT(VerifyBaseUtil.getT());
            myInvoice.setToken(VerifyBaseUtil.getToken());
            String myInvoiceJSON = JSON.toJSONString(myInvoice);
            System.out.println("MyInvoiceServiceImpl updateMyInvoice调用平台接口参数：" + myInvoiceJSON);
            Map<String, String> param = JSON.parseObject(myInvoiceJSON, Map.class);
            String resultStr = HttpUtil.postHttp(request_url, param); //返回结果
            System.out.println("MyInvoiceServiceImpl updateMyInvoice调用接口参数：" + myInvoiceJSON);
            Map<String, Object> result = JSON.parseObject(resultStr, Map.class);
            return result;
        } catch (Exception e) {
            System.out.println("MyInvoiceServiceImpl updateMyInvoice 程序出错,新增或失败"+e.getMessage());
            return null;
        }
    }

}

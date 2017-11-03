package com.jay.ssh.service.impl;

import com.jay.ssh.pojo.MyInvoice;
import com.jay.ssh.service.MyInvoiceService;
import com.jay.ssh.util.HttpUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;


/**
 * @author xiang.wei
 * @create 2017/10/26 17:08
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(HttpUtil.class)
public class MyInvoiceServiceImplTest {
    @InjectMocks
    private MyInvoiceService myInvoiceService = new MyInvoiceServiceImpl();
    @Before
    public void setUp(){
        PowerMockito.mockStatic(HttpUtil.class);
    }
    @Test
    public void testGetMyInvoice() throws Exception {
        String result_http="{\"result\":[{\"addDate\":1509010776000,\"buyerId\":" +
                "\"9E59A2D27B7748848FB65041B854240E\",\"headName\":\"项伟测试\"," +
                "\"headType\":\"0\",\"invoiceId\":\"9747A51B57FF4EA781F1CFDF73A0D9DF\"," +
                "\"invoiceType\":\"0\",\"isDefault\":0},{\"addDate\":1509092635000,\"" +
                "buyerId\":\"9E59A2D27B7748848FB65041B854240E\",\"editDate\":1509094177000,\"headName\":\"项伟测试二\",\"headType\":\"0\",\"invoiceId\":\"720CF6C50E594283B01C79D03D6D52B2\"" +
                ",\"invoiceType\":\"0\",\"isDefault\":1}],\"msg\":\"成功\",\"code\":104}";
//      1、  buyerId为空
        String buyerId = null;
        Assert.assertEquals(null, myInvoiceService.getMyInvoice(buyerId));
//        2、buyerId不为空
        buyerId = "FF8080810F5E601526";
        PowerMockito.when(HttpUtil.getHttp(anyString())).thenReturn(result_http);
        List<MyInvoice> result = myInvoiceService.getMyInvoice(buyerId);
        Assert.assertEquals(2,result.size());
    }

    @Test
    public void testSaveMyInvoice() throws Exception {
        MyInvoice myInvoice = new MyInvoice();
        myInvoice.setBuyerId("1111");
        myInvoice.setInvoiceType("0");
        myInvoice.setIsDefault("0");
        myInvoice.setHeadName("项伟测试");
        String result_http = "{\"data\":\"000000003DD0690913c\",\"msg\":\"成功\",\"code\":104}";
        PowerMockito.when(HttpUtil.postHttp(anyString(),anyMap())).thenReturn(result_http);
        Assert.assertEquals(myInvoiceService.saveMyInvoice(myInvoice),"000000003DD0690913c");

    }

}
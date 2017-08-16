package com.jay.springAOP.aopDecorator;

import org.springframework.stereotype.Service;

/**
 * Created by xiang.wei on 2017/8/14.
 */
@Service("paymentCommand")
public class PaymentCommand {


    public void pay() {
        //执行下订单操作
        int j=0;
        for (int i=0;i<10000;i++ ) {
            j++;
        }
        //执行支付操作
        System.out.println("进行支付");
    }
}

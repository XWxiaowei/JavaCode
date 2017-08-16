package com.jay.springAOP.Decorator;

/**
 * Created by xiang.wei on 2017/8/14.
 */
public class PaymentCommand  implements Command{


    public void execute() {
        //执行支付操作
        System.out.println("进行支付");
    }
}

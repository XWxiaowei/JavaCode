package com.jay.springAOP.aopDecorator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiang.wei on 2017/8/15.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopDecorator.xml");

        PlaceOrderCommand placeOrderCommand = ctx.getBean("placeOrderCommand", PlaceOrderCommand.class);
        placeOrderCommand.handleOrder();

        PaymentCommand paymentCommand = ctx.getBean("paymentCommand",PaymentCommand.class);
        paymentCommand.pay();
    }
}

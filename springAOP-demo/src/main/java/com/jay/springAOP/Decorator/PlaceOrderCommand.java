package com.jay.springAOP.Decorator;

/**
 * Created by xiang.wei on 2017/8/14.
 */
public class PlaceOrderCommand implements Command{

    public void execute() {
        //执行下订单操作
        System.out.println("进行下单操作");
    }
}

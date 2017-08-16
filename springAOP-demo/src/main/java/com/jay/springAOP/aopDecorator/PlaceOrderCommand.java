package com.jay.springAOP.aopDecorator;

import org.springframework.stereotype.Service;

/**
 * Created by xiang.wei on 2017/8/14.
 */
@Service("placeOrderCommand")
public class PlaceOrderCommand{

    public void handleOrder() {
        //执行下订单操作
        int j=0;
        for (int i=0;i<100000;i++ ) {
            j++;
        }
        System.out.println("进行下单操作");
    }
}

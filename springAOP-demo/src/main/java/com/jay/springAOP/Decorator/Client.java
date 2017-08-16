package com.jay.springAOP.Decorator;

/**
 * Created by xiang.wei on 2017/8/15.
 */
public class Client {
    public static void main(String[] args) {
        Command cmd = new LoggerDecorator(new PaymentCommand());
        cmd.execute();

        Command cmd1 = new PerformanceDecorator(new PlaceOrderCommand());
        cmd1.execute();

        Command cmd2 = new LoggerDecorator(new PerformanceDecorator(new PaymentCommand()));
        cmd2.execute();
    }
}

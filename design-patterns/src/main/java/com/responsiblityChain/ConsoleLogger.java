package com.responsiblityChain;


/**
 * @author xiang.wei
 * @date 2020/2/13 6:51 PM
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger() {
        this.level = DEBUG;
        setNextLogger(new FileLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("**********Console logger:" + message);
    }
}

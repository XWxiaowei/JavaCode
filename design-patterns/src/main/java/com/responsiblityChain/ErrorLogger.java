package com.responsiblityChain;

/**
 * @author xiang.wei
 * @date 2020/2/13 6:55 PM
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger() {
        this.level = ERROR;
        setNextLogger(null);
    }

    @Override
    protected void write(String message) {
        System.out.println("Error logger: " + message);
    }
}

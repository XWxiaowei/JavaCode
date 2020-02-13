package com.responsiblityChain;

/**
 * @author xiang.wei
 * @date 2020/2/13 6:53 PM
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(){
        this.level = INFO;
        setNextLogger(new ErrorLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

package com.responsiblityChain;

/**
 * @author xiang.wei
 * @date 2020/2/13 6:47 PM
 */
public abstract class AbstractLogger {
    protected static int INFO = 1;
    protected static int DEBUG = 2;
    protected static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

     protected abstract void write(String message);
}

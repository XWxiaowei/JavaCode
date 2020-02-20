package com.responsiblityChain;

/**
 * @author xiang.wei
 * @date 2020/2/13 6:57 PM
 */
public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger consoleLogger = new ConsoleLogger();

        consoleLogger.logMessage(3, "错误信息");
        System.out.println();
        consoleLogger.logMessage(2, "文件信息");
        System.out.println();
        consoleLogger.logMessage(1, "控制台信息");

    }
}

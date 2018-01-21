package com.jay.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class LoggerTest {

    private static final Logger myLogger=Logger.getLogger("com.jay.exception.LoggerTest");
    public static void main(String[] args) {
        Logger.getGlobal().info("日志测试");
        Logger.getGlobal().setLevel(Level.INFO);

        myLogger.info("info级别自定义日志");
        myLogger.fine("fine级别日志测试");
        myLogger.warning("warning级别自定义日志");
    }
}

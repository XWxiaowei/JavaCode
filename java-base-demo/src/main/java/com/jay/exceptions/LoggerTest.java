package com.jay.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志在日志文件未输出
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class LoggerTest {

    private static Logger MY_LOGGER=null;
    public static void main(String[] args) {
        System.setProperty("java.util.logging.config.file","/Volumes/Develop/JavaTempCode/java-base-demo/src/main/resources/logging.properties");
        Logger.getGlobal().info("日志测试");
        Logger.getGlobal().setLevel(Level.INFO);

        MY_LOGGER = Logger.getLogger("com.jay.exceptions");
        MY_LOGGER.info("info级别自定义日志");
        MY_LOGGER.fine("fine级别日志测试");
        MY_LOGGER.warning("warning级别自定义日志");
    }
}

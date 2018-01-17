package com.jay.jdk9.newFeature;

/**
 * @author xiang.wei
 * @create 2018/1/17 11:26
 */
public class LoggerFinderTest {
    private static final System.Logger LOGGER = System.getLogger("Main");

    public static void main(String[] args) {
        LOGGER.log(System.Logger.Level.INFO, "RUN!");
    }
}

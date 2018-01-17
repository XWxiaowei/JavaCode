package com.jay.jdk9.newFeature;

/**
 * @author xiang.wei
 * @create 2018/1/17 15:05
 */
public interface SayHi {
    private String buildMessage() {
        return "Hello";
    }
    void sayHi(final String message);
    default void sayHi() {
        sayHi(buildMessage());
    }
}


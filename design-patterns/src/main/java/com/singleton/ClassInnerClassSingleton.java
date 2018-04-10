package com.singleton;

/**
 * @author xiang.wei
 * @create 2018/4/10 11:16
 * 类级内部类方式
 */
public class ClassInnerClassSingleton {
    private static class innerClass {
        private static ClassInnerClassSingleton singleton = new ClassInnerClassSingleton();
    }
    private ClassInnerClassSingleton() {

    }
    public static ClassInnerClassSingleton getInstance() {
        return innerClass.singleton;
    }
}

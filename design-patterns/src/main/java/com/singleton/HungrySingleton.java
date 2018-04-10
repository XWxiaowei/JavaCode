package com.singleton;

/**
 * 饿汉式
 * 占用内存
 * @author xiang.wei
 * @create 2018/4/10 10:34
 */
public class HungrySingleton {
    private static final HungrySingleton SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return SINGLETON;
    }
}

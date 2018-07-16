package com.jay;

/**
 * Created by xiang.wei on 2018/7/16
 *
 * @author xiang.wei
 */
public class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    public Class<?> defineClassForName(String name, byte[] data) {
        return this.defineClass(name, data, 0, data.length);
    }


}

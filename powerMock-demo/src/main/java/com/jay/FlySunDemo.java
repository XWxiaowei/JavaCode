package com.jay;

import java.io.File;

/**
 * @author xiang.wei
 * @create 2018/7/5 13:55
 */
public class FlySunDemo {
    /**
     * 普通Mock： Mock参数传递的对象
     * @param file
     * @return
     */
    public boolean callArgumentInstance(File file) {
        return file.exists();
    }

    /**
     * Mock方法内部new出来的对象
     * @param path
     * @return
     */
    public boolean callArgumentInstance2(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Mock普通对象的final方法
     * @param refer
     * @return
     */
    public boolean callFinalMethod(ClassDependency refer) {
        return refer.isAlive();
    }

    /**
     * mock 私有方法
     * @return
     */
    public boolean callPrivateMethod() {
        return isAlive();
    }
    private boolean isAlive() {
        return false;
    }

    /**
     * Mock系统类的静态和final方法
     * @param string
     * @return
     */
    public String callSystemStaticMethod(String string) {
        return System.getProperty(string);
    }
}

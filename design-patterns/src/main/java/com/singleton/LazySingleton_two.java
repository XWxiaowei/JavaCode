package com.singleton;

/**
 * 懒汉式
 * 双重加锁
 * 效率不高
 * @author xiang.wei
 */
public class LazySingleton_two {
    /**
     * 定义一个私有变量，目的是外部不能直接访问该变量，必须通过公共的访问方法来访问
     */
    private static  volatile LazySingleton_two instance = null;

    /**
     * 私有化构造器，使之不能直接构造对象
     */
    private LazySingleton_two() {

    }

    /**
     * 公共的提取对象的方法
     *
     * @return
     */
    public static LazySingleton_two getInstance() {
        //如果单例存在则直接返回
        if (instance == null) {
            //单例不存在，则进入同步代码块
            synchronized (LazySingleton_two.class) {
                if (instance == null) {
                    System.out.println("实例化的次数");
                    instance = new LazySingleton_two();
                }
            }
        }
        return instance;
    }
}

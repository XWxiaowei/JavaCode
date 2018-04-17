package com.singleton;

/**
 * 懒汉式
 *  效率不高
 * @author xiang.wei
 */
public class LazySingleton {
	/**
	 * 定义一个私有变量，目的是外部不能直接访问该变量，必须通过公共的访问方法来访问
	 */
	private static LazySingleton instance=null;

	/**
	 * 私有化构造器，使之不能直接构造对象
	 */
	private LazySingleton(){
	    
	}

	/**
	 * 公共的提取对象的方法
	 * @return
	 */
	public synchronized static LazySingleton getInstance() {
	    if (instance==null) {
             instance=new LazySingleton();
        }
	    return instance;
	}
}

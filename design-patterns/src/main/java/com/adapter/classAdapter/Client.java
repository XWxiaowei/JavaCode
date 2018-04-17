package com.adapter.classAdapter;

import com.adapter.LowElectric;

/**
 * @author xiang.wei
 * @create 2018/4/10 14:56
 */
public class Client {
    public static void main(String[] args) {
        LowElectric lowElectric = new Adapter();
        lowElectric.createLowElectric(300);
    }
}

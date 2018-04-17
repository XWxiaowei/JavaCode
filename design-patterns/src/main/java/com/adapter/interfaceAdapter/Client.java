package com.adapter.interfaceAdapter;

import com.adapter.HeightElectricImpl;

/**
 * @author xiang.wei
 * @create 2018/4/10 14:56
 */
public class Client {
    public static void main(String[] args) {
        LowElectricNew lowElectricNew = new SonAdapter(new HeightElectricImpl());
        lowElectricNew.createLowElectric(300);
    }
}

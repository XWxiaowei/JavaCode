package com.adapter.interfaceAdapter;

/**
 * @author xiang.wei
 * @create 2018/4/10 14:46
 */
public interface LowElectricNew {
    /**
     * 创建低电压
     * @param inputElec 创建低电压
     */
    void createLowElectric(int inputElec);

    void showLowElectric();

    void shutdowElectric();
}

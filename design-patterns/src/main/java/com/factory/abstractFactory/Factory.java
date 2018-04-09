package com.factory.abstractFactory;

/**
 * @author xiang.wei
 * @create 2018/4/8 10:35
 */
public interface Factory {
    /**
     * 创建抽象产品A
     * @return
     */
    ProductA createProductA();

    /**
     * 创建抽象产品B
     * @return
     */
    ProductB createProductB();
}

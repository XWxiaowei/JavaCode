package com.factory.abstractFactory;

/**
 * @author xiang.wei
 * @create 2018/4/8 11:03
 */
public class FactoryB implements Factory {

    public ProductA createProductA() {
        return new ProductA2();
    }

    public ProductB createProductB() {
        return new ProductB2();
    }
}

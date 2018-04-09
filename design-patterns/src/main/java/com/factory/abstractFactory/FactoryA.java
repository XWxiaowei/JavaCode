package com.factory.abstractFactory;

/**
 * @author xiang.wei
 * @create 2018/4/8 10:54
 */
public class FactoryA implements Factory {

    public ProductA createProductA() {
        return new ProductA1();
    }

    public ProductB createProductB() {
        return new ProductB1();
    }
}

package com.factory.factoryMethod;

/**
 * @author xiang.wei
 * @create 2018/4/8 10:54
 */
public class FactoryA extends Factory {

    @Override
    public Product manufacture() {
        return new ProductA();
    }
}

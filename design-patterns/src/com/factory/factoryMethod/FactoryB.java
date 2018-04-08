package com.factory.factoryMethod;

/**
 * @author xiang.wei
 * @create 2018/4/8 11:03
 */
public class FactoryB extends Factory {

    @Override
    public Product manufacture() {
        return new ProductB();
    }
}

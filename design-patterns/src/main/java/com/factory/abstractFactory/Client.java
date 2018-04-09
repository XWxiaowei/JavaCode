package com.factory.abstractFactory;

/**
 * @author xiang.wei
 * @create 2018/4/8 11:05
 */
public class Client {
    public static void main(String[] args) {
        //客户需要产品A
        Factory factoryA = new FactoryA();
        factoryA.createProductA().show();
        factoryA.createProductB().show();
        //客户需要产品B
        FactoryB factoryB = new FactoryB();
        factoryB.createProductA().show();
        factoryB.createProductB().show();
    }
}

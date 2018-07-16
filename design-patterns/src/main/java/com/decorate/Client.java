package com.decorate;

/**
 * @author xiang.wei
 * @create 2018/4/11 14:18
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee1 = new Americano();
        Coffee coffee2 = new Latte();
        Flavour flavour = new Sugar(coffee1);
        System.out.println(flavour.getCoffeeInfo()+"现在的价格是:"+flavour.cost());
        Flavour flavour1 = new Milk(coffee2);
        System.out.println(flavour1.getCoffeeInfo()+"现在的价格是:"+flavour1.cost());

    }
}

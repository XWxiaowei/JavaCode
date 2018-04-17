package com.decorate;

/**
 * 配料牛奶类
 *
 * @author xiang.wei
 * @create 2018/4/11 13:54
 */
public class Milk extends Flavour {
    private Coffee coffee;

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getCoffeeInfo() {
        return coffee.getCoffeeInfo()+"加了牛奶";
    }

    @Override
    public int cost() {
        return coffee.cost()+5;
    }
}

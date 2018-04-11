package com.decorate;

/**
 * 配料糖类
 *
 * @author xiang.wei
 * @create 2018/4/11 13:54
 */
public class Sugar extends Flavour {
    private Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getCoffeeInfo() {
        return coffee.getCoffeeInfo()+"加了糖";
    }

    @Override
    public int cost() {
        return coffee.cost()+3;
    }
}

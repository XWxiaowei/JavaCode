package com.strategy;

/**
 * Created by xiang.wei on 2018/4/18
 *
 * @author xiang.wei
 */
public class Client {
    public static void main(String[] args) {
        Context contextA = new Context(new ConcreteStrategyA());
        contextA.contextInterface();

        Context contextB = new Context(new ConcreteStrategyB());
        contextB.contextInterface();

        Context contextC = new Context(new ConcreteStrategyC());
        contextC.contextInterface();
    }
}

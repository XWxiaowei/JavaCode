package com.flyweight;

import java.util.HashMap;
import java.util.Map;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : FlyweightFactory.java
//  @ Date : 2016/9/28
//  @ Author : 
//
//

public  class FlyweightFactory {
    public Map<String, Object> flyweights = new HashMap<String, Object>();

    public FlyweightFactory() {
        flyweights.put("x", new ConcreteFlyweight());
        flyweights.put("y", new ConcreteFlyweight());
        flyweights.put("z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return (Flyweight) flyweights.get(key);
    }
}

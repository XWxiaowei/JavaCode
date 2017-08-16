package com.jay.springAOP.aop01;

import org.aspectj.lang.JoinPoint;

/**
 * Created by xiang.wei on 2017/8/14.
 */
public class Advices {
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
    }
    public void after(JoinPoint jp){
        System.out.println("---------后置通知----------");
    }
}

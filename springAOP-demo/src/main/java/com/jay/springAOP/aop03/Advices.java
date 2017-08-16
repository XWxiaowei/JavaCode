package com.jay.springAOP.aop03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by xiang.wei on 2017/8/14.
 */
@Component
@Aspect
public class Advices {
    @Before("execution(* com.jay.springAOP.aop03.Math.*(..))")
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
    }
    @After("execution(* com.jay.springAOP.aop03.*.*(..))")
    public void after(JoinPoint jp){
        System.out.println("---------后置通知----------");
    }

    @After("within(com.jay.springAOP.aop03.*)")
    public void after1(JoinPoint joinPoint){
        System.out.println("--------------最终通知---------------");
    }
}

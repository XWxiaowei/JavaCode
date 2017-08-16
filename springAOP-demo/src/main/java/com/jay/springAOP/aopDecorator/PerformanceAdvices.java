package com.jay.springAOP.aopDecorator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 一个用于性能的统计
 * Created by xiang.wei on 2017/8/14.
 */
@Component
@Aspect
public class PerformanceAdvices {

    @Around("execution(* com.jay.springAOP.aopDecorator.*.*(..))")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(pjp.getSignature().getName());
        System.out.println("开始时间:"+System.currentTimeMillis());
        Object result = pjp.proceed();
        System.out.println("结束时间:"+System.currentTimeMillis());
        return result;
    }
}

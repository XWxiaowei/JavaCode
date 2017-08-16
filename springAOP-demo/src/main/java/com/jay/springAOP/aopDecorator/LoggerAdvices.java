package com.jay.springAOP.aopDecorator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 一个用于记录日志的切面
 * Created by xiang.wei on 2017/8/14.
 */
@Component
@Aspect
public class LoggerAdvices  {

    @Before("execution(* com.jay.springAOP.aopDecorator.*.*(..))")
    public void addLogger(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        Logger logger= LoggerFactory.getLogger(this.getClass());
        //记录日志
        logger.debug("-------起始操作----------");
        logger.debug("-------结束操作-----------");
    }
}

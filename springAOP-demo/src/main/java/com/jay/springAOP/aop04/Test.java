package com.jay.springAOP.aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiang.wei on 2017/8/14.
 */
public class Test {
    public static void main(String[] agrs){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop04.xml");
        Math math=ctx.getBean("math", Math.class);
        int n1 = 100, n2 = 0;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}

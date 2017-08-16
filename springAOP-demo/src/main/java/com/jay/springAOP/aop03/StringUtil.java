package com.jay.springAOP.aop03;

import org.springframework.stereotype.Component;

/**
 * Created by xiang.wei on 2017/8/15.
 */
@Component("stringUtil")
public class StringUtil {
    public void show(){
        System.out.println("Hello StringUtil");
    }
}

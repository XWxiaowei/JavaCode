package com.jay.optional;

import java.util.Optional;

/**
 * @author xiang.wei
 * @date 2020/2/18 2:07 PM
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable -允许传递为null参数
        Optional<Integer> value11 = Optional.ofNullable(value1);
        //Optional.of - 如果传递的参数是null，抛出异常NullPointerException
        Optional<Integer> value21 = Optional.of(value2);
        System.out.println(optionalTest.sum(value11, value21));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent -判断值是否存在
        System.out.println("第一个参数值存在：" + a.isPresent());
        System.out.println("第二个参数值存在：" + b.isPresent());

        //Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get -获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}

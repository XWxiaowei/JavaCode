package com.jay.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 了解Predicate<T>的使用
 * @author xiang.wei
 * @date 2020/2/17 9:25 PM
 */
public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        /**
         *
         * Predicate<Integer> dispatcher = n -> true;
         n 是一个参数传递到Predicate接口的test方法
         n 如果存在test方法返回true
         */
        System.out.println("输出所有数据：");
        //传递参数n
        eval(list, n -> true);

//        Predicate<Integer> dispatcher = n -> true;
//        n 是一个参数传递到Predicate接口的test方法
//        如果n%2为0，test方法返回true
        System.out.println("******输出所有的偶数：");
        eval(list, n -> n % 2 == 0);

//        Predicate<Integer> predicate2=n->n>3
//        n是一个参数传递到Predicate接口的test方法
//        如果n大于3 test方法返回true
        System.out.println("输出大于3的所有数字：");
        eval(list, n -> n > 3);
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n+" ");
            }
        }
    }
}

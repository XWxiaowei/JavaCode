package com.jay.lambda;

import java.util.function.IntConsumer;

/**
 * Created by xiang.wei on 2018/1/25
 *
 * @author xiang.wei
 */
public class LambdaDeal {
    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Hello,world"));
        repeat(10,i-> System.out.println("Countdown:"+(9-i)));
    }

    /**
     * 重复动作n次
     * @param n
     * @param action
     */
    public static void repeat(int n,Runnable action){
        for(int i=0;i<n;i++){
            action.run();
        }
    }

    /**
     * 在某次迭代中执行动作
     * @param n
     * @param action
     */
    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }
}

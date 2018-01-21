package com.jay.exceptions;

/**
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class FinallyReturnTest {
    public static void main(String[] args) {
        System.out.println("n=1时方法mult返回结果：" + mult(1));

        System.out.println("n=2时方法mult返回结果：" + mult(2));
    }

    public static int mult(int n) {
        try {
            int r = n * n;
            return r;
        } finally {
            if (n == 2) {
                return 0;
            }
        }
    }

}

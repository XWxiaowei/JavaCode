package com.jay.exceptions;

import java.util.Scanner;

/**
 * 递归阶乘函数的堆栈情况。
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class StackTraceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter=" + scanner);
        int n = scanner.nextInt();
        factorial(n);
    }

    public static int factorial(int n) {

        System.out.println("factorial(" + n + ")");
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement);
        }
        int result;
        if (n == 1) {
            result = 1;
        } else {
            result = n * factorial(n - 1);
        }
        System.out.println("result=" + result);
        return result;
    }

}

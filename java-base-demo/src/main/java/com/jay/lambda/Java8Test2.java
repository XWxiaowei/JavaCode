package com.jay.lambda;

/**
 * @author xiang.wei
 * @date 2020/2/16 5:36 PM
 */
public class Java8Test2 {
    final static String salutation = "Hello!";

    public static void main(String[] args) {
        GreetingService greetingService = message -> System.out.println(salutation + message);
        greetingService.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}

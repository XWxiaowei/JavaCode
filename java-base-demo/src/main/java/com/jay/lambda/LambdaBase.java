package com.jay.lambda;

import java.util.Arrays;
import java.util.Timer;

/**
 * Created by xiang.wei on 2018/1/24
 * lambda 基本写法
 * @author xiang.wei
 */
public class LambdaBase {
    public static void main(String[] args) {
        String[] strings = {"zhang","li","liu"};
        Arrays.sort(strings,(String first,String second)->{
            return first.length()-second.length();
        });
//
//        (String first, String second) -> {
//            if (first.length()<second.length()) {
//                return -1;
//            }else if (first.length()>second.length()) {
//                return 0;
//            }else{
//                return 0;
//            }
//        }
    }
}

package com.jay.generic;

/**
 * 2. 程序清单使用了Pair类，静态的minmax方法遍历了数组并同时计算出最大值和最小值。它用一个Pair对象返回了两个结果。
 * Created by xiang.wei on 2018/1/18
 *
 * @author xiang.wei
 */
public class PairTest {
    public static void main(String[] args) {
        String[] aTest = new String[]{"Main", "Scar", "Ocr", "test"};
        Pair<String> result = ArrayAlg.minmax(aTest);
        System.out.println(result.toString());
        String smallest = ArrayAlg.min(aTest);
        System.out.println(smallest);
    }


}

class ArrayAlg {
    public static Pair<String> minmax(String[] aTest) {
        if (aTest == null || aTest.length == 0) {
            return null;
        }
        String min = aTest[0];
        String max = aTest[0];
        for (int i = 0; i < aTest.length; i++) {
            if (min.compareTo(aTest[i]) > 0) {
                min = aTest[i];
            }
            if (max.compareTo(aTest[i]) < 0) {
                max = aTest[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T extends Comparable> T min(T[] aTest) {
        if (aTest == null || aTest.length == 0) {
            return null;
        }
        T smallest = aTest[0];
        for (int i = 0; i < aTest.length; i++) {
            if (smallest.compareTo(aTest[i])>0) {
                smallest = aTest[i];
            }
        }
        return smallest;
    }
}

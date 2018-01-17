package com.jay.generic;

import java.time.LocalDate;

/**
 * 计算泛型数组的最大值和最小值
 * Created by xiang.wei on 2018/1/18
 *
 * @author xiang.wei
 */
public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 1, 9),
                LocalDate.of(1903, 12, 7),
                LocalDate.of(1910, 6, 22),
        };
        Pair<LocalDate> result = ArrayAlg2.getMinAndMax(birthdays);
        System.out.println("min:" + result.getFirst());
        System.out.println("max:" + result.getSecond());

    }
}

class ArrayAlg2 {
    public static <T extends Comparable> Pair<T> getMinAndMax(T[] aTest) {
        if (aTest == null || aTest.length == 0) {
            return null;
        }
        T min = aTest[0];
        T max = aTest[1];
        for (T t : aTest) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return new Pair<>(min, max);
    }

}

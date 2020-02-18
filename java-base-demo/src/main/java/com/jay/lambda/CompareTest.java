package com.jay.lambda;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xiang.wei
 * @date 2020/2/17 9:44 PM
 */
public class CompareTest {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "pear");

        compareLength("apple", "banana", (n1, n2) -> -1);

        compareLength("banana", "pear", (n1, n2) -> 1);

        compareLength("banana", "banana", (n1, n2) -> 0);


        words.sort(Comparator.comparingInt(String::length));
    }

    public static void compareLength(String n1, String n2, Comparator comparator) {
        if (comparator.compare(n1, n2) == 0) {
            System.out.println("n1==n2" + n1 + "  " + n2);
        }
        if (comparator.compare(n1, n2) > 0) {
            System.out.println("n1>n2" + n1 + "  " + n2);
        }
        if (comparator.compare(n1, n2) < 0) {
            System.out.println("n1<n2" + n1 + "  " + n2);
        }

    }

}

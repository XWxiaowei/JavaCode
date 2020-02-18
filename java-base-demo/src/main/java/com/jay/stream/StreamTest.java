package com.jay.stream;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author xiang.wei
 * @date 2020/2/18 10:19 AM
 */
public class StreamTest {
    public static void main(String[] args) {
        //1.生成流
        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd", "");
        List<String> strings = stringList.stream().filter(string -> StringUtils.isNotBlank(string)).collect(Collectors.toList());
        //2.forEach 迭代流中的每个数据
        strings.forEach(System.out::println);

        //limit方法用于获取指定数量的流
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        //map方法用于映射每个元素，以下代码片段使用map输出元素对应的平方数
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5, 8, 9);
        //获取对应的平方数
        List<Integer> integers = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("*********获取对应的平方数"+integers);
        //sorted方法用于对流进行排序
        List<Integer> orgList = Arrays.asList(10, 9, 8, 7, 6, 13, 16, 0, 1, 2);
        List<Integer> sortedList = orgList.stream().sorted().collect(Collectors.toList());
        System.out.println("*********排序后集合是"+sortedList);

        //并行（parallel）程序
        List<String> emptyList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "");
        //获取空字符串的数量
        long count = emptyList.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("*****集合中的空字符串个数=" + count);
        //Collectors类实现了很多归约操作，例如将流转换成集合和集合元素，Collectors可用于返回列表或字符串
        List<String> orgCollectors = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = orgCollectors.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.toList());
        System.out.println("筛选列表：" + filtered);

        String mergedString = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println("合并字符串：" + mergedString);
        {
            //统计
            List<Integer> orgNums = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
            IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
            System.out.println("列表中最大的数：" + statistics.getMax());
            System.out.println("列表中最小的数：" + statistics.getMin());
            System.out.println("所有数之和：" + statistics.getSum());
            System.out.println("平均数：" + statistics.getAverage());
        }
    }
}

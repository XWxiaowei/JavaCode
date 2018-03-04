package com.jay.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiang.wei on 2018/3/4
 *
 * @author xiang.wei
 */
public class ArrayListIterTest {
    public static void main(String[] args) {
        //待遍历的ArrayList
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 500000; i++) {
            testList.add(i);
        }
        testFori(testList);
        testFor(testList);
        testIter(testList);

    }

    private static void testFori(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.println("RandomAccess用时  " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void testFor(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (Integer integer : list) {
                ;
        }
        System.out.println("for迭代用时  " + (System.currentTimeMillis() - startTime) + "   ms");
    }

    private static void testIter(List<Integer> list) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
//        for(Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
//            it.next();
//        }
        System.out.println("iterator迭代器用时 " + (System.currentTimeMillis() - startTime) + " ms");
    }
}

package com.jay.generic;

import com.jay.generic.employee.Employee;
import com.jay.generic.employee.Manager;

/**
 * 泛型综合总结应用
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("xiang", 10000);
        Manager cfo = new Manager("li", 8000);
        Pair<Manager> managerPair = new Pair<>(ceo, cfo);
        printBuddies(managerPair);

        ceo.setBonus(2000);
        cfo.setBonus(1000);

        Manager[] managers = {ceo, cfo};
        minmaxBonus(managers, managerPair);
        System.out.println("first:"+managerPair.getFirst().getName()+",second:"+managerPair.getSecond().getName());
        maxminBonux(managers,managerPair);
        System.out.println("first:"+managerPair.getFirst().getName()+",second:"+managerPair.getSecond().getName());

    }


    public static void printBuddies(Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println("first="+first.getName()+"------second="+second.getName());
    }

    public static void minmaxBonus(Manager[] managers, Pair<? super Manager> result) {
        if (managers.length == 0) {
            return;
        }
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i = 0; i < managers.length; i++) {
            if (min.getBonus() > managers[i].getBonus()) {
                min = managers[i];
            }
            if (max.getBonus() < managers[i].getBonus()) {
                max = managers[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonux(Manager[] managers, Pair<? super Manager> result) {
        if (managers.length == 0) {
            return;
        }
        minmaxBonus(managers, result);
        PairAlg.swapHelper(result);
    }
}

/**
 *
 */
class PairAlg {
    /**
     * @param pair
     * @return
     */
    public static boolean hasNulls(Pair<?> pair) {
        return pair.getFirst() == null || pair.getSecond() == null;
    }

    /**
     * 交换对象
     * @param pair
     */
    public static void swap(Pair<?> pair) {
        swapHelper(pair);
    }

    public static <T> void swapHelper(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }
}

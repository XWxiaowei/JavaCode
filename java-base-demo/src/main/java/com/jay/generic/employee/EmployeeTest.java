package com.jay.generic.employee;

import com.jay.generic.Pair;

/**
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("zhang", "cheng");
        Manager manager1 = new Manager("Li", "Si");
        //Test 1
        Pair<Manager> managerPair = new Pair<>(manager,manager1);
        printBuddies(managerPair);
        //Test 2
        Pair<? extends Employee> wildCardBuddies = managerPair;
        Pair<? extends Employee> lowEmployee = new Pair<>();
//        wildCardBuddies.setFirst(lowEmployee); //compile error

    }

    public static void printBuddies(Pair<? extends  Employee> employeePair) {
        Employee first = employeePair.getFirst();
        Employee second = employeePair.getSecond();
        System.out.println("first:"+first+"-----second:"+second);
    }
}

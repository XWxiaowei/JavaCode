package com.jay.extend;

/**
 * Created by xiang.wei on 2018/1/29
 *
 * @author xiang.wei
 */
public class TripleTest2 {
    public static void main(String[] args) {
        Employee outEmployee = new Employee();
        outEmployee.setName("测试");
        call(outEmployee);
        System.out.println("employee:"+outEmployee.getName());
    }

    public static void call(Employee inEmployee) {
        Employee employee = new Employee();
        employee.setName("cba");
        inEmployee.setName("abc");
        inEmployee = employee;
    }
}

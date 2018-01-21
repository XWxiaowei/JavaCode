package com.jay.generic.employee;

/**
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class Employee {
    private String name;
    private int salary;
    private int bonus;

    public Employee(String name, int salary) {
        this.name = name;
        this.bonus = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

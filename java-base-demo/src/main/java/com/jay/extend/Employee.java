package com.jay.extend;

/**
 * Created by xiang.wei on 2018/1/28
 *
 * @author xiang.wei
 */
public class Employee {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object other) {
        return other != null
                && getClass() == other.getClass();
    }
}

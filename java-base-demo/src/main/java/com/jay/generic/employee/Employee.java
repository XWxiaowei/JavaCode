package com.jay.generic.employee;

/**
 * Created by xiang.wei on 2018/1/21
 *
 * @author xiang.wei
 */
public class Employee {
    private String first;
    private String second;

    public Employee(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}

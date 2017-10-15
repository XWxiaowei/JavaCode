package com.jay.ssh.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiang.wei on 2017/10/15
 */
public class Department {
    private static final long serialVersionUID = 1L;
    private Integer did;
    private String dname;
    private String ddesc;
    private Set<Employee> employees = new HashSet<Employee>();

    // Constructors

    /** default constructor */
    public Department() {
    }

    /** full constructor */
    public Department(String dname, String ddesc, Set employees) {
        this.dname = dname;
        this.ddesc = ddesc;
        this.employees = employees;
    }

    // Property accessors

    public Integer getDid() {
        return this.did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdesc() {
        return this.ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

    public Set getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set employees) {
        this.employees = employees;
    }
}

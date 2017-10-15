package com.jay.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by xiang.wei on 2017/10/15
 */
@Entity
@Table(name = "sh_employee", schema = "ssh_employee")
public class Employee {
    private int eid;
    private int did;
    private String ename;
    private String sex;
    private Timestamp birthday;
    private Timestamp joinDate;
    private String eno;
    private String username;
    private String password;

    @Id
    @Column(name = "eid", nullable = false)
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "did", nullable = false)
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "ename", nullable = true, length = 150)
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "joinDate", nullable = true)
    public Timestamp getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
    }

    @Basic
    @Column(name = "eno", nullable = true, length = 150)
    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 150)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 150)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (eid != employee.eid) return false;
        if (did != employee.did) return false;
        if (ename != null ? !ename.equals(employee.ename) : employee.ename != null) return false;
        if (sex != null ? !sex.equals(employee.sex) : employee.sex != null) return false;
        if (birthday != null ? !birthday.equals(employee.birthday) : employee.birthday != null) return false;
        if (joinDate != null ? !joinDate.equals(employee.joinDate) : employee.joinDate != null) return false;
        if (eno != null ? !eno.equals(employee.eno) : employee.eno != null) return false;
        if (username != null ? !username.equals(employee.username) : employee.username != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + did;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (joinDate != null ? joinDate.hashCode() : 0);
        result = 31 * result + (eno != null ? eno.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}

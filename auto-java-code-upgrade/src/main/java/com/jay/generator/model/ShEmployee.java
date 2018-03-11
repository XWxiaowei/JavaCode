package com.jay.generator.model;

import java.util.Date;

public class ShEmployee {
    /**
     * eid
     */
    private Integer eid;

    /**
     * 部门id
     */
    private Integer did;

    /**
     * 员工姓名
     */
    private String ename;

    /**
     * 员工性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 加入时间
     */
    private Date joindate;

    /**
     * 员工编号
     */
    private String eno;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * eid
     * @return eid eid
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * eid
     * @param eid eid
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 部门id
     * @return did 部门id
     */
    public Integer getDid() {
        return did;
    }

    /**
     * 部门id
     * @param did 部门id
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 员工姓名
     * @return ename 员工姓名
     */
    public String getEname() {
        return ename;
    }

    /**
     * 员工姓名
     * @param ename 员工姓名
     */
    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    /**
     * 员工性别
     * @return sex 员工性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 员工性别
     * @param sex 员工性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 出生日期
     * @return birthday 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 加入时间
     * @return joinDate 加入时间
     */
    public Date getJoindate() {
        return joindate;
    }

    /**
     * 加入时间
     * @param joindate 加入时间
     */
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    /**
     * 员工编号
     * @return eno 员工编号
     */
    public String getEno() {
        return eno;
    }

    /**
     * 员工编号
     * @param eno 员工编号
     */
    public void setEno(String eno) {
        this.eno = eno == null ? null : eno.trim();
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
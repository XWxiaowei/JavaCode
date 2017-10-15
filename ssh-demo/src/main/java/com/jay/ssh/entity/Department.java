package com.jay.ssh.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xiang.wei on 2017/10/14
 */
@Entity
public class Department {
    private int did;
    private String dname;
    private String ddesc;

    @Id
    @Column(name = "did")
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "ddesc")
    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (did != that.did) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;
        if (ddesc != null ? !ddesc.equals(that.ddesc) : that.ddesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = did;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        result = 31 * result + (ddesc != null ? ddesc.hashCode() : 0);
        return result;
    }
}

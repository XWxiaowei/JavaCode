package com.jay.generator.model;

public class ShDepartment {
    /**
     * did
     */
    private Integer did;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * 部门描述
     */
    private String ddesc;

    /**
     * did
     * @return did did
     */
    public Integer getDid() {
        return did;
    }

    /**
     * did
     * @param did did
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * 部门名称
     * @return dname 部门名称
     */
    public String getDname() {
        return dname;
    }

    /**
     * 部门名称
     * @param dname 部门名称
     */
    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    /**
     * 部门描述
     * @return ddesc 部门描述
     */
    public String getDdesc() {
        return ddesc;
    }

    /**
     * 部门描述
     * @param ddesc 部门描述
     */
    public void setDdesc(String ddesc) {
        this.ddesc = ddesc == null ? null : ddesc.trim();
    }
}
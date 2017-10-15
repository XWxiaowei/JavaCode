package com.jay.ssh.dao;

import com.jay.ssh.entity.Department;

import java.util.List;

/**
 * Created by xiang.wei on 2017/10/14
 */
public interface DepartmentDao {


    /**
     * @return
     */
    List<Department> findAll();

    /**
     * @param did
     * @return
     */
    Department findById(Integer did);

    /**
     * @param department
     */
    void insert(Department department);

    /**
     * @param department
     */
    void update(Department department);



}

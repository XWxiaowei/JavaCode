package com.jay.ssh.service;

import com.jay.ssh.entity.Department;

import java.util.List;

/**
 * Created by xiang.wei on 2017/10/14
 */
public interface DepartmentService {

    /**
     * @return
     */
    List<Department> findAll();

    /**
     * @param did
     * @return
     */
    Department findByDid(Integer did);

    /**
     * @param department
     */
    void sava(Department department);

    /**
     * @param department
     */
    void update(Department department);

}

package com.jay.ssh.service.impl;

import com.jay.ssh.dao.DepartmentDao;
import com.jay.ssh.entity.Department;
import com.jay.ssh.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author  Created by xiang.wei on 2017/10/14
 */
@Transactional
@Service("departmentService")
public class DepartmentServiceImpl  implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        try {
            return departmentDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Department findByDid(Integer did) {
        try {
            return departmentDao.findById(did);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Department department) {
        try {
            departmentDao.insert(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {
        try {
            departmentDao.update(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

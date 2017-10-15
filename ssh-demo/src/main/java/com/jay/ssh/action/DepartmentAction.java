package com.jay.ssh.action;

import com.jay.ssh.entity.Department;
import com.jay.ssh.service.DepartmentService;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xiang.wei on 2017/10/14
 */
@Action(value = "departmentAction")
public class DepartmentAction  extends BaseAction{
    @Autowired
    private DepartmentService departmentService;
    // 模型驱动
    private Department department = new Department();

    public Department getModel() {
        return department;
    }

    

}

package com.jay.ssh.action;

import com.jay.ssh.entity.Department;
import com.jay.ssh.service.DepartmentService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xiang.wei on 2017/10/14
 * 模型驱动
 */
@Action(value = "departmentAction")
public class DepartmentAction  extends BaseAction implements ModelDriven<Department>{
    @Autowired
    private DepartmentService departmentService;
    // 模型驱动
    private Department department = new Department();

    public Department getModel() {
        return department;
    }

    private List<Department> departmentList;

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String findAll() {
        departmentList= departmentService.findAll();
        //使用的是模型驱动，把部门信息放入值栈，才可以使用OGNL表达式来获取
//        ActionContext.getContext().getValueStack().push(departments);
        return "findAll";
    }

    public String saveDepartment() {
        departmentService.sava(department);
        return "addSuccess";
    }
    public String findById() {
       department=departmentService.findByDid(department.getDid());
        return "goEditDepartment";
    }
    public String update() {
        departmentService.update(department);
        return "updateSuccess";
    }
    public String delete() {
        return "deleteSuccess";
    }
    public String goAddDepartment(){
        return "goAddDepartment";
    }
}

package com.jay.ssh.action;

import com.jay.ssh.entity.Department;
import com.jay.ssh.service.DepartmentService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author  xiang.wei on 2017/10/14
 * 模型驱动
 */
@Action(value = "departmentAction1")
public class DepartmentAction1 extends BaseAction implements ModelDriven<Department>{
    @Autowired
    private DepartmentService departmentService;
    /**
     * 模型驱动
     */
    private Department department = new Department();

    @Override
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
        return "findAll";
    }

    public String saveDepartment() {
        departmentService.save(department);
        return "addSuccess";
    }
    public String findById() {
        String did = ServletActionContext.getRequest().getParameter("did");
        department=departmentService.findByDid(Integer.valueOf(did));
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

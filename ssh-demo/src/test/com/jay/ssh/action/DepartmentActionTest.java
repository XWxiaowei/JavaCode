package com.jay.ssh.action;

import com.jay.ssh.entity.Department;
import com.opensymphony.xwork2.ActionProxy;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author xiang.wei
 * @create 2017/10/23 14:51
 */

public class DepartmentActionTest extends AbstractActionTest {

    @Test
    public void testFindAll() throws Exception {
        ActionProxy proxy = getActionProxy("/department_findAll.action");
        DepartmentAction action = (DepartmentAction) proxy.getAction();
        String result = action.findAll();
        Assert.assertEquals("findAll", result);
    }
    @Test
    public void testSaveDepartment() throws Exception {
        ActionProxy proxy = getActionProxy("/department_saveDepartment.action");
        DepartmentAction action = (DepartmentAction) proxy.getAction();
        Department department = new Department();
        department.setDname("测试123");
        department.setDdesc("测试部门123");
        action.setDepartment(department);
        String result = action.saveDepartment();
        Assert.assertEquals("addSuccess", result);

    }

    @Test
    public void testFindById() throws Exception {
         /*这个函数相当@Before注解的函数，是调用单元测试后的时候，
       首先会执行的方法。可以在这里面做一些必要的准备工作*/
        request.setParameter("did", "1");
        ActionProxy proxy = getActionProxy("/department_findById.action");
        DepartmentAction action = (DepartmentAction) proxy.getAction();
        String result = action.findById();
        Assert.assertEquals("goEditDepartment", result);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testGoAddDepartment() throws Exception {
    }
}
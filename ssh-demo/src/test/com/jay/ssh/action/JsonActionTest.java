package com.jay.ssh.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jay.ssh.entity.Department;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * @author xiang.wei
 * @create 2017/10/26 11:10
 */
public class JsonActionTest extends AbstractActionTest{
    @Test
    public void testFindAll() throws Exception {
        String result = executeAction("/json_findAll.action");
        Assert.assertNotNull(result);
        JSONObject jsonObject = JSON.parseObject(result);
        if ("success".equals(jsonObject.getString("key"))) {
            List<Department> departmentList = JSON.parseArray(jsonObject.getString("data"), Department.class);
            if (CollectionUtils.isEmpty(departmentList)) {
                return;
            }
            for (Department department : departmentList) {
                System.out.println(department.toString());
            }
        }
    }

}
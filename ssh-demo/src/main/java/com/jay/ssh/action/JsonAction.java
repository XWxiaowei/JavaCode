package com.jay.ssh.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jay.ssh.entity.Department;
import com.jay.ssh.service.DepartmentService;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xiang.wei
 */
@Action(value = "jsonAction")
public class JsonAction extends BaseAction {
    @Autowired
    private DepartmentService departmentService;

    public void  findAll() {
        List<Department> departmentList= departmentService.findAll();
        JSONObject jsonObject = new JSONObject();
        if (CollectionUtils.isEmpty(departmentList)) {
            jsonObject.put("key", "success");
            jsonObject.put("data", JSON.toJSONString(departmentList));
            writeJson(jsonObject);
            return;
        }
        jsonObject.put("key", "success");
        jsonObject.put("data", JSON.toJSONString(departmentList));
        writeJson(jsonObject);
    }
}

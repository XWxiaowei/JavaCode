package com.jay.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author xiang.wei
 * @date 2020/4/18 1:45 PM
 */
@Data
public class Student {

    /**
     * 班级名称
     */
    @Excel(name="班级名称")
    private String className;

    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名",orderNum = "1")
    private String studentName;
    /**
     * 学生手机号
     */
    @Excel(name = "学生手机号",orderNum = "2")
    private String studentMobile;
    /**
     * 学生身份证
     */
    @Excel(name = "学生身份证号",orderNum = "3")
    private String idCard;
    /**
     * 学号
     */
    @Excel(name = "学号",orderNum = "4")
    private String studentNo;
}

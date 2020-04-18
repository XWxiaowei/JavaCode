package com.jay.model;

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
    private String className;

    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生手机号
     */
    private String studentMobile;
    /**
     * 学生身份证
     */
    private String idCard;
    /**
     * 学号
     */
    private String studentNo;
}

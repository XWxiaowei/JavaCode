DROP DATABASE IF EXISTS ssh_employee;
CREATE DATABASE ssh_employee;
USE ssh_employee;
DROP TABLE IF EXISTS `sh_department`;
CREATE TABLE `sh_department` (
	`did` int(10) NOT NULL AUTO_INCREMENT COMMENT 'did',
	`dname` varchar(150) NOT NULL COMMENT '部门名称',
	`ddesc` varchar(150) NOT NULL COMMENT '部门描述',
	PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='部门表';

DROP TABLE IF EXISTS `sh_employee`;
CREATE TABLE `sh_employee` (
	`eid` int(10) NOT NULL AUTO_INCREMENT COMMENT 'eid',
	`did` int(10) NOT NULL COMMENT '部门id',
	`ename` varchar(150) DEFAULT NULL COMMENT '员工姓名',
	`sex` varchar(10) DEFAULT NULL COMMENT '员工性别',
	`birthday` datetime DEFAULT NULL COMMENT '出生日期',
	`joinDate` datetime DEFAULT NULL COMMENT '加入时间',
	`eno` varchar(150) DEFAULT NULL COMMENT '员工编号',
	`username` varchar(150) DEFAULT NULL COMMENT '用户名',
	`password` varchar(150) DEFAULT NULL COMMENT '密码',
	PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';
DROP TABLE IF EXISTS `sh_student`;
CREATE  TABLE `sh_student`(
	`id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`name` VARCHAR(125) NOT NULL COMMENT '学生姓名',
	`score_sum` INT(10) NOT NULL COMMENT '总分数',
	`score_avg` DECIMAL(10,2) NOT NULL COMMENT '平均分',
	`age` INT(3) NOT NULL COMMENT '年龄',
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';
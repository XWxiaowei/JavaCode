/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : ssh_employee

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 10/15/2017 15:38:58 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sh_department`
-- ----------------------------
DROP TABLE IF EXISTS `sh_department`;
CREATE TABLE `sh_department` (
  `did` int(11) NOT NULL AUTO_INCREMENT COMMENT 'did',
  `dname` varchar(150) NOT NULL COMMENT '部门名称',
  `ddesc` varchar(150) NOT NULL COMMENT '部门描述',
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=8323 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
--  Table structure for `sh_employee`
-- ----------------------------
DROP TABLE IF EXISTS `sh_employee`;
CREATE TABLE `sh_employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'eid',
  `did` int(11) NOT NULL COMMENT '部门id',
  `ename` varchar(150) DEFAULT NULL COMMENT '员工姓名',
  `sex` varchar(10) DEFAULT NULL COMMENT '员工性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `joinDate` datetime DEFAULT NULL COMMENT '加入时间',
  `eno` varchar(150) DEFAULT NULL COMMENT '员工编号',
  `username` varchar(150) DEFAULT NULL COMMENT '用户名',
  `password` varchar(150) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=8321 DEFAULT CHARSET=utf8 COMMENT='员工表';

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.101_3306
Source Server Version : 50719
Source Host           : 192.168.0.101:3306
Source Database       : edu_dev

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-23 09:09:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_USER`
-- ----------------------------
DROP TABLE IF EXISTS `T_USER`;
CREATE TABLE `T_USER` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `USER_NAME` varchar(64) DEFAULT NULL COMMENT '学员姓名',
  `USER_ACCOUNT` varchar(64) DEFAULT NULL COMMENT '学员账号',
  `PHONE_NUMBER` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `REG_DATE` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

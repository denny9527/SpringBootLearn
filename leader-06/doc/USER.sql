/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.106_3306
Source Server Version : 50719
Source Host           : 192.168.0.102:3306
Source Database       : prod_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-20 23:32:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `USER`
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `NAME` varchar(200) DEFAULT NULL COMMENT '用户姓名',
  `PASSWORD` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `ENABLED` char(1) DEFAULT NULL COMMENT '是否启用',
  `REG_TIME` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

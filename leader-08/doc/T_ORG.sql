/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.106_3306
Source Server Version : 50719
Source Host           : 192.168.0.106:3306
Source Database       : prod_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-09 16:46:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_ORG`
-- ----------------------------
DROP TABLE IF EXISTS `T_ORG`;
CREATE TABLE `T_ORG` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ORG_NAME` varchar(200) DEFAULT NULL COMMENT '机构名称',
  `ORG_ADDRESS` varchar(1000) DEFAULT NULL COMMENT '机构地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8 COMMENT='机构表';

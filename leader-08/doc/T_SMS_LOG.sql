/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.106_3306
Source Server Version : 50719
Source Host           : 192.168.0.106:3306
Source Database       : prod_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-09 16:46:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_SMS_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `T_SMS_LOG`;
CREATE TABLE `T_SMS_LOG` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `USER_ACCOUNT` varchar(128) DEFAULT NULL COMMENT '用户账号',
  `PHONE_NUMBER` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `SMS_CONTENT` varchar(2000) DEFAULT NULL COMMENT '短信内容',
  `SEND_TIME` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='短信发送日志表';
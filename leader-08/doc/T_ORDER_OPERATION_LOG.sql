/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.106_3306
Source Server Version : 50719
Source Host           : 192.168.0.106:3306
Source Database       : prod_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-09 16:46:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_ORDER_OPERATION_LOG`
-- ----------------------------
DROP TABLE IF EXISTS `T_ORDER_OPERATION_LOG`;
CREATE TABLE `T_ORDER_OPERATION_LOG` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `ORDER_ID` varchar(64) DEFAULT NULL COMMENT '订单ID',
  `LOG_CONTENT` varchar(2000) DEFAULT NULL COMMENT '操作日志内容',
  `OPERATOR` varchar(128) DEFAULT NULL COMMENT '操作员账号',
  `OPERATOR_TYPE` char(1) DEFAULT NULL COMMENT '操作员类型(0:用户 1:电商管理人员)',
  `OPERATION_TIME` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='订单操作日志表';

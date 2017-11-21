/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.106_3306
Source Server Version : 50719
Source Host           : 192.168.0.106:3306
Source Database       : prod_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-09 16:46:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_ORDER`
-- ----------------------------
DROP TABLE IF EXISTS `T_ORDER`;
CREATE TABLE `T_ORDER` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `ORDER_ID` varchar(64) DEFAULT NULL COMMENT '订单ID',
  `USER_ACCOUNT` varchar(128) DEFAULT NULL COMMENT '用户账号',
  `PRODUCT_ID` varchar(64) DEFAULT NULL COMMENT '商品ID',
  `PRODUCT_NAME` varchar(500) DEFAULT NULL COMMENT '商品名称',
  `PRODUCT_QUANTITY` bigint(12) DEFAULT NULL COMMENT '商品数量',
  `TOTAL_AMOUNT` decimal(18,2) DEFAULT NULL COMMENT '总金额',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='商品订单表';
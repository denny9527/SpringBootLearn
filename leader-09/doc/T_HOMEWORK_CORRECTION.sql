/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.101_3306
Source Server Version : 50719
Source Host           : 192.168.0.101:3306
Source Database       : edu_dev

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-23 09:09:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_HOMEWORK_CORRECTION`
-- ----------------------------
DROP TABLE IF EXISTS `T_HOMEWORK_CORRECTION`;
CREATE TABLE `T_HOMEWORK_CORRECTION` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `CORRECT_USER_ID` bigint(20) DEFAULT NULL COMMENT '批改学员ID',
  `USER_ID` bigint(20) DEFAULT NULL,
  `HOMEWORK_ID` bigint(20) DEFAULT NULL COMMENT '作业ID',
  `LEVEL_FLAG` char(1) DEFAULT NULL COMMENT '作业级别(A,B,C,D)',
  `APPRAISE_FLAG` char(1) DEFAULT NULL COMMENT '评价标志(1:点赞 0:差评)',
  `MARK` varchar(1000) DEFAULT NULL COMMENT '评语',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '提交时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='学员作业批改表';

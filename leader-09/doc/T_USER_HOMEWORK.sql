/*
Navicat MySQL Data Transfer

Source Server         : 192.168.0.101_3306
Source Server Version : 50719
Source Host           : 192.168.0.101:3306
Source Database       : edu_dev

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-23 09:09:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `T_USER_HOMEWORK`
-- ----------------------------
DROP TABLE IF EXISTS `T_USER_HOMEWORK`;
CREATE TABLE `T_USER_HOMEWORK` (
  `ID` bigint(17) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `USER_ID` bigint(17) DEFAULT NULL COMMENT '学员ID',
  `CLASS_ID` bigint(17) DEFAULT NULL COMMENT '班级ID',
  `LESSON_ID` bigint(17) DEFAULT NULL COMMENT '课程ID',
  `HOMEWORK_FILE_PATH` varchar(500) DEFAULT NULL COMMENT '作业文件路径',
  `HOMEWORK_FILE_NAME` varchar(500) DEFAULT NULL COMMENT '作业文件名称',
  `CORRECT_FLAG` char(1) DEFAULT NULL COMMENT '批改标志(0:未批改 1:已批改)',
  `STAR_COUNT` bigint(17) DEFAULT '0' COMMENT '点赞数',
  `NEGATIVE_COUNT` bigint(17) DEFAULT '0' COMMENT '差评数',
  `BEST_FLAG` char(1) DEFAULT NULL COMMENT '优秀作业',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='学员作业信息表';

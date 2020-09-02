/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_web

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 02/09/2020 00:21:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` VALUES (1, '张三', '男', '1991-01-01', 'zhangsan@163.com', '体育委员');
INSERT INTO `t_student` VALUES (2, '李四', '女', '1992-02-02', 'lisi@sina.com', '文艺委员');
INSERT INTO `t_student` VALUES (3, '王二麻子', '男', '1993-03-03', 'wangermazi@126.com', '宣传委员');
INSERT INTO `t_student` VALUES (4, '哈拉少', '男', '1994-04-04', 'halashao@qq.com', '平民');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost
 Source Database       : cetsys

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : utf-8

 Date: 04/12/2018 19:43:48 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_candidate`
-- ----------------------------
DROP TABLE IF EXISTS `t_candidate`;
CREATE TABLE `t_candidate` (
  `id` varchar(32) NOT NULL,
  `name` varchar(10) NOT NULL,
  `idcard` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `cetType` varchar(10) NOT NULL,
  `commAdress` varchar(50) DEFAULT NULL,
  `personImg` varchar(50) NOT NULL,
  `uid` varchar(32) NOT NULL,
  `admissionCard` varchar(20) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK3D338F78D0E97047` (`uid`),
  CONSTRAINT `FK3D338F78D0E97047` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_candidate`
-- ----------------------------
BEGIN;
INSERT INTO `t_candidate` VALUES ('8a0dcc8262b9959d0162b99630090000', '时光', '130525199806223818', '男', '13104663605', 'CET-4', '河南省郑州市', '/cetsignupsys/upload/user/1523532050429.png', '8a0dcc8262af314d0162af34a5bb0000', '201804120000', '2018-04-12 19:20:50'), ('8a0dcc8262b99c820162b99dba650000', '啦啦', '130525199806223818', '男', '13104663605', 'CET-4', '河南省郑州市', '/cetsignupsys/upload/user/1523532544600.jpeg', '8a0dcc8262af88210162af896a0b0000', '201804121', '2018-04-12 19:29:04'), ('8a0dcc8262b9a30e0162b9a42c5a0000', '哈哈', '130525199806223818', '男', '13104663605', 'CET-4', '河南省郑州市', '/cetsignupsys/upload/user/1523532966981.png', '8a0dcc8262af88210162af89e3f20001', '201804122', '2018-04-12 19:36:06'), ('8a0dcc8262b9a30e0162b9a5c0de0001', '呵呵', '130525199806223818', '男', '13104663605', 'CET-4', '河南省郑州市', '/cetsignupsys/upload/user/1523533070554.jpeg', '8a0dcc8262af6c000162af7558a10000', '201804123', '2018-04-12 19:37:50');
COMMIT;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `account` varchar(20) NOT NULL,
  `passwd` varchar(20) NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `role` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_user`
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('8a0dcc8262aec88a0162aecb47c70000', 'admin', 'admin', '13104663605', '157523345@qq.com', '1'), ('8a0dcc8262af314d0162af34a5bb0000', 'mjxs', '1234', '13104663605', '157535637@qq.com', '0'), ('8a0dcc8262af6c000162af7558a10000', 'hehe', '1234', '13104663605', '157523345@qq.com', '0'), ('8a0dcc8262af88210162af896a0b0000', 'lala', '1234', '13104663605', '157523345@qq.com', '0'), ('8a0dcc8262af88210162af89e3f20001', 'haha', '1234', '13104663605', '157523345@qq.com', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

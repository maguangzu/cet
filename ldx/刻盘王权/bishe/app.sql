/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : app

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-06-23 08:29:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for active
-- ----------------------------
DROP TABLE IF EXISTS `active`;
CREATE TABLE `active` (
  `active_id` int(11) NOT NULL AUTO_INCREMENT,
  `active_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_begtime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_endtime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_shichang` int(11) DEFAULT NULL,
  `active_userid` int(11) NOT NULL,
  `team_id` int(11) DEFAULT NULL,
  `shuxing_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_volnum` int(11) DEFAULT NULL,
  `active_addrees` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_major` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_shuxing` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `active_zhtai` int(11) DEFAULT NULL COMMENT '0申请1通过2结束',
  PRIMARY KEY (`active_id`,`active_userid`),
  KEY `active_userid` (`active_userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of active
-- ----------------------------
INSERT INTO `active` VALUES ('1', '1', '2017-05-29', '2017-05-29', '1', '1', '1', '1', '1', '1', '1', '1', '2');
INSERT INTO `active` VALUES ('2', '1', '2017-05-29', '2017-05-29', '1', '1', null, null, '1', '1', '1', null, '2');
INSERT INTO `active` VALUES ('3', '1', '2017-05-29', '2017-05-29', '1', '1', null, null, '1', '1', '1', null, '2');
INSERT INTO `active` VALUES ('4', '1', '2017-05-29', '2017-05-29', '1', '1', null, null, '1', '1', '1', null, '1');
INSERT INTO `active` VALUES ('5', '1', '2017-05-29', '2017-05-29', '2', '1', null, null, '2', '2', '1', null, '2');
INSERT INTO `active` VALUES ('9', '1', '1', '1', '1', '1', null, null, '1', '1', '1', null, '2');
INSERT INTO `active` VALUES ('10', '2', '2', '2', '2', '1', null, null, '2', '2', '2', null, '2');

-- ----------------------------
-- Table structure for juese
-- ----------------------------
DROP TABLE IF EXISTS `juese`;
CREATE TABLE `juese` (
  `juese_id` int(11) NOT NULL,
  `juese_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `juese_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`juese_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of juese
-- ----------------------------
INSERT INTO `juese` VALUES ('1', '超级管理员', null);
INSERT INTO `juese` VALUES ('2', '准团队队长', null);
INSERT INTO `juese` VALUES ('3', '团队队长', null);
INSERT INTO `juese` VALUES ('4', '活动发起人', null);
INSERT INTO `juese` VALUES ('5', '准活动发起人', null);
INSERT INTO `juese` VALUES ('6', '普通志愿者', null);

-- ----------------------------
-- Table structure for juese_quanxian
-- ----------------------------
DROP TABLE IF EXISTS `juese_quanxian`;
CREATE TABLE `juese_quanxian` (
  `quanxian_id` int(11) NOT NULL,
  `juese_id` int(11) NOT NULL,
  PRIMARY KEY (`quanxian_id`,`juese_id`),
  KEY `juese_quanxian_fk2` (`juese_id`) USING BTREE,
  CONSTRAINT `juese_quanxian_ibfk_1` FOREIGN KEY (`quanxian_id`) REFERENCES `quanxian` (`quanxian_id`),
  CONSTRAINT `juese_quanxian_ibfk_2` FOREIGN KEY (`juese_id`) REFERENCES `juese` (`juese_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of juese_quanxian
-- ----------------------------
INSERT INTO `juese_quanxian` VALUES ('1', '1');
INSERT INTO `juese_quanxian` VALUES ('2', '1');
INSERT INTO `juese_quanxian` VALUES ('3', '1');
INSERT INTO `juese_quanxian` VALUES ('4', '1');
INSERT INTO `juese_quanxian` VALUES ('5', '1');
INSERT INTO `juese_quanxian` VALUES ('6', '1');
INSERT INTO `juese_quanxian` VALUES ('7', '1');
INSERT INTO `juese_quanxian` VALUES ('8', '1');
INSERT INTO `juese_quanxian` VALUES ('9', '1');
INSERT INTO `juese_quanxian` VALUES ('10', '1');
INSERT INTO `juese_quanxian` VALUES ('11', '1');
INSERT INTO `juese_quanxian` VALUES ('12', '1');
INSERT INTO `juese_quanxian` VALUES ('13', '1');
INSERT INTO `juese_quanxian` VALUES ('14', '1');
INSERT INTO `juese_quanxian` VALUES ('15', '1');
INSERT INTO `juese_quanxian` VALUES ('16', '1');
INSERT INTO `juese_quanxian` VALUES ('17', '1');
INSERT INTO `juese_quanxian` VALUES ('18', '1');
INSERT INTO `juese_quanxian` VALUES ('19', '1');
INSERT INTO `juese_quanxian` VALUES ('20', '1');
INSERT INTO `juese_quanxian` VALUES ('21', '1');
INSERT INTO `juese_quanxian` VALUES ('22', '1');
INSERT INTO `juese_quanxian` VALUES ('3', '6');
INSERT INTO `juese_quanxian` VALUES ('4', '6');
INSERT INTO `juese_quanxian` VALUES ('5', '6');
INSERT INTO `juese_quanxian` VALUES ('6', '6');
INSERT INTO `juese_quanxian` VALUES ('7', '6');
INSERT INTO `juese_quanxian` VALUES ('8', '6');
INSERT INTO `juese_quanxian` VALUES ('9', '6');
INSERT INTO `juese_quanxian` VALUES ('10', '6');
INSERT INTO `juese_quanxian` VALUES ('11', '6');
INSERT INTO `juese_quanxian` VALUES ('16', '6');
INSERT INTO `juese_quanxian` VALUES ('18', '6');
INSERT INTO `juese_quanxian` VALUES ('22', '6');

-- ----------------------------
-- Table structure for juese_volenteer
-- ----------------------------
DROP TABLE IF EXISTS `juese_volenteer`;
CREATE TABLE `juese_volenteer` (
  `vol_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `juese_id` int(11) NOT NULL,
  PRIMARY KEY (`vol_name`,`juese_id`),
  KEY `juese_volenteer_fk2` (`juese_id`) USING BTREE,
  CONSTRAINT `juese_vlenteer_fk1` FOREIGN KEY (`vol_name`) REFERENCES `volenteer` (`vol_name`),
  CONSTRAINT `juese_volenteer_fk_2` FOREIGN KEY (`juese_id`) REFERENCES `juese` (`juese_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of juese_volenteer
-- ----------------------------
INSERT INTO `juese_volenteer` VALUES ('admin', '1');
INSERT INTO `juese_volenteer` VALUES ('111', '6');
INSERT INTO `juese_volenteer` VALUES ('1111', '6');
INSERT INTO `juese_volenteer` VALUES ('213', '6');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL,
  `men_menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `menu_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', null, '信息管理', '');
INSERT INTO `menu` VALUES ('2', null, '活动管理', null);
INSERT INTO `menu` VALUES ('3', null, '团队管理', null);
INSERT INTO `menu` VALUES ('4', null, '系统管理', null);
INSERT INTO `menu` VALUES ('5', null, '志愿者证明', 'help.html');
INSERT INTO `menu` VALUES ('11', '1', '我的资料', 'myself.jsp');
INSERT INTO `menu` VALUES ('13', '1', '我的记录', 'user.html');
INSERT INTO `menu` VALUES ('15', '1', '修改我的资料', 'modfiymyinfo.do');
INSERT INTO `menu` VALUES ('21', '2', '活动搜索', 'findallactive.do');
INSERT INTO `menu` VALUES ('23', '2', '我的活动', 'findmyactive.do');
INSERT INTO `menu` VALUES ('25', '2', '发起活动', '');
INSERT INTO `menu` VALUES ('31', '3', '团队搜索', 'findteam.do');
INSERT INTO `menu` VALUES ('33', '3', '我的团队', 'mineteam.do');
INSERT INTO `menu` VALUES ('35', '3', '创建团队', 'createteam.do');
INSERT INTO `menu` VALUES ('41', '4', '志愿者审理', 'volsl.do');
INSERT INTO `menu` VALUES ('43', '4', '活动审理', 'activesl.do');
INSERT INTO `menu` VALUES ('45', '4', '团队审理', 'teamsl.do');

-- ----------------------------
-- Table structure for quanxian
-- ----------------------------
DROP TABLE IF EXISTS `quanxian`;
CREATE TABLE `quanxian` (
  `quanxian_id` int(11) NOT NULL,
  `quanxian_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quanxian_url` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`quanxian_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quanxian
-- ----------------------------
INSERT INTO `quanxian` VALUES ('1', '登录', 'login.do');
INSERT INTO `quanxian` VALUES ('2', '注册', 'zhuce.do');
INSERT INTO `quanxian` VALUES ('3', '我的资料', 'myself.do');
INSERT INTO `quanxian` VALUES ('4', '我的记录', 'myjilu.do');
INSERT INTO `quanxian` VALUES ('5', '修改个人信息', 'myself.do');
INSERT INTO `quanxian` VALUES ('6', '活动搜索', 'findallactive.do');
INSERT INTO `quanxian` VALUES ('7', '我的活动', 'findmyactive.do');
INSERT INTO `quanxian` VALUES ('8', '发起活动', 'addactive.do');
INSERT INTO `quanxian` VALUES ('9', '团队搜索', 'findallteam.do');
INSERT INTO `quanxian` VALUES ('10', '我的团队', 'findmyteam.do');
INSERT INTO `quanxian` VALUES ('11', '创建团队', 'createteam.do');
INSERT INTO `quanxian` VALUES ('12', '志愿者审理', 'volsl.do');
INSERT INTO `quanxian` VALUES ('13', '活动审理', 'activesl.do');
INSERT INTO `quanxian` VALUES ('14', '团队审理', 'teamsl.do');
INSERT INTO `quanxian` VALUES ('15', '结束活动', 'endactive.do');
INSERT INTO `quanxian` VALUES ('16', '加入活动', 'joinactive.do');
INSERT INTO `quanxian` VALUES ('17', '解散团队', 'endteam.do');
INSERT INTO `quanxian` VALUES ('18', '加入团队', 'jointeam.do');
INSERT INTO `quanxian` VALUES ('19', '审核团队', 'teamsh.do');
INSERT INTO `quanxian` VALUES ('20', '剔除志愿者', 'delvol.do');
INSERT INTO `quanxian` VALUES ('21', '审核活动', 'activeshenhe.do');
INSERT INTO `quanxian` VALUES ('22', '注销用户', 'zhuxiao.do');

-- ----------------------------
-- Table structure for quanxian_menu
-- ----------------------------
DROP TABLE IF EXISTS `quanxian_menu`;
CREATE TABLE `quanxian_menu` (
  `quanxian_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`quanxian_id`,`menu_id`),
  KEY `quanxian_menu_fk2` (`menu_id`) USING BTREE,
  CONSTRAINT `quanxian_menu_ibfk_1` FOREIGN KEY (`quanxian_id`) REFERENCES `quanxian` (`quanxian_id`),
  CONSTRAINT `quanxian_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of quanxian_menu
-- ----------------------------
INSERT INTO `quanxian_menu` VALUES ('3', '11');
INSERT INTO `quanxian_menu` VALUES ('4', '13');
INSERT INTO `quanxian_menu` VALUES ('5', '15');
INSERT INTO `quanxian_menu` VALUES ('6', '21');
INSERT INTO `quanxian_menu` VALUES ('16', '21');
INSERT INTO `quanxian_menu` VALUES ('7', '23');
INSERT INTO `quanxian_menu` VALUES ('15', '23');
INSERT INTO `quanxian_menu` VALUES ('8', '25');
INSERT INTO `quanxian_menu` VALUES ('9', '31');
INSERT INTO `quanxian_menu` VALUES ('18', '31');
INSERT INTO `quanxian_menu` VALUES ('10', '33');
INSERT INTO `quanxian_menu` VALUES ('17', '33');
INSERT INTO `quanxian_menu` VALUES ('11', '35');
INSERT INTO `quanxian_menu` VALUES ('12', '41');
INSERT INTO `quanxian_menu` VALUES ('13', '43');
INSERT INTO `quanxian_menu` VALUES ('14', '45');

-- ----------------------------
-- Table structure for shuxing
-- ----------------------------
DROP TABLE IF EXISTS `shuxing`;
CREATE TABLE `shuxing` (
  `shuxing_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `shuxing_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shuxing_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of shuxing
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_usernum` int(11) DEFAULT NULL,
  `team_username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `team_madetime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_deltime` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_desc` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_js` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `team_zhtai` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '1', '12', 'admin', '2017-05-29', '2017-05-29', '1', '1', '??');
INSERT INTO `team` VALUES ('2', '1', '1', 'as', '2017-05-29', '2017-05-29', '1', '1', '通过');

-- ----------------------------
-- Table structure for team_shuxing
-- ----------------------------
DROP TABLE IF EXISTS `team_shuxing`;
CREATE TABLE `team_shuxing` (
  `shuxing_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `team_id` int(11) NOT NULL,
  PRIMARY KEY (`shuxing_name`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of team_shuxing
-- ----------------------------

-- ----------------------------
-- Table structure for volenteer
-- ----------------------------
DROP TABLE IF EXISTS `volenteer`;
CREATE TABLE `volenteer` (
  `vol_id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) DEFAULT NULL,
  `vol_idnumber` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vol_tel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vol_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `vol_password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vol_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`vol_id`,`vol_name`),
  KEY `vol_name` (`vol_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of volenteer
-- ----------------------------
INSERT INTO `volenteer` VALUES ('1', '1', '', '1822223432', 'admin', '1', null);
INSERT INTO `volenteer` VALUES ('3', null, null, null, '2', '2', null);
INSERT INTO `volenteer` VALUES ('4', null, null, null, '3', '3', null);
INSERT INTO `volenteer` VALUES ('5', null, '213213', '213123', 'as', '22', null);
INSERT INTO `volenteer` VALUES ('6', null, '123123', '232324', 'wangquan', '1', null);
INSERT INTO `volenteer` VALUES ('7', null, '11', '11', 'admin11', '11', null);
INSERT INTO `volenteer` VALUES ('8', null, '11111', '1111', '111', '111', null);
INSERT INTO `volenteer` VALUES ('9', null, '1111', '1111', '1111', '1111', null);
INSERT INTO `volenteer` VALUES ('10', null, '23', '213', '213', '213', null);

-- ----------------------------
-- Table structure for volteer_active
-- ----------------------------
DROP TABLE IF EXISTS `volteer_active`;
CREATE TABLE `volteer_active` (
  `vol_id` int(11) NOT NULL,
  `active_id` int(11) NOT NULL,
  PRIMARY KEY (`vol_id`,`active_id`),
  KEY `volteer_active_fk2` (`active_id`) USING BTREE,
  CONSTRAINT `volteer_active_ibfk_1` FOREIGN KEY (`vol_id`) REFERENCES `volenteer` (`vol_id`),
  CONSTRAINT `volteer_active_ibfk_2` FOREIGN KEY (`active_id`) REFERENCES `active` (`active_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of volteer_active
-- ----------------------------
INSERT INTO `volteer_active` VALUES ('1', '1');
INSERT INTO `volteer_active` VALUES ('3', '1');
INSERT INTO `volteer_active` VALUES ('8', '1');
INSERT INTO `volteer_active` VALUES ('1', '3');
INSERT INTO `volteer_active` VALUES ('3', '3');
INSERT INTO `volteer_active` VALUES ('1', '4');
INSERT INTO `volteer_active` VALUES ('3', '4');
INSERT INTO `volteer_active` VALUES ('1', '5');
INSERT INTO `volteer_active` VALUES ('3', '5');

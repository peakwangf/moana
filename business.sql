/*
Navicat MySQL Data Transfer

Source Server         : 6_business
Source Server Version : 50629
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-03-29 17:57:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(45) NOT NULL COMMENT '管理员姓名',
  `admin_account` varchar(45) NOT NULL,
  `admin_password` varchar(45) NOT NULL,
  `admin_role` char(4) NOT NULL,
  `remark` text,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_id_UNIQUE` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '超级管理员1号', 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '1111', '超级管理员。【注意】登录账户是：admin');
INSERT INTO `admin` VALUES ('2', '超级管理员2号', 'superadmin', '3cewLHwlCVdY60eYkcMD4Q==', '1111', '超级管理员。【注意】登录账户是：superadmin');
INSERT INTO `admin` VALUES ('3', '普通管理员01号', 'normal', 'ISMvKXpXpadDiUoOSoAfww==', '0001', '普通管理员01号');
INSERT INTO `admin` VALUES ('4', '经协科', '经协科', 'ICy5YqxZB1uWSwcVLSNLcA==', '0001', '');

-- ----------------------------
-- Table structure for `capital`
-- ----------------------------
DROP TABLE IF EXISTS `capital`;
CREATE TABLE `capital` (
  `capital_id` int(11) NOT NULL AUTO_INCREMENT,
  `capital_name` varchar(40) NOT NULL COMMENT '资金名称',
  `capital_num` varchar(45) NOT NULL COMMENT '资金总额度',
  `capital_introduction` varchar(45) DEFAULT NULL COMMENT '资金基本信息',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` text,
  `capital_year` char(4) NOT NULL,
  PRIMARY KEY (`capital_id`),
  UNIQUE KEY `capital_id_UNIQUE` (`capital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='资金项目表';

-- ----------------------------
-- Records of capital
-- ----------------------------
INSERT INTO `capital` VALUES ('2', '95', '122', '111', '2016-03-18 08:10:55', '', '1995');
INSERT INTO `capital` VALUES ('3', '91', '111.1', '1111', '2016-01-14 23:09:46', '1111', '1971');
INSERT INTO `capital` VALUES ('4', '71', '1111', '11111', '2016-01-14 23:09:46', '11111', '1971');
INSERT INTO `capital` VALUES ('5', '中南大学', '112', '这只是介绍', '2016-01-20 20:05:35', '11111', '1991');

-- ----------------------------
-- Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `enterprise_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业id',
  `enterprise_name` varchar(100) NOT NULL COMMENT '企业名称',
  `enterprise_code` varchar(45) NOT NULL COMMENT '组织机构代码',
  `enterprise_address` varchar(100) NOT NULL COMMENT '注册地址',
  `enterprise_representative` varchar(20) NOT NULL COMMENT '法定代表人',
  `enterprise_phone` varchar(20) NOT NULL COMMENT '联系方式',
  `enterprise_property` varchar(20) NOT NULL COMMENT '注册时间',
  `enterprise_investors` varchar(45) NOT NULL COMMENT '投资方',
  `enterprise_investor_place` varchar(20) NOT NULL COMMENT '籍贯',
  `enterprise_investor_phone` varchar(20) NOT NULL COMMENT '投资者联系方式',
  `enterprise_last_year_scottare` double NOT NULL COMMENT '上年度营业收入',
  `enterprise_contacts_name` varchar(10) NOT NULL COMMENT '联系人姓名',
  `enterprise_contacts_duty` varchar(20) NOT NULL COMMENT '联系人职务',
  `enterprise_contacts_phone` varchar(20) NOT NULL COMMENT '联系人电话',
  `enterprise_contacts_telephone` varchar(20) NOT NULL COMMENT '联系人手机',
  `enterprise_contacts_fax` varchar(20) NOT NULL COMMENT '联系人传真',
  `enterprise_contacts_email` varchar(30) NOT NULL COMMENT '联系人邮箱',
  `enterprise_position` varchar(30) NOT NULL COMMENT '所在县市区、园区',
  `enterprise_introduction` text NOT NULL COMMENT '单位简介',
  `project_introduction` text NOT NULL COMMENT '项目简介',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'TimeStamp',
  `remark` text COMMENT '补充字段',
  `enterprise_last_year_tax` double NOT NULL,
  `elastyear_in_out` double NOT NULL,
  PRIMARY KEY (`enterprise_id`),
  UNIQUE KEY `enterprise_id_UNIQUE` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='企业信息表';

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('5', 'zrq有限公司', '11111111', '111111111111', '1111111', '111111111111', '2015-12-11', '1111111111111', '111', '1111', '11111', '2222', '22', '222', '2222', '222', '2222@qq.com', '121212', 'zrq', '212121', '2016-03-28 22:43:17', null, '1122', '0');
INSERT INTO `enterprise` VALUES ('6', '企业代表2', '11111', '11111', '111', '1111', '1899-12-30', '11', '11111', '11', '1111', '1111', '11', '111', '11', '1111', '201@qq.com', '1111111', 'zrq', '1111111111111', '2016-03-28 22:56:24', null, '11', '0');
INSERT INTO `enterprise` VALUES ('7', 'dadadad', '11111', 'dadadad', '1', '11111111', '1899-12-30', '1111111', '11', '1111', '111', '企业代表人  吴××', 'dada', '111', '1', '111', '1@qq.com', 'dadadad', 'dad', 'dadad', '2016-03-28 11:46:28', null, '11', '0');
INSERT INTO `enterprise` VALUES ('8', 'dadadadxxx', '11111', 'dadadad', '企业代表人王××', '11111111', '1898-12-30', '1111111', '11', '1111', '111', 'dadad', 'dada', '111', '1', '111', '1@qq.com', 'dadadad', 'dad', 'dadad', '2016-03-28 11:45:34', null, '11', '0');
INSERT INTO `enterprise` VALUES ('11', 'dadad', '1111', '11111', '11111111', '111', '1897-12-21', '11111', '111', '111111', '11111', '1', '111', '111111111', '11111111', '111111', '1111111@qq.com', '1111', '1dadadad', 'daadad', '2016-01-17 16:40:04', null, '111111111', '0');
INSERT INTO `enterprise` VALUES ('12', 'dadad', '1111', '11111', '11111111', '111', '1897-12-21', '11111', '111', '111111', '11111', '1', '111', '111111111', '11111111', '111111', '1111111@qq.com', '1111', '1dadadad', 'daadad', '2016-01-17 16:40:04', null, '111111111', '0');
INSERT INTO `enterprise` VALUES ('13', 'zrq', '1111', '11111', '11111111', '111', '1896-12-21', '11111', '111', '111111', '11111', '1', '111', '111111111', '11111111', '111111', '1111111@qq.com', '1111', '1dadadad', 'daadad', '2016-03-13 20:48:00', null, '111111111', '0');
INSERT INTO `enterprise` VALUES ('20', 'zzz11aaaa', '1111111', '11111111', '111', '11', '1111111111', '1111111', '11111111111', '11111111', '11111111', '1', '1', '111111111', '11111111', '11111111', '111@qq.cc', '11111111', '222222', '111111111', '2016-03-27 18:19:33', null, '1111111111', '111111111');
INSERT INTO `enterprise` VALUES ('21', '微云', '-', '-', '-', '-', '-', '100', '-', '-', '100', '--', '--', '--', '15973215371', '--', '709015775@qq.com', '--', '--', '--', '2016-03-29 14:57:47', null, '100', '100');

-- ----------------------------
-- Table structure for `enterprise_capital_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_capital_relationship`;
CREATE TABLE `enterprise_capital_relationship` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `enterprise_id` int(11) NOT NULL COMMENT '企业id',
  `capital_id` int(11) NOT NULL COMMENT '资金id',
  `enterprise_capital_num` double NOT NULL COMMENT '资金额度',
  `enterprise_type` char(1) NOT NULL COMMENT '是否重点培育',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` text,
  PRIMARY KEY (`relation_id`),
  UNIQUE KEY `id_UNIQUE` (`relation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='企业和资金关系表';

-- ----------------------------
-- Records of enterprise_capital_relationship
-- ----------------------------
INSERT INTO `enterprise_capital_relationship` VALUES ('3', '3', '2', '20', '1', '2016-03-13 20:08:02', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('4', '0', '2', '20', '1', '2016-03-13 20:47:16', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('5', '0', '2', '112', '1', '2016-03-13 21:01:42', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('7', '7', '3', '2201', '1', '2016-03-28 11:46:28', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('8', '0', '3', '122', '1', '2016-03-13 20:28:28', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('10', '0', '4', '1', '0', '2016-03-18 08:11:49', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('11', '0', '5', '111', '2', '2016-03-27 18:00:03', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('13', '0', '4', '11', '0', '2016-03-27 18:03:23', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('14', '0', '4', '11', '0', '2016-03-27 18:03:23', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('15', '0', '4', '1', '1', '2016-03-27 18:04:01', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('16', '0', '4', '1', '1', '2016-03-27 18:04:01', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('17', '0', '4', '11', '1', '2016-03-27 18:07:01', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('18', '0', '4', '11', '1', '2016-03-27 18:07:01', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('19', '0', '5', '1', '2', '2016-03-27 18:11:25', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('20', '0', '2', '111', '2', '2016-03-27 18:15:03', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('21', '20', '3', '1111', '2', '2016-03-27 18:19:33', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('22', '5', '4', '12', '1', '2016-03-28 22:43:17', null);
INSERT INTO `enterprise_capital_relationship` VALUES ('44', '6', '5', '1', '1', '2016-03-28 22:56:24', null);

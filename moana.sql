
/*
Navicat MariaDB Data Transfer

Source Server         : localhost
Source Server Version : 100120
Source Host           : localhost:3306
Source Database       : moana

Target Server Type    : MariaDB
Target Server Version : 100120
File Encoding         : 65001

Date: 2017-01-05 08:53:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for movieticket
-- ----------------------------
DROP TABLE IF EXISTS `movieticket`;
CREATE TABLE `movieticket` (
  `TID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `MOVIENAME` varchar(255) CHARACTER SET utf8 NOT NULL,
  `RUNTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TICKETNUM` int(11) NOT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movieticket
-- ----------------------------
INSERT INTO `movieticket` VALUES ('1', '情圣', '2017-01-06 10:34:57', '290');
INSERT INTO `movieticket` VALUES ('2', '铁道飞虎', '2017-01-06 15:13:29', '298');
INSERT INTO `movieticket` VALUES ('3', '星球大战外传：侠盗一号', '2017-01-07 10:57:31', '299');
INSERT INTO `movieticket` VALUES ('4', '长城', '2017-01-07 19:08:26', '299');
INSERT INTO `movieticket` VALUES ('5', '摆渡人', '2017-01-08 17:24:47', '300');
INSERT INTO `movieticket` VALUES ('6', '血战钢锯岭', '2017-01-08 17:25:07', '300');
INSERT INTO `movieticket` VALUES ('7', '那年夏天你去了哪里', '2017-01-09 17:25:29', '300');
INSERT INTO `movieticket` VALUES ('8', '你好，疯子', '2017-01-10 20:25:44', '300');
INSERT INTO `movieticket` VALUES ('9', '单身日记：好孕来袭', '2017-01-10 11:26:15', '300');
INSERT INTO `movieticket` VALUES ('10', '一路逆风', '2017-01-11 17:44:35', '300');
INSERT INTO `movieticket` VALUES ('11', '你的名字。', '2017-01-12 19:44:11', '299');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(30) CHARACTER SET utf8 NOT NULL,
  `PASSWORD` varchar(20) CHARACTER SET utf8 NOT NULL,
  `USERNAME` varchar(20) CHARACTER SET utf8 NOT NULL,
  `LEFTGRABNUM` int(11) NOT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  `grabTime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

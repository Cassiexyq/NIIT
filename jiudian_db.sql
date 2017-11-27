/*
Navicat MySQL Data Transfer

Source Server         : localmysql
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : jiudian_db

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-11-23 12:03:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_fenlei`
-- ----------------------------
DROP TABLE IF EXISTS `t_fenlei`;
CREATE TABLE `t_fenlei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `deletestatus` int(11) NOT NULL,
  `jiage` double NOT NULL,
  `leixing` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fenlei
-- ----------------------------
INSERT INTO `t_fenlei` VALUES ('6', '2017-11-21 13:51:13', '0', '156', '大床房');
INSERT INTO `t_fenlei` VALUES ('7', '2017-11-21 13:51:23', '0', '256', '双床房');
INSERT INTO `t_fenlei` VALUES ('8', '2017-11-21 13:51:34', '0', '688', '情侣房');
INSERT INTO `t_fenlei` VALUES ('9', '2017-11-21 13:51:50', '0', '1068', '总统套房');

-- ----------------------------
-- Table structure for `t_kaifang`
-- ----------------------------
DROP TABLE IF EXISTS `t_kaifang`;
CREATE TABLE `t_kaifang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beizhu` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `jiezhangstatus` varchar(255) DEFAULT NULL,
  `kehuname` varchar(255) DEFAULT NULL,
  `ruzhutime` datetime DEFAULT NULL,
  `tianshu` int(11) NOT NULL,
  `tuifangtime` datetime DEFAULT NULL,
  `xiaofei` double NOT NULL,
  `yajin` double NOT NULL,
  `kefangid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE682DF1CAFDBF4E2` (`kefangid`),
  CONSTRAINT `FKE682DF1CAFDBF4E2` FOREIGN KEY (`kefangid`) REFERENCES `t_kefang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kaifang
-- ----------------------------
INSERT INTO `t_kaifang` VALUES ('1', '一天', '324543245646346', '未结账', '卢思思', '2017-11-21 14:00:27', '0', null, '0', '100', '9');

-- ----------------------------
-- Table structure for `t_kefang`
-- ----------------------------
DROP TABLE IF EXISTS `t_kefang`;
CREATE TABLE `t_kefang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deletestatus` int(11) NOT NULL,
  `fangjianhao` varchar(255) DEFAULT NULL,
  `fangjianstatus` varchar(255) DEFAULT NULL,
  `miaoshu` varchar(255) DEFAULT NULL,
  `fenleiid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3932E659AE2F5C48` (`fenleiid`),
  CONSTRAINT `FK3932E659AE2F5C48` FOREIGN KEY (`fenleiid`) REFERENCES `t_fenlei` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kefang
-- ----------------------------
INSERT INTO `t_kefang` VALUES ('7', '0', 'A101', '空房', '--', '6');
INSERT INTO `t_kefang` VALUES ('8', '0', 'A102', '空房', '--', '7');
INSERT INTO `t_kefang` VALUES ('9', '0', 'A103', '已入住', '--', '8');
INSERT INTO `t_kefang` VALUES ('10', '0', 'A104', '空房', '--', '9');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createtime` datetime DEFAULT NULL,
  `lianxifangshi` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `truename` varchar(255) DEFAULT NULL,
  `userlock` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10', null, null, '111111', '1', 'admin', '0', 'admin', null);
INSERT INTO `t_user` VALUES ('11', '2017-11-21 11:56:33', '111', '111111', '0', '111', '0', 'test', '男');

-- ----------------------------
-- Table structure for `t_yuding`
-- ----------------------------
DROP TABLE IF EXISTS `t_yuding`;
CREATE TABLE `t_yuding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beizhu` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `lianxifangshi` varchar(255) DEFAULT NULL,
  `truename` varchar(255) DEFAULT NULL,
  `xingbie` varchar(255) DEFAULT NULL,
  `yudingidcard` varchar(255) DEFAULT NULL,
  `yudingstatus` int(11) NOT NULL,
  `yudingtime` varchar(255) DEFAULT NULL,
  `kefangid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51F76C65AFDBF4E2` (`kefangid`),
  KEY `FK51F76C657614FDC` (`userid`),
  CONSTRAINT `FK51F76C657614FDC` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FK51F76C65AFDBF4E2` FOREIGN KEY (`kefangid`) REFERENCES `t_kefang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yuding
-- ----------------------------
INSERT INTO `t_yuding` VALUES ('1', '我要三点入住', '2017-11-21 13:59:08', '15158755875', '王小红', '男', '532723188575485451', '0', '2017/11/28 15:00', '10', '11');
INSERT INTO `t_yuding` VALUES ('2', '我要寄存行李', '2017-11-21 13:59:48', '15878544751', '张芳芳', '女', '5327231857465451', '0', '2017/11/24 15:00', '7', '11');

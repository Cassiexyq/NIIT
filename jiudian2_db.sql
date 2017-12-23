/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : jiudian_db

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-23 22:14:15
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fenlei
-- ----------------------------
INSERT INTO `t_fenlei` VALUES ('6', '2017-11-21 13:51:13', '0', '156', '大床房');
INSERT INTO `t_fenlei` VALUES ('7', '2017-11-21 13:51:23', '1', '256', '双床房');
INSERT INTO `t_fenlei` VALUES ('8', '2017-11-21 13:51:34', '1', '688', '情侣房');
INSERT INTO `t_fenlei` VALUES ('9', '2017-11-21 13:51:50', '0', '1068', '总统套房');
INSERT INTO `t_fenlei` VALUES ('10', '2017-12-19 17:31:31', '0', '568', '家庭房');
INSERT INTO `t_fenlei` VALUES ('11', '2017-12-19 17:31:55', '0', '234', '标间');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kaifang
-- ----------------------------
INSERT INTO `t_kaifang` VALUES ('2', '', '371921786234523', '已结账', '张贝贝', '2017-12-19 18:13:37', '2', '2017-12-20 18:36:52', '2136', '200', '10');
INSERT INTO `t_kaifang` VALUES ('3', '', '330234196743211123', '未结账', '萱萱', '2017-12-20 17:33:54', '0', null, '0', '0', '11');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kefang
-- ----------------------------
INSERT INTO `t_kefang` VALUES ('7', '0', 'B301', '空房', '一张大床，有独卫，有阳台', '6');
INSERT INTO `t_kefang` VALUES ('8', '1', 'A102', '空房', '--', '7');
INSERT INTO `t_kefang` VALUES ('9', '1', 'A103', '空房', '--', '8');
INSERT INTO `t_kefang` VALUES ('10', '0', 'E501', '空房', '高级家具，含早餐，所有设施齐全', '9');
INSERT INTO `t_kefang` VALUES ('11', '0', 'C301', '已入住', '一张大床，一张单人床，有独卫，有阳台，有客厅，有厨房', '10');
INSERT INTO `t_kefang` VALUES ('12', '0', 'B201', '空房', '两张单人床，有独卫，无阳台', '11');
INSERT INTO `t_kefang` VALUES ('13', '0', 'B302', '空房', '一张大床，无阳台', '6');
INSERT INTO `t_kefang` VALUES ('14', '0', 'B202', '空房', '两张单人床', '11');
INSERT INTO `t_kefang` VALUES ('15', '0', 'C102', '已预定', '设备齐全，两张床，一大一小', '10');

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10', null, null, '111111', '1', 'admin', '0', 'admin', null);
INSERT INTO `t_user` VALUES ('11', '2017-11-21 11:56:33', '111', '111111', '0', '111', '1', 'test', '男');
INSERT INTO `t_user` VALUES ('12', '2017-12-19 16:33:16', '13345276548', '121212', '0', '萱萱', '0', 'Cassie', '女');
INSERT INTO `t_user` VALUES ('13', '2017-12-19 17:29:31', '13422345643', '111111', '0', '王小轩', '0', '小轩', '男');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_yuding
-- ----------------------------
INSERT INTO `t_yuding` VALUES ('6', '', '2017-12-20 16:34:03', '13345276548', '萱萱', '女', '330234196743211123', '1', null, '15', '12');
INSERT INTO `t_yuding` VALUES ('11', '', '2017-12-20 17:22:40', '13345276548', '萱萱', '', '330234196743211123', '2', '2017-12-20 17:22:40', '11', '12');
INSERT INTO `t_yuding` VALUES ('12', '', '2017-12-20 18:35:50', '13422345643', '王小轩', '男', '3344223967490234', '0', '2017-12-20 18:35:50', '15', '13');

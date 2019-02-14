/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : music

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2019-02-14 14:45:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment` varchar(255) NOT NULL,
  `songId` bigint(20) DEFAULT NULL,
  `songName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `librarian`
-- ----------------------------
DROP TABLE IF EXISTS `librarian`;
CREATE TABLE `librarian` (
  `Gender` varchar(10) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Address` varchar(0) DEFAULT NULL,
  `section` bigint(20) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  `Salary` double DEFAULT NULL,
  `LibBNo` bigint(20) NOT NULL,
  PRIMARY KEY (`LibBNo`),
  KEY `section` (`section`),
  CONSTRAINT `section` FOREIGN KEY (`section`) REFERENCES `section` (`SectNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `superssn` FOREIGN KEY (`LibBNo`) REFERENCES `librarian` (`LibBNo`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of librarian
-- ----------------------------

-- ----------------------------
-- Table structure for `mcomment`
-- ----------------------------
DROP TABLE IF EXISTS `mcomment`;
CREATE TABLE `mcomment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ownerId` bigint(255) DEFAULT NULL,
  `fromId` bigint(255) DEFAULT NULL,
  `fromName` varchar(255) DEFAULT NULL,
  `likeNum` int(11) DEFAULT NULL,
  `fromAvatar` varchar(255) DEFAULT NULL,
  `reply` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mcomment
-- ----------------------------
INSERT INTO `mcomment` VALUES ('1', '7', '4', '', '3', 'http://ww4.sinaimg.cn/bmiddle/006DLFVFgy1ft0j2pddjuj30v90uvagf.jpg', null, '非常靠谱的程序员', '2019-01-15 11:37:00');
INSERT INTO `mcomment` VALUES ('2', '7', null, 'null', '0', 'http://ww4.sinaimg.cn/bmiddle/006DLFVFgy1ft0j2pddjuj30v90uvagf.jpg', null, '123', '2019-02-14 13:18:06');
INSERT INTO `mcomment` VALUES ('3', '7', null, 'li', '0', null, null, '123', '2019-02-14 13:21:53');
INSERT INTO `mcomment` VALUES ('4', '3', null, 'li', '0', null, null, '123', '2019-02-14 13:29:31');
INSERT INTO `mcomment` VALUES ('5', '3', null, 'li', '0', null, null, '', '2019-02-14 13:31:01');
INSERT INTO `mcomment` VALUES ('6', '4', null, 'li', '0', null, null, 'lih', '2019-02-14 13:38:37');
INSERT INTO `mcomment` VALUES ('7', '4', null, 'li', '0', null, null, '123', '2019-02-14 13:43:42');
INSERT INTO `mcomment` VALUES ('8', '3', null, 'li', '0', null, null, '1234', '2019-02-14 13:51:12');

-- ----------------------------
-- Table structure for `music`
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `img` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `singer` varchar(255) DEFAULT NULL,
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('https://y.gtimg.cn/music/photo_new/T002R150x150M000004TQc7M3bsr39.jpg?max_age=2592000', '10098', '红绿灯', '英文音乐', 'http://sc1.111ttt.cn:8282/2018/1/03m/13/396131232171.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3', null, '郑敏', '3');
INSERT INTO `music` VALUES ('https://y.gtimg.cn/music/photo_new/T002R150x150M000002LvbBx02Ex0V.jpg?max_age=2592000', '3000', '无侠', '粤语音乐', 'http://sc1.111ttt.cn:8282/2018/1/03m/13/396131232171.m4a?tflag=1519095601&pin=6cd414115fdb9a950d827487b16b5f97#.mp3', null, null, '4');
INSERT INTO `music` VALUES ('https://y.gtimg.cn/music/photo_new/T002R150x150M000001Qp10A3tDOIX.jpg?max_age=2592000', null, '一颗会开花的树', '流行音乐', null, null, null, '6');
INSERT INTO `music` VALUES ('https://y.gtimg.cn/music/photo_new/T002R300x300M000001IV22P1RDX7p.jpg?max_age=2592000', '100000', 'Checkmate ', '流行音乐', '', null, '林俊杰', '7');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `title` varchar(255) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `new_date` date NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('林俊杰即将来成都', '4月中旬，林俊杰即将来成都开演唱会', '2019-02-01', 'https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=179b770da5ec8a13141a50e6cf38f6b2/32fa828ba61ea8d3bda827e69b0a304e241f584d.jpg', '2');
INSERT INTO `news` VALUES ('我是歌手', '歌手第二季开播，刘欢坐镇', '2019-01-02', null, '3');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(30) NOT NULL,
  `roleid` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '/readName', '1', 'admin');
INSERT INTO `permission` VALUES ('2', '/readData', '2', 'user');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员');
INSERT INTO `role` VALUES ('2', '普通用户', '普通用户');
INSERT INTO `role` VALUES ('3', '购买商品用户', '用户');

-- ----------------------------
-- Table structure for `section`
-- ----------------------------
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `headssn` bigint(20) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `SectNo` bigint(20) NOT NULL,
  PRIMARY KEY (`SectNo`),
  KEY `headssn` (`headssn`),
  CONSTRAINT `headssn` FOREIGN KEY (`headssn`) REFERENCES `librarian` (`LibBNo`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of section
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `role` varchar(11) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('2', 'li', '123', '1', null);
INSERT INTO `tb_user` VALUES ('3', 'huihui', '01361421b81c236a3682e22bbb1a4914', '1', 'abcdef');
INSERT INTO `tb_user` VALUES ('4', 'hui', '123456', '0', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '2016141462099', '123456', '123456');
INSERT INTO `user` VALUES ('2', '1234', null, '1234');
INSERT INTO `user` VALUES ('4', 'huihui', null, '123456');

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('4', '4', '3');

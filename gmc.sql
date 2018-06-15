/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : gmc

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-06-13 21:07:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `gmc_brand`
-- ----------------------------
DROP TABLE IF EXISTS `gmc_brand`;
CREATE TABLE `gmc_brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `manu_id` int(11) NOT NULL,
  `en_name` varchar(150) DEFAULT NULL,
  `cn_name` varchar(150) DEFAULT NULL,
  `logo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`brand_id`),
  KEY `gmc_brand` (`manu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmc_brand
-- ----------------------------

-- ----------------------------
-- Table structure for `gmc_manuf`
-- ----------------------------
DROP TABLE IF EXISTS `gmc_manuf`;
CREATE TABLE `gmc_manuf` (
  `manu_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `en_name` varchar(150) DEFAULT NULL,
  `cn_name` varchar(150) DEFAULT NULL,
  `certi_type` char(100) DEFAULT NULL,
  `status` char(100) DEFAULT NULL,
  PRIMARY KEY (`manu_id`),
  KEY `gmc_manuf` (`user_id`),
  KEY `manu_id` (`manu_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmc_manuf
-- ----------------------------
INSERT INTO `gmc_manuf` VALUES ('2', '1', 'wfgdsfs', '山豆根豆腐干', '儿童广东人鬼地方', '大范甘迪风格');
INSERT INTO `gmc_manuf` VALUES ('4', '1', '山豆根豆腐干', '大范甘迪风格豆', '大范甘迪风格', '大范甘迪');
INSERT INTO `gmc_manuf` VALUES ('6', '1', 'PTY', '123', '321434', 'dews');
INSERT INTO `gmc_manuf` VALUES ('7', '1', 'KIII', 'asfd', 'sfsd', 'sdfsd');
INSERT INTO `gmc_manuf` VALUES ('8', '14', '13213123', 'dfgdf', 'sdfsd', 'sdfsdf');
INSERT INTO `gmc_manuf` VALUES ('9', '15', 'wfe', 'weftgsf', 'wefs', 'sfsd啊大叔vc');
INSERT INTO `gmc_manuf` VALUES ('10', '17', 'AAAA', '123', 'wef', 'sdfds');

-- ----------------------------
-- Table structure for `gmc_user`
-- ----------------------------
DROP TABLE IF EXISTS `gmc_user`;
CREATE TABLE `gmc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(150) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `nick_name` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gmc_user
-- ----------------------------
INSERT INTO `gmc_user` VALUES ('1', 'Mike', '73e4679dab7f54a42362ee9f7d2ce0fd', 'dddd', 'Wdddd@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('2', 'Mike', '73e4679dab7f54a42362ee9f7d2ce0fd', 'dddd', 'Wdddd@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('3', 'Mike', '202cb962ac59075b964b07152d234b70', 'Mike', 'WW@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('4', 'å°é£', '202cb962ac59075b964b07152d234b70', 'ç¬ç¬', 'kkkk@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('5', 'jia', '202cb962ac59075b964b07152d234b70', 'apple', 'asdafdfa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('6', 'jyw', '202cb962ac59075b964b07152d234b70', 'jia', 'asdafdfa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('7', 'qweqw', '202cb962ac59075b964b07152d234b70', 'asdfsa', 'werw@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('8', 'ppp', '202cb962ac59075b964b07152d234b70', 'fdff', 'qwqq@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('9', 'MC', '202cb962ac59075b964b07152d234b70', 'MC', 'aaa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('10', 'MCC', '202cb962ac59075b964b07152d234b70', 'AA', 'aaa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('11', 'KII', '202cb962ac59075b964b07152d234b70', 'KII', 'asdafdfa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('12', 'LPLP', '202cb962ac59075b964b07152d234b70', '123', 'asdafdfa@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('13', 'ert', '202cb962ac59075b964b07152d234b70', '123', '2134@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('14', 'MCC', '202cb962ac59075b964b07152d234b70', 'erwe', 'qwe@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('15', 'ASK', '202cb962ac59075b964b07152d234b70', 'ASK', 'ard@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('16', 'OPOP', '202cb962ac59075b964b07152d234b70', 'wd', 'sdfsd@qq.com', '1');
INSERT INTO `gmc_user` VALUES ('17', 'ASD', '202cb962ac59075b964b07152d234b70', 'dfsd', 'wfsd@qq.com', '1');

/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2017-03-30 07:14:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `contentid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `contentmain` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`contentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of content
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `productname` varchar(20) NOT NULL,
  `orderaddress` varchar(20) NOT NULL,
  `orderprice` double(40,0) NOT NULL,
  `ordernum` int(4) NOT NULL,
  `ordertel` varchar(20) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(4) NOT NULL AUTO_INCREMENT,
  `producttype` varchar(20) CHARACTER SET latin1 NOT NULL,
  `productname` varchar(255) NOT NULL,
  `price` double(20,0) NOT NULL,
  `salenum` int(4) NOT NULL,
  `imgurl` varchar(100) CHARACTER SET latin1 NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '智能擦窗机器人', '999', '0', '../images/1-big-1.jpg', '1', null);
INSERT INTO `product` VALUES ('2', '2', '智能擦窗机器人', '999', '0', '../images/1-big-1.jpg', '1', null);
INSERT INTO `product` VALUES ('3', '3', '智能擦窗机器人', '999', '0', '../images/1-big-1.jpg', '1', null);

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sellerid` int(11) NOT NULL,
  `myusername` varchar(20) NOT NULL,
  `mypassword` varchar(20) NOT NULL,
  `earning` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`sellerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seller
-- ----------------------------

-- ----------------------------
-- Table structure for shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `shoppingcartid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) NOT NULL,
  `productname` varchar(20) NOT NULL,
  `price` double(20,0) DEFAULT NULL,
  `imgurl` varchar(100) DEFAULT NULL,
  `shopppingcartid` int(11) NOT NULL,
  PRIMARY KEY (`shoppingcartid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `tel` varchar(20) NOT NULL,
  `money` double(15,0) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1');

/*
Navicat MySQL Data Transfer

Source Server         : wqj1
Source Server Version : 50621
Source Host           : 112.74.42.19:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-05-10 10:14:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `contentid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `contentmain` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`contentid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('1', '1', '1', '王雨', '4导风口：两侧翼设计，降低噪音，工作安静');
INSERT INTO `content` VALUES ('2', '1', '1', '李四', '2芯片：升级一代芯片，运行更稳定，更智能');
INSERT INTO `content` VALUES ('3', '1', '1', '张三', '更犀利，富有科技感，时尚简约大方');
INSERT INTO `content` VALUES ('4', '1', '12', '天堂羽', '清洁布：海岛超纤纱清洁布，灰白色，更耐脏。');
INSERT INTO `content` VALUES ('5', '1', '12', '雨下一整晚', '适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙,很棒');
INSERT INTO `content` VALUES ('6', '1', '1', '哈哈哈', '适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙');
INSERT INTO `content` VALUES ('7', '1', '2', '丁一', '更犀利，富有科技感，时尚简约大方');
INSERT INTO `content` VALUES ('8', '1', '3', '哈哈哈', '导风口两侧翼设计，降低噪音，工作安静');
INSERT INTO `content` VALUES ('9', '1', '9', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('10', '1', '4', '天天通苑', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('11', '1', '5', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('12', '1', '6', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('13', '1', '7', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('14', '1', '8', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('15', '1', '9', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('16', '1', '10', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('17', '1', '11', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('18', '1', '13', '天堂羽', '马达加强马达，吸力更强，安全更有保障');
INSERT INTO `content` VALUES ('19', '1', '14', '天堂羽', '马达加强马达，吸力更强，安全更有保障');

-- ----------------------------
-- Table structure for `flash`
-- ----------------------------
DROP TABLE IF EXISTS `flash`;
CREATE TABLE `flash` (
  `flashid` int(4) NOT NULL AUTO_INCREMENT,
  `productid` int(4) DEFAULT NULL,
  `bigimgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flashid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flash
-- ----------------------------
INSERT INTO `flash` VALUES ('1', '1', '../images/images1.jpg');
INSERT INTO `flash` VALUES ('2', '2', '../images/images2.jpg');
INSERT INTO `flash` VALUES ('3', '3', '../images/images3.jpg');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `productname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `orderaddress` varchar(20) CHARACTER SET utf8 NOT NULL,
  `orderprice` double(40,0) NOT NULL,
  `ordernum` int(4) NOT NULL,
  `ordertel` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('3', '1', '1', '1', '智能擦窗机器人', '1', '2997', '3', '1');
INSERT INTO `order` VALUES ('20', '12', '1', 'qqq', '智能擦窗机器人', '1', '999', '1', '15167194421');
INSERT INTO `order` VALUES ('25', '13', '9', '天堂羽', '双重静电压缩收纳袋', '杭州拱墅区湖州街51号', '5000', '1', '15167194421');
INSERT INTO `order` VALUES ('26', '13', '11', '天堂羽', '扫拖二合一', '杭州拱墅区湖州街51号', '250', '1', '15167194421');
INSERT INTO `order` VALUES ('27', '13', '2', '天堂羽', '双重静电压缩收纳袋', '杭州拱墅区湖州街51号', '246', '2', '15167194421');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productid` int(4) NOT NULL AUTO_INCREMENT,
  `producttype` varchar(20) NOT NULL,
  `productname` varchar(255) NOT NULL,
  `price` double(20,0) NOT NULL,
  `salenum` int(4) NOT NULL,
  `imgurl` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `state` int(4) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '1', '智能擦窗机器人123', '1999', '0', '/upload/14927853283381-big-2.jpg', '【1德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('2', '2', '双重静电压缩收纳袋', '999', '2', '/upload/14940933845032-b-1.jpg', '【2德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('3', '3', '智能擦窗机器人', '2999', '0', '/upload/14945193710893-b-1.jpg', '【3德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('4', '2', '智能扫地机1', '505', '1', '/upload/14927853283381-big-2.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('5', '2', '智能拖地机1', '256', '1', '/upload/14956785394171-big-1.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布哈哈哈啊哈哈，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('9', '1', '双重静电压缩收纳袋11', '500', '2', '/upload/14927853283381-big-2.jpg', '节省约70%空间台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('10', '2', '双重静电压缩收纳袋22', '100', '0', '/upload/14927853283381-big-2.jpg', '121212台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('11', '1', '扫拖二合一', '500', '1', '/upload/14927853283381-big-2.jpg', '气味气味气味大撒大声地往往往往往往 台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('12', '1', '智能擦窗机器人', '666', '2', '/upload/14927853283381-big-2.jpg', '【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('13', '1', '智能擦窗机器人', '507', '0', '/upload/14956785394171-big-1.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。1', null);
INSERT INTO `product` VALUES ('14', '2', '智能擦窗机器人222', '508', '0', '/upload/14927853283381-big-2.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮 【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】 1外观：更犀利，富有科技感，时尚简约大方 2芯片：升级一代芯片，运行更稳定，更智能 3马达：加强马达，吸力更强，安全更有保障 4导风口：两侧翼设计，降低噪音，工作安静 5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。222', null);
INSERT INTO `product` VALUES ('15', '3', 'HOBOT', '555', '0', '/upload/14953814395311-big-5.jpg', '极品属性，完美攻击，品质一流，已经附魔,超低价甩了！【+12战刃】极品属性，完美攻击，品质一流，已经附魔, 超低价甩了！！买就买最好！而且以后升值机会很大，懂的的要抓紧喽！！ ...o(∩_∩)o...踪迹天涯Ⅰ族团队', null);
INSERT INTO `product` VALUES ('16', '3', '智能擦窗机器人B3', '1200', '0', '/upload/14960210661503-b-3.jpg', '从娱乐业和房地产开发的角度来说，波卡格兰德都是一座死气沉沉的小镇，过去是这样，将来也许还会是这样。这就是为什么它吸引了无数富有朝气的人。  这里适合游泳、钓鱼和打高尔夫球的最好的地方，普罗维登斯市在这方面做得很是不错。', null);
INSERT INTO `product` VALUES ('17', '3', '拖扫二和一B2', '233', '0', '/upload/14958301438583-b-2.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮\r\n【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】\r\n1外观：更犀利，富有科技感，时尚简约大方\r\n2芯片：升级一代芯片，运行更稳定，更智能\r\n3马达：加强马达，吸力更强，安全更有保障\r\n4导风口：两侧翼设计，降低噪音，工作安静\r\n5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);
INSERT INTO `product` VALUES ('18', '3', '收纳袋B4', '25', '0', '/upload/14937515243892-b-4.jpg', '台湾进口玻妞智能擦窗机器人家用全自动波妞双面擦中空玻璃电动刮\r\n【德国纽伦堡发明金奖】【台湾制造 原装进口】【适用于任何厚度的玻璃窗 还可以擦地 擦墙纸 浴室瓷砖墙】\r\n1外观：更犀利，富有科技感，时尚简约大方\r\n2芯片：升级一代芯片，运行更稳定，更智能\r\n3马达：加强马达，吸力更强，安全更有保障\r\n4导风口：两侧翼设计，降低噪音，工作安静\r\n5清洁布：海岛超纤纱清洁布，灰白色，更耐脏。', null);

-- ----------------------------
-- Table structure for `promotion`
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `finishdate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES ('1', '1', '500.00', '2017-04-08 13:28:12', '2017-04-19 13:28:19');
INSERT INTO `promotion` VALUES ('2', '2', '123.00', '2017-05-10 02:32:43', '2017-05-04 19:11:00');
INSERT INTO `promotion` VALUES ('3', '11', '250.00', '2017-05-10 06:30:00', '2017-05-10 06:31:00');
INSERT INTO `promotion` VALUES ('9', '15', '250.00', '2017-05-10 00:00:00', '2017-05-11 00:00:00');

-- ----------------------------
-- Table structure for `seller`
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `sellerid` int(11) NOT NULL AUTO_INCREMENT,
  `myusername` varchar(20) CHARACTER SET utf8 NOT NULL,
  `mypassword` varchar(20) NOT NULL,
  `earning` double(20,0) DEFAULT NULL,
  PRIMARY KEY (`sellerid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '1', '1', '10566');

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `shoppingcartid` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) NOT NULL,
  `productid` int(4) NOT NULL,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `productname` varchar(20) CHARACTER SET utf8 NOT NULL,
  `price` double(20,0) DEFAULT NULL,
  `imgurl` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`shoppingcartid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------
INSERT INTO `shoppingcart` VALUES ('9', '1', '1', '1', '智能擦窗机器人', '999', '../images/1-big-1.jpg');
INSERT INTO `shoppingcart` VALUES ('12', '1', '9', '1', '双重静电压缩收纳袋', '500', '/upload/14934366722342-b-1.jpg');
INSERT INTO `shoppingcart` VALUES ('13', '1', '11', '1', '扫拖二合一', '500', '/upload/14928268040893-b-1.jpg');
INSERT INTO `shoppingcart` VALUES ('14', '1', '12', '1', '智能擦窗机器人', '666', '/upload/14939897741803-b-3.jpg');
INSERT INTO `shoppingcart` VALUES ('15', '13', '9', '天堂羽', '双重静电压缩收纳袋', '500', '/upload/14927853283381-big-2.jpg');
INSERT INTO `shoppingcart` VALUES ('16', '13', '11', '天堂羽', '扫拖二合一', '250', '/upload/14927853283381-big-2.jpg');
INSERT INTO `shoppingcart` VALUES ('17', '13', '16', '天堂羽', '智能擦窗机器人B3', '1200', '/upload/14960210661503-b-3.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL,
  `address` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 NOT NULL,
  `money` double(15,0) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '杭州拱墅区湖州街51号', '15167194421', '9268', '461822951');
INSERT INTO `user` VALUES ('2', '2', '2', '2', '2', '2', '46182291');
INSERT INTO `user` VALUES ('3', '3', '3', '3', '3', '3', '46182295');
INSERT INTO `user` VALUES ('6', '13', '12', '3131', '312313', '0', '231313');
INSERT INTO `user` VALUES ('7', '沈涛', '123', '我家在黄土高坡', '15167194421', '0', '31301364@stu.zucc.edu.c');
INSERT INTO `user` VALUES ('8', '阿斯顿撒盛大', '12', '1323123', '123', '1000', '2313');
INSERT INTO `user` VALUES ('9', 'ee', '12', '1', '15167194421', '1000', '1');
INSERT INTO `user` VALUES ('10', '人人', '123', '1', '15167194421', '1000', '1');
INSERT INTO `user` VALUES ('11', '呃呃呃', '123', '1', '15167194421', '1000', '1');
INSERT INTO `user` VALUES ('12', 'qqq', '1', '1', '15167194421', '1', '4618229512@qq.com');
INSERT INTO `user` VALUES ('13', '天堂羽', '1', '杭州拱墅区湖州街51号', '15167194421', '24754', '461822951@qq.com');
INSERT INTO `user` VALUES ('14', 'qqqqqq', '1', '1', '1', '1000', '1');

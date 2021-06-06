/*
 Navicat Premium Data Transfer

 Source Server         : host
 Source Server Type    : MySQL
 Source Server Version : 50715
 Source Host           : localhost:3306
 Source Schema         : mess

 Target Server Type    : MySQL
 Target Server Version : 50715
 File Encoding         : 65001

 Date: 06/06/2021 19:10:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`
(
    `aid`      int(11)                                                NOT NULL AUTO_INCREMENT,
    `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin`
VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`   int(11)                                                 NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category`
VALUES (1, '服装鞋帽');
INSERT INTO `category`
VALUES (2, '教育图书');
INSERT INTO `category`
VALUES (3, '饰品挂件');
INSERT INTO `category`
VALUES (4, '生活用品');
INSERT INTO `category`
VALUES (5, '电子产品');
INSERT INTO `category`
VALUES (6, '虚拟商品');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity`
(
    `cid`         int(11)                                                 NOT NULL AUTO_INCREMENT,
    `uid`         int(11)                                                 NOT NULL,
    `name`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `contact`     varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `date`        datetime                                                NOT NULL,
    `price`       float(10, 2)                                            NOT NULL,
    `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `category`    int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`cid`) USING BTREE,
    INDEX `commodity_category_id_fk` (`category`) USING BTREE,
    INDEX `commodity_user_uid_fk` (`uid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity`
VALUES (1, 1, '艾利克斯', 'v社', '2021-06-05 12:27:05', 198.00, '88', 5);
INSERT INTO `commodity`
VALUES (2, 1, '计算机基础', 'qq：1872375096', '2021-06-04 20:22:17', 28.00, '九成新', 2);
INSERT INTO `commodity`
VALUES (3, 1, '波司登', 'wx：daboluo', '2021-06-05 12:27:36', 1298.98, '没钱了，换生活费', 1);
INSERT INTO `commodity`
VALUES (4, 2, 'ipad2019', 'tel：117263554627', '2021-06-06 13:34:26', 1999.99, '换2020，要的私', 5);
INSERT INTO `commodity`
VALUES (5, 2, '秋裤', 'wx:silkroad', '2021-06-06 13:35:36', 0.50, '诶，就是玩', 1);
INSERT INTO `commodity`
VALUES (6, 2, '挂坠一条', 'wx:silkroad', '2021-06-06 13:39:22', 12.30, '一图流', 3);
INSERT INTO `commodity`
VALUES (7, 2, '卷纸2箱', 'wx:silkroad', '2021-06-06 13:40:12', 20.00, '买多了2333，出', 4);
INSERT INTO `commodity`
VALUES (8, 3, '守望先锋数字典藏版cdkey', 'wx:wow', '2021-06-06 13:42:59', 128.00, '便宜出', 6);
INSERT INTO `commodity`
VALUES (9, 3, '计算机网络：自顶而下方法', 'wx:wow', '2021-06-06 13:43:58', 20.00, '八成新，价格可私', 2);
INSERT INTO `commodity`
VALUES (10, 3, '西南石油大学明信片', 'wx:wow', '2021-06-06 13:44:35', 10.00, '来嘛', 3);

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`
(
    `id`  int(11) NOT NULL AUTO_INCREMENT,
    `cid` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `images_commodity_cid_fk` (`cid`) USING BTREE,
    CONSTRAINT `images_commodity_cid_fk` FOREIGN KEY (`cid`) REFERENCES `commodity` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `uid`      int(11)                                                NOT NULL AUTO_INCREMENT,
    `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'demo', 'demo');
INSERT INTO `user`
VALUES (2, 'xiaoxin', 'xiao');
INSERT INTO `user`
VALUES (3, 'whatthehell', 'workwork');

-- ----------------------------
-- Table structure for wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist`
(
    `id`  int(11) NOT NULL,
    `uid` int(11) NOT NULL,
    `cid` int(11) NOT NULL,
    PRIMARY KEY (`id`, `uid`, `cid`) USING BTREE,
    INDEX `wishlist_commodity_cid_fk` (`cid`) USING BTREE,
    INDEX `wishlist_commodity_uid_fk` (`uid`) USING BTREE,
    CONSTRAINT `wishlist_commodity_cid_fk` FOREIGN KEY (`cid`) REFERENCES `commodity` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `wishlist_commodity_uid_fk` FOREIGN KEY (`uid`) REFERENCES `commodity` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `wishlist_user_uid_fk` FOREIGN KEY (`id`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  CHARACTER SET = gb2312
  COLLATE = gb2312_chinese_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wishlist
-- ----------------------------
INSERT INTO `wishlist`
VALUES (2, 1, 1);
INSERT INTO `wishlist`
VALUES (3, 1, 2);
INSERT INTO `wishlist`
VALUES (1, 2, 4);
INSERT INTO `wishlist`
VALUES (3, 2, 4);
INSERT INTO `wishlist`
VALUES (3, 2, 6);
INSERT INTO `wishlist`
VALUES (1, 3, 8);
INSERT INTO `wishlist`
VALUES (2, 3, 9);
INSERT INTO `wishlist`
VALUES (1, 3, 10);

SET FOREIGN_KEY_CHECKS = 1;

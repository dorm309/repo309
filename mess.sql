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

 Date: 03/06/2021 21:19:13
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
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of category
-- ----------------------------

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
  AUTO_INCREMENT = 224
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity`
VALUES (221, 1, '运动鞋', '电话：17269278707', '2021-06-03 13:44:21', 99.00, 'test', NULL);
INSERT INTO `commodity`
VALUES (222, 1, '男装', 'qq：11256837654', '2021-06-03 13:44:41', 89.00, '测试', NULL);
INSERT INTO `commodity`
VALUES (223, 1, '小饰品', 'wx：qianbaidu', '2021-07-02 13:44:58', 7.90, '测试test', NULL);

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
VALUES (2, 'xiaoxiao', 'dada');
INSERT INTO `user`
VALUES (3, '123', '123');

-- ----------------------------
-- Table structure for wishlist
-- ----------------------------
DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist`
(
    `uid` int(11) NOT NULL DEFAULT 0,
    `cid` int(11) NOT NULL DEFAULT 0,
    PRIMARY KEY (`uid`, `cid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of wishlist
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

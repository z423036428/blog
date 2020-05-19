/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : myblog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 19/05/2020 14:44:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `firstCategory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `secondCategory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `thirdCategory` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(255) NOT NULL,
  `categoryName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `categoryLevel` int(255) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for right
-- ----------------------------
DROP TABLE IF EXISTS `right`;
CREATE TABLE `right`  (
  `id` bigint(20) NOT NULL,
  `rightName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rightDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` int(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `roleDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rolerightrelation
-- ----------------------------
DROP TABLE IF EXISTS `rolerightrelation`;
CREATE TABLE `rolerightrelation`  (
  `id` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `rightId` bigint(20) NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime``` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(11) NOT NULL,
  `tagName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tagDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userrolerelation
-- ----------------------------
DROP TABLE IF EXISTS `userrolerelation`;
CREATE TABLE `userrolerelation`  (
  `id` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `lastUpdateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `editor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

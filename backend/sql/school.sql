/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 06/04/2020 16:36:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏商品名',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `goods_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品id',
  `state` int(2) NOT NULL COMMENT '收藏状态0,删除，1，正常',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
BEGIN;
INSERT INTO `collect` VALUES (1, '课本', '2', '1', 1, '2020-04-05 17:34:06', '2020-04-05 17:34:09');
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布消息时间',
  `content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
  `seller_id` int(4) NOT NULL COMMENT '卖家id',
  `buyer_id` int(4) NOT NULL COMMENT '买家id',
  `comment_state` int(2) NOT NULL COMMENT '消息状态0删除，1正常',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '消息更新',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `comment_user_id` (`seller_id`) USING BTREE,
  KEY `reply_user_id` (`buyer_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES (1, '2020-03-31 10:45:52', '这个我好喜欢', 1, 2, 1, '2020-03-31 10:45:52');
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品描述',
  `image` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品配图',
  `price` double(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '商品状态0,删除，1正常',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建时间',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布商品的用户id',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '商品更新时间',
  `category` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, '物理课本', '这个商品很好', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 5, '2020-03-31 10:23:06', '闲置课本');
INSERT INTO `goods` VALUES (2, '自行车', '这个车子很好', 'http://localhost:8088/picture/goodsimg/b.jpg', 100.00, 1, '2020-03-19 10:28:01', 6, '2020-03-31 10:28:12', '生活用品');
INSERT INTO `goods` VALUES (3, '篮球', '这个篮球刚买没多久', 'http://localhost:8088/picture/goodsimg/e.jpg', 50.00, 1, '2020-03-31 10:27:56', 2, '2020-03-31 10:28:35', '体育用户');
INSERT INTO `goods` VALUES (4, '课本', '这个课本闲置了', 'http://localhost:8088/picture/goodsimg/c.jpg', 10.00, 1, '2020-03-31 10:29:06', 1, '2020-03-31 10:44:41', '闲置课本');
INSERT INTO `goods` VALUES (5, '课本', '这个课本没用多久', 'http://localhost:8088/picture/goodsimg/f.jpg', 8.00, 1, '2020-03-31 10:30:39', 3, '2020-03-31 10:44:45', '闲置课本');
INSERT INTO `goods` VALUES (6, '羽毛球', '现在闲置了 出售', 'http://localhost:8088/picture/goodsimg/d.jpg', 35.00, 1, '2020-03-31 10:32:59', 4, '2020-03-31 10:44:52', '体育用品');
INSERT INTO `goods` VALUES (7, '耳机', '用了没多久', 'http://localhost:8088/picture/goodsimg/.jpg', 25.00, 1, '2020-03-31 10:34:30', 10, '2020-03-31 10:44:57', '生活用品');
INSERT INTO `goods` VALUES (8, '手机', '现在换手机了  出售', 'http://localhost:8088/picture/goodsimg/h.jpg', 1000.00, 1, '2020-03-31 10:35:26', 7, '2020-03-31 10:45:01', '生活用品');
INSERT INTO `goods` VALUES (9, '相机', '刚买了一个新的  现在这个出售', 'http://localhost:8088/picture/goodsimg/j.jpg', 2000.00, 1, '2020-03-31 10:39:11', 8, '2020-03-31 10:45:05', '生活用品');
INSERT INTO `goods` VALUES (10, '床上书桌', '要毕业了 用不到了', 'http://localhost:8088/picture/goodsimg/k.jpg', 60.00, 1, '2020-03-31 10:40:55', 9, '2020-03-31 10:45:08', '生活用品');
INSERT INTO `goods` VALUES (15, '物理课本', '这个商品很好22222222', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 5, '2020-03-31 10:23:06', '闲置课本');
INSERT INTO `goods` VALUES (16, '物理课本很好么', '这个商品很好222222223333', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 5, '2020-04-06 15:40:01', '闲置课本');
INSERT INTO `goods` VALUES (17, '羽毛球全新', '这个商品很好222222223333', 'http://localhost:8088/picture/goodsimg/a.jpg', 18.00, 1, '2020-04-06 16:14:18', 0, '2020-04-06 16:15:42', '');
INSERT INTO `goods` VALUES (18, '羽毛球全新', '这个商品很好222222223333', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-04-06 16:27:26', 0, '2020-04-06 16:27:26', '');
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单名',
  `seller_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '卖家id',
  `buyer_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '买家id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `state` int(4) NOT NULL COMMENT '订单状态0删除，1正常',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `state` int(2) NOT NULL COMMENT '状态0删除，1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sort
-- ----------------------------
BEGIN;
INSERT INTO `sort` VALUES (1, '闲置课本', '2020-03-26 18:06:23', '2020-03-26 18:06:50', 1);
INSERT INTO `sort` VALUES (2, '生活用品', '2020-03-26 18:06:28', '2020-03-31 10:27:38', 1);
INSERT INTO `sort` VALUES (3, '数码电子', '2020-03-26 18:09:26', '2020-03-31 10:27:22', 1);
INSERT INTO `sort` VALUES (4, '体育用品', '2020-03-26 18:09:51', '2020-03-31 10:27:33', 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '用户状态',
  `wechat_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '关联用户的微信id(union_id)',
  `wechat_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户的微信名',
  `avatar_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头像（使用的是用户的微信头像）',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `gender` int(2) NOT NULL COMMENT '性别1男，2女',
  `state` int(64) NOT NULL DEFAULT '1' COMMENT '用户状态0禁用，1可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '\"\"', '蘭', 'http://localhost:8088/picture/atatar/b.jpg', '陈兰兰', '17014986522', 2, 1, '2020-03-26 15:42:14', '2020-04-06 14:39:00');
INSERT INTO `user` VALUES (21, 'AAAA', 'wechat-name-is', 'http://localhost:8088/picture/atatar/b.jpg', 'test_user', '17043781234', 2, 1, '2020-04-06 12:00:47', '2020-04-06 12:00:47');
INSERT INTO `user` VALUES (24, '', '赵璐手动阀', 'https://wx.qlogo.cn/mmopen/vi_32/cQZF8pcShTJZwVj4GrmictSqaRib6aEuW9lRlQE0wbZZa76nHIwZkz84RB3Hxt5q0ibpCoQU2uXctMeyEPIduOtPA/132', '赵璐888', '4556', 2, 1, '2020-04-06 15:13:06', '2020-04-06 16:22:11');
INSERT INTO `user` VALUES (39, '', '赵璐', 'https://wx.qlogo.cn/mmopen/vi_32/cQZF8pcShTJZwVj4GrmictSqaRib6aEuW9lRlQE0wbZZa76nHIwZkz84RB3Hxt5q0ibpCoQU2uXctMeyEPIduOtPA/132', '赵璐', '', 2, 1, '2020-04-06 16:25:23', '2020-04-06 16:25:23');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

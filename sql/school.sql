/*
 Navicat Premium Data Transfer

 Source Server         : localHost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 05/04/2020 13:03:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收藏商品名',
  `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `goods_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `state` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收藏状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, '课本', '2', '1', NULL, '2020-03-31 10:41:32', '1');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布消息时间',
  `content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息内容',
  `seller_id` int(4) NULL DEFAULT NULL COMMENT '卖家id',
  `buyer_id` int(4) NULL DEFAULT NULL COMMENT '买家id',
  `comment_state` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '消息状态',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '消息更新',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_user_id`(`seller_id`) USING BTREE,
  INDEX `reply_user_id`(`buyer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '2020-03-31 10:45:52', '这个我好喜欢', 1, 2, '1', '2020-03-31 10:45:52');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodsname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品名称',
  `textdesc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品描述',
  `goodsLmg` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品配图',
  `goodsPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `goodsState` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品状态',
  `means` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易方式',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '商品更新时间',
  `goodssort` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '课本', '这个商品很好', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, '1', '线下', '2020-03-10 21:46:59', 5, '2020-03-31 10:23:06', '闲置课本');
INSERT INTO `goods` VALUES (2, '自行车', '这个车子很好', 'http://localhost:8088/picture/goodsimg/b.jpg', 100.00, '1', '线下', '2020-03-19 10:28:01', 6, '2020-03-31 10:28:12', '生活用品');
INSERT INTO `goods` VALUES (3, '篮球', '这个篮球刚买没多久', 'http://localhost:8088/picture/goodsimg/e.jpg', 50.00, '1', '线下', '2020-03-31 10:27:56', 2, '2020-03-31 10:28:35', '体育用户');
INSERT INTO `goods` VALUES (4, '课本', '这个课本闲置了', 'http://localhost:8088/picture/goodsimg/c.jpg', 10.00, '1', '线下', '2020-03-31 10:29:06', 1, '2020-03-31 10:44:41', '闲置课本');
INSERT INTO `goods` VALUES (5, '课本', '这个课本没用多久', 'http://localhost:8088/picture/goodsimg/f.jpg', 8.00, '1', '线下', '2020-03-31 10:30:39', 3, '2020-03-31 10:44:45', '闲置课本');
INSERT INTO `goods` VALUES (6, '羽毛球', '现在闲置了 出售', 'http://localhost:8088/picture/goodsimg/d.jpg', 35.00, '1', '线下', '2020-03-31 10:32:59', 4, '2020-03-31 10:44:52', '体育用品');
INSERT INTO `goods` VALUES (7, '耳机', '用了没多久', 'http://localhost:8088/picture/goodsimg/.jpg', 25.00, '1', '线下', '2020-03-31 10:34:30', 10, '2020-03-31 10:44:57', '生活用品');
INSERT INTO `goods` VALUES (8, '手机', '现在换手机了  出售', 'http://localhost:8088/picture/goodsimg/h.jpg', 1000.00, '1', '线下', '2020-03-31 10:35:26', 7, '2020-03-31 10:45:01', '生活用品');
INSERT INTO `goods` VALUES (9, '相机', '刚买了一个新的  现在这个出售', 'http://localhost:8088/picture/goodsimg/j.jpg', 2000.00, '1', '线下', '2020-03-31 10:39:11', 8, '2020-03-31 10:45:05', '生活用品');
INSERT INTO `goods` VALUES (10, '床上书桌', '要毕业了 用不到了', 'http://localhost:8088/picture/goodsimg/k.jpg', 60.00, '1', '线下', '2020-03-31 10:40:55', 9, '2020-03-31 10:45:08', '生活用品');
INSERT INTO `goods` VALUES (14, '课本', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单名',
  `seller_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '卖家id',
  `buyer_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '买家id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `state` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单状态',
  `price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  `goods_id` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '订单修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `state` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (1, '闲置课本', '2020-03-26 18:06:23', '2020-03-26 18:06:50', '1');
INSERT INTO `sort` VALUES (2, '生活用品', '2020-03-26 18:06:28', '2020-03-31 10:27:38', '1');
INSERT INTO `sort` VALUES (3, '数码电子', '2020-03-26 18:09:26', '2020-03-31 10:27:22', '1');
INSERT INTO `sort` VALUES (4, '体育用品', '2020-03-26 18:09:51', '2020-03-31 10:27:33', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '用户状态',
  `atatar_url` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `gender` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `state` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'http://localhost:8088/picture/atatar/b.jpg', '陈兰兰', '17014986522', '0', '2020-03-26 15:42:14', '2020-03-31 10:47:32', '1');
INSERT INTO `user` VALUES (2, 'http://localhost:8088/picture/atatar/aa.jpg', '曹几参', '15019834909', '1', '2020-03-26 15:42:14', '2020-03-30 23:28:07', '1');
INSERT INTO `user` VALUES (3, 'http://localhost:8088/picture/atatar/c.jpg', '陈醪故', '17013391181', '1', '2020-03-26 15:42:14', '2020-03-31 10:43:11', '1');
INSERT INTO `user` VALUES (4, 'http://localhost:8088/picture/atatar/d.jpg', '谢乌感', '18516648841', '0', '2020-03-26 15:42:14', '2020-03-31 10:43:21', '1');
INSERT INTO `user` VALUES (5, 'http://localhost:8088/picture/atatar/e.jpg', '尤适绝', '15512525588', '0', '2020-03-26 15:42:14', '2020-03-31 10:43:34', '1');
INSERT INTO `user` VALUES (6, 'http://localhost:8088/picture/atatar/f.jpg', '华语斟', '17020383564', '1', '2020-03-26 15:42:14', '2020-03-31 10:43:42', '1');
INSERT INTO `user` VALUES (7, 'http://localhost:8088/picture/atatar/g.jpg', '任闲孤', '15519668734', '1', '2020-03-26 15:42:14', '2020-03-31 10:43:51', '1');
INSERT INTO `user` VALUES (8, 'http://localhost:8088/picture/atatar/i.jpg', '徐塞蓬', '15021254782', '0', '2020-03-26 15:42:14', '2020-03-31 10:44:00', '1');
INSERT INTO `user` VALUES (9, 'http://localhost:8088/picture/atatar/k.jpg', '曹贵徊', '16516807767', '0', '2020-03-26 15:42:14', '2020-03-31 10:44:08', '1');
INSERT INTO `user` VALUES (10, 'http://localhost:8088/picture/atatar/j.jpg', '魏来端', '16514414971', '0', '2020-03-26 15:42:14', '2020-03-31 10:44:21', '1');
INSERT INTO `user` VALUES (11, '1', '华升林', '16521550743', '1', '2020-03-26 15:42:15', '2020-03-26 15:42:15', '1');

SET FOREIGN_KEY_CHECKS = 1;

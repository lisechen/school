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

 Date: 03/05/2020 22:03:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `state` int(2) NOT NULL COMMENT '状态0删除，1正常',
  `image` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '闲置课本', '2020-03-26 18:06:23', '2020-04-23 18:28:43', 1, 'http://localhost:8088/picture/sort/shubao_a.png');
INSERT INTO `category` VALUES (2, '生活用品', '2020-03-26 18:06:28', '2020-04-23 18:30:07', 1, 'http://localhost:8088/picture/sort/yusan_a.png');
INSERT INTO `category` VALUES (3, '数码电子', '2020-03-26 18:09:26', '2020-04-23 18:29:48', 1, 'http://localhost:8088/picture/sort/sport.png');
INSERT INTO `category` VALUES (4, '体育用品', '2020-03-26 18:09:51', '2020-04-23 18:30:18', 1, 'http://localhost:8088/picture/sort/shouji_a.png');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏商品名',
  `user_id` int(64) NOT NULL COMMENT '用户id',
  `goods_id` int(64) NOT NULL COMMENT '商品id',
  `state` int(2) NOT NULL COMMENT '收藏状态0,删除，1，正常',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, '课本', 2, 1, 0, '2020-04-19 12:57:54', '2020-04-19 12:57:54');
INSERT INTO `collect` VALUES (2, '耳机', 3, 7, 1, '2020-04-11 21:00:19', '2020-04-11 21:00:19');
INSERT INTO `collect` VALUES (3, '自行车', 2, 2, 0, '2020-04-19 13:19:30', '2020-04-19 13:19:30');
INSERT INTO `collect` VALUES (4, '数学课本', 4, 15, 1, '2020-04-19 07:07:18', '2020-04-19 07:07:18');
INSERT INTO `collect` VALUES (5, '课本', 4, 5, 1, '2020-04-19 07:07:22', '2020-04-19 07:07:22');
INSERT INTO `collect` VALUES (6, '课本', 4, 4, 1, '2020-04-18 22:30:23', '2020-04-18 22:30:23');
INSERT INTO `collect` VALUES (7, '羽毛球全新', 5, 10, 1, '2020-04-23 18:18:49', '2020-04-23 18:18:49');
INSERT INTO `collect` VALUES (8, '课本', 4, 11, 1, '2020-04-19 12:56:12', '2020-04-19 12:56:12');
INSERT INTO `collect` VALUES (9, '耳机', 2, 6, 1, '2020-04-23 18:18:53', '2020-04-23 18:18:53');
INSERT INTO `collect` VALUES (10, '羽毛球全新', 4, 12, 1, '2020-04-19 12:55:52', '2020-04-19 12:55:52');
INSERT INTO `collect` VALUES (11, '物理课本', 3, 11, 1, '2020-04-23 18:18:56', '2020-04-23 18:18:56');
INSERT INTO `collect` VALUES (12, '课本', 4, 10, 1, '2020-04-19 12:55:47', '2020-04-19 12:55:47');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布消息时间',
  `content` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '消息内容',
  `reply_id` int(4) NULL DEFAULT NULL COMMENT '回复id',
  `user_id` int(4) NOT NULL COMMENT '评论id',
  `status` int(2) NOT NULL COMMENT '消息状态0回复，1正常 ',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '消息更新',
  `goods_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_user_id`(`reply_id`) USING BTREE,
  INDEX `reply_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '2020-03-31 10:45:52', '这个我好喜欢', 1, 3, 1, '2020-04-18 16:42:04', 1);
INSERT INTO `comment` VALUES (2, '2020-04-15 21:09:28', '哈哈', 5, 1, 1, '2020-04-18 16:42:11', 2);
INSERT INTO `comment` VALUES (3, '2020-04-18 16:38:24', 'kjsf', NULL, 2, 1, '2020-04-18 16:42:45', 1);
INSERT INTO `comment` VALUES (4, '2020-04-18 16:38:30', 'sdkfjk', NULL, 1, 1, '2020-04-18 16:42:52', 1);
INSERT INTO `comment` VALUES (5, '2020-04-19 12:15:16', '东西还好', NULL, 5, 1, '2020-04-23 18:16:29', 5);
INSERT INTO `comment` VALUES (6, '2020-04-19 12:25:40', '很不错啊', NULL, 5, 1, '2020-04-23 18:16:33', 2);
INSERT INTO `comment` VALUES (7, '2020-04-19 13:54:27', '东西很不许哦', NULL, 5, 1, '2020-04-23 18:16:39', 7);
INSERT INTO `comment` VALUES (8, '2020-04-19 14:57:03', '哈哈哈哈', NULL, 5, 1, '2020-04-19 14:57:03', 14);
INSERT INTO `comment` VALUES (9, '2020-04-26 17:19:54', '正在测试', NULL, 5, 1, '2020-04-26 17:19:54', 8);
INSERT INTO `comment` VALUES (10, '2020-04-26 17:20:46', '正在测试', NULL, 5, 1, '2020-04-26 17:20:46', 6);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `desc` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品描述',
  `image` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品配图',
  `price` double(10, 2) NOT NULL DEFAULT 0.00 COMMENT '商品价格',
  `status` int(2) NOT NULL DEFAULT 1 COMMENT '商品状态0,删除，1正常',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建时间',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '发布商品的用户id',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '商品更新时间',
  `category` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品分类',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '物理课本', '这个商品很好', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 1, '2020-04-23 18:30:51', '闲置课本');
INSERT INTO `goods` VALUES (2, '自行车', '这个车子很好', 'http://localhost:8088/picture/goodsimg/b.jpg', 100.00, 1, '2020-03-19 10:28:01', 2, '2020-04-26 19:35:44', '生活用品');
INSERT INTO `goods` VALUES (3, '篮球', '这个篮球刚买没多久', 'http://localhost:8088/picture/goodsimg/e.jpg', 50.00, 0, '2020-03-31 10:27:56', 3, '2020-04-26 23:49:29', '体育用品');
INSERT INTO `goods` VALUES (4, '课本', '这个课本闲置了', 'http://localhost:8088/picture/goodsimg/c.jpg', 10.00, 1, '2020-03-31 10:29:06', 4, '2020-04-23 18:30:56', '闲置课本');
INSERT INTO `goods` VALUES (5, '课本', '这个课本没用多久', 'http://localhost:8088/picture/goodsimg/f.jpg', 8.00, 1, '2020-03-31 10:30:39', 2, '2020-04-23 18:30:57', '闲置课本');
INSERT INTO `goods` VALUES (6, '羽毛球', '现在闲置了 出售', 'http://localhost:8088/picture/goodsimg/d.jpg', 35.00, 1, '2020-03-31 10:32:59', 1, '2020-04-26 19:35:57', '体育用品');
INSERT INTO `goods` VALUES (7, '耳机', '用了没多久', 'http://localhost:8088/picture/goodsimg/ee.jpg', 25.00, 1, '2020-03-31 10:34:30', 3, '2020-04-23 18:30:59', '生活用品');
INSERT INTO `goods` VALUES (8, '手机', '现在换手机了  出售', 'http://localhost:8088/picture/goodsimg/h.jpg', 1000.00, 0, '2020-03-31 10:35:26', 4, '2020-04-26 19:39:34', '数码电子');
INSERT INTO `goods` VALUES (9, '相机', '刚买了一个新的  现在这个出售', 'http://localhost:8088/picture/goodsimg/j.jpg', 2000.00, 1, '2020-03-31 10:39:11', 3, '2020-04-26 19:36:00', '数码电子');
INSERT INTO `goods` VALUES (10, '床上书桌', '要毕业了 用不到了', 'http://localhost:8088/picture/goodsimg/k.jpg', 60.00, 0, '2020-03-31 10:40:55', 4, '2020-04-26 19:26:13', '生活用品');
INSERT INTO `goods` VALUES (11, '物理课本', '这个商品很好', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 2, '2020-04-23 18:31:02', '闲置课本');
INSERT INTO `goods` VALUES (12, '物理课本', '这个商品很好', 'http://localhost:8088/picture/goodsimg/a.jpg', 10.00, 1, '2020-03-10 21:46:59', 1, '2020-04-26 19:36:03', '闲置课本');
INSERT INTO `goods` VALUES (13, '羽毛球全新', '这个商品很不错', 'http://localhost:8088/picture/goodsimg/d.jpg', 18.00, 0, '2020-04-06 16:14:18', 4, '2020-04-26 17:29:49', '体育用品');
INSERT INTO `goods` VALUES (15, '课本', '不用了', 'http://localhost:8088/picture/goodsimg/97a82856-18f5-408f-80aa-b0409aaccbcb.jpg', 4.00, 1, '2020-04-26 18:14:38', 5, '2020-04-26 18:14:38', '闲置课本');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `seller_id` int(64) NOT NULL COMMENT '卖家id',
  `buyer_id` int(64) NOT NULL COMMENT '买家id',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `status` int(4) NOT NULL COMMENT '订单状态0删除，1正常',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '订单修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (8, 3, 5, '2020-04-26 23:49:30', 1, 3, '2020-04-26 23:49:30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT '用户状态',
  `wechat_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '关联用户的微信id(open_id)',
  `wechat_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户的微信名',
  `avatar_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头像（使用的是用户的微信头像）',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `mobile` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `gender` int(2) NOT NULL COMMENT '性别1男，2女',
  `state` int(64) NOT NULL DEFAULT 1 COMMENT '用户状态0禁用，1可用',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'AAAA', '爱生活', 'http://localhost:8088/picture/atatar/b.jpg', 'test_user', '17043781234', 2, 1, '2020-04-06 12:00:47', '2020-04-09 23:25:26');
INSERT INTO `user` VALUES (2, '', '校园购物', 'http://localhost:8088/picture/atatar/c.jpg', '槐序', '4556', 2, 1, '2020-04-06 15:13:06', '2020-04-11 20:51:53');
INSERT INTO `user` VALUES (3, ' ', '嘻嘻', 'http://localhost:8088/picture/atatar/d.jpg', '陈乐乐', '5644', 2, 1, '2020-04-06 16:25:23', '2020-04-18 23:19:21');
INSERT INTO `user` VALUES (4, 'ohbP25fFAUjrY4LjCFlOtB0o1l1', '蘭', 'http://localhost:8088/picture/atatar/f.jpg', 'hey', '56', 2, 1, '2020-04-14 20:36:24', '2020-04-26 19:38:49');

SET FOREIGN_KEY_CHECKS = 1;

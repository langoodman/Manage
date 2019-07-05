/*
 Navicat Premium Data Transfer

 Source Server         : lan
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : manage

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 05/06/2019 10:34:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pass_word` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_time` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆时间',
  `sign_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_number`(`phone_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (10001, '13872617881', '73f50c9f17291ce93ee52e50b73f6f63', '吴恒', 18, '1090230661@qq.com', '2019-06-04 21:28:37', '2019-05-25 15:23:39');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名称',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '批号',
  `origin` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品产地',
  `specification` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品规格',
  `price` double(10, 2) NULL DEFAULT 0.00 COMMENT '药品价格',
  `stock` int(11) NULL DEFAULT 0 COMMENT '药品库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES (10001, '阿莫西林', '10110201238', '湖南省XXX有限公司', '克', 20.20, 200);
INSERT INTO `medicine` VALUES (10002, '99感冒灵', '10110201232', '湖南省XXX有限公司', '克', 0.01, 20);
INSERT INTO `medicine` VALUES (10003, '999感冒灵', '10110201232', '湖南省XXX有限公司', '克', 2.23, 20);

-- ----------------------------
-- Table structure for medicine_transaction
-- ----------------------------
DROP TABLE IF EXISTS `medicine_transaction`;
CREATE TABLE `medicine_transaction`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药品名字',
  `orders_id` int(11) NOT NULL COMMENT '订单id',
  `count` int(11) NULL DEFAULT 0 COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicine_transaction
-- ----------------------------
INSERT INTO `medicine_transaction` VALUES (10001, '阿莫西林', 10001, 7);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工名字',
  `pharmacy_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药店名字',
  `user_card_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员卡卡号',
  `should_money` double(10, 2) NULL DEFAULT NULL COMMENT '应收金额',
  `really_money` double(10, 2) NULL DEFAULT NULL COMMENT '实收金额',
  `integral` int(11) NULL DEFAULT 0 COMMENT '此次消费积分积分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (10002, 'lan', '三峡大学校医院', '123456788', 3.20, 2.00, 0);
INSERT INTO `orders` VALUES (10003, 'lanTest', '三峡大学校医院', '123456788', 3.20, 2.00, 0);
INSERT INTO `orders` VALUES (10004, 'la', '三峡大学校医院', '123456788', 0.00, 0.00, 0);

-- ----------------------------
-- Table structure for pharmacy
-- ----------------------------
DROP TABLE IF EXISTS `pharmacy`;
CREATE TABLE `pharmacy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '药店的地址',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10009 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pharmacy
-- ----------------------------
INSERT INTO `pharmacy` VALUES (10001, '13872617881', '三峡大学信息科学楼', '三峡大学校医院');
INSERT INTO `pharmacy` VALUES (10002, '13872617882', '葛洲坝', '宜昌市第一人民医院');
INSERT INTO `pharmacy` VALUES (10003, '13872617882', '葛洲坝', '宜昌市人民医院');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pharmacy_id` int(11) NOT NULL COMMENT '所属药店id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '在职' COMMENT '员工状态',
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工的家庭住址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_number`(`phone_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10007 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (10001, '13872617881', 10001, 'asd', '男', '在职', 18, '欣苑二栋');
INSERT INTO `staff` VALUES (10002, '13872617882', 10001, 'wh', '男', '在职', 23, '');
INSERT INTO `staff` VALUES (10003, '13872617885', 10001, 'wh', '男', '在职', 22, '');
INSERT INTO `staff` VALUES (10004, '13872617884', 10001, 'Test', '男', '在职', 12, '湖北省');
INSERT INTO `staff` VALUES (10005, '13872617841', 10001, 'qwe', '男', '在职', 23, '宜昌');
INSERT INTO `staff` VALUES (10006, '13872617843', 10001, 'lan', '男', '在职', 18, '宜昌');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员卡号',
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员状态',
  `pharmacy_id` int(11) NOT NULL COMMENT '所属药店id',
  `integral` int(11) NULL DEFAULT 0 COMMENT '会员积分',
  `sign_time` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_number`(`phone_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10023 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (10006, '123456787', '13872617883', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10007, '123456786', '13872617884', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10008, '123456785', '13872617885', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10009, '123456784', '13872617886', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10010, '123456783', '13872617887', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10011, '123456782', '13872617888', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10012, '123456781', '13872617889', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10013, '123456759', '13872617811', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10014, '123456589', '13872617821', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10015, '123256789', '13872617831', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10016, '121456789', '13872617841', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10017, '123466789', '13872617851', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10018, '223456789', '13872617861', 'lan', '男', '可用', 10001, 0, '2019-06-02 15:50:01');
INSERT INTO `user` VALUES (10021, '323456789', '13872217881', 'hwj', '女', '可用', 10001, 0, '2019-06-03 12:41:32');
INSERT INTO `user` VALUES (10022, '123456712', '12272617891', 'lc', '男', '可用', 10001, 0, '2019-06-04 17:27:55');

SET FOREIGN_KEY_CHECKS = 1;

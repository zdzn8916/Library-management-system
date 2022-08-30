/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306_2
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : books

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/08/2022 23:38:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` int NOT NULL,
  `名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系电话` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `邮箱` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `所属类别` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `剩余件数` int NULL DEFAULT NULL,
  `价格` int NULL DEFAULT NULL,
  `作者` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (44, '0001', 'Mysql必知必会', '计算机丛书', 33, 13, 'Ben Forta');
INSERT INTO `book` VALUES (56, '0000', 'MySql是怎样运行的', '计算机丛书', 3, 14, '小孩子4919');
INSERT INTO `book` VALUES (58, '0002', '沉默的十字架', '哲学书', 7, 12, '东野圭吾');
INSERT INTO `book` VALUES (60, '0003', '网络是怎样连接的', '计算机丛书', 20, 49, '互根勤');
INSERT INTO `book` VALUES (61, '0004', '计算机是怎样跑起来的', '计算机丛书', 10, 49, '互根勤');
INSERT INTO `book` VALUES (63, '0005', '平凡的世界', '长篇小说', 10, 35, '路遥');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '计算机丛书');
INSERT INTO `category` VALUES (2, '童书');
INSERT INTO `category` VALUES (4, '哲学书');
INSERT INTO `category` VALUES (5, '长篇小说');

-- ----------------------------
-- Table structure for categorystaff
-- ----------------------------
DROP TABLE IF EXISTS `categorystaff`;
CREATE TABLE `categorystaff`  (
  `id` int NOT NULL,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系方式` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `管辖书籍类型 id` int NULL DEFAULT NULL,
  `联系电话` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categorystaff
-- ----------------------------

-- ----------------------------
-- Table structure for commonstaff
-- ----------------------------
DROP TABLE IF EXISTS `commonstaff`;
CREATE TABLE `commonstaff`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系电话` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commonstaff
-- ----------------------------
INSERT INTO `commonstaff` VALUES (1, 'xk', '男', '123456789');
INSERT INTO `commonstaff` VALUES (2, 'xksd1233', '男', '18123841089');

-- ----------------------------
-- Table structure for curator
-- ----------------------------
DROP TABLE IF EXISTS `curator`;
CREATE TABLE `curator`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `姓名` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `性别` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `联系电话` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `邮箱` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of curator
-- ----------------------------

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES (1, '深圳图书馆');
INSERT INTO `library` VALUES (6, '广州图书馆');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 174 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (2, 'TRACE', '某位用户进行了借阅操作,借阅了id为44的书', '2022-08-06 11:04:34.373');
INSERT INTO `log` VALUES (142, 'TRACE', '修改了id为15的用户', '2022-08-10 11:14:07.218');
INSERT INTO `log` VALUES (143, 'TRACE', '某位用户进行了归还操作,借阅了id为44的书', '2022-08-16 17:44:06.307');
INSERT INTO `log` VALUES (144, 'TRACE', '某位用户进行了归还操作,借阅了id为44的书', '2022-08-16 17:44:06.722');
INSERT INTO `log` VALUES (145, 'TRACE', '某位用户进行了添加操作,添加了书名为123的书', '2022-08-16 17:45:04.373');
INSERT INTO `log` VALUES (146, 'TRACE', '某位用户进行了删除操作,删除了id为65的书', '2022-08-16 17:45:08.011');
INSERT INTO `log` VALUES (147, 'TRACE', '某位用户进行了添加操作,添加了书名为1的书', '2022-08-16 17:49:06.451');
INSERT INTO `log` VALUES (148, 'TRACE', '某位用户进行了删除操作,删除了id为66的书', '2022-08-16 17:49:09.353');
INSERT INTO `log` VALUES (149, 'TRACE', '某位用户进行了借阅操作,借阅了id为44的书', '2022-08-16 17:49:42.005');
INSERT INTO `log` VALUES (150, 'TRACE', '某位用户进行了借阅操作,借阅了id为56的书', '2022-08-16 17:49:42.014');
INSERT INTO `log` VALUES (151, 'TRACE', '某位用户进行了借阅操作,借阅了id为58的书', '2022-08-16 17:49:42.022');
INSERT INTO `log` VALUES (152, 'TRACE', '某位用户进行了借阅操作,借阅了id为60的书', '2022-08-16 17:49:42.031');
INSERT INTO `log` VALUES (153, 'TRACE', '某位用户进行了借阅操作,借阅了id为61的书', '2022-08-16 17:49:42.039');
INSERT INTO `log` VALUES (154, 'TRACE', '某位用户进行了借阅操作,借阅了id为63的书', '2022-08-16 17:49:42.047');
INSERT INTO `log` VALUES (155, 'TRACE', '某位用户进行了借阅操作,借阅了id为44的书', '2022-08-16 17:49:45.581');
INSERT INTO `log` VALUES (156, 'TRACE', '某位用户进行了借阅操作,借阅了id为56的书', '2022-08-16 17:49:45.589');
INSERT INTO `log` VALUES (157, 'TRACE', '某位用户进行了借阅操作,借阅了id为58的书', '2022-08-16 17:49:45.598');
INSERT INTO `log` VALUES (158, 'TRACE', '某位用户进行了借阅操作,借阅了id为60的书', '2022-08-16 17:49:45.605');
INSERT INTO `log` VALUES (159, 'TRACE', '某位用户进行了借阅操作,借阅了id为61的书', '2022-08-16 17:49:45.614');
INSERT INTO `log` VALUES (160, 'TRACE', '某位用户进行了借阅操作,借阅了id为63的书', '2022-08-16 17:49:45.622');
INSERT INTO `log` VALUES (161, 'TRACE', '某位用户进行了添加操作,添加了书名为123的书', '2022-08-21 16:07:25.013');
INSERT INTO `log` VALUES (162, 'TRACE', '某位用户进行了删除操作,删除了id为67的书', '2022-08-21 16:07:35.345');
INSERT INTO `log` VALUES (163, 'TRACE', '某位用户进行了添加操作,添加了书名为123的书', '2022-08-21 16:09:09.820');
INSERT INTO `log` VALUES (164, 'TRACE', '某位用户进行了添加操作,添加了书名为123的书', '2022-08-21 16:09:10.759');
INSERT INTO `log` VALUES (165, 'TRACE', '某位用户进行了添加操作,添加了书名为123123的书', '2022-08-22 15:21:31.632');
INSERT INTO `log` VALUES (166, 'TRACE', '某位用户进行了添加操作,添加了书名为123123的书', '2022-08-22 15:21:37.869');
INSERT INTO `log` VALUES (167, 'TRACE', '某位用户进行了删除操作,删除了id为71的书', '2022-08-22 15:22:19.200');
INSERT INTO `log` VALUES (168, 'TRACE', '某位用户进行了删除操作,删除了id为70的书', '2022-08-22 15:22:20.497');
INSERT INTO `log` VALUES (169, 'TRACE', '某位用户进行了删除操作,删除了id为69的书', '2022-08-22 15:22:21.235');
INSERT INTO `log` VALUES (170, 'TRACE', '某位用户进行了删除操作,删除了id为68的书', '2022-08-22 15:22:21.889');
INSERT INTO `log` VALUES (171, 'TRACE', '某位用户进行了添加操作,添加了书名为312354的书', '2022-08-22 15:22:41.667');
INSERT INTO `log` VALUES (172, 'TRACE', '某位用户进行了删除操作,删除了id为72的书', '2022-08-22 15:22:46.702');
INSERT INTO `log` VALUES (173, 'TRACE', '某位用户进行了修改操作,修改了id为60的书', '2022-08-30 23:07:04.489');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int NOT NULL,
  `权限名称` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '图书管理');
INSERT INTO `permission` VALUES (2, '职员管理');
INSERT INTO `permission` VALUES (3, '借阅管理');
INSERT INTO `permission` VALUES (4, '图书馆管理');
INSERT INTO `permission` VALUES (5, '图书类型管理');
INSERT INTO `permission` VALUES (6, '日志管理');
INSERT INTO `permission` VALUES (7, '通知管理');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_db` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '普通员工', 'commonstaff');
INSERT INTO `role` VALUES (2, '馆长', 'curator');
INSERT INTO `role` VALUES (3, '图书类型管理员', 'categoryStaff');
INSERT INTO `role` VALUES (4, '总管理员', 'administrator');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int NULL DEFAULT NULL,
  `menu_id` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (3, 1);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (3, 5);
INSERT INTO `role_menu` VALUES (4, 1);
INSERT INTO `role_menu` VALUES (4, 3);
INSERT INTO `role_menu` VALUES (4, 4);
INSERT INTO `role_menu` VALUES (4, 5);

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`  (
  `user_id` int NOT NULL,
  `role_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_user
-- ----------------------------
INSERT INTO `role_user` VALUES (1, '1');
INSERT INTO `role_user` VALUES (2, '2');
INSERT INTO `role_user` VALUES (3, '3');
INSERT INTO `role_user` VALUES (4, '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'xk', '123456', '1');
INSERT INTO `user` VALUES (2, 'xksd', '123456', '2');
INSERT INTO `user` VALUES (3, 'zdzn', '123456', '3');
INSERT INTO `user` VALUES (4, 'xx', '123456', '4');
INSERT INTO `user` VALUES (15, 'xksd1233', '123456', '1');

-- ----------------------------
-- Procedure structure for del_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `del_data`;
delimiter ;;
CREATE PROCEDURE `del_data`()
BEGIN
     delete  from  t_device_info where f_time < date_sub(curdate(), interval 30 day);
END
;;
delimiter ;

-- ----------------------------
-- Event structure for delete
-- ----------------------------
DROP EVENT IF EXISTS `delete`;
delimiter ;;
CREATE EVENT `delete`
ON SCHEDULE
EVERY '24' HOUR STARTS '2022-08-06 22:58:56'
DO delete from log where DATE(time) <= DATE(DATE_SUB(NOW(),INTERVAL 30 DAY))
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

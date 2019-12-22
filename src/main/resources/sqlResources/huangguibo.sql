/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : huangguibo

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 23/12/2019 01:08:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`
(
    `cid`          int(255)                                               NOT NULL,
    `cname`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `credit`       float(2, 1)                                            NULL DEFAULT NULL,
    `time`         varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci        NULL,
    `teacher`      int(10)                                                NULL DEFAULT NULL,
    `capacity`     int(10)                                                NULL DEFAULT 50,
    PRIMARY KEY (`cid`) USING BTREE,
    INDEX `teacher` (`teacher`) USING BTREE,
    CONSTRAINT `course_ibfk_1` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course`
VALUES (1, 'UML设计与分析', 4.0, '周一5，6节', NULL, 11101, 47);
INSERT INTO `course`
VALUES (2, '软件工程', 4.0, '周一1，2节', NULL, 11107, 48);
INSERT INTO `course`
VALUES (3, '计算机网络', 3.0, '周二1，2节', NULL, 11103, 50);
INSERT INTO `course`
VALUES (4, '计算机导论', 3.0, '周二3，4节', NULL, 11106, 50);
INSERT INTO `course`
VALUES (5, '高等数学1', 3.0, '周二3，4节', NULL, 11104, 50);
INSERT INTO `course`
VALUES (6, '高等数学2', 3.0, '周一3，4节', NULL, 11107, 50);
INSERT INTO `course`
VALUES (7, '离散数学', 3.0, '周三3，4节', NULL, 11104, 50);
INSERT INTO `course`
VALUES (8, '计算机网络', 3.0, '周二7，8节', NULL, 11102, 50);
INSERT INTO `course`
VALUES (9, '通信技术', 4.0, '周五5，6节', NULL, 11101, 50);
INSERT INTO `course`
VALUES (10, '数据库技术', 3.5, '周五3，4节', NULL, 11107, 50);
INSERT INTO `course`
VALUES (11, '计算机导论', 2.0, '周四3，4节', NULL, 11104, 50);
INSERT INTO `course`
VALUES (12, '软件测试', 3.0, '周四1，2节', NULL, 11101, 50);
INSERT INTO `course`
VALUES (13, '计算机组成原理', 3.0, '周四5，6节', NULL, 11105, 50);
INSERT INTO `course`
VALUES (14, '中国近代史', 3.0, '周四7，8节', NULL, 11107, 50);
INSERT INTO `course`
VALUES (15, '操作系统', 5.0, '周五1，2节', NULL, 11104, 50);
INSERT INTO `course`
VALUES (16, '大学英语1', 2.0, '周五5，6节', NULL, 11105, 50);
INSERT INTO `course`
VALUES (17, '大学英语2', 3.0, '周一3，4节', NULL, 11105, 50);
INSERT INTO `course`
VALUES (18, '大学英语3', 3.0, '周二3，4节', NULL, 11106, 50);
INSERT INTO `course`
VALUES (19, '大学英语4', 3.0, '周三3，4节', NULL, 11107, 50);
INSERT INTO `course`
VALUES (20, 'c语言', 3.0, '周三1，2节', NULL, 11105, 50);

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc`
(
    `sid`     int(5)                                                     NOT NULL,
    `cid`     int(5)                                                     NOT NULL,
    `grade`   int(5)                                                     NULL DEFAULT NULL,
    `choyear` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '2019-2020上',
    PRIMARY KEY (`sid`, `cid`) USING BTREE,
    INDEX `cid` (`cid`) USING BTREE,
    CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc`
VALUES (1104101, 1, 80, '2014-2015下');
INSERT INTO `sc`
VALUES (1104101, 3, 59, '2019-2020下');
INSERT INTO `sc`
VALUES (1104101, 10, 66, '2015-2016上');
INSERT INTO `sc`
VALUES (1104101, 12, 90, '2017-2018上');
INSERT INTO `sc`
VALUES (1104101, 19, 48, '2018-2019下');
INSERT INTO `sc`
VALUES (1104102, 6, 99, '2019-2020下');
INSERT INTO `sc`
VALUES (1104102, 10, 90, '2019-2020下');
INSERT INTO `sc`
VALUES (1104102, 20, 59, '2019-2020下');
INSERT INTO `sc`
VALUES (1104103, 9, 70, '2017-2018下');
INSERT INTO `sc`
VALUES (1104103, 16, 85, '2019-2020上');
INSERT INTO `sc`
VALUES (1104104, 1, 69, '2018-2019下');
INSERT INTO `sc`
VALUES (1104104, 7, 80, '2015-2016下');
INSERT INTO `sc`
VALUES (1104104, 10, 59, '2017-2018下');
INSERT INTO `sc`
VALUES (1104104, 15, 100, '2017-2018下');
INSERT INTO `sc`
VALUES (1104104, 19, 60, '2011-2012下');
INSERT INTO `sc`
VALUES (1104104, 20, 59, '2019-2020上');
INSERT INTO `sc`
VALUES (1104119, 6, 77, '2019-2020下');
INSERT INTO `sc`
VALUES (1104119, 11, 70, '2017-2018上');
INSERT INTO `sc`
VALUES (1104119, 16, 28, '2019-2020下');
INSERT INTO `sc`
VALUES (1104142, 1, 100, '2019-2020上');
INSERT INTO `sc`
VALUES (1104142, 2, 20, '2019-2020上');
INSERT INTO `sc`
VALUES (1104142, 4, NULL, '2018-2019下');
INSERT INTO `sc`
VALUES (1104142, 9, 67, '2004-2005下');
INSERT INTO `sc`
VALUES (1104142, 18, 99, '2018-2019下');
INSERT INTO `sc`
VALUES (1104147, 1, 59, '2019-2020上');
INSERT INTO `sc`
VALUES (1104147, 2, 98, '2019-2020上');
INSERT INTO `sc`
VALUES (1104147, 3, NULL, '2018-2019下');
INSERT INTO `sc`
VALUES (1104147, 4, 90, '2019-2020上');
INSERT INTO `sc`
VALUES (1104147, 12, 95, '2018-2019下');
INSERT INTO `sc`
VALUES (1104147, 14, 68, '2016-2017上');
INSERT INTO `sc`
VALUES (1104147, 15, 70, '2015-2016下');
INSERT INTO `sc`
VALUES (1104148, 8, 94, '2017-2018下');
INSERT INTO `sc`
VALUES (1104148, 14, 85, '2019-2020上');
INSERT INTO `sc`
VALUES (1104148, 17, 48, '2014-2015下');
INSERT INTO `sc`
VALUES (1104158, 1, 1, '2019-2020上');
INSERT INTO `sc`
VALUES (1104158, 6, 95, '2016-2017下');
INSERT INTO `sc`
VALUES (1104158, 11, 68, '2019-2020下');
INSERT INTO `sc`
VALUES (1104158, 17, 86, '2016-2017上');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `sid`       int(255)                                                     NOT NULL,
    `name`      varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `sex`       varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '男',
    `_class`    varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL DEFAULT NULL,
    `startyear` int(4)                                                       NULL DEFAULT 2017,
    `password`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci       NULL DEFAULT NULL,
    PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES (1104101, '苏家婷', '女', '17软工', 2017, '1104101');
INSERT INTO `student`
VALUES (1104102, '梁金秋', '女', '17软工', 2017, '1104102');
INSERT INTO `student`
VALUES (1104103, '石天禄', '男', '17软工', 2017, '1104103');
INSERT INTO `student`
VALUES (1104104, '韦盈全', '男', '17软工', 2017, '1104104');
INSERT INTO `student`
VALUES (1104119, '宋维', '男', '17软工', 2017, '1104119');
INSERT INTO `student`
VALUES (1104142, '王鹏辉', '男', '17软工', 2017, '1104142');
INSERT INTO `student`
VALUES (1104147, '黄贵波', '男', '17软工', 2017, '1104147');
INSERT INTO `student`
VALUES (1104148, '林志鹏', '男', '17软工', 2017, '1104148');
INSERT INTO `student`
VALUES (1104158, '孙威', '男', '17软工', 2017, '1104158');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`
(
    `tid`      int(255)                                                     NOT NULL,
    `name`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher`
VALUES (11101, '罗曦', '11101');
INSERT INTO `teacher`
VALUES (11102, '陈雄峰', '11102');
INSERT INTO `teacher`
VALUES (11103, '小明', '11103');
INSERT INTO `teacher`
VALUES (11104, '小红', '11104');
INSERT INTO `teacher`
VALUES (11105, '马壑爆', '11105');
INSERT INTO `teacher`
VALUES (11106, '卖鱼强', '11106');
INSERT INTO `teacher`
VALUES (11107, '高姝瑶', '11107');

SET FOREIGN_KEY_CHECKS = 1;

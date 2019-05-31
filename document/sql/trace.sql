/*
Navicat MySQL Data Transfer

Source Server         : cdb-puhlb3l3.gz.tencentcdb.com_10076
Source Server Version : 50718
Source Host           : cdb-puhlb3l3.gz.tencentcdb.com:10076
Source Database       : traceability_platform

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-05-31 15:26:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zsl_trace
-- ----------------------------
DROP TABLE IF EXISTS `zsl_trace`;
CREATE TABLE `zsl_trace` (
  `trace_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '追溯id',
  `trace_code_number` varchar(100) DEFAULT NULL COMMENT '追溯码批次号',
  `trace_business_id` int(11) DEFAULT NULL COMMENT '关联商家id',
  `trace_apply_type` int(11) DEFAULT NULL COMMENT '申请类型（1：纸质标签，2：电子标签）',
  `trace_handle_status` int(11) DEFAULT NULL COMMENT '处理状态（1：已通过，2：待审核，3：已撤回）',
  `trace_company_name` varchar(100) DEFAULT NULL COMMENT '所属公司名称',
  `trace_apply_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请日期',
  `trace_review_date` timestamp NULL DEFAULT NULL COMMENT '审批日期',
  `trace_apply_count` bigint(20) DEFAULT NULL COMMENT '申请数量',
  `trace_enable_count` int(11) DEFAULT NULL COMMENT '可用数量',
  `trace_refuse_remark` varchar(255) DEFAULT NULL COMMENT '拒绝申请原因',
  `trace_back1` int(11) DEFAULT NULL COMMENT '已经关联的数量',
  `trace_back2` int(11) DEFAULT NULL COMMENT '备用字段2',
  `trace_back3` varchar(100) DEFAULT NULL COMMENT '备用字段3',
  `trace_back4` varchar(100) DEFAULT NULL COMMENT '备用字段4',
  `trace_back5` varchar(100) DEFAULT NULL COMMENT '备用字段5',
  PRIMARY KEY (`trace_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of zsl_trace
-- ----------------------------

-- ----------------------------
-- Table structure for zsl_trace_point
-- ----------------------------
DROP TABLE IF EXISTS `zsl_trace_point`;
CREATE TABLE `zsl_trace_point` (
  `trace_point_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '追溯点id',
  `trace_goods_id` int(11) DEFAULT NULL COMMENT '关联商品id',
  `trace_point_name` varchar(100) DEFAULT NULL COMMENT '追溯点其他信息',
  `trace_point_to_number` int(11) DEFAULT NULL COMMENT '追溯点起始编码',
  `trace_point_from_number` int(11) DEFAULT NULL COMMENT '追溯点结束编码',
  `trace_parent_id` int(11) DEFAULT NULL COMMENT '父节点id',
  `trace_stall_id` int(11) DEFAULT NULL COMMENT '摊位id（非农贸则为-1）',
  `trace_code_number` varchar(255) DEFAULT NULL COMMENT '追溯码批次号',
  PRIMARY KEY (`trace_point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of zsl_trace_point
-- ----------------------------

-- ----------------------------
-- Table structure for zsl_trace_record
-- ----------------------------
DROP TABLE IF EXISTS `zsl_trace_record`;
CREATE TABLE `zsl_trace_record` (
  `trace_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '追溯记录id',
  `trace_code_number` varchar(255) DEFAULT NULL COMMENT '关联追溯码批次号',
  `trace_good_id` int(11) DEFAULT NULL COMMENT '关联商品id',
  `trace_to_number` int(11) DEFAULT NULL COMMENT '商品起始编码',
  `trace_from_number` int(11) DEFAULT NULL COMMENT '商品结束编码',
  `trace_stall_id` int(11) DEFAULT NULL COMMENT '关联摊位id（没有则为非农贸）',
  PRIMARY KEY (`trace_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of zsl_trace_record
-- ----------------------------

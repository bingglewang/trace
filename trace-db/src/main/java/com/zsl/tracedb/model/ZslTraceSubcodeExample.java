package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslTraceSubcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTraceSubcodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTraceSidIsNull() {
            addCriterion("trace_sid is null");
            return (Criteria) this;
        }

        public Criteria andTraceSidIsNotNull() {
            addCriterion("trace_sid is not null");
            return (Criteria) this;
        }

        public Criteria andTraceSidEqualTo(Long value) {
            addCriterion("trace_sid =", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotEqualTo(Long value) {
            addCriterion("trace_sid <>", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidGreaterThan(Long value) {
            addCriterion("trace_sid >", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_sid >=", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidLessThan(Long value) {
            addCriterion("trace_sid <", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidLessThanOrEqualTo(Long value) {
            addCriterion("trace_sid <=", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidIn(List<Long> values) {
            addCriterion("trace_sid in", values, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotIn(List<Long> values) {
            addCriterion("trace_sid not in", values, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidBetween(Long value1, Long value2) {
            addCriterion("trace_sid between", value1, value2, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotBetween(Long value1, Long value2) {
            addCriterion("trace_sid not between", value1, value2, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceIndexIsNull() {
            addCriterion("trace_index is null");
            return (Criteria) this;
        }

        public Criteria andTraceIndexIsNotNull() {
            addCriterion("trace_index is not null");
            return (Criteria) this;
        }

        public Criteria andTraceIndexEqualTo(Long value) {
            addCriterion("trace_index =", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexNotEqualTo(Long value) {
            addCriterion("trace_index <>", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexGreaterThan(Long value) {
            addCriterion("trace_index >", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_index >=", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexLessThan(Long value) {
            addCriterion("trace_index <", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexLessThanOrEqualTo(Long value) {
            addCriterion("trace_index <=", value, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexIn(List<Long> values) {
            addCriterion("trace_index in", values, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexNotIn(List<Long> values) {
            addCriterion("trace_index not in", values, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexBetween(Long value1, Long value2) {
            addCriterion("trace_index between", value1, value2, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceIndexNotBetween(Long value1, Long value2) {
            addCriterion("trace_index not between", value1, value2, "traceIndex");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIsNull() {
            addCriterion("trace_code_number is null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIsNotNull() {
            addCriterion("trace_code_number is not null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberEqualTo(String value) {
            addCriterion("trace_code_number =", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotEqualTo(String value) {
            addCriterion("trace_code_number <>", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberGreaterThan(String value) {
            addCriterion("trace_code_number >", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trace_code_number >=", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLessThan(String value) {
            addCriterion("trace_code_number <", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLessThanOrEqualTo(String value) {
            addCriterion("trace_code_number <=", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLike(String value) {
            addCriterion("trace_code_number like", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotLike(String value) {
            addCriterion("trace_code_number not like", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIn(List<String> values) {
            addCriterion("trace_code_number in", values, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotIn(List<String> values) {
            addCriterion("trace_code_number not in", values, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberBetween(String value1, String value2) {
            addCriterion("trace_code_number between", value1, value2, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotBetween(String value1, String value2) {
            addCriterion("trace_code_number not between", value1, value2, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberIsNull() {
            addCriterion("trace_sub_code_number is null");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberIsNotNull() {
            addCriterion("trace_sub_code_number is not null");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberEqualTo(String value) {
            addCriterion("trace_sub_code_number =", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberNotEqualTo(String value) {
            addCriterion("trace_sub_code_number <>", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberGreaterThan(String value) {
            addCriterion("trace_sub_code_number >", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trace_sub_code_number >=", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberLessThan(String value) {
            addCriterion("trace_sub_code_number <", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberLessThanOrEqualTo(String value) {
            addCriterion("trace_sub_code_number <=", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberLike(String value) {
            addCriterion("trace_sub_code_number like", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberNotLike(String value) {
            addCriterion("trace_sub_code_number not like", value, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberIn(List<String> values) {
            addCriterion("trace_sub_code_number in", values, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberNotIn(List<String> values) {
            addCriterion("trace_sub_code_number not in", values, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberBetween(String value1, String value2) {
            addCriterion("trace_sub_code_number between", value1, value2, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceSubCodeNumberNotBetween(String value1, String value2) {
            addCriterion("trace_sub_code_number not between", value1, value2, "traceSubCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdIsNull() {
            addCriterion("trace_good_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdIsNotNull() {
            addCriterion("trace_good_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdEqualTo(Integer value) {
            addCriterion("trace_good_id =", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdNotEqualTo(Integer value) {
            addCriterion("trace_good_id <>", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdGreaterThan(Integer value) {
            addCriterion("trace_good_id >", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_good_id >=", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdLessThan(Integer value) {
            addCriterion("trace_good_id <", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_good_id <=", value, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdIn(List<Integer> values) {
            addCriterion("trace_good_id in", values, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdNotIn(List<Integer> values) {
            addCriterion("trace_good_id not in", values, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_good_id between", value1, value2, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_good_id not between", value1, value2, "traceGoodId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdIsNull() {
            addCriterion("trace_stall_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdIsNotNull() {
            addCriterion("trace_stall_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdEqualTo(Integer value) {
            addCriterion("trace_stall_id =", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdNotEqualTo(Integer value) {
            addCriterion("trace_stall_id <>", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdGreaterThan(Integer value) {
            addCriterion("trace_stall_id >", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_stall_id >=", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdLessThan(Integer value) {
            addCriterion("trace_stall_id <", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_stall_id <=", value, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdIn(List<Integer> values) {
            addCriterion("trace_stall_id in", values, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdNotIn(List<Integer> values) {
            addCriterion("trace_stall_id not in", values, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_stall_id between", value1, value2, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andTraceStallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_stall_id not between", value1, value2, "traceStallId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNull() {
            addCriterion("is_leaf is null");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNotNull() {
            addCriterion("is_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeafEqualTo(String value) {
            addCriterion("is_leaf =", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotEqualTo(String value) {
            addCriterion("is_leaf <>", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThan(String value) {
            addCriterion("is_leaf >", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThanOrEqualTo(String value) {
            addCriterion("is_leaf >=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThan(String value) {
            addCriterion("is_leaf <", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThanOrEqualTo(String value) {
            addCriterion("is_leaf <=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLike(String value) {
            addCriterion("is_leaf like", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotLike(String value) {
            addCriterion("is_leaf not like", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafIn(List<String> values) {
            addCriterion("is_leaf in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotIn(List<String> values) {
            addCriterion("is_leaf not in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafBetween(String value1, String value2) {
            addCriterion("is_leaf between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotBetween(String value1, String value2) {
            addCriterion("is_leaf not between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andNodeLevelIsNull() {
            addCriterion("node_level is null");
            return (Criteria) this;
        }

        public Criteria andNodeLevelIsNotNull() {
            addCriterion("node_level is not null");
            return (Criteria) this;
        }

        public Criteria andNodeLevelEqualTo(Integer value) {
            addCriterion("node_level =", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelNotEqualTo(Integer value) {
            addCriterion("node_level <>", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelGreaterThan(Integer value) {
            addCriterion("node_level >", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("node_level >=", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelLessThan(Integer value) {
            addCriterion("node_level <", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("node_level <=", value, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelIn(List<Integer> values) {
            addCriterion("node_level in", values, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelNotIn(List<Integer> values) {
            addCriterion("node_level not in", values, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelBetween(Integer value1, Integer value2) {
            addCriterion("node_level between", value1, value2, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andNodeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("node_level not between", value1, value2, "nodeLevel");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNull() {
            addCriterion("scan_count is null");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNotNull() {
            addCriterion("scan_count is not null");
            return (Criteria) this;
        }

        public Criteria andScanCountEqualTo(Long value) {
            addCriterion("scan_count =", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotEqualTo(Long value) {
            addCriterion("scan_count <>", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThan(Long value) {
            addCriterion("scan_count >", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThanOrEqualTo(Long value) {
            addCriterion("scan_count >=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThan(Long value) {
            addCriterion("scan_count <", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThanOrEqualTo(Long value) {
            addCriterion("scan_count <=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIn(List<Long> values) {
            addCriterion("scan_count in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotIn(List<Long> values) {
            addCriterion("scan_count not in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountBetween(Long value1, Long value2) {
            addCriterion("scan_count between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotBetween(Long value1, Long value2) {
            addCriterion("scan_count not between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andIsSaledIsNull() {
            addCriterion("is_saled is null");
            return (Criteria) this;
        }

        public Criteria andIsSaledIsNotNull() {
            addCriterion("is_saled is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaledEqualTo(Integer value) {
            addCriterion("is_saled =", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledNotEqualTo(Integer value) {
            addCriterion("is_saled <>", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledGreaterThan(Integer value) {
            addCriterion("is_saled >", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_saled >=", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledLessThan(Integer value) {
            addCriterion("is_saled <", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledLessThanOrEqualTo(Integer value) {
            addCriterion("is_saled <=", value, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledIn(List<Integer> values) {
            addCriterion("is_saled in", values, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledNotIn(List<Integer> values) {
            addCriterion("is_saled not in", values, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledBetween(Integer value1, Integer value2) {
            addCriterion("is_saled between", value1, value2, "isSaled");
            return (Criteria) this;
        }

        public Criteria andIsSaledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_saled not between", value1, value2, "isSaled");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNull() {
            addCriterion("sale_time is null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIsNotNull() {
            addCriterion("sale_time is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTimeEqualTo(Date value) {
            addCriterion("sale_time =", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotEqualTo(Date value) {
            addCriterion("sale_time <>", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThan(Date value) {
            addCriterion("sale_time >", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sale_time >=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThan(Date value) {
            addCriterion("sale_time <", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeLessThanOrEqualTo(Date value) {
            addCriterion("sale_time <=", value, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeIn(List<Date> values) {
            addCriterion("sale_time in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotIn(List<Date> values) {
            addCriterion("sale_time not in", values, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeBetween(Date value1, Date value2) {
            addCriterion("sale_time between", value1, value2, "saleTime");
            return (Criteria) this;
        }

        public Criteria andSaleTimeNotBetween(Date value1, Date value2) {
            addCriterion("sale_time not between", value1, value2, "saleTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
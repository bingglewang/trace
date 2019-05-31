package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class ZslTracePointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTracePointExample() {
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

        public Criteria andTracePointIdIsNull() {
            addCriterion("trace_point_id is null");
            return (Criteria) this;
        }

        public Criteria andTracePointIdIsNotNull() {
            addCriterion("trace_point_id is not null");
            return (Criteria) this;
        }

        public Criteria andTracePointIdEqualTo(Integer value) {
            addCriterion("trace_point_id =", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdNotEqualTo(Integer value) {
            addCriterion("trace_point_id <>", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdGreaterThan(Integer value) {
            addCriterion("trace_point_id >", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_point_id >=", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdLessThan(Integer value) {
            addCriterion("trace_point_id <", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_point_id <=", value, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdIn(List<Integer> values) {
            addCriterion("trace_point_id in", values, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdNotIn(List<Integer> values) {
            addCriterion("trace_point_id not in", values, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_id between", value1, value2, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTracePointIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_id not between", value1, value2, "tracePointId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdIsNull() {
            addCriterion("trace_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdIsNotNull() {
            addCriterion("trace_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdEqualTo(Integer value) {
            addCriterion("trace_goods_id =", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdNotEqualTo(Integer value) {
            addCriterion("trace_goods_id <>", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdGreaterThan(Integer value) {
            addCriterion("trace_goods_id >", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_goods_id >=", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdLessThan(Integer value) {
            addCriterion("trace_goods_id <", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_goods_id <=", value, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdIn(List<Integer> values) {
            addCriterion("trace_goods_id in", values, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdNotIn(List<Integer> values) {
            addCriterion("trace_goods_id not in", values, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_goods_id between", value1, value2, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTraceGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_goods_id not between", value1, value2, "traceGoodsId");
            return (Criteria) this;
        }

        public Criteria andTracePointNameIsNull() {
            addCriterion("trace_point_name is null");
            return (Criteria) this;
        }

        public Criteria andTracePointNameIsNotNull() {
            addCriterion("trace_point_name is not null");
            return (Criteria) this;
        }

        public Criteria andTracePointNameEqualTo(String value) {
            addCriterion("trace_point_name =", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameNotEqualTo(String value) {
            addCriterion("trace_point_name <>", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameGreaterThan(String value) {
            addCriterion("trace_point_name >", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameGreaterThanOrEqualTo(String value) {
            addCriterion("trace_point_name >=", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameLessThan(String value) {
            addCriterion("trace_point_name <", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameLessThanOrEqualTo(String value) {
            addCriterion("trace_point_name <=", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameLike(String value) {
            addCriterion("trace_point_name like", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameNotLike(String value) {
            addCriterion("trace_point_name not like", value, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameIn(List<String> values) {
            addCriterion("trace_point_name in", values, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameNotIn(List<String> values) {
            addCriterion("trace_point_name not in", values, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameBetween(String value1, String value2) {
            addCriterion("trace_point_name between", value1, value2, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointNameNotBetween(String value1, String value2) {
            addCriterion("trace_point_name not between", value1, value2, "tracePointName");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberIsNull() {
            addCriterion("trace_point_to_number is null");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberIsNotNull() {
            addCriterion("trace_point_to_number is not null");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberEqualTo(Integer value) {
            addCriterion("trace_point_to_number =", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberNotEqualTo(Integer value) {
            addCriterion("trace_point_to_number <>", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberGreaterThan(Integer value) {
            addCriterion("trace_point_to_number >", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_point_to_number >=", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberLessThan(Integer value) {
            addCriterion("trace_point_to_number <", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberLessThanOrEqualTo(Integer value) {
            addCriterion("trace_point_to_number <=", value, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberIn(List<Integer> values) {
            addCriterion("trace_point_to_number in", values, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberNotIn(List<Integer> values) {
            addCriterion("trace_point_to_number not in", values, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_to_number between", value1, value2, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointToNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_to_number not between", value1, value2, "tracePointToNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberIsNull() {
            addCriterion("trace_point_from_number is null");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberIsNotNull() {
            addCriterion("trace_point_from_number is not null");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberEqualTo(Integer value) {
            addCriterion("trace_point_from_number =", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberNotEqualTo(Integer value) {
            addCriterion("trace_point_from_number <>", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberGreaterThan(Integer value) {
            addCriterion("trace_point_from_number >", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_point_from_number >=", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberLessThan(Integer value) {
            addCriterion("trace_point_from_number <", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberLessThanOrEqualTo(Integer value) {
            addCriterion("trace_point_from_number <=", value, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberIn(List<Integer> values) {
            addCriterion("trace_point_from_number in", values, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberNotIn(List<Integer> values) {
            addCriterion("trace_point_from_number not in", values, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_from_number between", value1, value2, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTracePointFromNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_point_from_number not between", value1, value2, "tracePointFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdIsNull() {
            addCriterion("trace_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdIsNotNull() {
            addCriterion("trace_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdEqualTo(Integer value) {
            addCriterion("trace_parent_id =", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdNotEqualTo(Integer value) {
            addCriterion("trace_parent_id <>", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdGreaterThan(Integer value) {
            addCriterion("trace_parent_id >", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_parent_id >=", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdLessThan(Integer value) {
            addCriterion("trace_parent_id <", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_parent_id <=", value, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdIn(List<Integer> values) {
            addCriterion("trace_parent_id in", values, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdNotIn(List<Integer> values) {
            addCriterion("trace_parent_id not in", values, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_parent_id between", value1, value2, "traceParentId");
            return (Criteria) this;
        }

        public Criteria andTraceParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_parent_id not between", value1, value2, "traceParentId");
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
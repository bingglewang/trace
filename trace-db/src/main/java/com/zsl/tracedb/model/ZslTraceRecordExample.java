package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class ZslTraceRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTraceRecordExample() {
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

        public Criteria andTraceRecordIdIsNull() {
            addCriterion("trace_record_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdIsNotNull() {
            addCriterion("trace_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdEqualTo(Integer value) {
            addCriterion("trace_record_id =", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdNotEqualTo(Integer value) {
            addCriterion("trace_record_id <>", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdGreaterThan(Integer value) {
            addCriterion("trace_record_id >", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_record_id >=", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdLessThan(Integer value) {
            addCriterion("trace_record_id <", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_record_id <=", value, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdIn(List<Integer> values) {
            addCriterion("trace_record_id in", values, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdNotIn(List<Integer> values) {
            addCriterion("trace_record_id not in", values, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_record_id between", value1, value2, "traceRecordId");
            return (Criteria) this;
        }

        public Criteria andTraceRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_record_id not between", value1, value2, "traceRecordId");
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

        public Criteria andTraceToNumberIsNull() {
            addCriterion("trace_to_number is null");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberIsNotNull() {
            addCriterion("trace_to_number is not null");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberEqualTo(Integer value) {
            addCriterion("trace_to_number =", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberNotEqualTo(Integer value) {
            addCriterion("trace_to_number <>", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberGreaterThan(Integer value) {
            addCriterion("trace_to_number >", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_to_number >=", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberLessThan(Integer value) {
            addCriterion("trace_to_number <", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberLessThanOrEqualTo(Integer value) {
            addCriterion("trace_to_number <=", value, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberIn(List<Integer> values) {
            addCriterion("trace_to_number in", values, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberNotIn(List<Integer> values) {
            addCriterion("trace_to_number not in", values, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberBetween(Integer value1, Integer value2) {
            addCriterion("trace_to_number between", value1, value2, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceToNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_to_number not between", value1, value2, "traceToNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberIsNull() {
            addCriterion("trace_from_number is null");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberIsNotNull() {
            addCriterion("trace_from_number is not null");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberEqualTo(Integer value) {
            addCriterion("trace_from_number =", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberNotEqualTo(Integer value) {
            addCriterion("trace_from_number <>", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberGreaterThan(Integer value) {
            addCriterion("trace_from_number >", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_from_number >=", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberLessThan(Integer value) {
            addCriterion("trace_from_number <", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberLessThanOrEqualTo(Integer value) {
            addCriterion("trace_from_number <=", value, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberIn(List<Integer> values) {
            addCriterion("trace_from_number in", values, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberNotIn(List<Integer> values) {
            addCriterion("trace_from_number not in", values, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberBetween(Integer value1, Integer value2) {
            addCriterion("trace_from_number between", value1, value2, "traceFromNumber");
            return (Criteria) this;
        }

        public Criteria andTraceFromNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_from_number not between", value1, value2, "traceFromNumber");
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
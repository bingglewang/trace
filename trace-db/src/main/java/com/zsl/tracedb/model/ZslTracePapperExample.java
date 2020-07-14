package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class ZslTracePapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTracePapperExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartIsNull() {
            addCriterion("trace_num_start is null");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartIsNotNull() {
            addCriterion("trace_num_start is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartEqualTo(Long value) {
            addCriterion("trace_num_start =", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartNotEqualTo(Long value) {
            addCriterion("trace_num_start <>", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartGreaterThan(Long value) {
            addCriterion("trace_num_start >", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_num_start >=", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartLessThan(Long value) {
            addCriterion("trace_num_start <", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartLessThanOrEqualTo(Long value) {
            addCriterion("trace_num_start <=", value, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartIn(List<Long> values) {
            addCriterion("trace_num_start in", values, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartNotIn(List<Long> values) {
            addCriterion("trace_num_start not in", values, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartBetween(Long value1, Long value2) {
            addCriterion("trace_num_start between", value1, value2, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumStartNotBetween(Long value1, Long value2) {
            addCriterion("trace_num_start not between", value1, value2, "traceNumStart");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndIsNull() {
            addCriterion("trace_num_end is null");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndIsNotNull() {
            addCriterion("trace_num_end is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndEqualTo(Long value) {
            addCriterion("trace_num_end =", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndNotEqualTo(Long value) {
            addCriterion("trace_num_end <>", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndGreaterThan(Long value) {
            addCriterion("trace_num_end >", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_num_end >=", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndLessThan(Long value) {
            addCriterion("trace_num_end <", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndLessThanOrEqualTo(Long value) {
            addCriterion("trace_num_end <=", value, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndIn(List<Long> values) {
            addCriterion("trace_num_end in", values, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndNotIn(List<Long> values) {
            addCriterion("trace_num_end not in", values, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndBetween(Long value1, Long value2) {
            addCriterion("trace_num_end between", value1, value2, "traceNumEnd");
            return (Criteria) this;
        }

        public Criteria andTraceNumEndNotBetween(Long value1, Long value2) {
            addCriterion("trace_num_end not between", value1, value2, "traceNumEnd");
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

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Integer value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Integer value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Integer value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Integer value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Integer> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Integer> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andTraceCountIsNull() {
            addCriterion("trace_count is null");
            return (Criteria) this;
        }

        public Criteria andTraceCountIsNotNull() {
            addCriterion("trace_count is not null");
            return (Criteria) this;
        }

        public Criteria andTraceCountEqualTo(Long value) {
            addCriterion("trace_count =", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountNotEqualTo(Long value) {
            addCriterion("trace_count <>", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountGreaterThan(Long value) {
            addCriterion("trace_count >", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_count >=", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountLessThan(Long value) {
            addCriterion("trace_count <", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountLessThanOrEqualTo(Long value) {
            addCriterion("trace_count <=", value, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountIn(List<Long> values) {
            addCriterion("trace_count in", values, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountNotIn(List<Long> values) {
            addCriterion("trace_count not in", values, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountBetween(Long value1, Long value2) {
            addCriterion("trace_count between", value1, value2, "traceCount");
            return (Criteria) this;
        }

        public Criteria andTraceCountNotBetween(Long value1, Long value2) {
            addCriterion("trace_count not between", value1, value2, "traceCount");
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
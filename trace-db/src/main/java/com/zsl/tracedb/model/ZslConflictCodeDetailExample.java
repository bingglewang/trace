package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslConflictCodeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslConflictCodeDetailExample() {
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

        public Criteria andConflictCodeIdIsNull() {
            addCriterion("conflict_code_id is null");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdIsNotNull() {
            addCriterion("conflict_code_id is not null");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdEqualTo(Integer value) {
            addCriterion("conflict_code_id =", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdNotEqualTo(Integer value) {
            addCriterion("conflict_code_id <>", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdGreaterThan(Integer value) {
            addCriterion("conflict_code_id >", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("conflict_code_id >=", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdLessThan(Integer value) {
            addCriterion("conflict_code_id <", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("conflict_code_id <=", value, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdIn(List<Integer> values) {
            addCriterion("conflict_code_id in", values, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdNotIn(List<Integer> values) {
            addCriterion("conflict_code_id not in", values, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdBetween(Integer value1, Integer value2) {
            addCriterion("conflict_code_id between", value1, value2, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictCodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("conflict_code_id not between", value1, value2, "conflictCodeId");
            return (Criteria) this;
        }

        public Criteria andConflictAddressIsNull() {
            addCriterion("conflict_address is null");
            return (Criteria) this;
        }

        public Criteria andConflictAddressIsNotNull() {
            addCriterion("conflict_address is not null");
            return (Criteria) this;
        }

        public Criteria andConflictAddressEqualTo(String value) {
            addCriterion("conflict_address =", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressNotEqualTo(String value) {
            addCriterion("conflict_address <>", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressGreaterThan(String value) {
            addCriterion("conflict_address >", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressGreaterThanOrEqualTo(String value) {
            addCriterion("conflict_address >=", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressLessThan(String value) {
            addCriterion("conflict_address <", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressLessThanOrEqualTo(String value) {
            addCriterion("conflict_address <=", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressLike(String value) {
            addCriterion("conflict_address like", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressNotLike(String value) {
            addCriterion("conflict_address not like", value, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressIn(List<String> values) {
            addCriterion("conflict_address in", values, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressNotIn(List<String> values) {
            addCriterion("conflict_address not in", values, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressBetween(String value1, String value2) {
            addCriterion("conflict_address between", value1, value2, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictAddressNotBetween(String value1, String value2) {
            addCriterion("conflict_address not between", value1, value2, "conflictAddress");
            return (Criteria) this;
        }

        public Criteria andConflictDateIsNull() {
            addCriterion("conflict_date is null");
            return (Criteria) this;
        }

        public Criteria andConflictDateIsNotNull() {
            addCriterion("conflict_date is not null");
            return (Criteria) this;
        }

        public Criteria andConflictDateEqualTo(Date value) {
            addCriterion("conflict_date =", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateNotEqualTo(Date value) {
            addCriterion("conflict_date <>", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateGreaterThan(Date value) {
            addCriterion("conflict_date >", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateGreaterThanOrEqualTo(Date value) {
            addCriterion("conflict_date >=", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateLessThan(Date value) {
            addCriterion("conflict_date <", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateLessThanOrEqualTo(Date value) {
            addCriterion("conflict_date <=", value, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateIn(List<Date> values) {
            addCriterion("conflict_date in", values, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateNotIn(List<Date> values) {
            addCriterion("conflict_date not in", values, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateBetween(Date value1, Date value2) {
            addCriterion("conflict_date between", value1, value2, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictDateNotBetween(Date value1, Date value2) {
            addCriterion("conflict_date not between", value1, value2, "conflictDate");
            return (Criteria) this;
        }

        public Criteria andConflictIpIsNull() {
            addCriterion("conflict_ip is null");
            return (Criteria) this;
        }

        public Criteria andConflictIpIsNotNull() {
            addCriterion("conflict_ip is not null");
            return (Criteria) this;
        }

        public Criteria andConflictIpEqualTo(String value) {
            addCriterion("conflict_ip =", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpNotEqualTo(String value) {
            addCriterion("conflict_ip <>", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpGreaterThan(String value) {
            addCriterion("conflict_ip >", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpGreaterThanOrEqualTo(String value) {
            addCriterion("conflict_ip >=", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpLessThan(String value) {
            addCriterion("conflict_ip <", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpLessThanOrEqualTo(String value) {
            addCriterion("conflict_ip <=", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpLike(String value) {
            addCriterion("conflict_ip like", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpNotLike(String value) {
            addCriterion("conflict_ip not like", value, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpIn(List<String> values) {
            addCriterion("conflict_ip in", values, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpNotIn(List<String> values) {
            addCriterion("conflict_ip not in", values, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpBetween(String value1, String value2) {
            addCriterion("conflict_ip between", value1, value2, "conflictIp");
            return (Criteria) this;
        }

        public Criteria andConflictIpNotBetween(String value1, String value2) {
            addCriterion("conflict_ip not between", value1, value2, "conflictIp");
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
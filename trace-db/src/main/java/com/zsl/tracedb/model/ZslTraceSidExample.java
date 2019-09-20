package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslTraceSidExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTraceSidExample() {
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

        public Criteria andSidStartIndexIsNull() {
            addCriterion("sid_start_index is null");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexIsNotNull() {
            addCriterion("sid_start_index is not null");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexEqualTo(Long value) {
            addCriterion("sid_start_index =", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexNotEqualTo(Long value) {
            addCriterion("sid_start_index <>", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexGreaterThan(Long value) {
            addCriterion("sid_start_index >", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("sid_start_index >=", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexLessThan(Long value) {
            addCriterion("sid_start_index <", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexLessThanOrEqualTo(Long value) {
            addCriterion("sid_start_index <=", value, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexIn(List<Long> values) {
            addCriterion("sid_start_index in", values, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexNotIn(List<Long> values) {
            addCriterion("sid_start_index not in", values, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexBetween(Long value1, Long value2) {
            addCriterion("sid_start_index between", value1, value2, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidStartIndexNotBetween(Long value1, Long value2) {
            addCriterion("sid_start_index not between", value1, value2, "sidStartIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexIsNull() {
            addCriterion("sid_end_index is null");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexIsNotNull() {
            addCriterion("sid_end_index is not null");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexEqualTo(Long value) {
            addCriterion("sid_end_index =", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexNotEqualTo(Long value) {
            addCriterion("sid_end_index <>", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexGreaterThan(Long value) {
            addCriterion("sid_end_index >", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("sid_end_index >=", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexLessThan(Long value) {
            addCriterion("sid_end_index <", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexLessThanOrEqualTo(Long value) {
            addCriterion("sid_end_index <=", value, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexIn(List<Long> values) {
            addCriterion("sid_end_index in", values, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexNotIn(List<Long> values) {
            addCriterion("sid_end_index not in", values, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexBetween(Long value1, Long value2) {
            addCriterion("sid_end_index between", value1, value2, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidEndIndexNotBetween(Long value1, Long value2) {
            addCriterion("sid_end_index not between", value1, value2, "sidEndIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexIsNull() {
            addCriterion("sid_current_index is null");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexIsNotNull() {
            addCriterion("sid_current_index is not null");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexEqualTo(Long value) {
            addCriterion("sid_current_index =", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexNotEqualTo(Long value) {
            addCriterion("sid_current_index <>", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexGreaterThan(Long value) {
            addCriterion("sid_current_index >", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("sid_current_index >=", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexLessThan(Long value) {
            addCriterion("sid_current_index <", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexLessThanOrEqualTo(Long value) {
            addCriterion("sid_current_index <=", value, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexIn(List<Long> values) {
            addCriterion("sid_current_index in", values, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexNotIn(List<Long> values) {
            addCriterion("sid_current_index not in", values, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexBetween(Long value1, Long value2) {
            addCriterion("sid_current_index between", value1, value2, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidCurrentIndexNotBetween(Long value1, Long value2) {
            addCriterion("sid_current_index not between", value1, value2, "sidCurrentIndex");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateIsNull() {
            addCriterion("sid_pre_create is null");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateIsNotNull() {
            addCriterion("sid_pre_create is not null");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateEqualTo(Byte value) {
            addCriterion("sid_pre_create =", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateNotEqualTo(Byte value) {
            addCriterion("sid_pre_create <>", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateGreaterThan(Byte value) {
            addCriterion("sid_pre_create >", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateGreaterThanOrEqualTo(Byte value) {
            addCriterion("sid_pre_create >=", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateLessThan(Byte value) {
            addCriterion("sid_pre_create <", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateLessThanOrEqualTo(Byte value) {
            addCriterion("sid_pre_create <=", value, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateIn(List<Byte> values) {
            addCriterion("sid_pre_create in", values, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateNotIn(List<Byte> values) {
            addCriterion("sid_pre_create not in", values, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateBetween(Byte value1, Byte value2) {
            addCriterion("sid_pre_create between", value1, value2, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andSidPreCreateNotBetween(Byte value1, Byte value2) {
            addCriterion("sid_pre_create not between", value1, value2, "sidPreCreate");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexIsNull() {
            addCriterion("current_E_index is null");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexIsNotNull() {
            addCriterion("current_E_index is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexEqualTo(Long value) {
            addCriterion("current_E_index =", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexNotEqualTo(Long value) {
            addCriterion("current_E_index <>", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexGreaterThan(Long value) {
            addCriterion("current_E_index >", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("current_E_index >=", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexLessThan(Long value) {
            addCriterion("current_E_index <", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexLessThanOrEqualTo(Long value) {
            addCriterion("current_E_index <=", value, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexIn(List<Long> values) {
            addCriterion("current_E_index in", values, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexNotIn(List<Long> values) {
            addCriterion("current_E_index not in", values, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexBetween(Long value1, Long value2) {
            addCriterion("current_E_index between", value1, value2, "currentEIndex");
            return (Criteria) this;
        }

        public Criteria andCurrentEIndexNotBetween(Long value1, Long value2) {
            addCriterion("current_E_index not between", value1, value2, "currentEIndex");
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
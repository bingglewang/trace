package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslRecallTraceSubcodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslRecallTraceSubcodeExample() {
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

        public Criteria andRecallIdIsNull() {
            addCriterion("recall_id is null");
            return (Criteria) this;
        }

        public Criteria andRecallIdIsNotNull() {
            addCriterion("recall_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecallIdEqualTo(Integer value) {
            addCriterion("recall_id =", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdNotEqualTo(Integer value) {
            addCriterion("recall_id <>", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdGreaterThan(Integer value) {
            addCriterion("recall_id >", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recall_id >=", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdLessThan(Integer value) {
            addCriterion("recall_id <", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdLessThanOrEqualTo(Integer value) {
            addCriterion("recall_id <=", value, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdIn(List<Integer> values) {
            addCriterion("recall_id in", values, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdNotIn(List<Integer> values) {
            addCriterion("recall_id not in", values, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdBetween(Integer value1, Integer value2) {
            addCriterion("recall_id between", value1, value2, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recall_id not between", value1, value2, "recallId");
            return (Criteria) this;
        }

        public Criteria andRecallTypeIsNull() {
            addCriterion("recall_type is null");
            return (Criteria) this;
        }

        public Criteria andRecallTypeIsNotNull() {
            addCriterion("recall_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecallTypeEqualTo(Integer value) {
            addCriterion("recall_type =", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeNotEqualTo(Integer value) {
            addCriterion("recall_type <>", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeGreaterThan(Integer value) {
            addCriterion("recall_type >", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recall_type >=", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeLessThan(Integer value) {
            addCriterion("recall_type <", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeLessThanOrEqualTo(Integer value) {
            addCriterion("recall_type <=", value, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeIn(List<Integer> values) {
            addCriterion("recall_type in", values, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeNotIn(List<Integer> values) {
            addCriterion("recall_type not in", values, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeBetween(Integer value1, Integer value2) {
            addCriterion("recall_type between", value1, value2, "recallType");
            return (Criteria) this;
        }

        public Criteria andRecallTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recall_type not between", value1, value2, "recallType");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdIsNull() {
            addCriterion("subcode_id is null");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdIsNotNull() {
            addCriterion("subcode_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdEqualTo(Integer value) {
            addCriterion("subcode_id =", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdNotEqualTo(Integer value) {
            addCriterion("subcode_id <>", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdGreaterThan(Integer value) {
            addCriterion("subcode_id >", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subcode_id >=", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdLessThan(Integer value) {
            addCriterion("subcode_id <", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("subcode_id <=", value, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdIn(List<Integer> values) {
            addCriterion("subcode_id in", values, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdNotIn(List<Integer> values) {
            addCriterion("subcode_id not in", values, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdBetween(Integer value1, Integer value2) {
            addCriterion("subcode_id between", value1, value2, "subcodeId");
            return (Criteria) this;
        }

        public Criteria andSubcodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subcode_id not between", value1, value2, "subcodeId");
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
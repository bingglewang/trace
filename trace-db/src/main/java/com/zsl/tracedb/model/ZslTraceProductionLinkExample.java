package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslTraceProductionLinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTraceProductionLinkExample() {
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

        public Criteria andProductionNameIsNull() {
            addCriterion("production_name is null");
            return (Criteria) this;
        }

        public Criteria andProductionNameIsNotNull() {
            addCriterion("production_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductionNameEqualTo(String value) {
            addCriterion("production_name =", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotEqualTo(String value) {
            addCriterion("production_name <>", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameGreaterThan(String value) {
            addCriterion("production_name >", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameGreaterThanOrEqualTo(String value) {
            addCriterion("production_name >=", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLessThan(String value) {
            addCriterion("production_name <", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLessThanOrEqualTo(String value) {
            addCriterion("production_name <=", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameLike(String value) {
            addCriterion("production_name like", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotLike(String value) {
            addCriterion("production_name not like", value, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameIn(List<String> values) {
            addCriterion("production_name in", values, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotIn(List<String> values) {
            addCriterion("production_name not in", values, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameBetween(String value1, String value2) {
            addCriterion("production_name between", value1, value2, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionNameNotBetween(String value1, String value2) {
            addCriterion("production_name not between", value1, value2, "productionName");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNull() {
            addCriterion("production_time is null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIsNotNull() {
            addCriterion("production_time is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeEqualTo(Date value) {
            addCriterion("production_time =", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotEqualTo(Date value) {
            addCriterion("production_time <>", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThan(Date value) {
            addCriterion("production_time >", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("production_time >=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThan(Date value) {
            addCriterion("production_time <", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeLessThanOrEqualTo(Date value) {
            addCriterion("production_time <=", value, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeIn(List<Date> values) {
            addCriterion("production_time in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotIn(List<Date> values) {
            addCriterion("production_time not in", values, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeBetween(Date value1, Date value2) {
            addCriterion("production_time between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionTimeNotBetween(Date value1, Date value2) {
            addCriterion("production_time not between", value1, value2, "productionTime");
            return (Criteria) this;
        }

        public Criteria andProductionManIsNull() {
            addCriterion("production_man is null");
            return (Criteria) this;
        }

        public Criteria andProductionManIsNotNull() {
            addCriterion("production_man is not null");
            return (Criteria) this;
        }

        public Criteria andProductionManEqualTo(String value) {
            addCriterion("production_man =", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManNotEqualTo(String value) {
            addCriterion("production_man <>", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManGreaterThan(String value) {
            addCriterion("production_man >", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManGreaterThanOrEqualTo(String value) {
            addCriterion("production_man >=", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManLessThan(String value) {
            addCriterion("production_man <", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManLessThanOrEqualTo(String value) {
            addCriterion("production_man <=", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManLike(String value) {
            addCriterion("production_man like", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManNotLike(String value) {
            addCriterion("production_man not like", value, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManIn(List<String> values) {
            addCriterion("production_man in", values, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManNotIn(List<String> values) {
            addCriterion("production_man not in", values, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManBetween(String value1, String value2) {
            addCriterion("production_man between", value1, value2, "productionMan");
            return (Criteria) this;
        }

        public Criteria andProductionManNotBetween(String value1, String value2) {
            addCriterion("production_man not between", value1, value2, "productionMan");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdIsNull() {
            addCriterion("trace_recode_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdIsNotNull() {
            addCriterion("trace_recode_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdEqualTo(Integer value) {
            addCriterion("trace_recode_id =", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdNotEqualTo(Integer value) {
            addCriterion("trace_recode_id <>", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdGreaterThan(Integer value) {
            addCriterion("trace_recode_id >", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_recode_id >=", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdLessThan(Integer value) {
            addCriterion("trace_recode_id <", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_recode_id <=", value, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdIn(List<Integer> values) {
            addCriterion("trace_recode_id in", values, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdNotIn(List<Integer> values) {
            addCriterion("trace_recode_id not in", values, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_recode_id between", value1, value2, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andTraceRecodeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_recode_id not between", value1, value2, "traceRecodeId");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeIsNull() {
            addCriterion("production_descripe is null");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeIsNotNull() {
            addCriterion("production_descripe is not null");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeEqualTo(String value) {
            addCriterion("production_descripe =", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeNotEqualTo(String value) {
            addCriterion("production_descripe <>", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeGreaterThan(String value) {
            addCriterion("production_descripe >", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeGreaterThanOrEqualTo(String value) {
            addCriterion("production_descripe >=", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeLessThan(String value) {
            addCriterion("production_descripe <", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeLessThanOrEqualTo(String value) {
            addCriterion("production_descripe <=", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeLike(String value) {
            addCriterion("production_descripe like", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeNotLike(String value) {
            addCriterion("production_descripe not like", value, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeIn(List<String> values) {
            addCriterion("production_descripe in", values, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeNotIn(List<String> values) {
            addCriterion("production_descripe not in", values, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeBetween(String value1, String value2) {
            addCriterion("production_descripe between", value1, value2, "productionDescripe");
            return (Criteria) this;
        }

        public Criteria andProductionDescripeNotBetween(String value1, String value2) {
            addCriterion("production_descripe not between", value1, value2, "productionDescripe");
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
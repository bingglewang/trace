package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class IntegralDeductRatioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralDeductRatioExample() {
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

        public Criteria andIntegralDeductRatioIdIsNull() {
            addCriterion("integral_deduct_ratio_id is null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdIsNotNull() {
            addCriterion("integral_deduct_ratio_id is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_id =", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdNotEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_id <>", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdGreaterThan(Integer value) {
            addCriterion("integral_deduct_ratio_id >", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_id >=", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdLessThan(Integer value) {
            addCriterion("integral_deduct_ratio_id <", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdLessThanOrEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_id <=", value, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdIn(List<Integer> values) {
            addCriterion("integral_deduct_ratio_id in", values, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdNotIn(List<Integer> values) {
            addCriterion("integral_deduct_ratio_id not in", values, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdBetween(Integer value1, Integer value2) {
            addCriterion("integral_deduct_ratio_id between", value1, value2, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioIdNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_deduct_ratio_id not between", value1, value2, "integralDeductRatioId");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeIsNull() {
            addCriterion("integral_deduct_ratio_type is null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeIsNotNull() {
            addCriterion("integral_deduct_ratio_type is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_type =", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeNotEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_type <>", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeGreaterThan(Integer value) {
            addCriterion("integral_deduct_ratio_type >", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_type >=", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeLessThan(Integer value) {
            addCriterion("integral_deduct_ratio_type <", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeLessThanOrEqualTo(Integer value) {
            addCriterion("integral_deduct_ratio_type <=", value, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeIn(List<Integer> values) {
            addCriterion("integral_deduct_ratio_type in", values, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeNotIn(List<Integer> values) {
            addCriterion("integral_deduct_ratio_type not in", values, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeBetween(Integer value1, Integer value2) {
            addCriterion("integral_deduct_ratio_type between", value1, value2, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_deduct_ratio_type not between", value1, value2, "integralDeductRatioType");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioIsNull() {
            addCriterion("integral_ratio is null");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioIsNotNull() {
            addCriterion("integral_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioEqualTo(Integer value) {
            addCriterion("integral_ratio =", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioNotEqualTo(Integer value) {
            addCriterion("integral_ratio <>", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioGreaterThan(Integer value) {
            addCriterion("integral_ratio >", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral_ratio >=", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioLessThan(Integer value) {
            addCriterion("integral_ratio <", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioLessThanOrEqualTo(Integer value) {
            addCriterion("integral_ratio <=", value, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioIn(List<Integer> values) {
            addCriterion("integral_ratio in", values, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioNotIn(List<Integer> values) {
            addCriterion("integral_ratio not in", values, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioBetween(Integer value1, Integer value2) {
            addCriterion("integral_ratio between", value1, value2, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralRatioNotBetween(Integer value1, Integer value2) {
            addCriterion("integral_ratio not between", value1, value2, "integralRatio");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionIsNull() {
            addCriterion("integral_deduct_ratio_desciption is null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionIsNotNull() {
            addCriterion("integral_deduct_ratio_desciption is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionEqualTo(String value) {
            addCriterion("integral_deduct_ratio_desciption =", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionNotEqualTo(String value) {
            addCriterion("integral_deduct_ratio_desciption <>", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionGreaterThan(String value) {
            addCriterion("integral_deduct_ratio_desciption >", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionGreaterThanOrEqualTo(String value) {
            addCriterion("integral_deduct_ratio_desciption >=", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionLessThan(String value) {
            addCriterion("integral_deduct_ratio_desciption <", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionLessThanOrEqualTo(String value) {
            addCriterion("integral_deduct_ratio_desciption <=", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionLike(String value) {
            addCriterion("integral_deduct_ratio_desciption like", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionNotLike(String value) {
            addCriterion("integral_deduct_ratio_desciption not like", value, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionIn(List<String> values) {
            addCriterion("integral_deduct_ratio_desciption in", values, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionNotIn(List<String> values) {
            addCriterion("integral_deduct_ratio_desciption not in", values, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionBetween(String value1, String value2) {
            addCriterion("integral_deduct_ratio_desciption between", value1, value2, "integralDeductRatioDesciption");
            return (Criteria) this;
        }

        public Criteria andIntegralDeductRatioDesciptionNotBetween(String value1, String value2) {
            addCriterion("integral_deduct_ratio_desciption not between", value1, value2, "integralDeductRatioDesciption");
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
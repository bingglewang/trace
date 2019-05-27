package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantStallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantStallExample() {
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

        public Criteria andStallIdIsNull() {
            addCriterion("stall_id is null");
            return (Criteria) this;
        }

        public Criteria andStallIdIsNotNull() {
            addCriterion("stall_id is not null");
            return (Criteria) this;
        }

        public Criteria andStallIdEqualTo(Integer value) {
            addCriterion("stall_id =", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotEqualTo(Integer value) {
            addCriterion("stall_id <>", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdGreaterThan(Integer value) {
            addCriterion("stall_id >", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stall_id >=", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdLessThan(Integer value) {
            addCriterion("stall_id <", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdLessThanOrEqualTo(Integer value) {
            addCriterion("stall_id <=", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdIn(List<Integer> values) {
            addCriterion("stall_id in", values, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotIn(List<Integer> values) {
            addCriterion("stall_id not in", values, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdBetween(Integer value1, Integer value2) {
            addCriterion("stall_id between", value1, value2, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stall_id not between", value1, value2, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallNameIsNull() {
            addCriterion("stall_name is null");
            return (Criteria) this;
        }

        public Criteria andStallNameIsNotNull() {
            addCriterion("stall_name is not null");
            return (Criteria) this;
        }

        public Criteria andStallNameEqualTo(String value) {
            addCriterion("stall_name =", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameNotEqualTo(String value) {
            addCriterion("stall_name <>", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameGreaterThan(String value) {
            addCriterion("stall_name >", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameGreaterThanOrEqualTo(String value) {
            addCriterion("stall_name >=", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameLessThan(String value) {
            addCriterion("stall_name <", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameLessThanOrEqualTo(String value) {
            addCriterion("stall_name <=", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameLike(String value) {
            addCriterion("stall_name like", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameNotLike(String value) {
            addCriterion("stall_name not like", value, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameIn(List<String> values) {
            addCriterion("stall_name in", values, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameNotIn(List<String> values) {
            addCriterion("stall_name not in", values, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameBetween(String value1, String value2) {
            addCriterion("stall_name between", value1, value2, "stallName");
            return (Criteria) this;
        }

        public Criteria andStallNameNotBetween(String value1, String value2) {
            addCriterion("stall_name not between", value1, value2, "stallName");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(Integer value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(Integer value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(Integer value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(Integer value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<Integer> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<Integer> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(Integer value1, Integer value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andStallholderNameIsNull() {
            addCriterion("stallholder_name is null");
            return (Criteria) this;
        }

        public Criteria andStallholderNameIsNotNull() {
            addCriterion("stallholder_name is not null");
            return (Criteria) this;
        }

        public Criteria andStallholderNameEqualTo(String value) {
            addCriterion("stallholder_name =", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameNotEqualTo(String value) {
            addCriterion("stallholder_name <>", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameGreaterThan(String value) {
            addCriterion("stallholder_name >", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameGreaterThanOrEqualTo(String value) {
            addCriterion("stallholder_name >=", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameLessThan(String value) {
            addCriterion("stallholder_name <", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameLessThanOrEqualTo(String value) {
            addCriterion("stallholder_name <=", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameLike(String value) {
            addCriterion("stallholder_name like", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameNotLike(String value) {
            addCriterion("stallholder_name not like", value, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameIn(List<String> values) {
            addCriterion("stallholder_name in", values, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameNotIn(List<String> values) {
            addCriterion("stallholder_name not in", values, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameBetween(String value1, String value2) {
            addCriterion("stallholder_name between", value1, value2, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNameNotBetween(String value1, String value2) {
            addCriterion("stallholder_name not between", value1, value2, "stallholderName");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberIsNull() {
            addCriterion("stallholder_number is null");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberIsNotNull() {
            addCriterion("stallholder_number is not null");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberEqualTo(String value) {
            addCriterion("stallholder_number =", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberNotEqualTo(String value) {
            addCriterion("stallholder_number <>", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberGreaterThan(String value) {
            addCriterion("stallholder_number >", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("stallholder_number >=", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberLessThan(String value) {
            addCriterion("stallholder_number <", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberLessThanOrEqualTo(String value) {
            addCriterion("stallholder_number <=", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberLike(String value) {
            addCriterion("stallholder_number like", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberNotLike(String value) {
            addCriterion("stallholder_number not like", value, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberIn(List<String> values) {
            addCriterion("stallholder_number in", values, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberNotIn(List<String> values) {
            addCriterion("stallholder_number not in", values, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberBetween(String value1, String value2) {
            addCriterion("stallholder_number between", value1, value2, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderNumberNotBetween(String value1, String value2) {
            addCriterion("stallholder_number not between", value1, value2, "stallholderNumber");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidIsNull() {
            addCriterion("stallholder_openid is null");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidIsNotNull() {
            addCriterion("stallholder_openid is not null");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidEqualTo(String value) {
            addCriterion("stallholder_openid =", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidNotEqualTo(String value) {
            addCriterion("stallholder_openid <>", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidGreaterThan(String value) {
            addCriterion("stallholder_openid >", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("stallholder_openid >=", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidLessThan(String value) {
            addCriterion("stallholder_openid <", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidLessThanOrEqualTo(String value) {
            addCriterion("stallholder_openid <=", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidLike(String value) {
            addCriterion("stallholder_openid like", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidNotLike(String value) {
            addCriterion("stallholder_openid not like", value, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidIn(List<String> values) {
            addCriterion("stallholder_openid in", values, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidNotIn(List<String> values) {
            addCriterion("stallholder_openid not in", values, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidBetween(String value1, String value2) {
            addCriterion("stallholder_openid between", value1, value2, "stallholderOpenid");
            return (Criteria) this;
        }

        public Criteria andStallholderOpenidNotBetween(String value1, String value2) {
            addCriterion("stallholder_openid not between", value1, value2, "stallholderOpenid");
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
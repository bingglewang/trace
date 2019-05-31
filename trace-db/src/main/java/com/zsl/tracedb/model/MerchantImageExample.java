package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantImageExample() {
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

        public Criteria andMerchantImageIdIsNull() {
            addCriterion("merchant_image_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdIsNotNull() {
            addCriterion("merchant_image_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdEqualTo(Integer value) {
            addCriterion("merchant_image_id =", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdNotEqualTo(Integer value) {
            addCriterion("merchant_image_id <>", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdGreaterThan(Integer value) {
            addCriterion("merchant_image_id >", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_image_id >=", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdLessThan(Integer value) {
            addCriterion("merchant_image_id <", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_image_id <=", value, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdIn(List<Integer> values) {
            addCriterion("merchant_image_id in", values, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdNotIn(List<Integer> values) {
            addCriterion("merchant_image_id not in", values, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdBetween(Integer value1, Integer value2) {
            addCriterion("merchant_image_id between", value1, value2, "merchantImageId");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_image_id not between", value1, value2, "merchantImageId");
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

        public Criteria andMerchantImageUrlIsNull() {
            addCriterion("merchant_image_url is null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlIsNotNull() {
            addCriterion("merchant_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlEqualTo(String value) {
            addCriterion("merchant_image_url =", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlNotEqualTo(String value) {
            addCriterion("merchant_image_url <>", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlGreaterThan(String value) {
            addCriterion("merchant_image_url >", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_image_url >=", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlLessThan(String value) {
            addCriterion("merchant_image_url <", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlLessThanOrEqualTo(String value) {
            addCriterion("merchant_image_url <=", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlLike(String value) {
            addCriterion("merchant_image_url like", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlNotLike(String value) {
            addCriterion("merchant_image_url not like", value, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlIn(List<String> values) {
            addCriterion("merchant_image_url in", values, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlNotIn(List<String> values) {
            addCriterion("merchant_image_url not in", values, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlBetween(String value1, String value2) {
            addCriterion("merchant_image_url between", value1, value2, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageUrlNotBetween(String value1, String value2) {
            addCriterion("merchant_image_url not between", value1, value2, "merchantImageUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexIsNull() {
            addCriterion("merchant_image_index is null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexIsNotNull() {
            addCriterion("merchant_image_index is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexEqualTo(Integer value) {
            addCriterion("merchant_image_index =", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexNotEqualTo(Integer value) {
            addCriterion("merchant_image_index <>", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexGreaterThan(Integer value) {
            addCriterion("merchant_image_index >", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_image_index >=", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexLessThan(Integer value) {
            addCriterion("merchant_image_index <", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_image_index <=", value, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexIn(List<Integer> values) {
            addCriterion("merchant_image_index in", values, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexNotIn(List<Integer> values) {
            addCriterion("merchant_image_index not in", values, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexBetween(Integer value1, Integer value2) {
            addCriterion("merchant_image_index between", value1, value2, "merchantImageIndex");
            return (Criteria) this;
        }

        public Criteria andMerchantImageIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_image_index not between", value1, value2, "merchantImageIndex");
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
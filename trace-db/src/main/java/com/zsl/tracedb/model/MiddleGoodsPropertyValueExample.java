package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class MiddleGoodsPropertyValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MiddleGoodsPropertyValueExample() {
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

        public Criteria andGoodsPropertyValueIdIsNull() {
            addCriterion("goods_property_value_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdIsNotNull() {
            addCriterion("goods_property_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdEqualTo(Integer value) {
            addCriterion("goods_property_value_id =", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdNotEqualTo(Integer value) {
            addCriterion("goods_property_value_id <>", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdGreaterThan(Integer value) {
            addCriterion("goods_property_value_id >", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_property_value_id >=", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdLessThan(Integer value) {
            addCriterion("goods_property_value_id <", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_property_value_id <=", value, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdIn(List<Integer> values) {
            addCriterion("goods_property_value_id in", values, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdNotIn(List<Integer> values) {
            addCriterion("goods_property_value_id not in", values, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_property_value_id between", value1, value2, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsPropertyValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_property_value_id not between", value1, value2, "goodsPropertyValueId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNull() {
            addCriterion("property_value_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNotNull() {
            addCriterion("property_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdEqualTo(Integer value) {
            addCriterion("property_value_id =", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotEqualTo(Integer value) {
            addCriterion("property_value_id <>", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThan(Integer value) {
            addCriterion("property_value_id >", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_value_id >=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThan(Integer value) {
            addCriterion("property_value_id <", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("property_value_id <=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIn(List<Integer> values) {
            addCriterion("property_value_id in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotIn(List<Integer> values) {
            addCriterion("property_value_id not in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id not between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andTextboxValueIsNull() {
            addCriterion("textbox_value is null");
            return (Criteria) this;
        }

        public Criteria andTextboxValueIsNotNull() {
            addCriterion("textbox_value is not null");
            return (Criteria) this;
        }

        public Criteria andTextboxValueEqualTo(String value) {
            addCriterion("textbox_value =", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueNotEqualTo(String value) {
            addCriterion("textbox_value <>", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueGreaterThan(String value) {
            addCriterion("textbox_value >", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueGreaterThanOrEqualTo(String value) {
            addCriterion("textbox_value >=", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueLessThan(String value) {
            addCriterion("textbox_value <", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueLessThanOrEqualTo(String value) {
            addCriterion("textbox_value <=", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueLike(String value) {
            addCriterion("textbox_value like", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueNotLike(String value) {
            addCriterion("textbox_value not like", value, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueIn(List<String> values) {
            addCriterion("textbox_value in", values, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueNotIn(List<String> values) {
            addCriterion("textbox_value not in", values, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueBetween(String value1, String value2) {
            addCriterion("textbox_value between", value1, value2, "textboxValue");
            return (Criteria) this;
        }

        public Criteria andTextboxValueNotBetween(String value1, String value2) {
            addCriterion("textbox_value not between", value1, value2, "textboxValue");
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
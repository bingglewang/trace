package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class PropertyValueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyValueExample() {
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

        public Criteria andCategoryPropertyIdIsNull() {
            addCriterion("category_property_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdIsNotNull() {
            addCriterion("category_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdEqualTo(Integer value) {
            addCriterion("category_property_id =", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdNotEqualTo(Integer value) {
            addCriterion("category_property_id <>", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdGreaterThan(Integer value) {
            addCriterion("category_property_id >", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_property_id >=", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdLessThan(Integer value) {
            addCriterion("category_property_id <", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_property_id <=", value, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdIn(List<Integer> values) {
            addCriterion("category_property_id in", values, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdNotIn(List<Integer> values) {
            addCriterion("category_property_id not in", values, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdBetween(Integer value1, Integer value2) {
            addCriterion("category_property_id between", value1, value2, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andCategoryPropertyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_property_id not between", value1, value2, "categoryPropertyId");
            return (Criteria) this;
        }

        public Criteria andComboboxValueIsNull() {
            addCriterion("combobox_value is null");
            return (Criteria) this;
        }

        public Criteria andComboboxValueIsNotNull() {
            addCriterion("combobox_value is not null");
            return (Criteria) this;
        }

        public Criteria andComboboxValueEqualTo(String value) {
            addCriterion("combobox_value =", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueNotEqualTo(String value) {
            addCriterion("combobox_value <>", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueGreaterThan(String value) {
            addCriterion("combobox_value >", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueGreaterThanOrEqualTo(String value) {
            addCriterion("combobox_value >=", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueLessThan(String value) {
            addCriterion("combobox_value <", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueLessThanOrEqualTo(String value) {
            addCriterion("combobox_value <=", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueLike(String value) {
            addCriterion("combobox_value like", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueNotLike(String value) {
            addCriterion("combobox_value not like", value, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueIn(List<String> values) {
            addCriterion("combobox_value in", values, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueNotIn(List<String> values) {
            addCriterion("combobox_value not in", values, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueBetween(String value1, String value2) {
            addCriterion("combobox_value between", value1, value2, "comboboxValue");
            return (Criteria) this;
        }

        public Criteria andComboboxValueNotBetween(String value1, String value2) {
            addCriterion("combobox_value not between", value1, value2, "comboboxValue");
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
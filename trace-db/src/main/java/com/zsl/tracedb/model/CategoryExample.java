package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdIsNull() {
            addCriterion("category_super_id is null");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdIsNotNull() {
            addCriterion("category_super_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdEqualTo(Integer value) {
            addCriterion("category_super_id =", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdNotEqualTo(Integer value) {
            addCriterion("category_super_id <>", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdGreaterThan(Integer value) {
            addCriterion("category_super_id >", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_super_id >=", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdLessThan(Integer value) {
            addCriterion("category_super_id <", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_super_id <=", value, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdIn(List<Integer> values) {
            addCriterion("category_super_id in", values, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdNotIn(List<Integer> values) {
            addCriterion("category_super_id not in", values, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdBetween(Integer value1, Integer value2) {
            addCriterion("category_super_id between", value1, value2, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategorySuperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_super_id not between", value1, value2, "categorySuperId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameIsNull() {
            addCriterion("category_full_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameIsNotNull() {
            addCriterion("category_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameEqualTo(String value) {
            addCriterion("category_full_name =", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameNotEqualTo(String value) {
            addCriterion("category_full_name <>", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameGreaterThan(String value) {
            addCriterion("category_full_name >", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_full_name >=", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameLessThan(String value) {
            addCriterion("category_full_name <", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameLessThanOrEqualTo(String value) {
            addCriterion("category_full_name <=", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameLike(String value) {
            addCriterion("category_full_name like", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameNotLike(String value) {
            addCriterion("category_full_name not like", value, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameIn(List<String> values) {
            addCriterion("category_full_name in", values, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameNotIn(List<String> values) {
            addCriterion("category_full_name not in", values, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameBetween(String value1, String value2) {
            addCriterion("category_full_name between", value1, value2, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryFullNameNotBetween(String value1, String value2) {
            addCriterion("category_full_name not between", value1, value2, "categoryFullName");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIsNull() {
            addCriterion("category_level is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIsNotNull() {
            addCriterion("category_level is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelEqualTo(Integer value) {
            addCriterion("category_level =", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotEqualTo(Integer value) {
            addCriterion("category_level <>", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelGreaterThan(Integer value) {
            addCriterion("category_level >", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_level >=", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelLessThan(Integer value) {
            addCriterion("category_level <", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelLessThanOrEqualTo(Integer value) {
            addCriterion("category_level <=", value, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelIn(List<Integer> values) {
            addCriterion("category_level in", values, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotIn(List<Integer> values) {
            addCriterion("category_level not in", values, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelBetween(Integer value1, Integer value2) {
            addCriterion("category_level between", value1, value2, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andCategoryLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("category_level not between", value1, value2, "categoryLevel");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandIsNull() {
            addCriterion("include_brand is null");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandIsNotNull() {
            addCriterion("include_brand is not null");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandEqualTo(Byte value) {
            addCriterion("include_brand =", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandNotEqualTo(Byte value) {
            addCriterion("include_brand <>", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandGreaterThan(Byte value) {
            addCriterion("include_brand >", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandGreaterThanOrEqualTo(Byte value) {
            addCriterion("include_brand >=", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandLessThan(Byte value) {
            addCriterion("include_brand <", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandLessThanOrEqualTo(Byte value) {
            addCriterion("include_brand <=", value, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandIn(List<Byte> values) {
            addCriterion("include_brand in", values, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandNotIn(List<Byte> values) {
            addCriterion("include_brand not in", values, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandBetween(Byte value1, Byte value2) {
            addCriterion("include_brand between", value1, value2, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andIncludeBrandNotBetween(Byte value1, Byte value2) {
            addCriterion("include_brand not between", value1, value2, "includeBrand");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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
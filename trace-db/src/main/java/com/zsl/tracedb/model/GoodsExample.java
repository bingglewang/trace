package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
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

        public Criteria andGoodsCreatTimeIsNull() {
            addCriterion("goods_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeIsNotNull() {
            addCriterion("goods_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeEqualTo(Date value) {
            addCriterion("goods_creat_time =", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeNotEqualTo(Date value) {
            addCriterion("goods_creat_time <>", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeGreaterThan(Date value) {
            addCriterion("goods_creat_time >", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_creat_time >=", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeLessThan(Date value) {
            addCriterion("goods_creat_time <", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_creat_time <=", value, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeIn(List<Date> values) {
            addCriterion("goods_creat_time in", values, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeNotIn(List<Date> values) {
            addCriterion("goods_creat_time not in", values, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeBetween(Date value1, Date value2) {
            addCriterion("goods_creat_time between", value1, value2, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_creat_time not between", value1, value2, "goodsCreatTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeIsNull() {
            addCriterion("goods_update_time is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeIsNotNull() {
            addCriterion("goods_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeEqualTo(Date value) {
            addCriterion("goods_update_time =", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeNotEqualTo(Date value) {
            addCriterion("goods_update_time <>", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeGreaterThan(Date value) {
            addCriterion("goods_update_time >", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("goods_update_time >=", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeLessThan(Date value) {
            addCriterion("goods_update_time <", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("goods_update_time <=", value, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeIn(List<Date> values) {
            addCriterion("goods_update_time in", values, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeNotIn(List<Date> values) {
            addCriterion("goods_update_time not in", values, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("goods_update_time between", value1, value2, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andGoodsUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("goods_update_time not between", value1, value2, "goodsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
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
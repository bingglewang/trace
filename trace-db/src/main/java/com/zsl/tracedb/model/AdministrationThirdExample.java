package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class AdministrationThirdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdministrationThirdExample() {
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

        public Criteria andThirdAdministrationIdIsNull() {
            addCriterion("third_administration_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdIsNotNull() {
            addCriterion("third_administration_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdEqualTo(Integer value) {
            addCriterion("third_administration_id =", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdNotEqualTo(Integer value) {
            addCriterion("third_administration_id <>", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdGreaterThan(Integer value) {
            addCriterion("third_administration_id >", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("third_administration_id >=", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdLessThan(Integer value) {
            addCriterion("third_administration_id <", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("third_administration_id <=", value, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdIn(List<Integer> values) {
            addCriterion("third_administration_id in", values, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdNotIn(List<Integer> values) {
            addCriterion("third_administration_id not in", values, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdBetween(Integer value1, Integer value2) {
            addCriterion("third_administration_id between", value1, value2, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("third_administration_id not between", value1, value2, "thirdAdministrationId");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameIsNull() {
            addCriterion("third_administration_name is null");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameIsNotNull() {
            addCriterion("third_administration_name is not null");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameEqualTo(String value) {
            addCriterion("third_administration_name =", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameNotEqualTo(String value) {
            addCriterion("third_administration_name <>", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameGreaterThan(String value) {
            addCriterion("third_administration_name >", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameGreaterThanOrEqualTo(String value) {
            addCriterion("third_administration_name >=", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameLessThan(String value) {
            addCriterion("third_administration_name <", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameLessThanOrEqualTo(String value) {
            addCriterion("third_administration_name <=", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameLike(String value) {
            addCriterion("third_administration_name like", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameNotLike(String value) {
            addCriterion("third_administration_name not like", value, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameIn(List<String> values) {
            addCriterion("third_administration_name in", values, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameNotIn(List<String> values) {
            addCriterion("third_administration_name not in", values, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameBetween(String value1, String value2) {
            addCriterion("third_administration_name between", value1, value2, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andThirdAdministrationNameNotBetween(String value1, String value2) {
            addCriterion("third_administration_name not between", value1, value2, "thirdAdministrationName");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdIsNull() {
            addCriterion("first_administration_id is null");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdIsNotNull() {
            addCriterion("first_administration_id is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdEqualTo(Integer value) {
            addCriterion("first_administration_id =", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdNotEqualTo(Integer value) {
            addCriterion("first_administration_id <>", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdGreaterThan(Integer value) {
            addCriterion("first_administration_id >", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("first_administration_id >=", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdLessThan(Integer value) {
            addCriterion("first_administration_id <", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("first_administration_id <=", value, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdIn(List<Integer> values) {
            addCriterion("first_administration_id in", values, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdNotIn(List<Integer> values) {
            addCriterion("first_administration_id not in", values, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdBetween(Integer value1, Integer value2) {
            addCriterion("first_administration_id between", value1, value2, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFirstAdministrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("first_administration_id not between", value1, value2, "firstAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdIsNull() {
            addCriterion("second_administration_id is null");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdIsNotNull() {
            addCriterion("second_administration_id is not null");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdEqualTo(Integer value) {
            addCriterion("second_administration_id =", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdNotEqualTo(Integer value) {
            addCriterion("second_administration_id <>", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdGreaterThan(Integer value) {
            addCriterion("second_administration_id >", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_administration_id >=", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdLessThan(Integer value) {
            addCriterion("second_administration_id <", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("second_administration_id <=", value, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdIn(List<Integer> values) {
            addCriterion("second_administration_id in", values, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdNotIn(List<Integer> values) {
            addCriterion("second_administration_id not in", values, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdBetween(Integer value1, Integer value2) {
            addCriterion("second_administration_id between", value1, value2, "secondAdministrationId");
            return (Criteria) this;
        }

        public Criteria andSecondAdministrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("second_administration_id not between", value1, value2, "secondAdministrationId");
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
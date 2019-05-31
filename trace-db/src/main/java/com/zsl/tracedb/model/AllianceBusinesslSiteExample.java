package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class AllianceBusinesslSiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllianceBusinesslSiteExample() {
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

        public Criteria andAllianceBusinesslSiteIdIsNull() {
            addCriterion("alliance_businessl_site_id is null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdIsNotNull() {
            addCriterion("alliance_businessl_site_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdEqualTo(Integer value) {
            addCriterion("alliance_businessl_site_id =", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdNotEqualTo(Integer value) {
            addCriterion("alliance_businessl_site_id <>", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdGreaterThan(Integer value) {
            addCriterion("alliance_businessl_site_id >", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alliance_businessl_site_id >=", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdLessThan(Integer value) {
            addCriterion("alliance_businessl_site_id <", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("alliance_businessl_site_id <=", value, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdIn(List<Integer> values) {
            addCriterion("alliance_businessl_site_id in", values, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdNotIn(List<Integer> values) {
            addCriterion("alliance_businessl_site_id not in", values, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("alliance_businessl_site_id between", value1, value2, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinesslSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alliance_businessl_site_id not between", value1, value2, "allianceBusinesslSiteId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdIsNull() {
            addCriterion("alliance_business_id is null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdIsNotNull() {
            addCriterion("alliance_business_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdEqualTo(Integer value) {
            addCriterion("alliance_business_id =", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdNotEqualTo(Integer value) {
            addCriterion("alliance_business_id <>", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdGreaterThan(Integer value) {
            addCriterion("alliance_business_id >", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alliance_business_id >=", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdLessThan(Integer value) {
            addCriterion("alliance_business_id <", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("alliance_business_id <=", value, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdIn(List<Integer> values) {
            addCriterion("alliance_business_id in", values, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdNotIn(List<Integer> values) {
            addCriterion("alliance_business_id not in", values, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("alliance_business_id between", value1, value2, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alliance_business_id not between", value1, value2, "allianceBusinessId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdIsNull() {
            addCriterion("administration_id is null");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdIsNotNull() {
            addCriterion("administration_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdEqualTo(Integer value) {
            addCriterion("administration_id =", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdNotEqualTo(Integer value) {
            addCriterion("administration_id <>", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdGreaterThan(Integer value) {
            addCriterion("administration_id >", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("administration_id >=", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdLessThan(Integer value) {
            addCriterion("administration_id <", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("administration_id <=", value, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdIn(List<Integer> values) {
            addCriterion("administration_id in", values, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdNotIn(List<Integer> values) {
            addCriterion("administration_id not in", values, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdBetween(Integer value1, Integer value2) {
            addCriterion("administration_id between", value1, value2, "administrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("administration_id not between", value1, value2, "administrationId");
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
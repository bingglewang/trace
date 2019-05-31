package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllianceBusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllianceBusinessExample() {
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

        public Criteria andAllianceBusinessNameIsNull() {
            addCriterion("alliance_business_name is null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameIsNotNull() {
            addCriterion("alliance_business_name is not null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameEqualTo(String value) {
            addCriterion("alliance_business_name =", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameNotEqualTo(String value) {
            addCriterion("alliance_business_name <>", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameGreaterThan(String value) {
            addCriterion("alliance_business_name >", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameGreaterThanOrEqualTo(String value) {
            addCriterion("alliance_business_name >=", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameLessThan(String value) {
            addCriterion("alliance_business_name <", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameLessThanOrEqualTo(String value) {
            addCriterion("alliance_business_name <=", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameLike(String value) {
            addCriterion("alliance_business_name like", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameNotLike(String value) {
            addCriterion("alliance_business_name not like", value, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameIn(List<String> values) {
            addCriterion("alliance_business_name in", values, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameNotIn(List<String> values) {
            addCriterion("alliance_business_name not in", values, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameBetween(String value1, String value2) {
            addCriterion("alliance_business_name between", value1, value2, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessNameNotBetween(String value1, String value2) {
            addCriterion("alliance_business_name not between", value1, value2, "allianceBusinessName");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIsNull() {
            addCriterion("business_license_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIsNotNull() {
            addCriterion("business_license_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlEqualTo(String value) {
            addCriterion("business_license_url =", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotEqualTo(String value) {
            addCriterion("business_license_url <>", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThan(String value) {
            addCriterion("business_license_url >", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_url >=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThan(String value) {
            addCriterion("business_license_url <", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("business_license_url <=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLike(String value) {
            addCriterion("business_license_url like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotLike(String value) {
            addCriterion("business_license_url not like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIn(List<String> values) {
            addCriterion("business_license_url in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotIn(List<String> values) {
            addCriterion("business_license_url not in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlBetween(String value1, String value2) {
            addCriterion("business_license_url between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("business_license_url not between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionIsNull() {
            addCriterion("company_description is null");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionIsNotNull() {
            addCriterion("company_description is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionEqualTo(String value) {
            addCriterion("company_description =", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionNotEqualTo(String value) {
            addCriterion("company_description <>", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionGreaterThan(String value) {
            addCriterion("company_description >", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("company_description >=", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionLessThan(String value) {
            addCriterion("company_description <", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionLessThanOrEqualTo(String value) {
            addCriterion("company_description <=", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionLike(String value) {
            addCriterion("company_description like", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionNotLike(String value) {
            addCriterion("company_description not like", value, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionIn(List<String> values) {
            addCriterion("company_description in", values, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionNotIn(List<String> values) {
            addCriterion("company_description not in", values, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionBetween(String value1, String value2) {
            addCriterion("company_description between", value1, value2, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andCompanyDescriptionNotBetween(String value1, String value2) {
            addCriterion("company_description not between", value1, value2, "companyDescription");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeIsNull() {
            addCriterion("alliance_business_enter_time is null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeIsNotNull() {
            addCriterion("alliance_business_enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeEqualTo(Date value) {
            addCriterion("alliance_business_enter_time =", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeNotEqualTo(Date value) {
            addCriterion("alliance_business_enter_time <>", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeGreaterThan(Date value) {
            addCriterion("alliance_business_enter_time >", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alliance_business_enter_time >=", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeLessThan(Date value) {
            addCriterion("alliance_business_enter_time <", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeLessThanOrEqualTo(Date value) {
            addCriterion("alliance_business_enter_time <=", value, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeIn(List<Date> values) {
            addCriterion("alliance_business_enter_time in", values, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeNotIn(List<Date> values) {
            addCriterion("alliance_business_enter_time not in", values, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeBetween(Date value1, Date value2) {
            addCriterion("alliance_business_enter_time between", value1, value2, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessEnterTimeNotBetween(Date value1, Date value2) {
            addCriterion("alliance_business_enter_time not between", value1, value2, "allianceBusinessEnterTime");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusIsNull() {
            addCriterion("alliance_business_status is null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusIsNotNull() {
            addCriterion("alliance_business_status is not null");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusEqualTo(Byte value) {
            addCriterion("alliance_business_status =", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusNotEqualTo(Byte value) {
            addCriterion("alliance_business_status <>", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusGreaterThan(Byte value) {
            addCriterion("alliance_business_status >", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("alliance_business_status >=", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusLessThan(Byte value) {
            addCriterion("alliance_business_status <", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusLessThanOrEqualTo(Byte value) {
            addCriterion("alliance_business_status <=", value, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusIn(List<Byte> values) {
            addCriterion("alliance_business_status in", values, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusNotIn(List<Byte> values) {
            addCriterion("alliance_business_status not in", values, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusBetween(Byte value1, Byte value2) {
            addCriterion("alliance_business_status between", value1, value2, "allianceBusinessStatus");
            return (Criteria) this;
        }

        public Criteria andAllianceBusinessStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("alliance_business_status not between", value1, value2, "allianceBusinessStatus");
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
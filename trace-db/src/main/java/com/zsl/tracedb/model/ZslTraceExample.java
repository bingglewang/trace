package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslTraceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslTraceExample() {
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

        public Criteria andTraceIdIsNull() {
            addCriterion("trace_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceIdIsNotNull() {
            addCriterion("trace_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceIdEqualTo(Integer value) {
            addCriterion("trace_id =", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotEqualTo(Integer value) {
            addCriterion("trace_id <>", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdGreaterThan(Integer value) {
            addCriterion("trace_id >", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_id >=", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdLessThan(Integer value) {
            addCriterion("trace_id <", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_id <=", value, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdIn(List<Integer> values) {
            addCriterion("trace_id in", values, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotIn(List<Integer> values) {
            addCriterion("trace_id not in", values, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_id between", value1, value2, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_id not between", value1, value2, "traceId");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIsNull() {
            addCriterion("trace_code_number is null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIsNotNull() {
            addCriterion("trace_code_number is not null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberEqualTo(String value) {
            addCriterion("trace_code_number =", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotEqualTo(String value) {
            addCriterion("trace_code_number <>", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberGreaterThan(String value) {
            addCriterion("trace_code_number >", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("trace_code_number >=", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLessThan(String value) {
            addCriterion("trace_code_number <", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLessThanOrEqualTo(String value) {
            addCriterion("trace_code_number <=", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberLike(String value) {
            addCriterion("trace_code_number like", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotLike(String value) {
            addCriterion("trace_code_number not like", value, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberIn(List<String> values) {
            addCriterion("trace_code_number in", values, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotIn(List<String> values) {
            addCriterion("trace_code_number not in", values, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberBetween(String value1, String value2) {
            addCriterion("trace_code_number between", value1, value2, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNumberNotBetween(String value1, String value2) {
            addCriterion("trace_code_number not between", value1, value2, "traceCodeNumber");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdIsNull() {
            addCriterion("trace_business_id is null");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdIsNotNull() {
            addCriterion("trace_business_id is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdEqualTo(Integer value) {
            addCriterion("trace_business_id =", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdNotEqualTo(Integer value) {
            addCriterion("trace_business_id <>", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdGreaterThan(Integer value) {
            addCriterion("trace_business_id >", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_business_id >=", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdLessThan(Integer value) {
            addCriterion("trace_business_id <", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("trace_business_id <=", value, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdIn(List<Integer> values) {
            addCriterion("trace_business_id in", values, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdNotIn(List<Integer> values) {
            addCriterion("trace_business_id not in", values, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("trace_business_id between", value1, value2, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_business_id not between", value1, value2, "traceBusinessId");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeIsNull() {
            addCriterion("trace_apply_type is null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeIsNotNull() {
            addCriterion("trace_apply_type is not null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeEqualTo(Integer value) {
            addCriterion("trace_apply_type =", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeNotEqualTo(Integer value) {
            addCriterion("trace_apply_type <>", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeGreaterThan(Integer value) {
            addCriterion("trace_apply_type >", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_apply_type >=", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeLessThan(Integer value) {
            addCriterion("trace_apply_type <", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trace_apply_type <=", value, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeIn(List<Integer> values) {
            addCriterion("trace_apply_type in", values, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeNotIn(List<Integer> values) {
            addCriterion("trace_apply_type not in", values, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeBetween(Integer value1, Integer value2) {
            addCriterion("trace_apply_type between", value1, value2, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceApplyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_apply_type not between", value1, value2, "traceApplyType");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusIsNull() {
            addCriterion("trace_handle_status is null");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusIsNotNull() {
            addCriterion("trace_handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusEqualTo(Integer value) {
            addCriterion("trace_handle_status =", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusNotEqualTo(Integer value) {
            addCriterion("trace_handle_status <>", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusGreaterThan(Integer value) {
            addCriterion("trace_handle_status >", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_handle_status >=", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusLessThan(Integer value) {
            addCriterion("trace_handle_status <", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusLessThanOrEqualTo(Integer value) {
            addCriterion("trace_handle_status <=", value, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusIn(List<Integer> values) {
            addCriterion("trace_handle_status in", values, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusNotIn(List<Integer> values) {
            addCriterion("trace_handle_status not in", values, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusBetween(Integer value1, Integer value2) {
            addCriterion("trace_handle_status between", value1, value2, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceHandleStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_handle_status not between", value1, value2, "traceHandleStatus");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameIsNull() {
            addCriterion("trace_company_name is null");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameIsNotNull() {
            addCriterion("trace_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameEqualTo(String value) {
            addCriterion("trace_company_name =", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameNotEqualTo(String value) {
            addCriterion("trace_company_name <>", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameGreaterThan(String value) {
            addCriterion("trace_company_name >", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("trace_company_name >=", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameLessThan(String value) {
            addCriterion("trace_company_name <", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("trace_company_name <=", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameLike(String value) {
            addCriterion("trace_company_name like", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameNotLike(String value) {
            addCriterion("trace_company_name not like", value, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameIn(List<String> values) {
            addCriterion("trace_company_name in", values, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameNotIn(List<String> values) {
            addCriterion("trace_company_name not in", values, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameBetween(String value1, String value2) {
            addCriterion("trace_company_name between", value1, value2, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceCompanyNameNotBetween(String value1, String value2) {
            addCriterion("trace_company_name not between", value1, value2, "traceCompanyName");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateIsNull() {
            addCriterion("trace_apply_date is null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateIsNotNull() {
            addCriterion("trace_apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateEqualTo(Date value) {
            addCriterion("trace_apply_date =", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateNotEqualTo(Date value) {
            addCriterion("trace_apply_date <>", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateGreaterThan(Date value) {
            addCriterion("trace_apply_date >", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("trace_apply_date >=", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateLessThan(Date value) {
            addCriterion("trace_apply_date <", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("trace_apply_date <=", value, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateIn(List<Date> values) {
            addCriterion("trace_apply_date in", values, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateNotIn(List<Date> values) {
            addCriterion("trace_apply_date not in", values, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateBetween(Date value1, Date value2) {
            addCriterion("trace_apply_date between", value1, value2, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("trace_apply_date not between", value1, value2, "traceApplyDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateIsNull() {
            addCriterion("trace_review_date is null");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateIsNotNull() {
            addCriterion("trace_review_date is not null");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateEqualTo(Date value) {
            addCriterion("trace_review_date =", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateNotEqualTo(Date value) {
            addCriterion("trace_review_date <>", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateGreaterThan(Date value) {
            addCriterion("trace_review_date >", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateGreaterThanOrEqualTo(Date value) {
            addCriterion("trace_review_date >=", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateLessThan(Date value) {
            addCriterion("trace_review_date <", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateLessThanOrEqualTo(Date value) {
            addCriterion("trace_review_date <=", value, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateIn(List<Date> values) {
            addCriterion("trace_review_date in", values, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateNotIn(List<Date> values) {
            addCriterion("trace_review_date not in", values, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateBetween(Date value1, Date value2) {
            addCriterion("trace_review_date between", value1, value2, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceReviewDateNotBetween(Date value1, Date value2) {
            addCriterion("trace_review_date not between", value1, value2, "traceReviewDate");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountIsNull() {
            addCriterion("trace_apply_count is null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountIsNotNull() {
            addCriterion("trace_apply_count is not null");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountEqualTo(Long value) {
            addCriterion("trace_apply_count =", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountNotEqualTo(Long value) {
            addCriterion("trace_apply_count <>", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountGreaterThan(Long value) {
            addCriterion("trace_apply_count >", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_apply_count >=", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountLessThan(Long value) {
            addCriterion("trace_apply_count <", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountLessThanOrEqualTo(Long value) {
            addCriterion("trace_apply_count <=", value, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountIn(List<Long> values) {
            addCriterion("trace_apply_count in", values, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountNotIn(List<Long> values) {
            addCriterion("trace_apply_count not in", values, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountBetween(Long value1, Long value2) {
            addCriterion("trace_apply_count between", value1, value2, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceApplyCountNotBetween(Long value1, Long value2) {
            addCriterion("trace_apply_count not between", value1, value2, "traceApplyCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountIsNull() {
            addCriterion("trace_enable_count is null");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountIsNotNull() {
            addCriterion("trace_enable_count is not null");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountEqualTo(Integer value) {
            addCriterion("trace_enable_count =", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountNotEqualTo(Integer value) {
            addCriterion("trace_enable_count <>", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountGreaterThan(Integer value) {
            addCriterion("trace_enable_count >", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_enable_count >=", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountLessThan(Integer value) {
            addCriterion("trace_enable_count <", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountLessThanOrEqualTo(Integer value) {
            addCriterion("trace_enable_count <=", value, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountIn(List<Integer> values) {
            addCriterion("trace_enable_count in", values, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountNotIn(List<Integer> values) {
            addCriterion("trace_enable_count not in", values, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountBetween(Integer value1, Integer value2) {
            addCriterion("trace_enable_count between", value1, value2, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceEnableCountNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_enable_count not between", value1, value2, "traceEnableCount");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkIsNull() {
            addCriterion("trace_refuse_remark is null");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkIsNotNull() {
            addCriterion("trace_refuse_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkEqualTo(String value) {
            addCriterion("trace_refuse_remark =", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkNotEqualTo(String value) {
            addCriterion("trace_refuse_remark <>", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkGreaterThan(String value) {
            addCriterion("trace_refuse_remark >", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("trace_refuse_remark >=", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkLessThan(String value) {
            addCriterion("trace_refuse_remark <", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkLessThanOrEqualTo(String value) {
            addCriterion("trace_refuse_remark <=", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkLike(String value) {
            addCriterion("trace_refuse_remark like", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkNotLike(String value) {
            addCriterion("trace_refuse_remark not like", value, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkIn(List<String> values) {
            addCriterion("trace_refuse_remark in", values, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkNotIn(List<String> values) {
            addCriterion("trace_refuse_remark not in", values, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkBetween(String value1, String value2) {
            addCriterion("trace_refuse_remark between", value1, value2, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceRefuseRemarkNotBetween(String value1, String value2) {
            addCriterion("trace_refuse_remark not between", value1, value2, "traceRefuseRemark");
            return (Criteria) this;
        }

        public Criteria andTraceBack1IsNull() {
            addCriterion("trace_back1 is null");
            return (Criteria) this;
        }

        public Criteria andTraceBack1IsNotNull() {
            addCriterion("trace_back1 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBack1EqualTo(Integer value) {
            addCriterion("trace_back1 =", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1NotEqualTo(Integer value) {
            addCriterion("trace_back1 <>", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1GreaterThan(Integer value) {
            addCriterion("trace_back1 >", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1GreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_back1 >=", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1LessThan(Integer value) {
            addCriterion("trace_back1 <", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1LessThanOrEqualTo(Integer value) {
            addCriterion("trace_back1 <=", value, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1In(List<Integer> values) {
            addCriterion("trace_back1 in", values, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1NotIn(List<Integer> values) {
            addCriterion("trace_back1 not in", values, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1Between(Integer value1, Integer value2) {
            addCriterion("trace_back1 between", value1, value2, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack1NotBetween(Integer value1, Integer value2) {
            addCriterion("trace_back1 not between", value1, value2, "traceBack1");
            return (Criteria) this;
        }

        public Criteria andTraceBack2IsNull() {
            addCriterion("trace_back2 is null");
            return (Criteria) this;
        }

        public Criteria andTraceBack2IsNotNull() {
            addCriterion("trace_back2 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBack2EqualTo(Integer value) {
            addCriterion("trace_back2 =", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2NotEqualTo(Integer value) {
            addCriterion("trace_back2 <>", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2GreaterThan(Integer value) {
            addCriterion("trace_back2 >", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2GreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_back2 >=", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2LessThan(Integer value) {
            addCriterion("trace_back2 <", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2LessThanOrEqualTo(Integer value) {
            addCriterion("trace_back2 <=", value, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2In(List<Integer> values) {
            addCriterion("trace_back2 in", values, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2NotIn(List<Integer> values) {
            addCriterion("trace_back2 not in", values, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2Between(Integer value1, Integer value2) {
            addCriterion("trace_back2 between", value1, value2, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack2NotBetween(Integer value1, Integer value2) {
            addCriterion("trace_back2 not between", value1, value2, "traceBack2");
            return (Criteria) this;
        }

        public Criteria andTraceBack3IsNull() {
            addCriterion("trace_back3 is null");
            return (Criteria) this;
        }

        public Criteria andTraceBack3IsNotNull() {
            addCriterion("trace_back3 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBack3EqualTo(String value) {
            addCriterion("trace_back3 =", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3NotEqualTo(String value) {
            addCriterion("trace_back3 <>", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3GreaterThan(String value) {
            addCriterion("trace_back3 >", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3GreaterThanOrEqualTo(String value) {
            addCriterion("trace_back3 >=", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3LessThan(String value) {
            addCriterion("trace_back3 <", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3LessThanOrEqualTo(String value) {
            addCriterion("trace_back3 <=", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3Like(String value) {
            addCriterion("trace_back3 like", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3NotLike(String value) {
            addCriterion("trace_back3 not like", value, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3In(List<String> values) {
            addCriterion("trace_back3 in", values, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3NotIn(List<String> values) {
            addCriterion("trace_back3 not in", values, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3Between(String value1, String value2) {
            addCriterion("trace_back3 between", value1, value2, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack3NotBetween(String value1, String value2) {
            addCriterion("trace_back3 not between", value1, value2, "traceBack3");
            return (Criteria) this;
        }

        public Criteria andTraceBack4IsNull() {
            addCriterion("trace_back4 is null");
            return (Criteria) this;
        }

        public Criteria andTraceBack4IsNotNull() {
            addCriterion("trace_back4 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBack4EqualTo(String value) {
            addCriterion("trace_back4 =", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4NotEqualTo(String value) {
            addCriterion("trace_back4 <>", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4GreaterThan(String value) {
            addCriterion("trace_back4 >", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4GreaterThanOrEqualTo(String value) {
            addCriterion("trace_back4 >=", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4LessThan(String value) {
            addCriterion("trace_back4 <", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4LessThanOrEqualTo(String value) {
            addCriterion("trace_back4 <=", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4Like(String value) {
            addCriterion("trace_back4 like", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4NotLike(String value) {
            addCriterion("trace_back4 not like", value, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4In(List<String> values) {
            addCriterion("trace_back4 in", values, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4NotIn(List<String> values) {
            addCriterion("trace_back4 not in", values, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4Between(String value1, String value2) {
            addCriterion("trace_back4 between", value1, value2, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack4NotBetween(String value1, String value2) {
            addCriterion("trace_back4 not between", value1, value2, "traceBack4");
            return (Criteria) this;
        }

        public Criteria andTraceBack5IsNull() {
            addCriterion("trace_back5 is null");
            return (Criteria) this;
        }

        public Criteria andTraceBack5IsNotNull() {
            addCriterion("trace_back5 is not null");
            return (Criteria) this;
        }

        public Criteria andTraceBack5EqualTo(String value) {
            addCriterion("trace_back5 =", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5NotEqualTo(String value) {
            addCriterion("trace_back5 <>", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5GreaterThan(String value) {
            addCriterion("trace_back5 >", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5GreaterThanOrEqualTo(String value) {
            addCriterion("trace_back5 >=", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5LessThan(String value) {
            addCriterion("trace_back5 <", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5LessThanOrEqualTo(String value) {
            addCriterion("trace_back5 <=", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5Like(String value) {
            addCriterion("trace_back5 like", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5NotLike(String value) {
            addCriterion("trace_back5 not like", value, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5In(List<String> values) {
            addCriterion("trace_back5 in", values, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5NotIn(List<String> values) {
            addCriterion("trace_back5 not in", values, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5Between(String value1, String value2) {
            addCriterion("trace_back5 between", value1, value2, "traceBack5");
            return (Criteria) this;
        }

        public Criteria andTraceBack5NotBetween(String value1, String value2) {
            addCriterion("trace_back5 not between", value1, value2, "traceBack5");
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
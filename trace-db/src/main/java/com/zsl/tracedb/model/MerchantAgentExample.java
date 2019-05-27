package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantAgentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantAgentExample() {
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

        public Criteria andMerchantAgentIdIsNull() {
            addCriterion("merchant_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdIsNotNull() {
            addCriterion("merchant_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdEqualTo(Integer value) {
            addCriterion("merchant_agent_id =", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdNotEqualTo(Integer value) {
            addCriterion("merchant_agent_id <>", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdGreaterThan(Integer value) {
            addCriterion("merchant_agent_id >", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_agent_id >=", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdLessThan(Integer value) {
            addCriterion("merchant_agent_id <", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_agent_id <=", value, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdIn(List<Integer> values) {
            addCriterion("merchant_agent_id in", values, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdNotIn(List<Integer> values) {
            addCriterion("merchant_agent_id not in", values, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("merchant_agent_id between", value1, value2, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andMerchantAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_agent_id not between", value1, value2, "merchantAgentId");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameIsNull() {
            addCriterion("agent_another_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameIsNotNull() {
            addCriterion("agent_another_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameEqualTo(String value) {
            addCriterion("agent_another_name =", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameNotEqualTo(String value) {
            addCriterion("agent_another_name <>", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameGreaterThan(String value) {
            addCriterion("agent_another_name >", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_another_name >=", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameLessThan(String value) {
            addCriterion("agent_another_name <", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameLessThanOrEqualTo(String value) {
            addCriterion("agent_another_name <=", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameLike(String value) {
            addCriterion("agent_another_name like", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameNotLike(String value) {
            addCriterion("agent_another_name not like", value, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameIn(List<String> values) {
            addCriterion("agent_another_name in", values, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameNotIn(List<String> values) {
            addCriterion("agent_another_name not in", values, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameBetween(String value1, String value2) {
            addCriterion("agent_another_name between", value1, value2, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentAnotherNameNotBetween(String value1, String value2) {
            addCriterion("agent_another_name not between", value1, value2, "agentAnotherName");
            return (Criteria) this;
        }

        public Criteria andAgentContactIsNull() {
            addCriterion("agent_contact is null");
            return (Criteria) this;
        }

        public Criteria andAgentContactIsNotNull() {
            addCriterion("agent_contact is not null");
            return (Criteria) this;
        }

        public Criteria andAgentContactEqualTo(String value) {
            addCriterion("agent_contact =", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactNotEqualTo(String value) {
            addCriterion("agent_contact <>", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactGreaterThan(String value) {
            addCriterion("agent_contact >", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactGreaterThanOrEqualTo(String value) {
            addCriterion("agent_contact >=", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactLessThan(String value) {
            addCriterion("agent_contact <", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactLessThanOrEqualTo(String value) {
            addCriterion("agent_contact <=", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactLike(String value) {
            addCriterion("agent_contact like", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactNotLike(String value) {
            addCriterion("agent_contact not like", value, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactIn(List<String> values) {
            addCriterion("agent_contact in", values, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactNotIn(List<String> values) {
            addCriterion("agent_contact not in", values, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactBetween(String value1, String value2) {
            addCriterion("agent_contact between", value1, value2, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentContactNotBetween(String value1, String value2) {
            addCriterion("agent_contact not between", value1, value2, "agentContact");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberIsNull() {
            addCriterion("agent_cpntact_number is null");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberIsNotNull() {
            addCriterion("agent_cpntact_number is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberEqualTo(String value) {
            addCriterion("agent_cpntact_number =", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberNotEqualTo(String value) {
            addCriterion("agent_cpntact_number <>", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberGreaterThan(String value) {
            addCriterion("agent_cpntact_number >", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("agent_cpntact_number >=", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberLessThan(String value) {
            addCriterion("agent_cpntact_number <", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberLessThanOrEqualTo(String value) {
            addCriterion("agent_cpntact_number <=", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberLike(String value) {
            addCriterion("agent_cpntact_number like", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberNotLike(String value) {
            addCriterion("agent_cpntact_number not like", value, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberIn(List<String> values) {
            addCriterion("agent_cpntact_number in", values, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberNotIn(List<String> values) {
            addCriterion("agent_cpntact_number not in", values, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberBetween(String value1, String value2) {
            addCriterion("agent_cpntact_number between", value1, value2, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andAgentCpntactNumberNotBetween(String value1, String value2) {
            addCriterion("agent_cpntact_number not between", value1, value2, "agentCpntactNumber");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdIsNull() {
            addCriterion("fourth_administration_id is null");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdIsNotNull() {
            addCriterion("fourth_administration_id is not null");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdEqualTo(Integer value) {
            addCriterion("fourth_administration_id =", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdNotEqualTo(Integer value) {
            addCriterion("fourth_administration_id <>", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdGreaterThan(Integer value) {
            addCriterion("fourth_administration_id >", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fourth_administration_id >=", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdLessThan(Integer value) {
            addCriterion("fourth_administration_id <", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("fourth_administration_id <=", value, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdIn(List<Integer> values) {
            addCriterion("fourth_administration_id in", values, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdNotIn(List<Integer> values) {
            addCriterion("fourth_administration_id not in", values, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdBetween(Integer value1, Integer value2) {
            addCriterion("fourth_administration_id between", value1, value2, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andFourthAdministrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fourth_administration_id not between", value1, value2, "fourthAdministrationId");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteIsNull() {
            addCriterion("agent_detail_site is null");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteIsNotNull() {
            addCriterion("agent_detail_site is not null");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteEqualTo(String value) {
            addCriterion("agent_detail_site =", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteNotEqualTo(String value) {
            addCriterion("agent_detail_site <>", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteGreaterThan(String value) {
            addCriterion("agent_detail_site >", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteGreaterThanOrEqualTo(String value) {
            addCriterion("agent_detail_site >=", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteLessThan(String value) {
            addCriterion("agent_detail_site <", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteLessThanOrEqualTo(String value) {
            addCriterion("agent_detail_site <=", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteLike(String value) {
            addCriterion("agent_detail_site like", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteNotLike(String value) {
            addCriterion("agent_detail_site not like", value, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteIn(List<String> values) {
            addCriterion("agent_detail_site in", values, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteNotIn(List<String> values) {
            addCriterion("agent_detail_site not in", values, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteBetween(String value1, String value2) {
            addCriterion("agent_detail_site between", value1, value2, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentDetailSiteNotBetween(String value1, String value2) {
            addCriterion("agent_detail_site not between", value1, value2, "agentDetailSite");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlIsNull() {
            addCriterion("agent_papers_url is null");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlIsNotNull() {
            addCriterion("agent_papers_url is not null");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlEqualTo(String value) {
            addCriterion("agent_papers_url =", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlNotEqualTo(String value) {
            addCriterion("agent_papers_url <>", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlGreaterThan(String value) {
            addCriterion("agent_papers_url >", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlGreaterThanOrEqualTo(String value) {
            addCriterion("agent_papers_url >=", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlLessThan(String value) {
            addCriterion("agent_papers_url <", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlLessThanOrEqualTo(String value) {
            addCriterion("agent_papers_url <=", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlLike(String value) {
            addCriterion("agent_papers_url like", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlNotLike(String value) {
            addCriterion("agent_papers_url not like", value, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlIn(List<String> values) {
            addCriterion("agent_papers_url in", values, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlNotIn(List<String> values) {
            addCriterion("agent_papers_url not in", values, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlBetween(String value1, String value2) {
            addCriterion("agent_papers_url between", value1, value2, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentPapersUrlNotBetween(String value1, String value2) {
            addCriterion("agent_papers_url not between", value1, value2, "agentPapersUrl");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionIsNull() {
            addCriterion("agent_description is null");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionIsNotNull() {
            addCriterion("agent_description is not null");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionEqualTo(String value) {
            addCriterion("agent_description =", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionNotEqualTo(String value) {
            addCriterion("agent_description <>", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionGreaterThan(String value) {
            addCriterion("agent_description >", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("agent_description >=", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionLessThan(String value) {
            addCriterion("agent_description <", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionLessThanOrEqualTo(String value) {
            addCriterion("agent_description <=", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionLike(String value) {
            addCriterion("agent_description like", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionNotLike(String value) {
            addCriterion("agent_description not like", value, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionIn(List<String> values) {
            addCriterion("agent_description in", values, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionNotIn(List<String> values) {
            addCriterion("agent_description not in", values, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionBetween(String value1, String value2) {
            addCriterion("agent_description between", value1, value2, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentDescriptionNotBetween(String value1, String value2) {
            addCriterion("agent_description not between", value1, value2, "agentDescription");
            return (Criteria) this;
        }

        public Criteria andAgentStatusIsNull() {
            addCriterion("agent_status is null");
            return (Criteria) this;
        }

        public Criteria andAgentStatusIsNotNull() {
            addCriterion("agent_status is not null");
            return (Criteria) this;
        }

        public Criteria andAgentStatusEqualTo(Byte value) {
            addCriterion("agent_status =", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusNotEqualTo(Byte value) {
            addCriterion("agent_status <>", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusGreaterThan(Byte value) {
            addCriterion("agent_status >", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("agent_status >=", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusLessThan(Byte value) {
            addCriterion("agent_status <", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("agent_status <=", value, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusIn(List<Byte> values) {
            addCriterion("agent_status in", values, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusNotIn(List<Byte> values) {
            addCriterion("agent_status not in", values, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusBetween(Byte value1, Byte value2) {
            addCriterion("agent_status between", value1, value2, "agentStatus");
            return (Criteria) this;
        }

        public Criteria andAgentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("agent_status not between", value1, value2, "agentStatus");
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
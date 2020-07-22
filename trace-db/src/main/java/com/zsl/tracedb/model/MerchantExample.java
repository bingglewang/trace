package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantExample() {
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

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountIsNull() {
            addCriterion("merchant_account is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountIsNotNull() {
            addCriterion("merchant_account is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountEqualTo(String value) {
            addCriterion("merchant_account =", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNotEqualTo(String value) {
            addCriterion("merchant_account <>", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountGreaterThan(String value) {
            addCriterion("merchant_account >", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_account >=", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountLessThan(String value) {
            addCriterion("merchant_account <", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountLessThanOrEqualTo(String value) {
            addCriterion("merchant_account <=", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountLike(String value) {
            addCriterion("merchant_account like", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNotLike(String value) {
            addCriterion("merchant_account not like", value, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountIn(List<String> values) {
            addCriterion("merchant_account in", values, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNotIn(List<String> values) {
            addCriterion("merchant_account not in", values, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountBetween(String value1, String value2) {
            addCriterion("merchant_account between", value1, value2, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andMerchantAccountNotBetween(String value1, String value2) {
            addCriterion("merchant_account not between", value1, value2, "merchantAccount");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdIsNull() {
            addCriterion("adminstration_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdIsNotNull() {
            addCriterion("adminstration_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdEqualTo(Integer value) {
            addCriterion("adminstration_id =", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdNotEqualTo(Integer value) {
            addCriterion("adminstration_id <>", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdGreaterThan(Integer value) {
            addCriterion("adminstration_id >", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminstration_id >=", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdLessThan(Integer value) {
            addCriterion("adminstration_id <", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdLessThanOrEqualTo(Integer value) {
            addCriterion("adminstration_id <=", value, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdIn(List<Integer> values) {
            addCriterion("adminstration_id in", values, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdNotIn(List<Integer> values) {
            addCriterion("adminstration_id not in", values, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdBetween(Integer value1, Integer value2) {
            addCriterion("adminstration_id between", value1, value2, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdminstrationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adminstration_id not between", value1, value2, "adminstrationId");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteIsNull() {
            addCriterion("administrative_division_full_site is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteIsNotNull() {
            addCriterion("administrative_division_full_site is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteEqualTo(String value) {
            addCriterion("administrative_division_full_site =", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteNotEqualTo(String value) {
            addCriterion("administrative_division_full_site <>", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteGreaterThan(String value) {
            addCriterion("administrative_division_full_site >", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_division_full_site >=", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteLessThan(String value) {
            addCriterion("administrative_division_full_site <", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteLessThanOrEqualTo(String value) {
            addCriterion("administrative_division_full_site <=", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteLike(String value) {
            addCriterion("administrative_division_full_site like", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteNotLike(String value) {
            addCriterion("administrative_division_full_site not like", value, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteIn(List<String> values) {
            addCriterion("administrative_division_full_site in", values, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteNotIn(List<String> values) {
            addCriterion("administrative_division_full_site not in", values, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteBetween(String value1, String value2) {
            addCriterion("administrative_division_full_site between", value1, value2, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andAdministrativeDivisionFullSiteNotBetween(String value1, String value2) {
            addCriterion("administrative_division_full_site not between", value1, value2, "administrativeDivisionFullSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteIsNull() {
            addCriterion("merchant_detail_site is null");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteIsNotNull() {
            addCriterion("merchant_detail_site is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteEqualTo(String value) {
            addCriterion("merchant_detail_site =", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteNotEqualTo(String value) {
            addCriterion("merchant_detail_site <>", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteGreaterThan(String value) {
            addCriterion("merchant_detail_site >", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_detail_site >=", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteLessThan(String value) {
            addCriterion("merchant_detail_site <", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteLessThanOrEqualTo(String value) {
            addCriterion("merchant_detail_site <=", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteLike(String value) {
            addCriterion("merchant_detail_site like", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteNotLike(String value) {
            addCriterion("merchant_detail_site not like", value, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteIn(List<String> values) {
            addCriterion("merchant_detail_site in", values, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteNotIn(List<String> values) {
            addCriterion("merchant_detail_site not in", values, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteBetween(String value1, String value2) {
            addCriterion("merchant_detail_site between", value1, value2, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantDetailSiteNotBetween(String value1, String value2) {
            addCriterion("merchant_detail_site not between", value1, value2, "merchantDetailSite");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlIsNull() {
            addCriterion("merchant_url is null");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlIsNotNull() {
            addCriterion("merchant_url is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlEqualTo(String value) {
            addCriterion("merchant_url =", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlNotEqualTo(String value) {
            addCriterion("merchant_url <>", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlGreaterThan(String value) {
            addCriterion("merchant_url >", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_url >=", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlLessThan(String value) {
            addCriterion("merchant_url <", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlLessThanOrEqualTo(String value) {
            addCriterion("merchant_url <=", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlLike(String value) {
            addCriterion("merchant_url like", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlNotLike(String value) {
            addCriterion("merchant_url not like", value, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlIn(List<String> values) {
            addCriterion("merchant_url in", values, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlNotIn(List<String> values) {
            addCriterion("merchant_url not in", values, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlBetween(String value1, String value2) {
            addCriterion("merchant_url between", value1, value2, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantUrlNotBetween(String value1, String value2) {
            addCriterion("merchant_url not between", value1, value2, "merchantUrl");
            return (Criteria) this;
        }

        public Criteria andNetTypeIsNull() {
            addCriterion("net_type is null");
            return (Criteria) this;
        }

        public Criteria andNetTypeIsNotNull() {
            addCriterion("net_type is not null");
            return (Criteria) this;
        }

        public Criteria andNetTypeEqualTo(Integer value) {
            addCriterion("net_type =", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotEqualTo(Integer value) {
            addCriterion("net_type <>", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThan(Integer value) {
            addCriterion("net_type >", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("net_type >=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThan(Integer value) {
            addCriterion("net_type <", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("net_type <=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeIn(List<Integer> values) {
            addCriterion("net_type in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotIn(List<Integer> values) {
            addCriterion("net_type not in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeBetween(Integer value1, Integer value2) {
            addCriterion("net_type between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("net_type not between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinIsNull() {
            addCriterion("merchant_coin is null");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinIsNotNull() {
            addCriterion("merchant_coin is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinEqualTo(Integer value) {
            addCriterion("merchant_coin =", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinNotEqualTo(Integer value) {
            addCriterion("merchant_coin <>", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinGreaterThan(Integer value) {
            addCriterion("merchant_coin >", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_coin >=", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinLessThan(Integer value) {
            addCriterion("merchant_coin <", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_coin <=", value, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinIn(List<Integer> values) {
            addCriterion("merchant_coin in", values, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinNotIn(List<Integer> values) {
            addCriterion("merchant_coin not in", values, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinBetween(Integer value1, Integer value2) {
            addCriterion("merchant_coin between", value1, value2, "merchantCoin");
            return (Criteria) this;
        }

        public Criteria andMerchantCoinNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_coin not between", value1, value2, "merchantCoin");
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

        public Criteria andMerchantTypeIsNull() {
            addCriterion("merchant_type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("merchant_type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(Integer value) {
            addCriterion("merchant_type =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(Integer value) {
            addCriterion("merchant_type <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(Integer value) {
            addCriterion("merchant_type >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_type >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(Integer value) {
            addCriterion("merchant_type <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_type <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<Integer> values) {
            addCriterion("merchant_type in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<Integer> values) {
            addCriterion("merchant_type not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(Integer value1, Integer value2) {
            addCriterion("merchant_type between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_type not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameIsNull() {
            addCriterion("leal_person_name is null");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameIsNotNull() {
            addCriterion("leal_person_name is not null");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameEqualTo(String value) {
            addCriterion("leal_person_name =", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameNotEqualTo(String value) {
            addCriterion("leal_person_name <>", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameGreaterThan(String value) {
            addCriterion("leal_person_name >", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("leal_person_name >=", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameLessThan(String value) {
            addCriterion("leal_person_name <", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameLessThanOrEqualTo(String value) {
            addCriterion("leal_person_name <=", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameLike(String value) {
            addCriterion("leal_person_name like", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameNotLike(String value) {
            addCriterion("leal_person_name not like", value, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameIn(List<String> values) {
            addCriterion("leal_person_name in", values, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameNotIn(List<String> values) {
            addCriterion("leal_person_name not in", values, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameBetween(String value1, String value2) {
            addCriterion("leal_person_name between", value1, value2, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andLealPersonNameNotBetween(String value1, String value2) {
            addCriterion("leal_person_name not between", value1, value2, "lealPersonName");
            return (Criteria) this;
        }

        public Criteria andPapersUrlIsNull() {
            addCriterion("papers_url is null");
            return (Criteria) this;
        }

        public Criteria andPapersUrlIsNotNull() {
            addCriterion("papers_url is not null");
            return (Criteria) this;
        }

        public Criteria andPapersUrlEqualTo(String value) {
            addCriterion("papers_url =", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlNotEqualTo(String value) {
            addCriterion("papers_url <>", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlGreaterThan(String value) {
            addCriterion("papers_url >", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlGreaterThanOrEqualTo(String value) {
            addCriterion("papers_url >=", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlLessThan(String value) {
            addCriterion("papers_url <", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlLessThanOrEqualTo(String value) {
            addCriterion("papers_url <=", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlLike(String value) {
            addCriterion("papers_url like", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlNotLike(String value) {
            addCriterion("papers_url not like", value, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlIn(List<String> values) {
            addCriterion("papers_url in", values, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlNotIn(List<String> values) {
            addCriterion("papers_url not in", values, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlBetween(String value1, String value2) {
            addCriterion("papers_url between", value1, value2, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersUrlNotBetween(String value1, String value2) {
            addCriterion("papers_url not between", value1, value2, "papersUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlIsNull() {
            addCriterion("papers_back_url is null");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlIsNotNull() {
            addCriterion("papers_back_url is not null");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlEqualTo(String value) {
            addCriterion("papers_back_url =", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlNotEqualTo(String value) {
            addCriterion("papers_back_url <>", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlGreaterThan(String value) {
            addCriterion("papers_back_url >", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("papers_back_url >=", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlLessThan(String value) {
            addCriterion("papers_back_url <", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlLessThanOrEqualTo(String value) {
            addCriterion("papers_back_url <=", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlLike(String value) {
            addCriterion("papers_back_url like", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlNotLike(String value) {
            addCriterion("papers_back_url not like", value, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlIn(List<String> values) {
            addCriterion("papers_back_url in", values, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlNotIn(List<String> values) {
            addCriterion("papers_back_url not in", values, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlBetween(String value1, String value2) {
            addCriterion("papers_back_url between", value1, value2, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersBackUrlNotBetween(String value1, String value2) {
            addCriterion("papers_back_url not between", value1, value2, "papersBackUrl");
            return (Criteria) this;
        }

        public Criteria andPapersNumberIsNull() {
            addCriterion("papers_number is null");
            return (Criteria) this;
        }

        public Criteria andPapersNumberIsNotNull() {
            addCriterion("papers_number is not null");
            return (Criteria) this;
        }

        public Criteria andPapersNumberEqualTo(String value) {
            addCriterion("papers_number =", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberNotEqualTo(String value) {
            addCriterion("papers_number <>", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberGreaterThan(String value) {
            addCriterion("papers_number >", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberGreaterThanOrEqualTo(String value) {
            addCriterion("papers_number >=", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberLessThan(String value) {
            addCriterion("papers_number <", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberLessThanOrEqualTo(String value) {
            addCriterion("papers_number <=", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberLike(String value) {
            addCriterion("papers_number like", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberNotLike(String value) {
            addCriterion("papers_number not like", value, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberIn(List<String> values) {
            addCriterion("papers_number in", values, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberNotIn(List<String> values) {
            addCriterion("papers_number not in", values, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberBetween(String value1, String value2) {
            addCriterion("papers_number between", value1, value2, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andPapersNumberNotBetween(String value1, String value2) {
            addCriterion("papers_number not between", value1, value2, "papersNumber");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesIsNull() {
            addCriterion("business_lines is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesIsNotNull() {
            addCriterion("business_lines is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesEqualTo(String value) {
            addCriterion("business_lines =", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesNotEqualTo(String value) {
            addCriterion("business_lines <>", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesGreaterThan(String value) {
            addCriterion("business_lines >", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesGreaterThanOrEqualTo(String value) {
            addCriterion("business_lines >=", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesLessThan(String value) {
            addCriterion("business_lines <", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesLessThanOrEqualTo(String value) {
            addCriterion("business_lines <=", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesLike(String value) {
            addCriterion("business_lines like", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesNotLike(String value) {
            addCriterion("business_lines not like", value, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesIn(List<String> values) {
            addCriterion("business_lines in", values, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesNotIn(List<String> values) {
            addCriterion("business_lines not in", values, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesBetween(String value1, String value2) {
            addCriterion("business_lines between", value1, value2, "businessLines");
            return (Criteria) this;
        }

        public Criteria andBusinessLinesNotBetween(String value1, String value2) {
            addCriterion("business_lines not between", value1, value2, "businessLines");
            return (Criteria) this;
        }

        public Criteria andMerchantContactIsNull() {
            addCriterion("merchant_contact is null");
            return (Criteria) this;
        }

        public Criteria andMerchantContactIsNotNull() {
            addCriterion("merchant_contact is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantContactEqualTo(String value) {
            addCriterion("merchant_contact =", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactNotEqualTo(String value) {
            addCriterion("merchant_contact <>", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactGreaterThan(String value) {
            addCriterion("merchant_contact >", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_contact >=", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactLessThan(String value) {
            addCriterion("merchant_contact <", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactLessThanOrEqualTo(String value) {
            addCriterion("merchant_contact <=", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactLike(String value) {
            addCriterion("merchant_contact like", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactNotLike(String value) {
            addCriterion("merchant_contact not like", value, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactIn(List<String> values) {
            addCriterion("merchant_contact in", values, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactNotIn(List<String> values) {
            addCriterion("merchant_contact not in", values, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactBetween(String value1, String value2) {
            addCriterion("merchant_contact between", value1, value2, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andMerchantContactNotBetween(String value1, String value2) {
            addCriterion("merchant_contact not between", value1, value2, "merchantContact");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("contact_number is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("contact_number =", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("contact_number <>", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("contact_number >", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contact_number >=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("contact_number <", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("contact_number <=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("contact_number like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("contact_number not like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(List<String> values) {
            addCriterion("contact_number in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(List<String> values) {
            addCriterion("contact_number not in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("contact_number between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("contact_number not between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeIsNull() {
            addCriterion("merchant_enter_time is null");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeIsNotNull() {
            addCriterion("merchant_enter_time is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeEqualTo(Date value) {
            addCriterion("merchant_enter_time =", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeNotEqualTo(Date value) {
            addCriterion("merchant_enter_time <>", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeGreaterThan(Date value) {
            addCriterion("merchant_enter_time >", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("merchant_enter_time >=", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeLessThan(Date value) {
            addCriterion("merchant_enter_time <", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeLessThanOrEqualTo(Date value) {
            addCriterion("merchant_enter_time <=", value, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeIn(List<Date> values) {
            addCriterion("merchant_enter_time in", values, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeNotIn(List<Date> values) {
            addCriterion("merchant_enter_time not in", values, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeBetween(Date value1, Date value2) {
            addCriterion("merchant_enter_time between", value1, value2, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantEnterTimeNotBetween(Date value1, Date value2) {
            addCriterion("merchant_enter_time not between", value1, value2, "merchantEnterTime");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusIsNull() {
            addCriterion("merchant_status is null");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusIsNotNull() {
            addCriterion("merchant_status is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusEqualTo(Integer value) {
            addCriterion("merchant_status =", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusNotEqualTo(Integer value) {
            addCriterion("merchant_status <>", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusGreaterThan(Integer value) {
            addCriterion("merchant_status >", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_status >=", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusLessThan(Integer value) {
            addCriterion("merchant_status <", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_status <=", value, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusIn(List<Integer> values) {
            addCriterion("merchant_status in", values, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusNotIn(List<Integer> values) {
            addCriterion("merchant_status not in", values, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusBetween(Integer value1, Integer value2) {
            addCriterion("merchant_status between", value1, value2, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andMerchantStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_status not between", value1, value2, "merchantStatus");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlIsNull() {
            addCriterion("short_video_url is null");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlIsNotNull() {
            addCriterion("short_video_url is not null");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlEqualTo(String value) {
            addCriterion("short_video_url =", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlNotEqualTo(String value) {
            addCriterion("short_video_url <>", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlGreaterThan(String value) {
            addCriterion("short_video_url >", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("short_video_url >=", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlLessThan(String value) {
            addCriterion("short_video_url <", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("short_video_url <=", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlLike(String value) {
            addCriterion("short_video_url like", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlNotLike(String value) {
            addCriterion("short_video_url not like", value, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlIn(List<String> values) {
            addCriterion("short_video_url in", values, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlNotIn(List<String> values) {
            addCriterion("short_video_url not in", values, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlBetween(String value1, String value2) {
            addCriterion("short_video_url between", value1, value2, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andShortVideoUrlNotBetween(String value1, String value2) {
            addCriterion("short_video_url not between", value1, value2, "shortVideoUrl");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayIsNull() {
            addCriterion("certification_to_pay is null");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayIsNotNull() {
            addCriterion("certification_to_pay is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayEqualTo(Byte value) {
            addCriterion("certification_to_pay =", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayNotEqualTo(Byte value) {
            addCriterion("certification_to_pay <>", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayGreaterThan(Byte value) {
            addCriterion("certification_to_pay >", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayGreaterThanOrEqualTo(Byte value) {
            addCriterion("certification_to_pay >=", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayLessThan(Byte value) {
            addCriterion("certification_to_pay <", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayLessThanOrEqualTo(Byte value) {
            addCriterion("certification_to_pay <=", value, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayIn(List<Byte> values) {
            addCriterion("certification_to_pay in", values, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayNotIn(List<Byte> values) {
            addCriterion("certification_to_pay not in", values, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayBetween(Byte value1, Byte value2) {
            addCriterion("certification_to_pay between", value1, value2, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andCertificationToPayNotBetween(Byte value1, Byte value2) {
            addCriterion("certification_to_pay not between", value1, value2, "certificationToPay");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionIsNull() {
            addCriterion("merchant_desciption is null");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionIsNotNull() {
            addCriterion("merchant_desciption is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionEqualTo(String value) {
            addCriterion("merchant_desciption =", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionNotEqualTo(String value) {
            addCriterion("merchant_desciption <>", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionGreaterThan(String value) {
            addCriterion("merchant_desciption >", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_desciption >=", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionLessThan(String value) {
            addCriterion("merchant_desciption <", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionLessThanOrEqualTo(String value) {
            addCriterion("merchant_desciption <=", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionLike(String value) {
            addCriterion("merchant_desciption like", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionNotLike(String value) {
            addCriterion("merchant_desciption not like", value, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionIn(List<String> values) {
            addCriterion("merchant_desciption in", values, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionNotIn(List<String> values) {
            addCriterion("merchant_desciption not in", values, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionBetween(String value1, String value2) {
            addCriterion("merchant_desciption between", value1, value2, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andMerchantDesciptionNotBetween(String value1, String value2) {
            addCriterion("merchant_desciption not between", value1, value2, "merchantDesciption");
            return (Criteria) this;
        }

        public Criteria andStallLimitIsNull() {
            addCriterion("stall_limit is null");
            return (Criteria) this;
        }

        public Criteria andStallLimitIsNotNull() {
            addCriterion("stall_limit is not null");
            return (Criteria) this;
        }

        public Criteria andStallLimitEqualTo(Integer value) {
            addCriterion("stall_limit =", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitNotEqualTo(Integer value) {
            addCriterion("stall_limit <>", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitGreaterThan(Integer value) {
            addCriterion("stall_limit >", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("stall_limit >=", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitLessThan(Integer value) {
            addCriterion("stall_limit <", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitLessThanOrEqualTo(Integer value) {
            addCriterion("stall_limit <=", value, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitIn(List<Integer> values) {
            addCriterion("stall_limit in", values, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitNotIn(List<Integer> values) {
            addCriterion("stall_limit not in", values, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitBetween(Integer value1, Integer value2) {
            addCriterion("stall_limit between", value1, value2, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andStallLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("stall_limit not between", value1, value2, "stallLimit");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperIsNull() {
            addCriterion("paper_enable_uppper is null");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperIsNotNull() {
            addCriterion("paper_enable_uppper is not null");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperEqualTo(Long value) {
            addCriterion("paper_enable_uppper =", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperNotEqualTo(Long value) {
            addCriterion("paper_enable_uppper <>", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperGreaterThan(Long value) {
            addCriterion("paper_enable_uppper >", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperGreaterThanOrEqualTo(Long value) {
            addCriterion("paper_enable_uppper >=", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperLessThan(Long value) {
            addCriterion("paper_enable_uppper <", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperLessThanOrEqualTo(Long value) {
            addCriterion("paper_enable_uppper <=", value, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperIn(List<Long> values) {
            addCriterion("paper_enable_uppper in", values, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperNotIn(List<Long> values) {
            addCriterion("paper_enable_uppper not in", values, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperBetween(Long value1, Long value2) {
            addCriterion("paper_enable_uppper between", value1, value2, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperEnableUppperNotBetween(Long value1, Long value2) {
            addCriterion("paper_enable_uppper not between", value1, value2, "paperEnableUppper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperIsNull() {
            addCriterion("paper_label_upper is null");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperIsNotNull() {
            addCriterion("paper_label_upper is not null");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperEqualTo(Long value) {
            addCriterion("paper_label_upper =", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperNotEqualTo(Long value) {
            addCriterion("paper_label_upper <>", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperGreaterThan(Long value) {
            addCriterion("paper_label_upper >", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperGreaterThanOrEqualTo(Long value) {
            addCriterion("paper_label_upper >=", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperLessThan(Long value) {
            addCriterion("paper_label_upper <", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperLessThanOrEqualTo(Long value) {
            addCriterion("paper_label_upper <=", value, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperIn(List<Long> values) {
            addCriterion("paper_label_upper in", values, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperNotIn(List<Long> values) {
            addCriterion("paper_label_upper not in", values, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperBetween(Long value1, Long value2) {
            addCriterion("paper_label_upper between", value1, value2, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andPaperLabelUpperNotBetween(Long value1, Long value2) {
            addCriterion("paper_label_upper not between", value1, value2, "paperLabelUpper");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaIsNull() {
            addCriterion("site_abscissa is null");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaIsNotNull() {
            addCriterion("site_abscissa is not null");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaEqualTo(String value) {
            addCriterion("site_abscissa =", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaNotEqualTo(String value) {
            addCriterion("site_abscissa <>", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaGreaterThan(String value) {
            addCriterion("site_abscissa >", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaGreaterThanOrEqualTo(String value) {
            addCriterion("site_abscissa >=", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaLessThan(String value) {
            addCriterion("site_abscissa <", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaLessThanOrEqualTo(String value) {
            addCriterion("site_abscissa <=", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaLike(String value) {
            addCriterion("site_abscissa like", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaNotLike(String value) {
            addCriterion("site_abscissa not like", value, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaIn(List<String> values) {
            addCriterion("site_abscissa in", values, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaNotIn(List<String> values) {
            addCriterion("site_abscissa not in", values, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaBetween(String value1, String value2) {
            addCriterion("site_abscissa between", value1, value2, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteAbscissaNotBetween(String value1, String value2) {
            addCriterion("site_abscissa not between", value1, value2, "siteAbscissa");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateIsNull() {
            addCriterion("site_ordinate is null");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateIsNotNull() {
            addCriterion("site_ordinate is not null");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateEqualTo(String value) {
            addCriterion("site_ordinate =", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateNotEqualTo(String value) {
            addCriterion("site_ordinate <>", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateGreaterThan(String value) {
            addCriterion("site_ordinate >", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateGreaterThanOrEqualTo(String value) {
            addCriterion("site_ordinate >=", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateLessThan(String value) {
            addCriterion("site_ordinate <", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateLessThanOrEqualTo(String value) {
            addCriterion("site_ordinate <=", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateLike(String value) {
            addCriterion("site_ordinate like", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateNotLike(String value) {
            addCriterion("site_ordinate not like", value, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateIn(List<String> values) {
            addCriterion("site_ordinate in", values, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateNotIn(List<String> values) {
            addCriterion("site_ordinate not in", values, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateBetween(String value1, String value2) {
            addCriterion("site_ordinate between", value1, value2, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andSiteOrdinateNotBetween(String value1, String value2) {
            addCriterion("site_ordinate not between", value1, value2, "siteOrdinate");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteIsNull() {
            addCriterion("discern_site is null");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteIsNotNull() {
            addCriterion("discern_site is not null");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteEqualTo(String value) {
            addCriterion("discern_site =", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteNotEqualTo(String value) {
            addCriterion("discern_site <>", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteGreaterThan(String value) {
            addCriterion("discern_site >", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteGreaterThanOrEqualTo(String value) {
            addCriterion("discern_site >=", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteLessThan(String value) {
            addCriterion("discern_site <", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteLessThanOrEqualTo(String value) {
            addCriterion("discern_site <=", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteLike(String value) {
            addCriterion("discern_site like", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteNotLike(String value) {
            addCriterion("discern_site not like", value, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteIn(List<String> values) {
            addCriterion("discern_site in", values, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteNotIn(List<String> values) {
            addCriterion("discern_site not in", values, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteBetween(String value1, String value2) {
            addCriterion("discern_site between", value1, value2, "discernSite");
            return (Criteria) this;
        }

        public Criteria andDiscernSiteNotBetween(String value1, String value2) {
            addCriterion("discern_site not between", value1, value2, "discernSite");
            return (Criteria) this;
        }

        public Criteria andSalesUrlIsNull() {
            addCriterion("sales_url is null");
            return (Criteria) this;
        }

        public Criteria andSalesUrlIsNotNull() {
            addCriterion("sales_url is not null");
            return (Criteria) this;
        }

        public Criteria andSalesUrlEqualTo(String value) {
            addCriterion("sales_url =", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlNotEqualTo(String value) {
            addCriterion("sales_url <>", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlGreaterThan(String value) {
            addCriterion("sales_url >", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sales_url >=", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlLessThan(String value) {
            addCriterion("sales_url <", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlLessThanOrEqualTo(String value) {
            addCriterion("sales_url <=", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlLike(String value) {
            addCriterion("sales_url like", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlNotLike(String value) {
            addCriterion("sales_url not like", value, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlIn(List<String> values) {
            addCriterion("sales_url in", values, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlNotIn(List<String> values) {
            addCriterion("sales_url not in", values, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlBetween(String value1, String value2) {
            addCriterion("sales_url between", value1, value2, "salesUrl");
            return (Criteria) this;
        }

        public Criteria andSalesUrlNotBetween(String value1, String value2) {
            addCriterion("sales_url not between", value1, value2, "salesUrl");
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
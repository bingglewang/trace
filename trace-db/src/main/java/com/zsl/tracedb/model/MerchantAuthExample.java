package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantAuthExample() {
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

        public Criteria andMerchantAuthIdIsNull() {
            addCriterion("merchant_auth_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdIsNotNull() {
            addCriterion("merchant_auth_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdEqualTo(Integer value) {
            addCriterion("merchant_auth_id =", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdNotEqualTo(Integer value) {
            addCriterion("merchant_auth_id <>", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdGreaterThan(Integer value) {
            addCriterion("merchant_auth_id >", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_auth_id >=", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdLessThan(Integer value) {
            addCriterion("merchant_auth_id <", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_auth_id <=", value, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdIn(List<Integer> values) {
            addCriterion("merchant_auth_id in", values, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdNotIn(List<Integer> values) {
            addCriterion("merchant_auth_id not in", values, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdBetween(Integer value1, Integer value2) {
            addCriterion("merchant_auth_id between", value1, value2, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andMerchantAuthIdNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_auth_id not between", value1, value2, "merchantAuthId");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(String value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(String value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(String value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(String value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(String value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLike(String value) {
            addCriterion("order_num like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotLike(String value) {
            addCriterion("order_num not like", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<String> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<String> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(String value1, String value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(String value1, String value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
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

        public Criteria andIpSiteIsNull() {
            addCriterion("ip_site is null");
            return (Criteria) this;
        }

        public Criteria andIpSiteIsNotNull() {
            addCriterion("ip_site is not null");
            return (Criteria) this;
        }

        public Criteria andIpSiteEqualTo(String value) {
            addCriterion("ip_site =", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteNotEqualTo(String value) {
            addCriterion("ip_site <>", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteGreaterThan(String value) {
            addCriterion("ip_site >", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteGreaterThanOrEqualTo(String value) {
            addCriterion("ip_site >=", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteLessThan(String value) {
            addCriterion("ip_site <", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteLessThanOrEqualTo(String value) {
            addCriterion("ip_site <=", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteLike(String value) {
            addCriterion("ip_site like", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteNotLike(String value) {
            addCriterion("ip_site not like", value, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteIn(List<String> values) {
            addCriterion("ip_site in", values, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteNotIn(List<String> values) {
            addCriterion("ip_site not in", values, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteBetween(String value1, String value2) {
            addCriterion("ip_site between", value1, value2, "ipSite");
            return (Criteria) this;
        }

        public Criteria andIpSiteNotBetween(String value1, String value2) {
            addCriterion("ip_site not between", value1, value2, "ipSite");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andAuthSumIsNull() {
            addCriterion("auth_sum is null");
            return (Criteria) this;
        }

        public Criteria andAuthSumIsNotNull() {
            addCriterion("auth_sum is not null");
            return (Criteria) this;
        }

        public Criteria andAuthSumEqualTo(Float value) {
            addCriterion("auth_sum =", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumNotEqualTo(Float value) {
            addCriterion("auth_sum <>", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumGreaterThan(Float value) {
            addCriterion("auth_sum >", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumGreaterThanOrEqualTo(Float value) {
            addCriterion("auth_sum >=", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumLessThan(Float value) {
            addCriterion("auth_sum <", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumLessThanOrEqualTo(Float value) {
            addCriterion("auth_sum <=", value, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumIn(List<Float> values) {
            addCriterion("auth_sum in", values, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumNotIn(List<Float> values) {
            addCriterion("auth_sum not in", values, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumBetween(Float value1, Float value2) {
            addCriterion("auth_sum between", value1, value2, "authSum");
            return (Criteria) this;
        }

        public Criteria andAuthSumNotBetween(Float value1, Float value2) {
            addCriterion("auth_sum not between", value1, value2, "authSum");
            return (Criteria) this;
        }

        public Criteria andPayCertifyIsNull() {
            addCriterion("pay_certify is null");
            return (Criteria) this;
        }

        public Criteria andPayCertifyIsNotNull() {
            addCriterion("pay_certify is not null");
            return (Criteria) this;
        }

        public Criteria andPayCertifyEqualTo(String value) {
            addCriterion("pay_certify =", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyNotEqualTo(String value) {
            addCriterion("pay_certify <>", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyGreaterThan(String value) {
            addCriterion("pay_certify >", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyGreaterThanOrEqualTo(String value) {
            addCriterion("pay_certify >=", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyLessThan(String value) {
            addCriterion("pay_certify <", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyLessThanOrEqualTo(String value) {
            addCriterion("pay_certify <=", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyLike(String value) {
            addCriterion("pay_certify like", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyNotLike(String value) {
            addCriterion("pay_certify not like", value, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyIn(List<String> values) {
            addCriterion("pay_certify in", values, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyNotIn(List<String> values) {
            addCriterion("pay_certify not in", values, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyBetween(String value1, String value2) {
            addCriterion("pay_certify between", value1, value2, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayCertifyNotBetween(String value1, String value2) {
            addCriterion("pay_certify not between", value1, value2, "payCertify");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("pay_status =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("pay_status <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("pay_status >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_status >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("pay_status <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pay_status <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("pay_status in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("pay_status not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pay_status between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_status not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNull() {
            addCriterion("audit_status is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("audit_status is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Integer value) {
            addCriterion("audit_status =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Integer value) {
            addCriterion("audit_status <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Integer value) {
            addCriterion("audit_status >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_status >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Integer value) {
            addCriterion("audit_status <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Integer value) {
            addCriterion("audit_status <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Integer> values) {
            addCriterion("audit_status in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Integer> values) {
            addCriterion("audit_status not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Integer value1, Integer value2) {
            addCriterion("audit_status between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_status not between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolIsNull() {
            addCriterion("is_accept_protocol is null");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolIsNotNull() {
            addCriterion("is_accept_protocol is not null");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolEqualTo(Integer value) {
            addCriterion("is_accept_protocol =", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolNotEqualTo(Integer value) {
            addCriterion("is_accept_protocol <>", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolGreaterThan(Integer value) {
            addCriterion("is_accept_protocol >", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_accept_protocol >=", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolLessThan(Integer value) {
            addCriterion("is_accept_protocol <", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolLessThanOrEqualTo(Integer value) {
            addCriterion("is_accept_protocol <=", value, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolIn(List<Integer> values) {
            addCriterion("is_accept_protocol in", values, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolNotIn(List<Integer> values) {
            addCriterion("is_accept_protocol not in", values, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolBetween(Integer value1, Integer value2) {
            addCriterion("is_accept_protocol between", value1, value2, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andIsAcceptProtocolNotBetween(Integer value1, Integer value2) {
            addCriterion("is_accept_protocol not between", value1, value2, "isAcceptProtocol");
            return (Criteria) this;
        }

        public Criteria andGetIntegralIsNull() {
            addCriterion("get_integral is null");
            return (Criteria) this;
        }

        public Criteria andGetIntegralIsNotNull() {
            addCriterion("get_integral is not null");
            return (Criteria) this;
        }

        public Criteria andGetIntegralEqualTo(Integer value) {
            addCriterion("get_integral =", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralNotEqualTo(Integer value) {
            addCriterion("get_integral <>", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralGreaterThan(Integer value) {
            addCriterion("get_integral >", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("get_integral >=", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralLessThan(Integer value) {
            addCriterion("get_integral <", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("get_integral <=", value, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralIn(List<Integer> values) {
            addCriterion("get_integral in", values, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralNotIn(List<Integer> values) {
            addCriterion("get_integral not in", values, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralBetween(Integer value1, Integer value2) {
            addCriterion("get_integral between", value1, value2, "getIntegral");
            return (Criteria) this;
        }

        public Criteria andGetIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("get_integral not between", value1, value2, "getIntegral");
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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
package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantStallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantStallExample() {
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

        public Criteria andStallIdIsNull() {
            addCriterion("stall_id is null");
            return (Criteria) this;
        }

        public Criteria andStallIdIsNotNull() {
            addCriterion("stall_id is not null");
            return (Criteria) this;
        }

        public Criteria andStallIdEqualTo(Integer value) {
            addCriterion("stall_id =", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotEqualTo(Integer value) {
            addCriterion("stall_id <>", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdGreaterThan(Integer value) {
            addCriterion("stall_id >", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stall_id >=", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdLessThan(Integer value) {
            addCriterion("stall_id <", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdLessThanOrEqualTo(Integer value) {
            addCriterion("stall_id <=", value, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdIn(List<Integer> values) {
            addCriterion("stall_id in", values, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotIn(List<Integer> values) {
            addCriterion("stall_id not in", values, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdBetween(Integer value1, Integer value2) {
            addCriterion("stall_id between", value1, value2, "stallId");
            return (Criteria) this;
        }

        public Criteria andStallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stall_id not between", value1, value2, "stallId");
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

        public Criteria andStallNoIsNull() {
            addCriterion("stall_no is null");
            return (Criteria) this;
        }

        public Criteria andStallNoIsNotNull() {
            addCriterion("stall_no is not null");
            return (Criteria) this;
        }

        public Criteria andStallNoEqualTo(String value) {
            addCriterion("stall_no =", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoNotEqualTo(String value) {
            addCriterion("stall_no <>", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoGreaterThan(String value) {
            addCriterion("stall_no >", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoGreaterThanOrEqualTo(String value) {
            addCriterion("stall_no >=", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoLessThan(String value) {
            addCriterion("stall_no <", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoLessThanOrEqualTo(String value) {
            addCriterion("stall_no <=", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoLike(String value) {
            addCriterion("stall_no like", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoNotLike(String value) {
            addCriterion("stall_no not like", value, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoIn(List<String> values) {
            addCriterion("stall_no in", values, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoNotIn(List<String> values) {
            addCriterion("stall_no not in", values, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoBetween(String value1, String value2) {
            addCriterion("stall_no between", value1, value2, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStallNoNotBetween(String value1, String value2) {
            addCriterion("stall_no not between", value1, value2, "stallNo");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andStallHolderIdIsNull() {
            addCriterion("stall_holder_id is null");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdIsNotNull() {
            addCriterion("stall_holder_id is not null");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdEqualTo(Integer value) {
            addCriterion("stall_holder_id =", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdNotEqualTo(Integer value) {
            addCriterion("stall_holder_id <>", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdGreaterThan(Integer value) {
            addCriterion("stall_holder_id >", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stall_holder_id >=", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdLessThan(Integer value) {
            addCriterion("stall_holder_id <", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdLessThanOrEqualTo(Integer value) {
            addCriterion("stall_holder_id <=", value, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdIn(List<Integer> values) {
            addCriterion("stall_holder_id in", values, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdNotIn(List<Integer> values) {
            addCriterion("stall_holder_id not in", values, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdBetween(Integer value1, Integer value2) {
            addCriterion("stall_holder_id between", value1, value2, "stallHolderId");
            return (Criteria) this;
        }

        public Criteria andStallHolderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stall_holder_id not between", value1, value2, "stallHolderId");
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
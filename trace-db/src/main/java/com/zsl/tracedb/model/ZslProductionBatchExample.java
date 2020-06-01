package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslProductionBatchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslProductionBatchExample() {
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

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(Integer value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(Integer value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(Integer value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(Integer value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<Integer> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<Integer> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batch_no is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batch_no =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batch_no <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batch_no >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batch_no >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batch_no <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batch_no <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batch_no like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batch_no not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batch_no in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batch_no not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batch_no between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batch_no not between", value1, value2, "batchNo");
            return (Criteria) this;
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

        public Criteria andProductionTimeScopeIsNull() {
            addCriterion("production_time_scope is null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeIsNotNull() {
            addCriterion("production_time_scope is not null");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeEqualTo(String value) {
            addCriterion("production_time_scope =", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeNotEqualTo(String value) {
            addCriterion("production_time_scope <>", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeGreaterThan(String value) {
            addCriterion("production_time_scope >", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeGreaterThanOrEqualTo(String value) {
            addCriterion("production_time_scope >=", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeLessThan(String value) {
            addCriterion("production_time_scope <", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeLessThanOrEqualTo(String value) {
            addCriterion("production_time_scope <=", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeLike(String value) {
            addCriterion("production_time_scope like", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeNotLike(String value) {
            addCriterion("production_time_scope not like", value, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeIn(List<String> values) {
            addCriterion("production_time_scope in", values, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeNotIn(List<String> values) {
            addCriterion("production_time_scope not in", values, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeBetween(String value1, String value2) {
            addCriterion("production_time_scope between", value1, value2, "productionTimeScope");
            return (Criteria) this;
        }

        public Criteria andProductionTimeScopeNotBetween(String value1, String value2) {
            addCriterion("production_time_scope not between", value1, value2, "productionTimeScope");
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

        public Criteria andTraceCodeNoIsNull() {
            addCriterion("trace_code_no is null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoIsNotNull() {
            addCriterion("trace_code_no is not null");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoEqualTo(String value) {
            addCriterion("trace_code_no =", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoNotEqualTo(String value) {
            addCriterion("trace_code_no <>", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoGreaterThan(String value) {
            addCriterion("trace_code_no >", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trace_code_no >=", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoLessThan(String value) {
            addCriterion("trace_code_no <", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoLessThanOrEqualTo(String value) {
            addCriterion("trace_code_no <=", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoLike(String value) {
            addCriterion("trace_code_no like", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoNotLike(String value) {
            addCriterion("trace_code_no not like", value, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoIn(List<String> values) {
            addCriterion("trace_code_no in", values, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoNotIn(List<String> values) {
            addCriterion("trace_code_no not in", values, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoBetween(String value1, String value2) {
            addCriterion("trace_code_no between", value1, value2, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andTraceCodeNoNotBetween(String value1, String value2) {
            addCriterion("trace_code_no not between", value1, value2, "traceCodeNo");
            return (Criteria) this;
        }

        public Criteria andSidStartIsNull() {
            addCriterion("sid_start is null");
            return (Criteria) this;
        }

        public Criteria andSidStartIsNotNull() {
            addCriterion("sid_start is not null");
            return (Criteria) this;
        }

        public Criteria andSidStartEqualTo(Long value) {
            addCriterion("sid_start =", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartNotEqualTo(Long value) {
            addCriterion("sid_start <>", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartGreaterThan(Long value) {
            addCriterion("sid_start >", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartGreaterThanOrEqualTo(Long value) {
            addCriterion("sid_start >=", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartLessThan(Long value) {
            addCriterion("sid_start <", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartLessThanOrEqualTo(Long value) {
            addCriterion("sid_start <=", value, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartIn(List<Long> values) {
            addCriterion("sid_start in", values, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartNotIn(List<Long> values) {
            addCriterion("sid_start not in", values, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartBetween(Long value1, Long value2) {
            addCriterion("sid_start between", value1, value2, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidStartNotBetween(Long value1, Long value2) {
            addCriterion("sid_start not between", value1, value2, "sidStart");
            return (Criteria) this;
        }

        public Criteria andSidEndIsNull() {
            addCriterion("sid_end is null");
            return (Criteria) this;
        }

        public Criteria andSidEndIsNotNull() {
            addCriterion("sid_end is not null");
            return (Criteria) this;
        }

        public Criteria andSidEndEqualTo(Long value) {
            addCriterion("sid_end =", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndNotEqualTo(Long value) {
            addCriterion("sid_end <>", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndGreaterThan(Long value) {
            addCriterion("sid_end >", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndGreaterThanOrEqualTo(Long value) {
            addCriterion("sid_end >=", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndLessThan(Long value) {
            addCriterion("sid_end <", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndLessThanOrEqualTo(Long value) {
            addCriterion("sid_end <=", value, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndIn(List<Long> values) {
            addCriterion("sid_end in", values, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndNotIn(List<Long> values) {
            addCriterion("sid_end not in", values, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndBetween(Long value1, Long value2) {
            addCriterion("sid_end between", value1, value2, "sidEnd");
            return (Criteria) this;
        }

        public Criteria andSidEndNotBetween(Long value1, Long value2) {
            addCriterion("sid_end not between", value1, value2, "sidEnd");
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
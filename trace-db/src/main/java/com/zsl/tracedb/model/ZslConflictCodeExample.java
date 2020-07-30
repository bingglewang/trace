package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class ZslConflictCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslConflictCodeExample() {
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

        public Criteria andTraceSidIsNull() {
            addCriterion("trace_sid is null");
            return (Criteria) this;
        }

        public Criteria andTraceSidIsNotNull() {
            addCriterion("trace_sid is not null");
            return (Criteria) this;
        }

        public Criteria andTraceSidEqualTo(Long value) {
            addCriterion("trace_sid =", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotEqualTo(Long value) {
            addCriterion("trace_sid <>", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidGreaterThan(Long value) {
            addCriterion("trace_sid >", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidGreaterThanOrEqualTo(Long value) {
            addCriterion("trace_sid >=", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidLessThan(Long value) {
            addCriterion("trace_sid <", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidLessThanOrEqualTo(Long value) {
            addCriterion("trace_sid <=", value, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidIn(List<Long> values) {
            addCriterion("trace_sid in", values, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotIn(List<Long> values) {
            addCriterion("trace_sid not in", values, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidBetween(Long value1, Long value2) {
            addCriterion("trace_sid between", value1, value2, "traceSid");
            return (Criteria) this;
        }

        public Criteria andTraceSidNotBetween(Long value1, Long value2) {
            addCriterion("trace_sid not between", value1, value2, "traceSid");
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

        public Criteria andProductBatchCodeIsNull() {
            addCriterion("product_batch_code is null");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeIsNotNull() {
            addCriterion("product_batch_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeEqualTo(String value) {
            addCriterion("product_batch_code =", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeNotEqualTo(String value) {
            addCriterion("product_batch_code <>", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeGreaterThan(String value) {
            addCriterion("product_batch_code >", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_batch_code >=", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeLessThan(String value) {
            addCriterion("product_batch_code <", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeLessThanOrEqualTo(String value) {
            addCriterion("product_batch_code <=", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeLike(String value) {
            addCriterion("product_batch_code like", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeNotLike(String value) {
            addCriterion("product_batch_code not like", value, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeIn(List<String> values) {
            addCriterion("product_batch_code in", values, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeNotIn(List<String> values) {
            addCriterion("product_batch_code not in", values, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeBetween(String value1, String value2) {
            addCriterion("product_batch_code between", value1, value2, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andProductBatchCodeNotBetween(String value1, String value2) {
            addCriterion("product_batch_code not between", value1, value2, "productBatchCode");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameIsNull() {
            addCriterion("trace_good_name is null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameIsNotNull() {
            addCriterion("trace_good_name is not null");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameEqualTo(String value) {
            addCriterion("trace_good_name =", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameNotEqualTo(String value) {
            addCriterion("trace_good_name <>", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameGreaterThan(String value) {
            addCriterion("trace_good_name >", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("trace_good_name >=", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameLessThan(String value) {
            addCriterion("trace_good_name <", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameLessThanOrEqualTo(String value) {
            addCriterion("trace_good_name <=", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameLike(String value) {
            addCriterion("trace_good_name like", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameNotLike(String value) {
            addCriterion("trace_good_name not like", value, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameIn(List<String> values) {
            addCriterion("trace_good_name in", values, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameNotIn(List<String> values) {
            addCriterion("trace_good_name not in", values, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameBetween(String value1, String value2) {
            addCriterion("trace_good_name between", value1, value2, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceGoodNameNotBetween(String value1, String value2) {
            addCriterion("trace_good_name not between", value1, value2, "traceGoodName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameIsNull() {
            addCriterion("trace_node_name is null");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameIsNotNull() {
            addCriterion("trace_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameEqualTo(String value) {
            addCriterion("trace_node_name =", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameNotEqualTo(String value) {
            addCriterion("trace_node_name <>", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameGreaterThan(String value) {
            addCriterion("trace_node_name >", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trace_node_name >=", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameLessThan(String value) {
            addCriterion("trace_node_name <", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameLessThanOrEqualTo(String value) {
            addCriterion("trace_node_name <=", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameLike(String value) {
            addCriterion("trace_node_name like", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameNotLike(String value) {
            addCriterion("trace_node_name not like", value, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameIn(List<String> values) {
            addCriterion("trace_node_name in", values, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameNotIn(List<String> values) {
            addCriterion("trace_node_name not in", values, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameBetween(String value1, String value2) {
            addCriterion("trace_node_name between", value1, value2, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceNodeNameNotBetween(String value1, String value2) {
            addCriterion("trace_node_name not between", value1, value2, "traceNodeName");
            return (Criteria) this;
        }

        public Criteria andTraceAddressIsNull() {
            addCriterion("trace_address is null");
            return (Criteria) this;
        }

        public Criteria andTraceAddressIsNotNull() {
            addCriterion("trace_address is not null");
            return (Criteria) this;
        }

        public Criteria andTraceAddressEqualTo(String value) {
            addCriterion("trace_address =", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressNotEqualTo(String value) {
            addCriterion("trace_address <>", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressGreaterThan(String value) {
            addCriterion("trace_address >", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("trace_address >=", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressLessThan(String value) {
            addCriterion("trace_address <", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressLessThanOrEqualTo(String value) {
            addCriterion("trace_address <=", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressLike(String value) {
            addCriterion("trace_address like", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressNotLike(String value) {
            addCriterion("trace_address not like", value, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressIn(List<String> values) {
            addCriterion("trace_address in", values, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressNotIn(List<String> values) {
            addCriterion("trace_address not in", values, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressBetween(String value1, String value2) {
            addCriterion("trace_address between", value1, value2, "traceAddress");
            return (Criteria) this;
        }

        public Criteria andTraceAddressNotBetween(String value1, String value2) {
            addCriterion("trace_address not between", value1, value2, "traceAddress");
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
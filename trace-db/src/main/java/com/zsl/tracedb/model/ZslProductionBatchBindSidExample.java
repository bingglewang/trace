package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslProductionBatchBindSidExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslProductionBatchBindSidExample() {
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

        public Criteria andBatchSidIdIsNull() {
            addCriterion("batch_sid_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdIsNotNull() {
            addCriterion("batch_sid_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdEqualTo(Integer value) {
            addCriterion("batch_sid_id =", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdNotEqualTo(Integer value) {
            addCriterion("batch_sid_id <>", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdGreaterThan(Integer value) {
            addCriterion("batch_sid_id >", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_sid_id >=", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdLessThan(Integer value) {
            addCriterion("batch_sid_id <", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_sid_id <=", value, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdIn(List<Integer> values) {
            addCriterion("batch_sid_id in", values, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdNotIn(List<Integer> values) {
            addCriterion("batch_sid_id not in", values, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_sid_id between", value1, value2, "batchSidId");
            return (Criteria) this;
        }

        public Criteria andBatchSidIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_sid_id not between", value1, value2, "batchSidId");
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

        public Criteria andProductionBatchIdIsNull() {
            addCriterion("production_batch_id is null");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdIsNotNull() {
            addCriterion("production_batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdEqualTo(Integer value) {
            addCriterion("production_batch_id =", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdNotEqualTo(Integer value) {
            addCriterion("production_batch_id <>", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdGreaterThan(Integer value) {
            addCriterion("production_batch_id >", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("production_batch_id >=", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdLessThan(Integer value) {
            addCriterion("production_batch_id <", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("production_batch_id <=", value, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdIn(List<Integer> values) {
            addCriterion("production_batch_id in", values, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdNotIn(List<Integer> values) {
            addCriterion("production_batch_id not in", values, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("production_batch_id between", value1, value2, "productionBatchId");
            return (Criteria) this;
        }

        public Criteria andProductionBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("production_batch_id not between", value1, value2, "productionBatchId");
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
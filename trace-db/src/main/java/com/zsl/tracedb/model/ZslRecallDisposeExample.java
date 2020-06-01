package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslRecallDisposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslRecallDisposeExample() {
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

        public Criteria andRecallDisposeIdIsNull() {
            addCriterion("recall_dispose_id is null");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdIsNotNull() {
            addCriterion("recall_dispose_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdEqualTo(Integer value) {
            addCriterion("recall_dispose_id =", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdNotEqualTo(Integer value) {
            addCriterion("recall_dispose_id <>", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdGreaterThan(Integer value) {
            addCriterion("recall_dispose_id >", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recall_dispose_id >=", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdLessThan(Integer value) {
            addCriterion("recall_dispose_id <", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdLessThanOrEqualTo(Integer value) {
            addCriterion("recall_dispose_id <=", value, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdIn(List<Integer> values) {
            addCriterion("recall_dispose_id in", values, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdNotIn(List<Integer> values) {
            addCriterion("recall_dispose_id not in", values, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdBetween(Integer value1, Integer value2) {
            addCriterion("recall_dispose_id between", value1, value2, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andRecallDisposeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recall_dispose_id not between", value1, value2, "recallDisposeId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdIsNull() {
            addCriterion("batch_recall_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdIsNotNull() {
            addCriterion("batch_recall_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdEqualTo(Integer value) {
            addCriterion("batch_recall_id =", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdNotEqualTo(Integer value) {
            addCriterion("batch_recall_id <>", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdGreaterThan(Integer value) {
            addCriterion("batch_recall_id >", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_recall_id >=", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdLessThan(Integer value) {
            addCriterion("batch_recall_id <", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_recall_id <=", value, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdIn(List<Integer> values) {
            addCriterion("batch_recall_id in", values, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdNotIn(List<Integer> values) {
            addCriterion("batch_recall_id not in", values, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_recall_id between", value1, value2, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andBatchRecallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_recall_id not between", value1, value2, "batchRecallId");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlIsNull() {
            addCriterion("code_segment_file_url is null");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlIsNotNull() {
            addCriterion("code_segment_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlEqualTo(String value) {
            addCriterion("code_segment_file_url =", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlNotEqualTo(String value) {
            addCriterion("code_segment_file_url <>", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlGreaterThan(String value) {
            addCriterion("code_segment_file_url >", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("code_segment_file_url >=", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlLessThan(String value) {
            addCriterion("code_segment_file_url <", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlLessThanOrEqualTo(String value) {
            addCriterion("code_segment_file_url <=", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlLike(String value) {
            addCriterion("code_segment_file_url like", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlNotLike(String value) {
            addCriterion("code_segment_file_url not like", value, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlIn(List<String> values) {
            addCriterion("code_segment_file_url in", values, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlNotIn(List<String> values) {
            addCriterion("code_segment_file_url not in", values, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlBetween(String value1, String value2) {
            addCriterion("code_segment_file_url between", value1, value2, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andCodeSegmentFileUrlNotBetween(String value1, String value2) {
            addCriterion("code_segment_file_url not between", value1, value2, "codeSegmentFileUrl");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeIsNull() {
            addCriterion("dispose_type is null");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeIsNotNull() {
            addCriterion("dispose_type is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeEqualTo(Integer value) {
            addCriterion("dispose_type =", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeNotEqualTo(Integer value) {
            addCriterion("dispose_type <>", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeGreaterThan(Integer value) {
            addCriterion("dispose_type >", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispose_type >=", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeLessThan(Integer value) {
            addCriterion("dispose_type <", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("dispose_type <=", value, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeIn(List<Integer> values) {
            addCriterion("dispose_type in", values, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeNotIn(List<Integer> values) {
            addCriterion("dispose_type not in", values, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeBetween(Integer value1, Integer value2) {
            addCriterion("dispose_type between", value1, value2, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("dispose_type not between", value1, value2, "disposeType");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeIsNull() {
            addCriterion("dispose_time_scope is null");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeIsNotNull() {
            addCriterion("dispose_time_scope is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeEqualTo(String value) {
            addCriterion("dispose_time_scope =", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeNotEqualTo(String value) {
            addCriterion("dispose_time_scope <>", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeGreaterThan(String value) {
            addCriterion("dispose_time_scope >", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeGreaterThanOrEqualTo(String value) {
            addCriterion("dispose_time_scope >=", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeLessThan(String value) {
            addCriterion("dispose_time_scope <", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeLessThanOrEqualTo(String value) {
            addCriterion("dispose_time_scope <=", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeLike(String value) {
            addCriterion("dispose_time_scope like", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeNotLike(String value) {
            addCriterion("dispose_time_scope not like", value, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeIn(List<String> values) {
            addCriterion("dispose_time_scope in", values, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeNotIn(List<String> values) {
            addCriterion("dispose_time_scope not in", values, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeBetween(String value1, String value2) {
            addCriterion("dispose_time_scope between", value1, value2, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andDisposeTimeScopeNotBetween(String value1, String value2) {
            addCriterion("dispose_time_scope not between", value1, value2, "disposeTimeScope");
            return (Criteria) this;
        }

        public Criteria andEmployeIdIsNull() {
            addCriterion("employe_id is null");
            return (Criteria) this;
        }

        public Criteria andEmployeIdIsNotNull() {
            addCriterion("employe_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeIdEqualTo(Integer value) {
            addCriterion("employe_id =", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdNotEqualTo(Integer value) {
            addCriterion("employe_id <>", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdGreaterThan(Integer value) {
            addCriterion("employe_id >", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employe_id >=", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdLessThan(Integer value) {
            addCriterion("employe_id <", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employe_id <=", value, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdIn(List<Integer> values) {
            addCriterion("employe_id in", values, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdNotIn(List<Integer> values) {
            addCriterion("employe_id not in", values, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdBetween(Integer value1, Integer value2) {
            addCriterion("employe_id between", value1, value2, "employeId");
            return (Criteria) this;
        }

        public Criteria andEmployeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employe_id not between", value1, value2, "employeId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andDisposeWayIsNull() {
            addCriterion("dispose_way is null");
            return (Criteria) this;
        }

        public Criteria andDisposeWayIsNotNull() {
            addCriterion("dispose_way is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeWayEqualTo(String value) {
            addCriterion("dispose_way =", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayNotEqualTo(String value) {
            addCriterion("dispose_way <>", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayGreaterThan(String value) {
            addCriterion("dispose_way >", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayGreaterThanOrEqualTo(String value) {
            addCriterion("dispose_way >=", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayLessThan(String value) {
            addCriterion("dispose_way <", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayLessThanOrEqualTo(String value) {
            addCriterion("dispose_way <=", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayLike(String value) {
            addCriterion("dispose_way like", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayNotLike(String value) {
            addCriterion("dispose_way not like", value, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayIn(List<String> values) {
            addCriterion("dispose_way in", values, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayNotIn(List<String> values) {
            addCriterion("dispose_way not in", values, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayBetween(String value1, String value2) {
            addCriterion("dispose_way between", value1, value2, "disposeWay");
            return (Criteria) this;
        }

        public Criteria andDisposeWayNotBetween(String value1, String value2) {
            addCriterion("dispose_way not between", value1, value2, "disposeWay");
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
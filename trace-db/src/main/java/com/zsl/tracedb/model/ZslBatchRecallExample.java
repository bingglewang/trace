package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslBatchRecallExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslBatchRecallExample() {
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

        public Criteria andRecallCountIsNull() {
            addCriterion("recall_count is null");
            return (Criteria) this;
        }

        public Criteria andRecallCountIsNotNull() {
            addCriterion("recall_count is not null");
            return (Criteria) this;
        }

        public Criteria andRecallCountEqualTo(Integer value) {
            addCriterion("recall_count =", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotEqualTo(Integer value) {
            addCriterion("recall_count <>", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountGreaterThan(Integer value) {
            addCriterion("recall_count >", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("recall_count >=", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountLessThan(Integer value) {
            addCriterion("recall_count <", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountLessThanOrEqualTo(Integer value) {
            addCriterion("recall_count <=", value, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountIn(List<Integer> values) {
            addCriterion("recall_count in", values, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotIn(List<Integer> values) {
            addCriterion("recall_count not in", values, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountBetween(Integer value1, Integer value2) {
            addCriterion("recall_count between", value1, value2, "recallCount");
            return (Criteria) this;
        }

        public Criteria andRecallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("recall_count not between", value1, value2, "recallCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountIsNull() {
            addCriterion("undisposed_count is null");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountIsNotNull() {
            addCriterion("undisposed_count is not null");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountEqualTo(Integer value) {
            addCriterion("undisposed_count =", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountNotEqualTo(Integer value) {
            addCriterion("undisposed_count <>", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountGreaterThan(Integer value) {
            addCriterion("undisposed_count >", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("undisposed_count >=", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountLessThan(Integer value) {
            addCriterion("undisposed_count <", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountLessThanOrEqualTo(Integer value) {
            addCriterion("undisposed_count <=", value, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountIn(List<Integer> values) {
            addCriterion("undisposed_count in", values, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountNotIn(List<Integer> values) {
            addCriterion("undisposed_count not in", values, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountBetween(Integer value1, Integer value2) {
            addCriterion("undisposed_count between", value1, value2, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andUndisposedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("undisposed_count not between", value1, value2, "undisposedCount");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusIsNull() {
            addCriterion("dispose_status is null");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusIsNotNull() {
            addCriterion("dispose_status is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusEqualTo(Integer value) {
            addCriterion("dispose_status =", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusNotEqualTo(Integer value) {
            addCriterion("dispose_status <>", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusGreaterThan(Integer value) {
            addCriterion("dispose_status >", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispose_status >=", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusLessThan(Integer value) {
            addCriterion("dispose_status <", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("dispose_status <=", value, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusIn(List<Integer> values) {
            addCriterion("dispose_status in", values, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusNotIn(List<Integer> values) {
            addCriterion("dispose_status not in", values, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusBetween(Integer value1, Integer value2) {
            addCriterion("dispose_status between", value1, value2, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andDisposeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dispose_status not between", value1, value2, "disposeStatus");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("principal is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("principal is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("principal =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("principal <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("principal >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("principal >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("principal <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("principal <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("principal like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("principal not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("principal in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("principal not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("principal between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("principal not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIsNull() {
            addCriterion("principal_phone is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIsNotNull() {
            addCriterion("principal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneEqualTo(String value) {
            addCriterion("principal_phone =", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotEqualTo(String value) {
            addCriterion("principal_phone <>", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneGreaterThan(String value) {
            addCriterion("principal_phone >", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("principal_phone >=", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLessThan(String value) {
            addCriterion("principal_phone <", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLessThanOrEqualTo(String value) {
            addCriterion("principal_phone <=", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneLike(String value) {
            addCriterion("principal_phone like", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotLike(String value) {
            addCriterion("principal_phone not like", value, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneIn(List<String> values) {
            addCriterion("principal_phone in", values, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotIn(List<String> values) {
            addCriterion("principal_phone not in", values, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneBetween(String value1, String value2) {
            addCriterion("principal_phone between", value1, value2, "principalPhone");
            return (Criteria) this;
        }

        public Criteria andPrincipalPhoneNotBetween(String value1, String value2) {
            addCriterion("principal_phone not between", value1, value2, "principalPhone");
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
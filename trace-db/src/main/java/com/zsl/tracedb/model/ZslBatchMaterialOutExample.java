package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZslBatchMaterialOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZslBatchMaterialOutExample() {
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

        public Criteria andBatchMaterialOutIdIsNull() {
            addCriterion("batch_material_out_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdIsNotNull() {
            addCriterion("batch_material_out_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdEqualTo(Integer value) {
            addCriterion("batch_material_out_id =", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdNotEqualTo(Integer value) {
            addCriterion("batch_material_out_id <>", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdGreaterThan(Integer value) {
            addCriterion("batch_material_out_id >", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_material_out_id >=", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdLessThan(Integer value) {
            addCriterion("batch_material_out_id <", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdLessThanOrEqualTo(Integer value) {
            addCriterion("batch_material_out_id <=", value, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdIn(List<Integer> values) {
            addCriterion("batch_material_out_id in", values, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdNotIn(List<Integer> values) {
            addCriterion("batch_material_out_id not in", values, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdBetween(Integer value1, Integer value2) {
            addCriterion("batch_material_out_id between", value1, value2, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andBatchMaterialOutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_material_out_id not between", value1, value2, "batchMaterialOutId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdIsNull() {
            addCriterion("scene_batch_id is null");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdIsNotNull() {
            addCriterion("scene_batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdEqualTo(Integer value) {
            addCriterion("scene_batch_id =", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdNotEqualTo(Integer value) {
            addCriterion("scene_batch_id <>", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdGreaterThan(Integer value) {
            addCriterion("scene_batch_id >", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scene_batch_id >=", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdLessThan(Integer value) {
            addCriterion("scene_batch_id <", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdLessThanOrEqualTo(Integer value) {
            addCriterion("scene_batch_id <=", value, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdIn(List<Integer> values) {
            addCriterion("scene_batch_id in", values, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdNotIn(List<Integer> values) {
            addCriterion("scene_batch_id not in", values, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdBetween(Integer value1, Integer value2) {
            addCriterion("scene_batch_id between", value1, value2, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andSceneBatchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scene_batch_id not between", value1, value2, "sceneBatchId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdIsNull() {
            addCriterion("material_out_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdIsNotNull() {
            addCriterion("material_out_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdEqualTo(Integer value) {
            addCriterion("material_out_id =", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdNotEqualTo(Integer value) {
            addCriterion("material_out_id <>", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdGreaterThan(Integer value) {
            addCriterion("material_out_id >", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_out_id >=", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdLessThan(Integer value) {
            addCriterion("material_out_id <", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_out_id <=", value, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdIn(List<Integer> values) {
            addCriterion("material_out_id in", values, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdNotIn(List<Integer> values) {
            addCriterion("material_out_id not in", values, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdBetween(Integer value1, Integer value2) {
            addCriterion("material_out_id between", value1, value2, "materialOutId");
            return (Criteria) this;
        }

        public Criteria andMaterialOutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_out_id not between", value1, value2, "materialOutId");
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
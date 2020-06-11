package com.zsl.tracedb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialWarehouseOutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialWarehouseOutExample() {
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

        public Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderIsNull() {
            addCriterion("warehouse_out_order is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderIsNotNull() {
            addCriterion("warehouse_out_order is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderEqualTo(String value) {
            addCriterion("warehouse_out_order =", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderNotEqualTo(String value) {
            addCriterion("warehouse_out_order <>", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderGreaterThan(String value) {
            addCriterion("warehouse_out_order >", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_out_order >=", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderLessThan(String value) {
            addCriterion("warehouse_out_order <", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderLessThanOrEqualTo(String value) {
            addCriterion("warehouse_out_order <=", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderLike(String value) {
            addCriterion("warehouse_out_order like", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderNotLike(String value) {
            addCriterion("warehouse_out_order not like", value, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderIn(List<String> values) {
            addCriterion("warehouse_out_order in", values, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderNotIn(List<String> values) {
            addCriterion("warehouse_out_order not in", values, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderBetween(String value1, String value2) {
            addCriterion("warehouse_out_order between", value1, value2, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOutOrderNotBetween(String value1, String value2) {
            addCriterion("warehouse_out_order not between", value1, value2, "warehouseOutOrder");
            return (Criteria) this;
        }

        public Criteria andStockNumberIsNull() {
            addCriterion("stock_number is null");
            return (Criteria) this;
        }

        public Criteria andStockNumberIsNotNull() {
            addCriterion("stock_number is not null");
            return (Criteria) this;
        }

        public Criteria andStockNumberEqualTo(BigDecimal value) {
            addCriterion("stock_number =", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotEqualTo(BigDecimal value) {
            addCriterion("stock_number <>", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThan(BigDecimal value) {
            addCriterion("stock_number >", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_number >=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThan(BigDecimal value) {
            addCriterion("stock_number <", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_number <=", value, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberIn(List<BigDecimal> values) {
            addCriterion("stock_number in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotIn(List<BigDecimal> values) {
            addCriterion("stock_number not in", values, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_number between", value1, value2, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andStockNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_number not between", value1, value2, "stockNumber");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNull() {
            addCriterion("units is null");
            return (Criteria) this;
        }

        public Criteria andUnitsIsNotNull() {
            addCriterion("units is not null");
            return (Criteria) this;
        }

        public Criteria andUnitsEqualTo(String value) {
            addCriterion("units =", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotEqualTo(String value) {
            addCriterion("units <>", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThan(String value) {
            addCriterion("units >", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("units >=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThan(String value) {
            addCriterion("units <", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLessThanOrEqualTo(String value) {
            addCriterion("units <=", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsLike(String value) {
            addCriterion("units like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotLike(String value) {
            addCriterion("units not like", value, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsIn(List<String> values) {
            addCriterion("units in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotIn(List<String> values) {
            addCriterion("units not in", values, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsBetween(String value1, String value2) {
            addCriterion("units between", value1, value2, "units");
            return (Criteria) this;
        }

        public Criteria andUnitsNotBetween(String value1, String value2) {
            addCriterion("units not between", value1, value2, "units");
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
package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IntegralLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralLogExample() {
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

        public Criteria andFunctionTypeIsNull() {
            addCriterion("function_type is null");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeIsNotNull() {
            addCriterion("function_type is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeEqualTo(Integer value) {
            addCriterion("function_type =", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotEqualTo(Integer value) {
            addCriterion("function_type <>", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeGreaterThan(Integer value) {
            addCriterion("function_type >", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("function_type >=", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeLessThan(Integer value) {
            addCriterion("function_type <", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("function_type <=", value, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeIn(List<Integer> values) {
            addCriterion("function_type in", values, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotIn(List<Integer> values) {
            addCriterion("function_type not in", values, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeBetween(Integer value1, Integer value2) {
            addCriterion("function_type between", value1, value2, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("function_type not between", value1, value2, "functionType");
            return (Criteria) this;
        }

        public Criteria andFunctionIdIsNull() {
            addCriterion("function_id is null");
            return (Criteria) this;
        }

        public Criteria andFunctionIdIsNotNull() {
            addCriterion("function_id is not null");
            return (Criteria) this;
        }

        public Criteria andFunctionIdEqualTo(Integer value) {
            addCriterion("function_id =", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotEqualTo(Integer value) {
            addCriterion("function_id <>", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdGreaterThan(Integer value) {
            addCriterion("function_id >", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("function_id >=", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdLessThan(Integer value) {
            addCriterion("function_id <", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdLessThanOrEqualTo(Integer value) {
            addCriterion("function_id <=", value, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdIn(List<Integer> values) {
            addCriterion("function_id in", values, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotIn(List<Integer> values) {
            addCriterion("function_id not in", values, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdBetween(Integer value1, Integer value2) {
            addCriterion("function_id between", value1, value2, "functionId");
            return (Criteria) this;
        }

        public Criteria andFunctionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("function_id not between", value1, value2, "functionId");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralIsNull() {
            addCriterion("deduct_integral is null");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralIsNotNull() {
            addCriterion("deduct_integral is not null");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralEqualTo(Integer value) {
            addCriterion("deduct_integral =", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralNotEqualTo(Integer value) {
            addCriterion("deduct_integral <>", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralGreaterThan(Integer value) {
            addCriterion("deduct_integral >", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_integral >=", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralLessThan(Integer value) {
            addCriterion("deduct_integral <", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_integral <=", value, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralIn(List<Integer> values) {
            addCriterion("deduct_integral in", values, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralNotIn(List<Integer> values) {
            addCriterion("deduct_integral not in", values, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralBetween(Integer value1, Integer value2) {
            addCriterion("deduct_integral between", value1, value2, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_integral not between", value1, value2, "deductIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralIsNull() {
            addCriterion("surplus_integral is null");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralIsNotNull() {
            addCriterion("surplus_integral is not null");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralEqualTo(Integer value) {
            addCriterion("surplus_integral =", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralNotEqualTo(Integer value) {
            addCriterion("surplus_integral <>", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralGreaterThan(Integer value) {
            addCriterion("surplus_integral >", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("surplus_integral >=", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralLessThan(Integer value) {
            addCriterion("surplus_integral <", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("surplus_integral <=", value, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralIn(List<Integer> values) {
            addCriterion("surplus_integral in", values, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralNotIn(List<Integer> values) {
            addCriterion("surplus_integral not in", values, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralBetween(Integer value1, Integer value2) {
            addCriterion("surplus_integral between", value1, value2, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andSurplusIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("surplus_integral not between", value1, value2, "surplusIntegral");
            return (Criteria) this;
        }

        public Criteria andDeductTimeIsNull() {
            addCriterion("deduct_time is null");
            return (Criteria) this;
        }

        public Criteria andDeductTimeIsNotNull() {
            addCriterion("deduct_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeductTimeEqualTo(Date value) {
            addCriterion("deduct_time =", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeNotEqualTo(Date value) {
            addCriterion("deduct_time <>", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeGreaterThan(Date value) {
            addCriterion("deduct_time >", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deduct_time >=", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeLessThan(Date value) {
            addCriterion("deduct_time <", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeLessThanOrEqualTo(Date value) {
            addCriterion("deduct_time <=", value, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeIn(List<Date> values) {
            addCriterion("deduct_time in", values, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeNotIn(List<Date> values) {
            addCriterion("deduct_time not in", values, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeBetween(Date value1, Date value2) {
            addCriterion("deduct_time between", value1, value2, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductTimeNotBetween(Date value1, Date value2) {
            addCriterion("deduct_time not between", value1, value2, "deductTime");
            return (Criteria) this;
        }

        public Criteria andDeductStatusIsNull() {
            addCriterion("deduct_status is null");
            return (Criteria) this;
        }

        public Criteria andDeductStatusIsNotNull() {
            addCriterion("deduct_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeductStatusEqualTo(Integer value) {
            addCriterion("deduct_status =", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusNotEqualTo(Integer value) {
            addCriterion("deduct_status <>", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusGreaterThan(Integer value) {
            addCriterion("deduct_status >", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_status >=", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusLessThan(Integer value) {
            addCriterion("deduct_status <", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_status <=", value, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusIn(List<Integer> values) {
            addCriterion("deduct_status in", values, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusNotIn(List<Integer> values) {
            addCriterion("deduct_status not in", values, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusBetween(Integer value1, Integer value2) {
            addCriterion("deduct_status between", value1, value2, "deductStatus");
            return (Criteria) this;
        }

        public Criteria andDeductStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_status not between", value1, value2, "deductStatus");
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
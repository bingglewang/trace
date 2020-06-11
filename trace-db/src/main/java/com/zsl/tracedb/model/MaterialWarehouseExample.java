package com.zsl.tracedb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialWarehouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialWarehouseExample() {
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

        public Criteria andWarehouseNameIsNull() {
            addCriterion("warehouse_name is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIsNotNull() {
            addCriterion("warehouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameEqualTo(String value) {
            addCriterion("warehouse_name =", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotEqualTo(String value) {
            addCriterion("warehouse_name <>", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThan(String value) {
            addCriterion("warehouse_name >", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_name >=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThan(String value) {
            addCriterion("warehouse_name <", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLessThanOrEqualTo(String value) {
            addCriterion("warehouse_name <=", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameLike(String value) {
            addCriterion("warehouse_name like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotLike(String value) {
            addCriterion("warehouse_name not like", value, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameIn(List<String> values) {
            addCriterion("warehouse_name in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotIn(List<String> values) {
            addCriterion("warehouse_name not in", values, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameBetween(String value1, String value2) {
            addCriterion("warehouse_name between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNameNotBetween(String value1, String value2) {
            addCriterion("warehouse_name not between", value1, value2, "warehouseName");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIsNull() {
            addCriterion("warehouse_number is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIsNotNull() {
            addCriterion("warehouse_number is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberEqualTo(String value) {
            addCriterion("warehouse_number =", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotEqualTo(String value) {
            addCriterion("warehouse_number <>", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberGreaterThan(String value) {
            addCriterion("warehouse_number >", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_number >=", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberLessThan(String value) {
            addCriterion("warehouse_number <", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberLessThanOrEqualTo(String value) {
            addCriterion("warehouse_number <=", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberLike(String value) {
            addCriterion("warehouse_number like", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotLike(String value) {
            addCriterion("warehouse_number not like", value, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberIn(List<String> values) {
            addCriterion("warehouse_number in", values, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotIn(List<String> values) {
            addCriterion("warehouse_number not in", values, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberBetween(String value1, String value2) {
            addCriterion("warehouse_number between", value1, value2, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseNumberNotBetween(String value1, String value2) {
            addCriterion("warehouse_number not between", value1, value2, "warehouseNumber");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderIsNull() {
            addCriterion("warehouse_order is null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderIsNotNull() {
            addCriterion("warehouse_order is not null");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderEqualTo(String value) {
            addCriterion("warehouse_order =", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderNotEqualTo(String value) {
            addCriterion("warehouse_order <>", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderGreaterThan(String value) {
            addCriterion("warehouse_order >", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderGreaterThanOrEqualTo(String value) {
            addCriterion("warehouse_order >=", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderLessThan(String value) {
            addCriterion("warehouse_order <", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderLessThanOrEqualTo(String value) {
            addCriterion("warehouse_order <=", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderLike(String value) {
            addCriterion("warehouse_order like", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderNotLike(String value) {
            addCriterion("warehouse_order not like", value, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderIn(List<String> values) {
            addCriterion("warehouse_order in", values, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderNotIn(List<String> values) {
            addCriterion("warehouse_order not in", values, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderBetween(String value1, String value2) {
            addCriterion("warehouse_order between", value1, value2, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andWarehouseOrderNotBetween(String value1, String value2) {
            addCriterion("warehouse_order not between", value1, value2, "warehouseOrder");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Integer value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Integer value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Integer value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Integer value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Integer> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Integer> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Integer value1, Integer value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(BigDecimal value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(BigDecimal value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(BigDecimal value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(BigDecimal value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<BigDecimal> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<BigDecimal> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andResidueStockIsNull() {
            addCriterion("residue_stock is null");
            return (Criteria) this;
        }

        public Criteria andResidueStockIsNotNull() {
            addCriterion("residue_stock is not null");
            return (Criteria) this;
        }

        public Criteria andResidueStockEqualTo(BigDecimal value) {
            addCriterion("residue_stock =", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockNotEqualTo(BigDecimal value) {
            addCriterion("residue_stock <>", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockGreaterThan(BigDecimal value) {
            addCriterion("residue_stock >", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("residue_stock >=", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockLessThan(BigDecimal value) {
            addCriterion("residue_stock <", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("residue_stock <=", value, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockIn(List<BigDecimal> values) {
            addCriterion("residue_stock in", values, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockNotIn(List<BigDecimal> values) {
            addCriterion("residue_stock not in", values, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residue_stock between", value1, value2, "residueStock");
            return (Criteria) this;
        }

        public Criteria andResidueStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residue_stock not between", value1, value2, "residueStock");
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

        public Criteria andAllotIdIsNull() {
            addCriterion("allot_id is null");
            return (Criteria) this;
        }

        public Criteria andAllotIdIsNotNull() {
            addCriterion("allot_id is not null");
            return (Criteria) this;
        }

        public Criteria andAllotIdEqualTo(Integer value) {
            addCriterion("allot_id =", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdNotEqualTo(Integer value) {
            addCriterion("allot_id <>", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdGreaterThan(Integer value) {
            addCriterion("allot_id >", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("allot_id >=", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdLessThan(Integer value) {
            addCriterion("allot_id <", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdLessThanOrEqualTo(Integer value) {
            addCriterion("allot_id <=", value, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdIn(List<Integer> values) {
            addCriterion("allot_id in", values, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdNotIn(List<Integer> values) {
            addCriterion("allot_id not in", values, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdBetween(Integer value1, Integer value2) {
            addCriterion("allot_id between", value1, value2, "allotId");
            return (Criteria) this;
        }

        public Criteria andAllotIdNotBetween(Integer value1, Integer value2) {
            addCriterion("allot_id not between", value1, value2, "allotId");
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
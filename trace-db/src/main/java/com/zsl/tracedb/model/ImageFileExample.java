package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageFileExample() {
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

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(String value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(String value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(String value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(String value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(String value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLike(String value) {
            addCriterion("img_id like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotLike(String value) {
            addCriterion("img_id not like", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<String> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<String> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(String value1, String value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(String value1, String value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerIsNull() {
            addCriterion("img_location_server is null");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerIsNotNull() {
            addCriterion("img_location_server is not null");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerEqualTo(String value) {
            addCriterion("img_location_server =", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerNotEqualTo(String value) {
            addCriterion("img_location_server <>", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerGreaterThan(String value) {
            addCriterion("img_location_server >", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerGreaterThanOrEqualTo(String value) {
            addCriterion("img_location_server >=", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerLessThan(String value) {
            addCriterion("img_location_server <", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerLessThanOrEqualTo(String value) {
            addCriterion("img_location_server <=", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerLike(String value) {
            addCriterion("img_location_server like", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerNotLike(String value) {
            addCriterion("img_location_server not like", value, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerIn(List<String> values) {
            addCriterion("img_location_server in", values, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerNotIn(List<String> values) {
            addCriterion("img_location_server not in", values, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerBetween(String value1, String value2) {
            addCriterion("img_location_server between", value1, value2, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationServerNotBetween(String value1, String value2) {
            addCriterion("img_location_server not between", value1, value2, "imgLocationServer");
            return (Criteria) this;
        }

        public Criteria andImgLocationIsNull() {
            addCriterion("img_location is null");
            return (Criteria) this;
        }

        public Criteria andImgLocationIsNotNull() {
            addCriterion("img_location is not null");
            return (Criteria) this;
        }

        public Criteria andImgLocationEqualTo(String value) {
            addCriterion("img_location =", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationNotEqualTo(String value) {
            addCriterion("img_location <>", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationGreaterThan(String value) {
            addCriterion("img_location >", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationGreaterThanOrEqualTo(String value) {
            addCriterion("img_location >=", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationLessThan(String value) {
            addCriterion("img_location <", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationLessThanOrEqualTo(String value) {
            addCriterion("img_location <=", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationLike(String value) {
            addCriterion("img_location like", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationNotLike(String value) {
            addCriterion("img_location not like", value, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationIn(List<String> values) {
            addCriterion("img_location in", values, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationNotIn(List<String> values) {
            addCriterion("img_location not in", values, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationBetween(String value1, String value2) {
            addCriterion("img_location between", value1, value2, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgLocationNotBetween(String value1, String value2) {
            addCriterion("img_location not between", value1, value2, "imgLocation");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNull() {
            addCriterion("img_url is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlIsNotNull() {
            addCriterion("img_url is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlEqualTo(String value) {
            addCriterion("img_url =", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotEqualTo(String value) {
            addCriterion("img_url <>", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThan(String value) {
            addCriterion("img_url >", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("img_url >=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThan(String value) {
            addCriterion("img_url <", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLessThanOrEqualTo(String value) {
            addCriterion("img_url <=", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlLike(String value) {
            addCriterion("img_url like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotLike(String value) {
            addCriterion("img_url not like", value, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlIn(List<String> values) {
            addCriterion("img_url in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotIn(List<String> values) {
            addCriterion("img_url not in", values, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlBetween(String value1, String value2) {
            addCriterion("img_url between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgUrlNotBetween(String value1, String value2) {
            addCriterion("img_url not between", value1, value2, "imgUrl");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdIsNull() {
            addCriterion("img_system_id is null");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdIsNotNull() {
            addCriterion("img_system_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdEqualTo(String value) {
            addCriterion("img_system_id =", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdNotEqualTo(String value) {
            addCriterion("img_system_id <>", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdGreaterThan(String value) {
            addCriterion("img_system_id >", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("img_system_id >=", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdLessThan(String value) {
            addCriterion("img_system_id <", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdLessThanOrEqualTo(String value) {
            addCriterion("img_system_id <=", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdLike(String value) {
            addCriterion("img_system_id like", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdNotLike(String value) {
            addCriterion("img_system_id not like", value, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdIn(List<String> values) {
            addCriterion("img_system_id in", values, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdNotIn(List<String> values) {
            addCriterion("img_system_id not in", values, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdBetween(String value1, String value2) {
            addCriterion("img_system_id between", value1, value2, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgSystemIdNotBetween(String value1, String value2) {
            addCriterion("img_system_id not between", value1, value2, "imgSystemId");
            return (Criteria) this;
        }

        public Criteria andImgFlagIsNull() {
            addCriterion("img_flag is null");
            return (Criteria) this;
        }

        public Criteria andImgFlagIsNotNull() {
            addCriterion("img_flag is not null");
            return (Criteria) this;
        }

        public Criteria andImgFlagEqualTo(String value) {
            addCriterion("img_flag =", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagNotEqualTo(String value) {
            addCriterion("img_flag <>", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagGreaterThan(String value) {
            addCriterion("img_flag >", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagGreaterThanOrEqualTo(String value) {
            addCriterion("img_flag >=", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagLessThan(String value) {
            addCriterion("img_flag <", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagLessThanOrEqualTo(String value) {
            addCriterion("img_flag <=", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagLike(String value) {
            addCriterion("img_flag like", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagNotLike(String value) {
            addCriterion("img_flag not like", value, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagIn(List<String> values) {
            addCriterion("img_flag in", values, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagNotIn(List<String> values) {
            addCriterion("img_flag not in", values, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagBetween(String value1, String value2) {
            addCriterion("img_flag between", value1, value2, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgFlagNotBetween(String value1, String value2) {
            addCriterion("img_flag not between", value1, value2, "imgFlag");
            return (Criteria) this;
        }

        public Criteria andImgAttributeIsNull() {
            addCriterion("img_attribute is null");
            return (Criteria) this;
        }

        public Criteria andImgAttributeIsNotNull() {
            addCriterion("img_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andImgAttributeEqualTo(String value) {
            addCriterion("img_attribute =", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeNotEqualTo(String value) {
            addCriterion("img_attribute <>", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeGreaterThan(String value) {
            addCriterion("img_attribute >", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeGreaterThanOrEqualTo(String value) {
            addCriterion("img_attribute >=", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeLessThan(String value) {
            addCriterion("img_attribute <", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeLessThanOrEqualTo(String value) {
            addCriterion("img_attribute <=", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeLike(String value) {
            addCriterion("img_attribute like", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeNotLike(String value) {
            addCriterion("img_attribute not like", value, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeIn(List<String> values) {
            addCriterion("img_attribute in", values, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeNotIn(List<String> values) {
            addCriterion("img_attribute not in", values, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeBetween(String value1, String value2) {
            addCriterion("img_attribute between", value1, value2, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgAttributeNotBetween(String value1, String value2) {
            addCriterion("img_attribute not between", value1, value2, "imgAttribute");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueIsNull() {
            addCriterion("img_specific_unique_value is null");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueIsNotNull() {
            addCriterion("img_specific_unique_value is not null");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueEqualTo(String value) {
            addCriterion("img_specific_unique_value =", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueNotEqualTo(String value) {
            addCriterion("img_specific_unique_value <>", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueGreaterThan(String value) {
            addCriterion("img_specific_unique_value >", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueGreaterThanOrEqualTo(String value) {
            addCriterion("img_specific_unique_value >=", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueLessThan(String value) {
            addCriterion("img_specific_unique_value <", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueLessThanOrEqualTo(String value) {
            addCriterion("img_specific_unique_value <=", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueLike(String value) {
            addCriterion("img_specific_unique_value like", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueNotLike(String value) {
            addCriterion("img_specific_unique_value not like", value, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueIn(List<String> values) {
            addCriterion("img_specific_unique_value in", values, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueNotIn(List<String> values) {
            addCriterion("img_specific_unique_value not in", values, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueBetween(String value1, String value2) {
            addCriterion("img_specific_unique_value between", value1, value2, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgSpecificUniqueValueNotBetween(String value1, String value2) {
            addCriterion("img_specific_unique_value not between", value1, value2, "imgSpecificUniqueValue");
            return (Criteria) this;
        }

        public Criteria andImgParamIsNull() {
            addCriterion("img_param is null");
            return (Criteria) this;
        }

        public Criteria andImgParamIsNotNull() {
            addCriterion("img_param is not null");
            return (Criteria) this;
        }

        public Criteria andImgParamEqualTo(String value) {
            addCriterion("img_param =", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamNotEqualTo(String value) {
            addCriterion("img_param <>", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamGreaterThan(String value) {
            addCriterion("img_param >", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamGreaterThanOrEqualTo(String value) {
            addCriterion("img_param >=", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamLessThan(String value) {
            addCriterion("img_param <", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamLessThanOrEqualTo(String value) {
            addCriterion("img_param <=", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamLike(String value) {
            addCriterion("img_param like", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamNotLike(String value) {
            addCriterion("img_param not like", value, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamIn(List<String> values) {
            addCriterion("img_param in", values, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamNotIn(List<String> values) {
            addCriterion("img_param not in", values, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamBetween(String value1, String value2) {
            addCriterion("img_param between", value1, value2, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgParamNotBetween(String value1, String value2) {
            addCriterion("img_param not between", value1, value2, "imgParam");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIsNull() {
            addCriterion("img_remark is null");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIsNotNull() {
            addCriterion("img_remark is not null");
            return (Criteria) this;
        }

        public Criteria andImgRemarkEqualTo(String value) {
            addCriterion("img_remark =", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotEqualTo(String value) {
            addCriterion("img_remark <>", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkGreaterThan(String value) {
            addCriterion("img_remark >", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("img_remark >=", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLessThan(String value) {
            addCriterion("img_remark <", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLessThanOrEqualTo(String value) {
            addCriterion("img_remark <=", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkLike(String value) {
            addCriterion("img_remark like", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotLike(String value) {
            addCriterion("img_remark not like", value, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkIn(List<String> values) {
            addCriterion("img_remark in", values, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotIn(List<String> values) {
            addCriterion("img_remark not in", values, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkBetween(String value1, String value2) {
            addCriterion("img_remark between", value1, value2, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgRemarkNotBetween(String value1, String value2) {
            addCriterion("img_remark not between", value1, value2, "imgRemark");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNull() {
            addCriterion("img_type is null");
            return (Criteria) this;
        }

        public Criteria andImgTypeIsNotNull() {
            addCriterion("img_type is not null");
            return (Criteria) this;
        }

        public Criteria andImgTypeEqualTo(String value) {
            addCriterion("img_type =", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotEqualTo(String value) {
            addCriterion("img_type <>", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThan(String value) {
            addCriterion("img_type >", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("img_type >=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThan(String value) {
            addCriterion("img_type <", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLessThanOrEqualTo(String value) {
            addCriterion("img_type <=", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeLike(String value) {
            addCriterion("img_type like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotLike(String value) {
            addCriterion("img_type not like", value, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeIn(List<String> values) {
            addCriterion("img_type in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotIn(List<String> values) {
            addCriterion("img_type not in", values, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeBetween(String value1, String value2) {
            addCriterion("img_type between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgTypeNotBetween(String value1, String value2) {
            addCriterion("img_type not between", value1, value2, "imgType");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeIsNull() {
            addCriterion("img_create_time is null");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeIsNotNull() {
            addCriterion("img_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeEqualTo(Date value) {
            addCriterion("img_create_time =", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeNotEqualTo(Date value) {
            addCriterion("img_create_time <>", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeGreaterThan(Date value) {
            addCriterion("img_create_time >", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("img_create_time >=", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeLessThan(Date value) {
            addCriterion("img_create_time <", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("img_create_time <=", value, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeIn(List<Date> values) {
            addCriterion("img_create_time in", values, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeNotIn(List<Date> values) {
            addCriterion("img_create_time not in", values, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeBetween(Date value1, Date value2) {
            addCriterion("img_create_time between", value1, value2, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("img_create_time not between", value1, value2, "imgCreateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeIsNull() {
            addCriterion("img_update_time is null");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeIsNotNull() {
            addCriterion("img_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeEqualTo(Date value) {
            addCriterion("img_update_time =", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeNotEqualTo(Date value) {
            addCriterion("img_update_time <>", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeGreaterThan(Date value) {
            addCriterion("img_update_time >", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("img_update_time >=", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeLessThan(Date value) {
            addCriterion("img_update_time <", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("img_update_time <=", value, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeIn(List<Date> values) {
            addCriterion("img_update_time in", values, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeNotIn(List<Date> values) {
            addCriterion("img_update_time not in", values, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("img_update_time between", value1, value2, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("img_update_time not between", value1, value2, "imgUpdateTime");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagIsNull() {
            addCriterion("img_open_flag is null");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagIsNotNull() {
            addCriterion("img_open_flag is not null");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagEqualTo(String value) {
            addCriterion("img_open_flag =", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagNotEqualTo(String value) {
            addCriterion("img_open_flag <>", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagGreaterThan(String value) {
            addCriterion("img_open_flag >", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagGreaterThanOrEqualTo(String value) {
            addCriterion("img_open_flag >=", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagLessThan(String value) {
            addCriterion("img_open_flag <", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagLessThanOrEqualTo(String value) {
            addCriterion("img_open_flag <=", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagLike(String value) {
            addCriterion("img_open_flag like", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagNotLike(String value) {
            addCriterion("img_open_flag not like", value, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagIn(List<String> values) {
            addCriterion("img_open_flag in", values, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagNotIn(List<String> values) {
            addCriterion("img_open_flag not in", values, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagBetween(String value1, String value2) {
            addCriterion("img_open_flag between", value1, value2, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgOpenFlagNotBetween(String value1, String value2) {
            addCriterion("img_open_flag not between", value1, value2, "imgOpenFlag");
            return (Criteria) this;
        }

        public Criteria andImgStatusIsNull() {
            addCriterion("img_status is null");
            return (Criteria) this;
        }

        public Criteria andImgStatusIsNotNull() {
            addCriterion("img_status is not null");
            return (Criteria) this;
        }

        public Criteria andImgStatusEqualTo(Integer value) {
            addCriterion("img_status =", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotEqualTo(Integer value) {
            addCriterion("img_status <>", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusGreaterThan(Integer value) {
            addCriterion("img_status >", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("img_status >=", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusLessThan(Integer value) {
            addCriterion("img_status <", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("img_status <=", value, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusIn(List<Integer> values) {
            addCriterion("img_status in", values, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotIn(List<Integer> values) {
            addCriterion("img_status not in", values, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusBetween(Integer value1, Integer value2) {
            addCriterion("img_status between", value1, value2, "imgStatus");
            return (Criteria) this;
        }

        public Criteria andImgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("img_status not between", value1, value2, "imgStatus");
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
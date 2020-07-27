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

        public Criteria andDisposeBatchNoIsNull() {
            addCriterion("dispose_batch_no is null");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoIsNotNull() {
            addCriterion("dispose_batch_no is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoEqualTo(String value) {
            addCriterion("dispose_batch_no =", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoNotEqualTo(String value) {
            addCriterion("dispose_batch_no <>", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoGreaterThan(String value) {
            addCriterion("dispose_batch_no >", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("dispose_batch_no >=", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoLessThan(String value) {
            addCriterion("dispose_batch_no <", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoLessThanOrEqualTo(String value) {
            addCriterion("dispose_batch_no <=", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoLike(String value) {
            addCriterion("dispose_batch_no like", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoNotLike(String value) {
            addCriterion("dispose_batch_no not like", value, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoIn(List<String> values) {
            addCriterion("dispose_batch_no in", values, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoNotIn(List<String> values) {
            addCriterion("dispose_batch_no not in", values, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoBetween(String value1, String value2) {
            addCriterion("dispose_batch_no between", value1, value2, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andDisposeBatchNoNotBetween(String value1, String value2) {
            addCriterion("dispose_batch_no not between", value1, value2, "disposeBatchNo");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlIsNull() {
            addCriterion("excel_file_url is null");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlIsNotNull() {
            addCriterion("excel_file_url is not null");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlEqualTo(String value) {
            addCriterion("excel_file_url =", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlNotEqualTo(String value) {
            addCriterion("excel_file_url <>", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlGreaterThan(String value) {
            addCriterion("excel_file_url >", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("excel_file_url >=", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlLessThan(String value) {
            addCriterion("excel_file_url <", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlLessThanOrEqualTo(String value) {
            addCriterion("excel_file_url <=", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlLike(String value) {
            addCriterion("excel_file_url like", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlNotLike(String value) {
            addCriterion("excel_file_url not like", value, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlIn(List<String> values) {
            addCriterion("excel_file_url in", values, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlNotIn(List<String> values) {
            addCriterion("excel_file_url not in", values, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlBetween(String value1, String value2) {
            addCriterion("excel_file_url between", value1, value2, "excelFileUrl");
            return (Criteria) this;
        }

        public Criteria andExcelFileUrlNotBetween(String value1, String value2) {
            addCriterion("excel_file_url not between", value1, value2, "excelFileUrl");
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

        public Criteria andDisposeSiteIsNull() {
            addCriterion("dispose_site is null");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteIsNotNull() {
            addCriterion("dispose_site is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteEqualTo(String value) {
            addCriterion("dispose_site =", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteNotEqualTo(String value) {
            addCriterion("dispose_site <>", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteGreaterThan(String value) {
            addCriterion("dispose_site >", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteGreaterThanOrEqualTo(String value) {
            addCriterion("dispose_site >=", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteLessThan(String value) {
            addCriterion("dispose_site <", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteLessThanOrEqualTo(String value) {
            addCriterion("dispose_site <=", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteLike(String value) {
            addCriterion("dispose_site like", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteNotLike(String value) {
            addCriterion("dispose_site not like", value, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteIn(List<String> values) {
            addCriterion("dispose_site in", values, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteNotIn(List<String> values) {
            addCriterion("dispose_site not in", values, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteBetween(String value1, String value2) {
            addCriterion("dispose_site between", value1, value2, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeSiteNotBetween(String value1, String value2) {
            addCriterion("dispose_site not between", value1, value2, "disposeSite");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIsNull() {
            addCriterion("dispose_count is null");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIsNotNull() {
            addCriterion("dispose_count is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeCountEqualTo(Integer value) {
            addCriterion("dispose_count =", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotEqualTo(Integer value) {
            addCriterion("dispose_count <>", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountGreaterThan(Integer value) {
            addCriterion("dispose_count >", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispose_count >=", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountLessThan(Integer value) {
            addCriterion("dispose_count <", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountLessThanOrEqualTo(Integer value) {
            addCriterion("dispose_count <=", value, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountIn(List<Integer> values) {
            addCriterion("dispose_count in", values, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotIn(List<Integer> values) {
            addCriterion("dispose_count not in", values, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountBetween(Integer value1, Integer value2) {
            addCriterion("dispose_count between", value1, value2, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDisposeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("dispose_count not between", value1, value2, "disposeCount");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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
package com.zsl.tracedb.model;

import java.util.ArrayList;
import java.util.List;

public class MerchantPapersGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantPapersGroupExample() {
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

        public Criteria andPapersGroupIdIsNull() {
            addCriterion("papers_group_id is null");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdIsNotNull() {
            addCriterion("papers_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdEqualTo(Integer value) {
            addCriterion("papers_group_id =", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdNotEqualTo(Integer value) {
            addCriterion("papers_group_id <>", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdGreaterThan(Integer value) {
            addCriterion("papers_group_id >", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("papers_group_id >=", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdLessThan(Integer value) {
            addCriterion("papers_group_id <", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("papers_group_id <=", value, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdIn(List<Integer> values) {
            addCriterion("papers_group_id in", values, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdNotIn(List<Integer> values) {
            addCriterion("papers_group_id not in", values, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("papers_group_id between", value1, value2, "papersGroupId");
            return (Criteria) this;
        }

        public Criteria andPapersGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("papers_group_id not between", value1, value2, "papersGroupId");
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

        public Criteria andMerchantLogoUrlIsNull() {
            addCriterion("merchant_logo_url is null");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlIsNotNull() {
            addCriterion("merchant_logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlEqualTo(String value) {
            addCriterion("merchant_logo_url =", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlNotEqualTo(String value) {
            addCriterion("merchant_logo_url <>", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlGreaterThan(String value) {
            addCriterion("merchant_logo_url >", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_logo_url >=", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlLessThan(String value) {
            addCriterion("merchant_logo_url <", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("merchant_logo_url <=", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlLike(String value) {
            addCriterion("merchant_logo_url like", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlNotLike(String value) {
            addCriterion("merchant_logo_url not like", value, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlIn(List<String> values) {
            addCriterion("merchant_logo_url in", values, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlNotIn(List<String> values) {
            addCriterion("merchant_logo_url not in", values, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlBetween(String value1, String value2) {
            addCriterion("merchant_logo_url between", value1, value2, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andMerchantLogoUrlNotBetween(String value1, String value2) {
            addCriterion("merchant_logo_url not between", value1, value2, "merchantLogoUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlIsNull() {
            addCriterion("product_test_report_url is null");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlIsNotNull() {
            addCriterion("product_test_report_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlEqualTo(String value) {
            addCriterion("product_test_report_url =", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlNotEqualTo(String value) {
            addCriterion("product_test_report_url <>", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlGreaterThan(String value) {
            addCriterion("product_test_report_url >", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlGreaterThanOrEqualTo(String value) {
            addCriterion("product_test_report_url >=", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlLessThan(String value) {
            addCriterion("product_test_report_url <", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlLessThanOrEqualTo(String value) {
            addCriterion("product_test_report_url <=", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlLike(String value) {
            addCriterion("product_test_report_url like", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlNotLike(String value) {
            addCriterion("product_test_report_url not like", value, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlIn(List<String> values) {
            addCriterion("product_test_report_url in", values, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlNotIn(List<String> values) {
            addCriterion("product_test_report_url not in", values, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlBetween(String value1, String value2) {
            addCriterion("product_test_report_url between", value1, value2, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andProductTestReportUrlNotBetween(String value1, String value2) {
            addCriterion("product_test_report_url not between", value1, value2, "productTestReportUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlIsNull() {
            addCriterion("hygienic_license_url is null");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlIsNotNull() {
            addCriterion("hygienic_license_url is not null");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlEqualTo(String value) {
            addCriterion("hygienic_license_url =", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlNotEqualTo(String value) {
            addCriterion("hygienic_license_url <>", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlGreaterThan(String value) {
            addCriterion("hygienic_license_url >", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("hygienic_license_url >=", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlLessThan(String value) {
            addCriterion("hygienic_license_url <", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("hygienic_license_url <=", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlLike(String value) {
            addCriterion("hygienic_license_url like", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlNotLike(String value) {
            addCriterion("hygienic_license_url not like", value, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlIn(List<String> values) {
            addCriterion("hygienic_license_url in", values, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlNotIn(List<String> values) {
            addCriterion("hygienic_license_url not in", values, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlBetween(String value1, String value2) {
            addCriterion("hygienic_license_url between", value1, value2, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("hygienic_license_url not between", value1, value2, "hygienicLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlIsNull() {
            addCriterion("business_certificate_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlIsNotNull() {
            addCriterion("business_certificate_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlEqualTo(String value) {
            addCriterion("business_certificate_url =", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlNotEqualTo(String value) {
            addCriterion("business_certificate_url <>", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlGreaterThan(String value) {
            addCriterion("business_certificate_url >", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_certificate_url >=", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlLessThan(String value) {
            addCriterion("business_certificate_url <", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlLessThanOrEqualTo(String value) {
            addCriterion("business_certificate_url <=", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlLike(String value) {
            addCriterion("business_certificate_url like", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlNotLike(String value) {
            addCriterion("business_certificate_url not like", value, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlIn(List<String> values) {
            addCriterion("business_certificate_url in", values, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlNotIn(List<String> values) {
            addCriterion("business_certificate_url not in", values, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlBetween(String value1, String value2) {
            addCriterion("business_certificate_url between", value1, value2, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessCertificateUrlNotBetween(String value1, String value2) {
            addCriterion("business_certificate_url not between", value1, value2, "businessCertificateUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlIsNull() {
            addCriterion("product_certification_url is null");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlIsNotNull() {
            addCriterion("product_certification_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlEqualTo(String value) {
            addCriterion("product_certification_url =", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlNotEqualTo(String value) {
            addCriterion("product_certification_url <>", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlGreaterThan(String value) {
            addCriterion("product_certification_url >", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlGreaterThanOrEqualTo(String value) {
            addCriterion("product_certification_url >=", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlLessThan(String value) {
            addCriterion("product_certification_url <", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlLessThanOrEqualTo(String value) {
            addCriterion("product_certification_url <=", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlLike(String value) {
            addCriterion("product_certification_url like", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlNotLike(String value) {
            addCriterion("product_certification_url not like", value, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlIn(List<String> values) {
            addCriterion("product_certification_url in", values, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlNotIn(List<String> values) {
            addCriterion("product_certification_url not in", values, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlBetween(String value1, String value2) {
            addCriterion("product_certification_url between", value1, value2, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductCertificationUrlNotBetween(String value1, String value2) {
            addCriterion("product_certification_url not between", value1, value2, "productCertificationUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlIsNull() {
            addCriterion("production_licence_url is null");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlIsNotNull() {
            addCriterion("production_licence_url is not null");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlEqualTo(String value) {
            addCriterion("production_licence_url =", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlNotEqualTo(String value) {
            addCriterion("production_licence_url <>", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlGreaterThan(String value) {
            addCriterion("production_licence_url >", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("production_licence_url >=", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlLessThan(String value) {
            addCriterion("production_licence_url <", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlLessThanOrEqualTo(String value) {
            addCriterion("production_licence_url <=", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlLike(String value) {
            addCriterion("production_licence_url like", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlNotLike(String value) {
            addCriterion("production_licence_url not like", value, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlIn(List<String> values) {
            addCriterion("production_licence_url in", values, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlNotIn(List<String> values) {
            addCriterion("production_licence_url not in", values, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlBetween(String value1, String value2) {
            addCriterion("production_licence_url between", value1, value2, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andProductionLicenceUrlNotBetween(String value1, String value2) {
            addCriterion("production_licence_url not between", value1, value2, "productionLicenceUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlIsNull() {
            addCriterion("warenzeichenlizenz_url is null");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlIsNotNull() {
            addCriterion("warenzeichenlizenz_url is not null");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlEqualTo(String value) {
            addCriterion("warenzeichenlizenz_url =", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlNotEqualTo(String value) {
            addCriterion("warenzeichenlizenz_url <>", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlGreaterThan(String value) {
            addCriterion("warenzeichenlizenz_url >", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlGreaterThanOrEqualTo(String value) {
            addCriterion("warenzeichenlizenz_url >=", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlLessThan(String value) {
            addCriterion("warenzeichenlizenz_url <", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlLessThanOrEqualTo(String value) {
            addCriterion("warenzeichenlizenz_url <=", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlLike(String value) {
            addCriterion("warenzeichenlizenz_url like", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlNotLike(String value) {
            addCriterion("warenzeichenlizenz_url not like", value, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlIn(List<String> values) {
            addCriterion("warenzeichenlizenz_url in", values, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlNotIn(List<String> values) {
            addCriterion("warenzeichenlizenz_url not in", values, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlBetween(String value1, String value2) {
            addCriterion("warenzeichenlizenz_url between", value1, value2, "warenzeichenlizenzUrl");
            return (Criteria) this;
        }

        public Criteria andWarenzeichenlizenzUrlNotBetween(String value1, String value2) {
            addCriterion("warenzeichenlizenz_url not between", value1, value2, "warenzeichenlizenzUrl");
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
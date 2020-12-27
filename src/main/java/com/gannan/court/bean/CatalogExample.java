package com.gannan.court.bean;

import java.util.ArrayList;
import java.util.List;

public class CatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatalogExample() {
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

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTitlenameIsNull() {
            addCriterion("titlename is null");
            return (Criteria) this;
        }

        public Criteria andTitlenameIsNotNull() {
            addCriterion("titlename is not null");
            return (Criteria) this;
        }

        public Criteria andTitlenameEqualTo(String value) {
            addCriterion("titlename =", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotEqualTo(String value) {
            addCriterion("titlename <>", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameGreaterThan(String value) {
            addCriterion("titlename >", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameGreaterThanOrEqualTo(String value) {
            addCriterion("titlename >=", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLessThan(String value) {
            addCriterion("titlename <", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLessThanOrEqualTo(String value) {
            addCriterion("titlename <=", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameLike(String value) {
            addCriterion("titlename like", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotLike(String value) {
            addCriterion("titlename not like", value, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameIn(List<String> values) {
            addCriterion("titlename in", values, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotIn(List<String> values) {
            addCriterion("titlename not in", values, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameBetween(String value1, String value2) {
            addCriterion("titlename between", value1, value2, "titlename");
            return (Criteria) this;
        }

        public Criteria andTitlenameNotBetween(String value1, String value2) {
            addCriterion("titlename not between", value1, value2, "titlename");
            return (Criteria) this;
        }

        public Criteria andHcategoryIsNull() {
            addCriterion("hcategory is null");
            return (Criteria) this;
        }

        public Criteria andHcategoryIsNotNull() {
            addCriterion("hcategory is not null");
            return (Criteria) this;
        }

        public Criteria andHcategoryEqualTo(String value) {
            addCriterion("hcategory =", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotEqualTo(String value) {
            addCriterion("hcategory <>", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryGreaterThan(String value) {
            addCriterion("hcategory >", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryGreaterThanOrEqualTo(String value) {
            addCriterion("hcategory >=", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryLessThan(String value) {
            addCriterion("hcategory <", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryLessThanOrEqualTo(String value) {
            addCriterion("hcategory <=", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryLike(String value) {
            addCriterion("hcategory like", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotLike(String value) {
            addCriterion("hcategory not like", value, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryIn(List<String> values) {
            addCriterion("hcategory in", values, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotIn(List<String> values) {
            addCriterion("hcategory not in", values, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryBetween(String value1, String value2) {
            addCriterion("hcategory between", value1, value2, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHcategoryNotBetween(String value1, String value2) {
            addCriterion("hcategory not between", value1, value2, "hcategory");
            return (Criteria) this;
        }

        public Criteria andHtitlenameIsNull() {
            addCriterion("htitlename is null");
            return (Criteria) this;
        }

        public Criteria andHtitlenameIsNotNull() {
            addCriterion("htitlename is not null");
            return (Criteria) this;
        }

        public Criteria andHtitlenameEqualTo(String value) {
            addCriterion("htitlename =", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameNotEqualTo(String value) {
            addCriterion("htitlename <>", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameGreaterThan(String value) {
            addCriterion("htitlename >", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameGreaterThanOrEqualTo(String value) {
            addCriterion("htitlename >=", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameLessThan(String value) {
            addCriterion("htitlename <", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameLessThanOrEqualTo(String value) {
            addCriterion("htitlename <=", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameLike(String value) {
            addCriterion("htitlename like", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameNotLike(String value) {
            addCriterion("htitlename not like", value, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameIn(List<String> values) {
            addCriterion("htitlename in", values, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameNotIn(List<String> values) {
            addCriterion("htitlename not in", values, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameBetween(String value1, String value2) {
            addCriterion("htitlename between", value1, value2, "htitlename");
            return (Criteria) this;
        }

        public Criteria andHtitlenameNotBetween(String value1, String value2) {
            addCriterion("htitlename not between", value1, value2, "htitlename");
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
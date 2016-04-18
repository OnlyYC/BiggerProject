package com.liaoyb.persistence.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArtistIdIsNull() {
            addCriterion("artistId is null");
            return (Criteria) this;
        }

        public Criteria andArtistIdIsNotNull() {
            addCriterion("artistId is not null");
            return (Criteria) this;
        }

        public Criteria andArtistIdEqualTo(Long value) {
            addCriterion("artistId =", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdNotEqualTo(Long value) {
            addCriterion("artistId <>", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdGreaterThan(Long value) {
            addCriterion("artistId >", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdGreaterThanOrEqualTo(Long value) {
            addCriterion("artistId >=", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdLessThan(Long value) {
            addCriterion("artistId <", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdLessThanOrEqualTo(Long value) {
            addCriterion("artistId <=", value, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdIn(List<Long> values) {
            addCriterion("artistId in", values, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdNotIn(List<Long> values) {
            addCriterion("artistId not in", values, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdBetween(Long value1, Long value2) {
            addCriterion("artistId between", value1, value2, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistIdNotBetween(Long value1, Long value2) {
            addCriterion("artistId not between", value1, value2, "artistId");
            return (Criteria) this;
        }

        public Criteria andArtistNameIsNull() {
            addCriterion("artistName is null");
            return (Criteria) this;
        }

        public Criteria andArtistNameIsNotNull() {
            addCriterion("artistName is not null");
            return (Criteria) this;
        }

        public Criteria andArtistNameEqualTo(String value) {
            addCriterion("artistName =", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameNotEqualTo(String value) {
            addCriterion("artistName <>", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameGreaterThan(String value) {
            addCriterion("artistName >", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameGreaterThanOrEqualTo(String value) {
            addCriterion("artistName >=", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameLessThan(String value) {
            addCriterion("artistName <", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameLessThanOrEqualTo(String value) {
            addCriterion("artistName <=", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameLike(String value) {
            addCriterion("artistName like", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameNotLike(String value) {
            addCriterion("artistName not like", value, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameIn(List<String> values) {
            addCriterion("artistName in", values, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameNotIn(List<String> values) {
            addCriterion("artistName not in", values, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameBetween(String value1, String value2) {
            addCriterion("artistName between", value1, value2, "artistName");
            return (Criteria) this;
        }

        public Criteria andArtistNameNotBetween(String value1, String value2) {
            addCriterion("artistName not between", value1, value2, "artistName");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNull() {
            addCriterion("coverUrl is null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIsNotNull() {
            addCriterion("coverUrl is not null");
            return (Criteria) this;
        }

        public Criteria andCoverUrlEqualTo(String value) {
            addCriterion("coverUrl =", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotEqualTo(String value) {
            addCriterion("coverUrl <>", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThan(String value) {
            addCriterion("coverUrl >", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlGreaterThanOrEqualTo(String value) {
            addCriterion("coverUrl >=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThan(String value) {
            addCriterion("coverUrl <", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLessThanOrEqualTo(String value) {
            addCriterion("coverUrl <=", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlLike(String value) {
            addCriterion("coverUrl like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotLike(String value) {
            addCriterion("coverUrl not like", value, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlIn(List<String> values) {
            addCriterion("coverUrl in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotIn(List<String> values) {
            addCriterion("coverUrl not in", values, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlBetween(String value1, String value2) {
            addCriterion("coverUrl between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCoverUrlNotBetween(String value1, String value2) {
            addCriterion("coverUrl not between", value1, value2, "coverUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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
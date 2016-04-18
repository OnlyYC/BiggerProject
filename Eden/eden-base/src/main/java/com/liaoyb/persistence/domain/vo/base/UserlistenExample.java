package com.liaoyb.persistence.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

public class UserlistenExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserlistenExample() {
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

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Long value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Long value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Long value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Long value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Long value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Long value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Long> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Long> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Long value1, Long value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Long value1, Long value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNull() {
            addCriterion("playCount is null");
            return (Criteria) this;
        }

        public Criteria andPlayCountIsNotNull() {
            addCriterion("playCount is not null");
            return (Criteria) this;
        }

        public Criteria andPlayCountEqualTo(Long value) {
            addCriterion("playCount =", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotEqualTo(Long value) {
            addCriterion("playCount <>", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThan(Long value) {
            addCriterion("playCount >", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountGreaterThanOrEqualTo(Long value) {
            addCriterion("playCount >=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThan(Long value) {
            addCriterion("playCount <", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountLessThanOrEqualTo(Long value) {
            addCriterion("playCount <=", value, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountIn(List<Long> values) {
            addCriterion("playCount in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotIn(List<Long> values) {
            addCriterion("playCount not in", values, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountBetween(Long value1, Long value2) {
            addCriterion("playCount between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andPlayCountNotBetween(Long value1, Long value2) {
            addCriterion("playCount not between", value1, value2, "playCount");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNull() {
            addCriterion("songId is null");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNotNull() {
            addCriterion("songId is not null");
            return (Criteria) this;
        }

        public Criteria andSongIdEqualTo(Long value) {
            addCriterion("songId =", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotEqualTo(Long value) {
            addCriterion("songId <>", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThan(Long value) {
            addCriterion("songId >", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThanOrEqualTo(Long value) {
            addCriterion("songId >=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThan(Long value) {
            addCriterion("songId <", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThanOrEqualTo(Long value) {
            addCriterion("songId <=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdIn(List<Long> values) {
            addCriterion("songId in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotIn(List<Long> values) {
            addCriterion("songId not in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdBetween(Long value1, Long value2) {
            addCriterion("songId between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotBetween(Long value1, Long value2) {
            addCriterion("songId not between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNull() {
            addCriterion("songName is null");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNotNull() {
            addCriterion("songName is not null");
            return (Criteria) this;
        }

        public Criteria andSongNameEqualTo(String value) {
            addCriterion("songName =", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotEqualTo(String value) {
            addCriterion("songName <>", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThan(String value) {
            addCriterion("songName >", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThanOrEqualTo(String value) {
            addCriterion("songName >=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThan(String value) {
            addCriterion("songName <", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThanOrEqualTo(String value) {
            addCriterion("songName <=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLike(String value) {
            addCriterion("songName like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotLike(String value) {
            addCriterion("songName not like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameIn(List<String> values) {
            addCriterion("songName in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotIn(List<String> values) {
            addCriterion("songName not in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameBetween(String value1, String value2) {
            addCriterion("songName between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotBetween(String value1, String value2) {
            addCriterion("songName not between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
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
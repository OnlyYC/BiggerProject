package com.liaoyb.persistence.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

public class MessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessExample() {
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Long value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Long value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Long value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Long value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Long value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Long value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Long> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Long> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Long value1, Long value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Long value1, Long value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarIsNull() {
            addCriterion("fromUserAvatar is null");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarIsNotNull() {
            addCriterion("fromUserAvatar is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarEqualTo(String value) {
            addCriterion("fromUserAvatar =", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarNotEqualTo(String value) {
            addCriterion("fromUserAvatar <>", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarGreaterThan(String value) {
            addCriterion("fromUserAvatar >", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("fromUserAvatar >=", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarLessThan(String value) {
            addCriterion("fromUserAvatar <", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarLessThanOrEqualTo(String value) {
            addCriterion("fromUserAvatar <=", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarLike(String value) {
            addCriterion("fromUserAvatar like", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarNotLike(String value) {
            addCriterion("fromUserAvatar not like", value, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarIn(List<String> values) {
            addCriterion("fromUserAvatar in", values, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarNotIn(List<String> values) {
            addCriterion("fromUserAvatar not in", values, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarBetween(String value1, String value2) {
            addCriterion("fromUserAvatar between", value1, value2, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserAvatarNotBetween(String value1, String value2) {
            addCriterion("fromUserAvatar not between", value1, value2, "fromUserAvatar");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNull() {
            addCriterion("fromUser is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNotNull() {
            addCriterion("fromUser is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserEqualTo(Long value) {
            addCriterion("fromUser =", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotEqualTo(Long value) {
            addCriterion("fromUser <>", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThan(Long value) {
            addCriterion("fromUser >", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThanOrEqualTo(Long value) {
            addCriterion("fromUser >=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThan(Long value) {
            addCriterion("fromUser <", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThanOrEqualTo(Long value) {
            addCriterion("fromUser <=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserIn(List<Long> values) {
            addCriterion("fromUser in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotIn(List<Long> values) {
            addCriterion("fromUser not in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserBetween(Long value1, Long value2) {
            addCriterion("fromUser between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotBetween(Long value1, Long value2) {
            addCriterion("fromUser not between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIsNull() {
            addCriterion("fromUserName is null");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIsNotNull() {
            addCriterion("fromUserName is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserNameEqualTo(String value) {
            addCriterion("fromUserName =", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotEqualTo(String value) {
            addCriterion("fromUserName <>", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameGreaterThan(String value) {
            addCriterion("fromUserName >", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("fromUserName >=", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLessThan(String value) {
            addCriterion("fromUserName <", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLessThanOrEqualTo(String value) {
            addCriterion("fromUserName <=", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameLike(String value) {
            addCriterion("fromUserName like", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotLike(String value) {
            addCriterion("fromUserName not like", value, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameIn(List<String> values) {
            addCriterion("fromUserName in", values, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotIn(List<String> values) {
            addCriterion("fromUserName not in", values, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameBetween(String value1, String value2) {
            addCriterion("fromUserName between", value1, value2, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andFromUserNameNotBetween(String value1, String value2) {
            addCriterion("fromUserName not between", value1, value2, "fromUserName");
            return (Criteria) this;
        }

        public Criteria andLookedIsNull() {
            addCriterion("looked is null");
            return (Criteria) this;
        }

        public Criteria andLookedIsNotNull() {
            addCriterion("looked is not null");
            return (Criteria) this;
        }

        public Criteria andLookedEqualTo(Long value) {
            addCriterion("looked =", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedNotEqualTo(Long value) {
            addCriterion("looked <>", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedGreaterThan(Long value) {
            addCriterion("looked >", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedGreaterThanOrEqualTo(Long value) {
            addCriterion("looked >=", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedLessThan(Long value) {
            addCriterion("looked <", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedLessThanOrEqualTo(Long value) {
            addCriterion("looked <=", value, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedIn(List<Long> values) {
            addCriterion("looked in", values, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedNotIn(List<Long> values) {
            addCriterion("looked not in", values, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedBetween(Long value1, Long value2) {
            addCriterion("looked between", value1, value2, "looked");
            return (Criteria) this;
        }

        public Criteria andLookedNotBetween(Long value1, Long value2) {
            addCriterion("looked not between", value1, value2, "looked");
            return (Criteria) this;
        }

        public Criteria andToUserIsNull() {
            addCriterion("toUser is null");
            return (Criteria) this;
        }

        public Criteria andToUserIsNotNull() {
            addCriterion("toUser is not null");
            return (Criteria) this;
        }

        public Criteria andToUserEqualTo(Long value) {
            addCriterion("toUser =", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotEqualTo(Long value) {
            addCriterion("toUser <>", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThan(Long value) {
            addCriterion("toUser >", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserGreaterThanOrEqualTo(Long value) {
            addCriterion("toUser >=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThan(Long value) {
            addCriterion("toUser <", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserLessThanOrEqualTo(Long value) {
            addCriterion("toUser <=", value, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserIn(List<Long> values) {
            addCriterion("toUser in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotIn(List<Long> values) {
            addCriterion("toUser not in", values, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserBetween(Long value1, Long value2) {
            addCriterion("toUser between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andToUserNotBetween(Long value1, Long value2) {
            addCriterion("toUser not between", value1, value2, "toUser");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Long value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Long value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Long value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Long value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Long value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Long> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Long> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Long value1, Long value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Long value1, Long value2) {
            addCriterion("type not between", value1, value2, "type");
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
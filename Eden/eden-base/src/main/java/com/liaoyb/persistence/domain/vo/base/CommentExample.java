package com.liaoyb.persistence.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andAddDateIsNull() {
            addCriterion("addDate is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("addDate is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Long value) {
            addCriterion("addDate =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Long value) {
            addCriterion("addDate <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Long value) {
            addCriterion("addDate >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Long value) {
            addCriterion("addDate >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Long value) {
            addCriterion("addDate <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Long value) {
            addCriterion("addDate <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Long> values) {
            addCriterion("addDate in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Long> values) {
            addCriterion("addDate not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Long value1, Long value2) {
            addCriterion("addDate between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Long value1, Long value2) {
            addCriterion("addDate not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andBelongIsNull() {
            addCriterion("belong is null");
            return (Criteria) this;
        }

        public Criteria andBelongIsNotNull() {
            addCriterion("belong is not null");
            return (Criteria) this;
        }

        public Criteria andBelongEqualTo(Long value) {
            addCriterion("belong =", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotEqualTo(Long value) {
            addCriterion("belong <>", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThan(Long value) {
            addCriterion("belong >", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongGreaterThanOrEqualTo(Long value) {
            addCriterion("belong >=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThan(Long value) {
            addCriterion("belong <", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongLessThanOrEqualTo(Long value) {
            addCriterion("belong <=", value, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongIn(List<Long> values) {
            addCriterion("belong in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotIn(List<Long> values) {
            addCriterion("belong not in", values, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongBetween(Long value1, Long value2) {
            addCriterion("belong between", value1, value2, "belong");
            return (Criteria) this;
        }

        public Criteria andBelongNotBetween(Long value1, Long value2) {
            addCriterion("belong not between", value1, value2, "belong");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIsNull() {
            addCriterion("fatherCommentId is null");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIsNotNull() {
            addCriterion("fatherCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdEqualTo(Long value) {
            addCriterion("fatherCommentId =", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotEqualTo(Long value) {
            addCriterion("fatherCommentId <>", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdGreaterThan(Long value) {
            addCriterion("fatherCommentId >", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("fatherCommentId >=", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdLessThan(Long value) {
            addCriterion("fatherCommentId <", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdLessThanOrEqualTo(Long value) {
            addCriterion("fatherCommentId <=", value, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdIn(List<Long> values) {
            addCriterion("fatherCommentId in", values, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotIn(List<Long> values) {
            addCriterion("fatherCommentId not in", values, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdBetween(Long value1, Long value2) {
            addCriterion("fatherCommentId between", value1, value2, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andFatherCommentIdNotBetween(Long value1, Long value2) {
            addCriterion("fatherCommentId not between", value1, value2, "fatherCommentId");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIsNull() {
            addCriterion("praiseCount is null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIsNotNull() {
            addCriterion("praiseCount is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseCountEqualTo(Long value) {
            addCriterion("praiseCount =", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotEqualTo(Long value) {
            addCriterion("praiseCount <>", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThan(Long value) {
            addCriterion("praiseCount >", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountGreaterThanOrEqualTo(Long value) {
            addCriterion("praiseCount >=", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThan(Long value) {
            addCriterion("praiseCount <", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountLessThanOrEqualTo(Long value) {
            addCriterion("praiseCount <=", value, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountIn(List<Long> values) {
            addCriterion("praiseCount in", values, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotIn(List<Long> values) {
            addCriterion("praiseCount not in", values, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountBetween(Long value1, Long value2) {
            addCriterion("praiseCount between", value1, value2, "praiseCount");
            return (Criteria) this;
        }

        public Criteria andPraiseCountNotBetween(Long value1, Long value2) {
            addCriterion("praiseCount not between", value1, value2, "praiseCount");
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

        public Criteria andUserAvatarUrlIsNull() {
            addCriterion("userAvatarUrl is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlIsNotNull() {
            addCriterion("userAvatarUrl is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlEqualTo(String value) {
            addCriterion("userAvatarUrl =", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotEqualTo(String value) {
            addCriterion("userAvatarUrl <>", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlGreaterThan(String value) {
            addCriterion("userAvatarUrl >", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("userAvatarUrl >=", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLessThan(String value) {
            addCriterion("userAvatarUrl <", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("userAvatarUrl <=", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlLike(String value) {
            addCriterion("userAvatarUrl like", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotLike(String value) {
            addCriterion("userAvatarUrl not like", value, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlIn(List<String> values) {
            addCriterion("userAvatarUrl in", values, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotIn(List<String> values) {
            addCriterion("userAvatarUrl not in", values, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlBetween(String value1, String value2) {
            addCriterion("userAvatarUrl between", value1, value2, "userAvatarUrl");
            return (Criteria) this;
        }

        public Criteria andUserAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("userAvatarUrl not between", value1, value2, "userAvatarUrl");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
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
package com.liaoyb.persistence.domain.vo.base;

import java.util.ArrayList;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
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

        public Criteria andAlbumIdIsNull() {
            addCriterion("albumId is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNotNull() {
            addCriterion("albumId is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdEqualTo(Long value) {
            addCriterion("albumId =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(Long value) {
            addCriterion("albumId <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(Long value) {
            addCriterion("albumId >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(Long value) {
            addCriterion("albumId >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(Long value) {
            addCriterion("albumId <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(Long value) {
            addCriterion("albumId <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(List<Long> values) {
            addCriterion("albumId in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(List<Long> values) {
            addCriterion("albumId not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(Long value1, Long value2) {
            addCriterion("albumId between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(Long value1, Long value2) {
            addCriterion("albumId not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNull() {
            addCriterion("albumName is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("albumName is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("albumName =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("albumName <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("albumName >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("albumName >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("albumName <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("albumName <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("albumName like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("albumName not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(List<String> values) {
            addCriterion("albumName in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(List<String> values) {
            addCriterion("albumName not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("albumName between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("albumName not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Long value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Long value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Long value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Long value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Long value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Long value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Long> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Long> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Long value1, Long value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Long value1, Long value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collectCount is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collectCount is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Long value) {
            addCriterion("collectCount =", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Long value) {
            addCriterion("collectCount <>", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Long value) {
            addCriterion("collectCount >", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Long value) {
            addCriterion("collectCount >=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Long value) {
            addCriterion("collectCount <", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Long value) {
            addCriterion("collectCount <=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Long> values) {
            addCriterion("collectCount in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Long> values) {
            addCriterion("collectCount not in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Long value1, Long value2) {
            addCriterion("collectCount between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Long value1, Long value2) {
            addCriterion("collectCount not between", value1, value2, "collectCount");
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

        public Criteria andDownloadCountIsNull() {
            addCriterion("downloadCount is null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIsNotNull() {
            addCriterion("downloadCount is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadCountEqualTo(Long value) {
            addCriterion("downloadCount =", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotEqualTo(Long value) {
            addCriterion("downloadCount <>", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThan(Long value) {
            addCriterion("downloadCount >", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountGreaterThanOrEqualTo(Long value) {
            addCriterion("downloadCount >=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThan(Long value) {
            addCriterion("downloadCount <", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountLessThanOrEqualTo(Long value) {
            addCriterion("downloadCount <=", value, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountIn(List<Long> values) {
            addCriterion("downloadCount in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotIn(List<Long> values) {
            addCriterion("downloadCount not in", values, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountBetween(Long value1, Long value2) {
            addCriterion("downloadCount between", value1, value2, "downloadCount");
            return (Criteria) this;
        }

        public Criteria andDownloadCountNotBetween(Long value1, Long value2) {
            addCriterion("downloadCount not between", value1, value2, "downloadCount");
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

        public Criteria andLyricIsNull() {
            addCriterion("lyric is null");
            return (Criteria) this;
        }

        public Criteria andLyricIsNotNull() {
            addCriterion("lyric is not null");
            return (Criteria) this;
        }

        public Criteria andLyricEqualTo(String value) {
            addCriterion("lyric =", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotEqualTo(String value) {
            addCriterion("lyric <>", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThan(String value) {
            addCriterion("lyric >", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThanOrEqualTo(String value) {
            addCriterion("lyric >=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThan(String value) {
            addCriterion("lyric <", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThanOrEqualTo(String value) {
            addCriterion("lyric <=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLike(String value) {
            addCriterion("lyric like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotLike(String value) {
            addCriterion("lyric not like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricIn(List<String> values) {
            addCriterion("lyric in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotIn(List<String> values) {
            addCriterion("lyric not in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricBetween(String value1, String value2) {
            addCriterion("lyric between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotBetween(String value1, String value2) {
            addCriterion("lyric not between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andMvIdIsNull() {
            addCriterion("mvId is null");
            return (Criteria) this;
        }

        public Criteria andMvIdIsNotNull() {
            addCriterion("mvId is not null");
            return (Criteria) this;
        }

        public Criteria andMvIdEqualTo(Long value) {
            addCriterion("mvId =", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdNotEqualTo(Long value) {
            addCriterion("mvId <>", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdGreaterThan(Long value) {
            addCriterion("mvId >", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mvId >=", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdLessThan(Long value) {
            addCriterion("mvId <", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdLessThanOrEqualTo(Long value) {
            addCriterion("mvId <=", value, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdIn(List<Long> values) {
            addCriterion("mvId in", values, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdNotIn(List<Long> values) {
            addCriterion("mvId not in", values, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdBetween(Long value1, Long value2) {
            addCriterion("mvId between", value1, value2, "mvId");
            return (Criteria) this;
        }

        public Criteria andMvIdNotBetween(Long value1, Long value2) {
            addCriterion("mvId not between", value1, value2, "mvId");
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

        public Criteria andPureIsNull() {
            addCriterion("pure is null");
            return (Criteria) this;
        }

        public Criteria andPureIsNotNull() {
            addCriterion("pure is not null");
            return (Criteria) this;
        }

        public Criteria andPureEqualTo(Long value) {
            addCriterion("pure =", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureNotEqualTo(Long value) {
            addCriterion("pure <>", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureGreaterThan(Long value) {
            addCriterion("pure >", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureGreaterThanOrEqualTo(Long value) {
            addCriterion("pure >=", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureLessThan(Long value) {
            addCriterion("pure <", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureLessThanOrEqualTo(Long value) {
            addCriterion("pure <=", value, "pure");
            return (Criteria) this;
        }

        public Criteria andPureIn(List<Long> values) {
            addCriterion("pure in", values, "pure");
            return (Criteria) this;
        }

        public Criteria andPureNotIn(List<Long> values) {
            addCriterion("pure not in", values, "pure");
            return (Criteria) this;
        }

        public Criteria andPureBetween(Long value1, Long value2) {
            addCriterion("pure between", value1, value2, "pure");
            return (Criteria) this;
        }

        public Criteria andPureNotBetween(Long value1, Long value2) {
            addCriterion("pure not between", value1, value2, "pure");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("releaseTime is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("releaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Long value) {
            addCriterion("releaseTime =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Long value) {
            addCriterion("releaseTime <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Long value) {
            addCriterion("releaseTime >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("releaseTime >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Long value) {
            addCriterion("releaseTime <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Long value) {
            addCriterion("releaseTime <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Long> values) {
            addCriterion("releaseTime in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Long> values) {
            addCriterion("releaseTime not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Long value1, Long value2) {
            addCriterion("releaseTime between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Long value1, Long value2) {
            addCriterion("releaseTime not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyIsNull() {
            addCriterion("songFileKey is null");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyIsNotNull() {
            addCriterion("songFileKey is not null");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyEqualTo(String value) {
            addCriterion("songFileKey =", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyNotEqualTo(String value) {
            addCriterion("songFileKey <>", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyGreaterThan(String value) {
            addCriterion("songFileKey >", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyGreaterThanOrEqualTo(String value) {
            addCriterion("songFileKey >=", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyLessThan(String value) {
            addCriterion("songFileKey <", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyLessThanOrEqualTo(String value) {
            addCriterion("songFileKey <=", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyLike(String value) {
            addCriterion("songFileKey like", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyNotLike(String value) {
            addCriterion("songFileKey not like", value, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyIn(List<String> values) {
            addCriterion("songFileKey in", values, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyNotIn(List<String> values) {
            addCriterion("songFileKey not in", values, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyBetween(String value1, String value2) {
            addCriterion("songFileKey between", value1, value2, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongFileKeyNotBetween(String value1, String value2) {
            addCriterion("songFileKey not between", value1, value2, "songFileKey");
            return (Criteria) this;
        }

        public Criteria andSongUrlIsNull() {
            addCriterion("songUrl is null");
            return (Criteria) this;
        }

        public Criteria andSongUrlIsNotNull() {
            addCriterion("songUrl is not null");
            return (Criteria) this;
        }

        public Criteria andSongUrlEqualTo(String value) {
            addCriterion("songUrl =", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotEqualTo(String value) {
            addCriterion("songUrl <>", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlGreaterThan(String value) {
            addCriterion("songUrl >", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("songUrl >=", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLessThan(String value) {
            addCriterion("songUrl <", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLessThanOrEqualTo(String value) {
            addCriterion("songUrl <=", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLike(String value) {
            addCriterion("songUrl like", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotLike(String value) {
            addCriterion("songUrl not like", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlIn(List<String> values) {
            addCriterion("songUrl in", values, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotIn(List<String> values) {
            addCriterion("songUrl not in", values, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlBetween(String value1, String value2) {
            addCriterion("songUrl between", value1, value2, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotBetween(String value1, String value2) {
            addCriterion("songUrl not between", value1, value2, "songUrl");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("time not between", value1, value2, "time");
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
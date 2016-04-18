package com.liaoyb.persistence.domain.vo.base;

public class Collect {
    private Long id;

    private Long collectType;

    private Long date;

    private Long targetId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCollectType() {
        return collectType;
    }

    public void setCollectType(Long collectType) {
        this.collectType = collectType;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
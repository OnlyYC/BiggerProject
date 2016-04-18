package com.liaoyb.persistence.domain.vo.base;

public class UserPrefer {
    private Long id;

    private Float factor;

    private Long tagId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getFactor() {
        return factor;
    }

    public void setFactor(Float factor) {
        this.factor = factor;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
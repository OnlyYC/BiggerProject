package com.liaoyb.persistence.domain.vo.base;

public class UserPlayBehavior {
    private Long id;

    private Long behavior;

    private Long date;

    private Long songId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBehavior() {
        return behavior;
    }

    public void setBehavior(Long behavior) {
        this.behavior = behavior;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
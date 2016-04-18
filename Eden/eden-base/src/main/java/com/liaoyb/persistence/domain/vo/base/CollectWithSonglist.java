package com.liaoyb.persistence.domain.vo.base;

public class CollectWithSonglist {
    private Long id;

    private Long songlistId;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Long songlistId) {
        this.songlistId = songlistId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
package com.liaoyb.persistence.domain.vo.base;

public class SonglistWithType {
    private Long id;

    private Long songlistId;

    private Long typeId;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
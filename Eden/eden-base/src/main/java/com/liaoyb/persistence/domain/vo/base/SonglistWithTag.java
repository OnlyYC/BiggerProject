package com.liaoyb.persistence.domain.vo.base;

public class SonglistWithTag {
    private Long id;

    private Float ratio;

    private Long songlistId;

    private Long tagId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    public Long getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Long songlistId) {
        this.songlistId = songlistId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
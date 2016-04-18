package com.liaoyb.persistence.domain.vo.base;

public class SonglistWithSong {
    private Long id;

    private Long rank;

    private Long songId;

    private Long songlistId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Long songlistId) {
        this.songlistId = songlistId;
    }
}
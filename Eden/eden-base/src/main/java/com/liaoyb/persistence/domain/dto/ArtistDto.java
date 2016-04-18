package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.Artist;

/**
 * 歌手dto
 * @author ybliao2
 */
public class ArtistDto  extends Artist {

    //单曲数
    private Long singleSongCount;
    //专辑数
    private Long albumCount;
    //mv数
    private Long mvCount;

    //国籍(字典项对应的text)
    private String countryText;

    //性别(字典项对应的text)
    private String sexText;

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public String getSexText() {
        return sexText;
    }

    public void setSexText(String sexText) {
        this.sexText = sexText;
    }

    public Long getSingleSongCount() {
        return singleSongCount;
    }

    public void setSingleSongCount(Long singleSongCount) {
        this.singleSongCount = singleSongCount;
    }

    public Long getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Long albumCount) {
        this.albumCount = albumCount;
    }

    public Long getMvCount() {
        return mvCount;
    }

    public void setMvCount(Long mvCount) {
        this.mvCount = mvCount;
    }
}

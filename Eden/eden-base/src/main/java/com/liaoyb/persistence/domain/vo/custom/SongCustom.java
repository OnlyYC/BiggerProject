package com.liaoyb.persistence.domain.vo.custom;

import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.base.Song;

import java.util.List;

/**
 * 音乐扩展类，包含歌手信息
 *
 * @author liao
 * @create 2016-01-30-11:37
 **/
public class SongCustom extends Song{


    //对应的艺术家,可能是多个
    private List<Artist> artists;

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}

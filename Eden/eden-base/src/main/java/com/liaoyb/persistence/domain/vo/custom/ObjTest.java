package com.liaoyb.persistence.domain.vo.custom;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.vo.base.Artist;

/**
 * @author ybliao2
 */
public class ObjTest {
    private String gg;

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    private Artist artist;
    private Page<Artist> page;


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Page<Artist> getPage() {
        return page;
    }

    public void setPage(Page<Artist> page) {
        this.page = page;
    }

    private String tt;

}

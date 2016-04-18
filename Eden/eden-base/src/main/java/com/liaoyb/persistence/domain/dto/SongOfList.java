package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.custom.SongCustom;

/**
 * 榜单中音乐
 * @author ybliao2
 */
public class SongOfList extends SongCustom{
    //排名
    private Long rank;

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }
}

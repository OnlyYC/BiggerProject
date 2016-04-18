package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.Songlist;

/**
 * @author ybliao2
 */
public class SonglistCountDto extends Songlist {

    private Integer songCount;//歌曲数量，有几首

    public Integer getSongCount() {
        return songCount;
    }

    public void setSongCount(Integer songCount) {
        this.songCount = songCount;
    }
}

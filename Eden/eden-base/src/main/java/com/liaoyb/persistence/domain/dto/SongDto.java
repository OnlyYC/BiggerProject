package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.custom.SongCustom;

/**
 * 在songCustom基础上加一个字段，是否是用户(我喜欢)歌单中
 * @author ybliao2
 */
public class SongDto extends SongCustom{
    private boolean like;

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}

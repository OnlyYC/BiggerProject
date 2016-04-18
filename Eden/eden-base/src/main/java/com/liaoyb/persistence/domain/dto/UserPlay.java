package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.User;

/**
 * 用户对某首歌播放
 * @author ybliao2
 */
public class UserPlay extends User{
    //播放次数
    private Long playCount;

    public Long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Long playCount) {
        this.playCount = playCount;
    }
}

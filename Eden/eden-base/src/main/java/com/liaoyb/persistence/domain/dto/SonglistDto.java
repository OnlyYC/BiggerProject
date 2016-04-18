package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.base.Tag;

/**
 * 歌单dto
 * @author ybliao2
 */
public class SonglistDto extends Songlist{
    //用户头像
    private String userAvatar;
    //是否是当前用户创建的歌单,1-是用户的歌单，0-不是
    private Integer userOwn;

    //标签tag
    private Tag tags;

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Integer getUserOwn() {
        return userOwn;
    }

    public void setUserOwn(Integer userOwn) {
        this.userOwn = userOwn;
    }
}

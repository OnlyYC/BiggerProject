package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.SongOfList;

/**
 * 榜单服务
 * @author ybliao2
 */
public interface SongOfListService {

    /**
     * 榜单中歌曲,分页
     *
     */
    Page<SongOfList> findSongInList(Page<SongOfList> page, Long listId);


    //操作........................................................
    //插入歌曲到榜单中
}

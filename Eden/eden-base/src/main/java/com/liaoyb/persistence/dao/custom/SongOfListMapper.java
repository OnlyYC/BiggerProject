package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.SongOfList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 榜单
 * @author ybliao2
 */
public interface SongOfListMapper {


    /**
     * 榜单中歌曲
     * @param listId 榜单id(歌单id)
     * @return
     */
    List<SongOfList> findSongInList(@Param("listId") Long listId);
}

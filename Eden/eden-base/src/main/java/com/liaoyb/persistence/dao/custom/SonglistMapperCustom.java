package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.SonglistCountDto;
import com.liaoyb.persistence.domain.dto.SonglistDto;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.base.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 歌单的查询
 * @author ybliao2
 */
public interface SonglistMapperCustom {


    /**
     * 歌单的tag
     * @param songlistId
     * @return
     */
    List<Tag>findTagForSonglist(@Param("songlistId") Long songlistId);
    /**
     * SonglistDto
     * @param songlistId
     * @param userId
     * @return
     */
    SonglistDto findSonglistDto(@Param("songlistId") Long songlistId, @Param("userId") Long userId);


    /**
     * 歌单推荐,根据播放量，收藏量
     * @return 歌单
     */
    List<Songlist> findSonglistRecommend();

    /**
     * 歌单推荐(根据用户的喜好来推荐)
     * @param userId
     * @return
     */
    List<Songlist>findSonglistUserLike(@Param("userId") Long userId);

    //包含这首歌的歌单,按播放量倒序，分页
    List<Songlist>findSonglistCustomsIncludeSong(Long songId);



    /**
     * 歌单条件查询
     * @param condition
     * @return
     */
    List<Songlist>findsonglistQuery(@Param("condition") Songlist condition);


    /**
     * 歌单搜索
     * @param searchText
     * @return
     */
    List<SonglistCountDto> findSonglist(String searchText);
}

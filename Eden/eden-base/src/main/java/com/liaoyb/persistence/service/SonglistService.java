package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.dto.SonglistCountDto;
import com.liaoyb.persistence.domain.dto.SonglistDto;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;

import java.util.List;

/**
 * 歌单service
 * Created by  liao on 2016/2/5.
 */
public interface SonglistService {
    //查询..................................................


    /**
     * 歌单dto
     * @param songlistId
     * @param userId
     * @return
     */
    SonglistDto findSonglistDto(Long songlistId, Long userId);

    /**
     * 歌单详情
     * @param songlistId
     * @return
     */
    Songlist findSonglistById(Long songlistId);

    /**
     * 根据歌单id找到歌单中的歌曲
     * @param songlistId 歌单id
     * @return
     */
     List<SongCustom>findSongCustomsInSonglist(Long songlistId);



    /**
     * 歌单中的音乐SongDto,分页
     * @param page
     * @param userId
     * @return
     */
    Page<SongDto>findSongDtoInSonglist(Page<SongDto> page, Long songlistId, Long userId);




    /**
     * 歌单推荐,根据播放量，收藏量,分页
     * @param page 分页
     * @return 歌单
     */
    Page<Songlist>findSonglistRecommend(Page<Songlist> page);

    /**
     * 歌单推荐(根据用户的喜好来推荐),不能是用户自己的歌单
     * @param page
     * @return
     */
    Page<Songlist>findSonglistUserLike(Page<Songlist> page, Long userId);


    /**
     * 包含这首歌的歌单,按播放量倒序，分页
     * @param page 分页
     * @param songId 歌曲id
     * @return
     */
    Page<Songlist>findSonglistCustomsIncludeSong(Page<Songlist> page, Long songId);



    /**
     * 官方榜单
     * @return 榜单
     */
    List<Songlist> findOfficialSonglist();



    /**
     * 全球榜单
     * @return 榜单
     */
    List<Songlist>findGlobalSonglist();







    //操作..................................................


    /**
     * 删除歌单,用户只能删除自己的歌单,只是把flag置为0
     * @param songlistId 歌单id
     * @return
     */
    public boolean dealSonglistById(Long songlistId);


    /**
     * 创建歌单
     * @param songlist 歌单
     * @return
     */
    public boolean addSonglist(Songlist songlist);


    /**
     * 修改歌单
     * @param songlist 歌单
     * @return
     */
    public boolean updateSonglist(Songlist songlist);


    /**
     * 歌单搜索
     * @param page
     * @param searchText
     * @return
     */
    Page<SonglistCountDto> findSonglist(Page<SonglistCountDto> page, String searchText);

    /**
     * 歌曲是否在歌单中存在
     * @param songId
     * @param songlistId
     * @return
     */
    boolean isSongInSonglist(Long songId,Long songlistId);


    /**
     * 创建歌单
     * 不能是【我喜欢】
     * @param userId
     * @param listName
     * @return
     */
    Response createSonglist(Long userId,String listName) throws Exception;
}

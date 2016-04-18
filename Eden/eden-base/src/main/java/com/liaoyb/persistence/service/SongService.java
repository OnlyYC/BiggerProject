package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;

/**
 * 歌曲service
 * Created by  liao on 2016/2/1.
 */
public interface SongService {




    /**
     * 所有歌曲,分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom> findAllSongCustomsPage(Page<SongCustom> page, Long type);


    /**
     * 通过歌曲id找到歌曲的详细信息
     * @param id 歌曲id
     * @return 歌曲扩展
     */
    public SongCustom findSongCustomById(Long id);


    /**
     * 歌曲(MV)播放量排名，降序,分页
     * @param area 地区，字典项
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongsRankByPlayCount(Page<SongCustom> page, Long type, Long area);


    /**
     * 最新的歌曲,根据发布时间排序,分页
     * @param page 分页
     * @param type 类型，字典项
     * @param area 地区  字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findlastSongs(Page<SongCustom> page, Long type, Long area);


    /**
     * 歌曲综合排名,分页
     * @param page 分页
     * @param type 类型，字典项
     * @param area 地区  字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSonsComprehensive(Page<SongCustom> page, Long type, Long area);

    /**
     * 歌曲搜索,根据歌名进行查询,模糊查询,分页
     * @param page 分页
     * @param songName 歌名
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongCustomsQuery(Page<SongCustom> page, String songName, Long type);

    /**
     * 歌曲推荐(整体推荐,根据播放量，用户收藏来决定),分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongCustomsRecommend(Page<SongCustom> page, Long type);


    /**
     * 歌曲推荐(根据用户的喜好来推荐),分页
     * @param page 分页
     * @param userId 用户id
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongCustomsUserLike(Page<SongCustom> page, Long userId, Long type);



    /**
     * 相似歌曲推荐(相似算法),分页
     * @param page 分页
     * @param songId 歌曲id
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongCustomsSimilar(Page<SongCustom> page, Long songId);



    /**
     * 随机推荐，分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    public Page<SongCustom>findSongCustomsRandom(Page<SongCustom> page, Long type);








    //操作...................................................






    /**
     * 播放音乐，，里面要对音乐播放量加1。如果用户id不为null，
     * 要给用户添加一条播放历史或者对播放历史里面的歌曲播放数加1
     * @param userId 用户Id
     * @param songId 歌曲id
     */
    public void playSong(Long userId, Long songId);


    /**
     * 歌曲搜索
     * 区分歌曲、mv
     * @param page
     * @param type 歌曲类型,1-歌曲，2-mv
     * @param searchText
     * @return
     */
    Page<SongCustom> findSong(Page<SongCustom> page,Integer type,String searchText);


    /**
     * 歌曲是否有效
     * @param songId
     * @return
     */
    boolean isValid(Long songId);

    /**
     * 随机
     * @param page
     * @param userId
     * @param type
     * @return
     */
    Page<SongDto> findSongDtoRandom(Page<SongDto> page, Long userId, Long type);
}

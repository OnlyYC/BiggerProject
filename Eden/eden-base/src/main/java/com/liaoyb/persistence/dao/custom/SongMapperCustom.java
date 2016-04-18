package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.vo.base.Song;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 歌曲dao
 * Created by  liao on 2016/1/31.
 */
public interface SongMapperCustom {
    /**
     * 根据Id查找音乐
     * @param songId 主键
     * @return 歌曲扩展
     */
    SongCustom findSongCustomById(Long songId);

    /**
     * 根据id查找音乐，音乐是否是用户喜欢的
     * @param songId
     * @param userId
     * @return
     */
    SongDto findSongDtoById(@Param("songId") Long songId, @Param("userId") Long userId);


    /**
     * 专辑中的音乐
     * @param albumId 专辑id
     * @return 歌曲扩展集合
     */
    List<SongCustom> findSongCustomsInAlbum(@Param("albumId") Long albumId);

    /**
     * 专辑中的音乐dto
     * @param albumId
     * @param userId
     * @return
     */
    List<SongDto>findSongDtoInAlbum(@Param("albumId") Long albumId, @Param("userId") Long userId);



    /**
     * 歌单中的音乐
     * @param songlistId 歌单id
     * @return 歌曲扩展集合
     */
    List<SongCustom> findSongCustomsInSonglist(Long songlistId);



    /**
     * 歌单中的音乐SnogDto
     * @param songlistId
     * @param userId
     * @return
     */
    List<SongDto>findSongDtoInSonglist(@Param("songlistId") Long songlistId, @Param("userId") Long userId);



    /**
     * 艺术家的所有音乐
     * @param artistId 艺术家id
     * @return 歌曲扩展集合
     */
    List<SongCustom>findSongCustomsBelongToArtist(Long artistId);





    /**
     * 歌曲播放量排名
     * @param area 地区，字典项
     * @param type 类型，歌曲或MV,字典项
     * @return 歌曲扩展集合
     */
    List<SongCustom>findSongsRankByPlayCount(@Param("type") Long type, @Param("area") Long area);

    /**
     * 歌曲综合排名
     * @param type 类型，歌曲或MV,字典项
     * @param area 地区，字典项
     * @return
     */
    List<SongCustom>findSonsComprehensive(@Param("type") Long type, @Param("area") Long area);


    /**
     * 最新的歌曲,根据发布时间排序,分页
     * @param type 类型，歌曲或MV,字典项
     * @param area 地区   字典项
     * @return 歌曲扩展集合
     */
    List<SongCustom> findlastSongs(@Param("type") Long type, @Param("area") Long area);


    /**
     * 歌曲搜索
     * @param condition 条件
     * @return 歌曲扩展集合
     */
    List<SongCustom>findSongCustomsQuery(Song condition);


    /**
     * 歌曲推荐(整体推荐,根据播放量，用户收藏来决定)
     * @param type 类型，歌曲或MV,字典项
     * @return 歌曲扩展集合
     */
    List<SongCustom> findSongCustomsRecommend(@Param("type") Long type);

    /**
     * 歌曲推荐(根据用户的喜好来推荐)
     * @param userId 用户Id
     * @param type 类型，歌曲或MV,字典项
     * @return 歌曲扩展集合
     */
    List<SongCustom> findSongCustomsUserLike(@Param("userId") Long userId, @Param("type") Long type);

    /**
     * 相似歌曲推荐(相似算法)
     * @param songId 歌曲id
     * @return
     */
    List<SongCustom> findSongCustomsSimilar(@Param("songId") Long songId);

    /**
     * 随机推荐
     * @param type 类型，歌曲或MV,字典项
     * @return
     */
    List<SongCustom> findSongCustomsRandom(@Param("type") Long type);


    /**
     * 搜索歌曲
     * 区分歌曲、mv
     * @param type
     * @param searchText
     * @return
     */
    public List<SongCustom> findSong(@Param("type") Integer type,@Param("searchText") String searchText);

    /**
     * 对歌曲收藏量加1
     * @param songId
     * @return
     */
    public int addOneSongCollectCount(Long songId);

    /**
     * 随机
     * @param userId
     * @param type
     * @return
     */
    List<SongDto> findSongDtoRandom(@Param("userId") Long userId,@Param("type")Long type);
}

package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 艺术家dao
 * @author ybliao2
 */
public interface ArtistMapperCustom {


    //找到艺术家dto根据id
    ArtistDto findArtistDtoById(@Param("artistId") Long artistId);

    //根据歌曲id找到多个艺术家
    List<Artist>findArtistsBySongId(@Param("songId") Long songId);

    /**
     *热门艺术家,根据关注数
     */
    List<Artist> findHotArtists();


    /**
     * 艺术家查询(名称,国籍，性别和组合)
     */
    List<Artist> artistsQuery(@Param("artist") Artist artist);

    /**
     * 艺术家的专辑
     */
    List<Album> findAlbumsBelongToArtist(Long artistId);


    /**
     * 艺术家的所有mv或音乐
     */
    List<SongCustom> findMvBelongToArtist(@Param("artistId") Long artistId, @Param("type") Long type);

    /**
     * 歌手搜索
     * @param searchText
     * @return
     */
    List<ArtistDto> findArtist(@Param("searchText") String searchText);
}

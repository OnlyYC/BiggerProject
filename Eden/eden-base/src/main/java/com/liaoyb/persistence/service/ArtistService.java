package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;

/**
 * 艺术家service
 * Created by  liao on 2016/2/5.
 */
public interface ArtistService {


    /**
     * 歌手dto，通过歌手id
     * @param artistId
     * @return
     */
    ArtistDto findArtistDtoById(Long artistId);

    /**
     * 通过id,拿到艺术家详细信息
     * @param artistId
     * @return
     */
    Artist findArtistById(Long artistId);


    /**
     *热门艺术家,根据关注数,分页
     * @param page
     * @return
     */
    Page<Artist>findHotArtists(Page<Artist> page);



    /**
     * 艺术家查询(名称,国籍，地区,性别和组合),分页
     * @param page
     * @param artist
     * @return
     */
    Page<Artist>artistsQuery(Page<Artist> page, Artist artist);






    /**
     * 艺术家的专辑,分页
     * @param page
     * @param artistId
     * @return
     */
    Page<Album>findAlbumsBelongToArtist(Page<Album> page, Long artistId);




    /**
     * 艺术家的所有mv,分页
     * @param page
     * @param artistId
     * @return
     */
    Page<SongCustom>findMvBelongToArtist(Page<SongCustom> page, Long artistId);



    /**
     * 艺术家的所有音乐,分页
     * @param page
     * @param artistId
     * @return
     */
    Page<SongCustom>findAllSongCustomsBelontToArtist(Page<SongCustom> page, Long artistId);


    /**
     * 歌手搜索
     * @param page
     * @param searchText
     * @return
     */
    Page<ArtistDto> findArtist(Page<ArtistDto> page, String searchText);
}

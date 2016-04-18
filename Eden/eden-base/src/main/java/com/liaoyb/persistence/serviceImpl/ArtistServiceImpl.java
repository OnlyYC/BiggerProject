package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.base.ArtistMapper;
import com.liaoyb.persistence.dao.custom.ArtistMapperCustom;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ybliao2
 */
@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Autowired
    private ArtistMapperCustom artistMapperCustom;

    /**
     * 歌手dto，通过歌手id
     * @param artistId
     * @return
     */
    @Override
    public ArtistDto findArtistDtoById(Long artistId) {
        return artistMapperCustom.findArtistDtoById(artistId);
    }

    /**
     * 通过id,拿到艺术家详细信息
     * @param artistId
     * @return
     */
    @Override
    public Artist findArtistById(Long artistId) {
        return artistMapper.selectByPrimaryKey(artistId);
    }

    /**
     * 热门艺术家,根据关注数,分页
     * @param page
     * @return
     */
    @Override
    public Page<Artist> findHotArtists(Page<Artist> page) {
        List<Artist>artists=artistMapperCustom.findHotArtists();
        page.setResult(artists);
        return page;
    }

    /**
     * 艺术家查询(国籍，性别和组合),分页
     * @param page
     * @param artist
     * @return
     */
    @Override
    public Page<Artist> artistsQuery(Page<Artist> page, Artist artist) {
        List<Artist>artists=artistMapperCustom.artistsQuery(artist);
        page.setResult(artists);
        return page;
    }



    /**
     * 艺术家的专辑,分页
     * @param page
     * @param artistId
     * @return
     */
    @Override
    public Page<Album> findAlbumsBelongToArtist(Page<Album> page, Long artistId) {
        List<Album>albumList=artistMapperCustom.findAlbumsBelongToArtist(artistId);
        page.setResult(albumList);
        return page;
    }

    /**
     * 艺术家的所有mv,分页
     * @param page
     * @param artistId
     * @return
     */
    @Override
    public Page<SongCustom> findMvBelongToArtist(Page<SongCustom> page, Long artistId) {
        List<SongCustom>songCustoms=artistMapperCustom.findMvBelongToArtist(artistId, SysCode.SONG_TYPE.MV);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 艺术家的所有音乐,分页
     * @param page
     * @param artistId
     * @return
     */
    @Override
    public Page<SongCustom> findAllSongCustomsBelontToArtist(Page<SongCustom> page, Long artistId) {
        List<SongCustom>songCustoms=artistMapperCustom.findMvBelongToArtist(artistId, SysCode.SONG_TYPE.SONG);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 歌手搜索
     *
     * @param page
     * @param searchText
     * @return
     */
    @Override
    @PageAnnotation
    public Page<ArtistDto> findArtist(Page<ArtistDto> page, String searchText) {
        page.setResult(artistMapperCustom.findArtist(searchText));
        return page;
    }
}

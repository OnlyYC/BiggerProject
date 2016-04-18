package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;

import java.util.List;

/**
 * 专辑Service接口
 * @author ybliao2
 */
public interface AlbumService {


    /**
     * 通过id找到专辑
     * @param albumId
     * @return
     */
    Album findAlbumById(Long albumId);


    /**
     * 专辑中音乐,分页
     * @param albumId
     * @param userId
     * @return
     */
    Page<SongDto> findSongDtoInAlbum(Page<SongDto> page, Long albumId, Long userId);

    /**
     * 专辑中的音乐，不使用分页
     * @param albumId
     * @return
     */
    List<SongCustom>findSongCustomInAlbum(Long albumId);

    /**
     * 专辑搜索
     * @param page
     * @param searchText
     * @return
     */
    Page<Album> findAlbum(Page<Album> page, String searchText);
}

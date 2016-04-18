package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Album;

import java.util.List;

/**
 * 专辑扩展Mapper
 * @author ybliao2
 */
public interface AlbumMapperCustom {


    /**
     * 搜索专辑
     * @param searchText
     * @return
     */
    List<Album> findAlbum(String searchText);
}

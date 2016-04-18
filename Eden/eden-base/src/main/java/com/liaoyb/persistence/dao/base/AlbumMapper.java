package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.AlbumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Album record);

    int insertSelective(Album record);

    List<Album> selectByExample(AlbumExample example);

    Album selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);
}
package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SongWithArtist;
import com.liaoyb.persistence.domain.vo.base.SongWithArtistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongWithArtistMapper {
    int countByExample(SongWithArtistExample example);

    int deleteByExample(SongWithArtistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SongWithArtist record);

    int insertSelective(SongWithArtist record);

    List<SongWithArtist> selectByExample(SongWithArtistExample example);

    SongWithArtist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SongWithArtist record, @Param("example") SongWithArtistExample example);

    int updateByExample(@Param("record") SongWithArtist record, @Param("example") SongWithArtistExample example);

    int updateByPrimaryKeySelective(SongWithArtist record);

    int updateByPrimaryKey(SongWithArtist record);
}
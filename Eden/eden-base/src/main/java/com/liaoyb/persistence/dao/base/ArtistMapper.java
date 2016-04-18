package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.base.ArtistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArtistMapper {
    int countByExample(ArtistExample example);

    int deleteByExample(ArtistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Artist record);

    int insertSelective(Artist record);

    List<Artist> selectByExample(ArtistExample example);

    Artist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Artist record, @Param("example") ArtistExample example);

    int updateByExample(@Param("record") Artist record, @Param("example") ArtistExample example);

    int updateByPrimaryKeySelective(Artist record);

    int updateByPrimaryKey(Artist record);
}
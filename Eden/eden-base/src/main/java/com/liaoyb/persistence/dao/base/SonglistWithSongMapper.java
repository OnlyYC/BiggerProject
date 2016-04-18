package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SonglistWithSong;
import com.liaoyb.persistence.domain.vo.base.SonglistWithSongExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SonglistWithSongMapper {
    int countByExample(SonglistWithSongExample example);

    int deleteByExample(SonglistWithSongExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SonglistWithSong record);

    int insertSelective(SonglistWithSong record);

    List<SonglistWithSong> selectByExample(SonglistWithSongExample example);

    SonglistWithSong selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SonglistWithSong record, @Param("example") SonglistWithSongExample example);

    int updateByExample(@Param("record") SonglistWithSong record, @Param("example") SonglistWithSongExample example);

    int updateByPrimaryKeySelective(SonglistWithSong record);

    int updateByPrimaryKey(SonglistWithSong record);
}
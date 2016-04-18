package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.base.SonglistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SonglistMapper {
    int countByExample(SonglistExample example);

    int deleteByExample(SonglistExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Songlist record);

    int insertSelective(Songlist record);

    List<Songlist> selectByExample(SonglistExample example);

    Songlist selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Songlist record, @Param("example") SonglistExample example);

    int updateByExample(@Param("record") Songlist record, @Param("example") SonglistExample example);

    int updateByPrimaryKeySelective(Songlist record);

    int updateByPrimaryKey(Songlist record);
}
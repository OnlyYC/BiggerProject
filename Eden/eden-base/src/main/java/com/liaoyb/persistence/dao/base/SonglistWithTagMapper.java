package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SonglistWithTag;
import com.liaoyb.persistence.domain.vo.base.SonglistWithTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SonglistWithTagMapper {
    int countByExample(SonglistWithTagExample example);

    int deleteByExample(SonglistWithTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SonglistWithTag record);

    int insertSelective(SonglistWithTag record);

    List<SonglistWithTag> selectByExample(SonglistWithTagExample example);

    SonglistWithTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SonglistWithTag record, @Param("example") SonglistWithTagExample example);

    int updateByExample(@Param("record") SonglistWithTag record, @Param("example") SonglistWithTagExample example);

    int updateByPrimaryKeySelective(SonglistWithTag record);

    int updateByPrimaryKey(SonglistWithTag record);
}
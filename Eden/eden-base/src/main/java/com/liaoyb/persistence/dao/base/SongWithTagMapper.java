package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SongWithTag;
import com.liaoyb.persistence.domain.vo.base.SongWithTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongWithTagMapper {
    int countByExample(SongWithTagExample example);

    int deleteByExample(SongWithTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SongWithTag record);

    int insertSelective(SongWithTag record);

    List<SongWithTag> selectByExample(SongWithTagExample example);

    SongWithTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SongWithTag record, @Param("example") SongWithTagExample example);

    int updateByExample(@Param("record") SongWithTag record, @Param("example") SongWithTagExample example);

    int updateByPrimaryKeySelective(SongWithTag record);

    int updateByPrimaryKey(SongWithTag record);
}
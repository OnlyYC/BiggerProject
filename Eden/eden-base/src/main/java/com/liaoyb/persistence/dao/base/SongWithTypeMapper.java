package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SongWithType;
import com.liaoyb.persistence.domain.vo.base.SongWithTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongWithTypeMapper {
    int countByExample(SongWithTypeExample example);

    int deleteByExample(SongWithTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SongWithType record);

    int insertSelective(SongWithType record);

    List<SongWithType> selectByExample(SongWithTypeExample example);

    SongWithType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SongWithType record, @Param("example") SongWithTypeExample example);

    int updateByExample(@Param("record") SongWithType record, @Param("example") SongWithTypeExample example);

    int updateByPrimaryKeySelective(SongWithType record);

    int updateByPrimaryKey(SongWithType record);
}
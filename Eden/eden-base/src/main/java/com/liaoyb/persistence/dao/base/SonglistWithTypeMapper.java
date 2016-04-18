package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.SonglistWithType;
import com.liaoyb.persistence.domain.vo.base.SonglistWithTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SonglistWithTypeMapper {
    int countByExample(SonglistWithTypeExample example);

    int deleteByExample(SonglistWithTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SonglistWithType record);

    int insertSelective(SonglistWithType record);

    List<SonglistWithType> selectByExample(SonglistWithTypeExample example);

    SonglistWithType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SonglistWithType record, @Param("example") SonglistWithTypeExample example);

    int updateByExample(@Param("record") SonglistWithType record, @Param("example") SonglistWithTypeExample example);

    int updateByPrimaryKeySelective(SonglistWithType record);

    int updateByPrimaryKey(SonglistWithType record);
}
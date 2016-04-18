package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Tag;
import com.liaoyb.persistence.domain.vo.base.TagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    int countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    List<Tag> selectByExample(TagExample example);

    Tag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}
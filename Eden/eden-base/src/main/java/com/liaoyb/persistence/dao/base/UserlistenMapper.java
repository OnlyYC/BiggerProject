package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Userlisten;
import com.liaoyb.persistence.domain.vo.base.UserlistenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserlistenMapper {
    int countByExample(UserlistenExample example);

    int deleteByExample(UserlistenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Userlisten record);

    int insertSelective(Userlisten record);

    List<Userlisten> selectByExample(UserlistenExample example);

    Userlisten selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Userlisten record, @Param("example") UserlistenExample example);

    int updateByExample(@Param("record") Userlisten record, @Param("example") UserlistenExample example);

    int updateByPrimaryKeySelective(Userlisten record);

    int updateByPrimaryKey(Userlisten record);
}
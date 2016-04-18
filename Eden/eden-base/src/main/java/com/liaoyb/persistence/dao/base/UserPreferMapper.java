package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.UserPrefer;
import com.liaoyb.persistence.domain.vo.base.UserPreferExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPreferMapper {
    int countByExample(UserPreferExample example);

    int deleteByExample(UserPreferExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPrefer record);

    int insertSelective(UserPrefer record);

    List<UserPrefer> selectByExample(UserPreferExample example);

    UserPrefer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPrefer record, @Param("example") UserPreferExample example);

    int updateByExample(@Param("record") UserPrefer record, @Param("example") UserPreferExample example);

    int updateByPrimaryKeySelective(UserPrefer record);

    int updateByPrimaryKey(UserPrefer record);
}
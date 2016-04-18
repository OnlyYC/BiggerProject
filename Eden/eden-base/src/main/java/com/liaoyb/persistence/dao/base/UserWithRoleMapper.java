package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.UserWithRole;
import com.liaoyb.persistence.domain.vo.base.UserWithRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserWithRoleMapper {
    int countByExample(UserWithRoleExample example);

    int deleteByExample(UserWithRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserWithRole record);

    int insertSelective(UserWithRole record);

    List<UserWithRole> selectByExample(UserWithRoleExample example);

    UserWithRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserWithRole record, @Param("example") UserWithRoleExample example);

    int updateByExample(@Param("record") UserWithRole record, @Param("example") UserWithRoleExample example);

    int updateByPrimaryKeySelective(UserWithRole record);

    int updateByPrimaryKey(UserWithRole record);
}
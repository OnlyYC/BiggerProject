package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.UserPlayBehavior;
import com.liaoyb.persistence.domain.vo.base.UserPlayBehaviorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPlayBehaviorMapper {
    int countByExample(UserPlayBehaviorExample example);

    int deleteByExample(UserPlayBehaviorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPlayBehavior record);

    int insertSelective(UserPlayBehavior record);

    List<UserPlayBehavior> selectByExample(UserPlayBehaviorExample example);

    UserPlayBehavior selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPlayBehavior record, @Param("example") UserPlayBehaviorExample example);

    int updateByExample(@Param("record") UserPlayBehavior record, @Param("example") UserPlayBehaviorExample example);

    int updateByPrimaryKeySelective(UserPlayBehavior record);

    int updateByPrimaryKey(UserPlayBehavior record);
}
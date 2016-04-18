package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Mess;
import com.liaoyb.persistence.domain.vo.base.MessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessMapper {
    int countByExample(MessExample example);

    int deleteByExample(MessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Mess record);

    int insertSelective(Mess record);

    List<Mess> selectByExampleWithBLOBs(MessExample example);

    List<Mess> selectByExample(MessExample example);

    Mess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Mess record, @Param("example") MessExample example);

    int updateByExampleWithBLOBs(@Param("record") Mess record, @Param("example") MessExample example);

    int updateByExample(@Param("record") Mess record, @Param("example") MessExample example);

    int updateByPrimaryKeySelective(Mess record);

    int updateByPrimaryKeyWithBLOBs(Mess record);

    int updateByPrimaryKey(Mess record);
}
package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Zd;
import com.liaoyb.persistence.domain.vo.base.ZdExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZdMapper {
    int countByExample(ZdExample example);

    int deleteByExample(ZdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Zd record);

    int insertSelective(Zd record);

    List<Zd> selectByExample(ZdExample example);

    Zd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Zd record, @Param("example") ZdExample example);

    int updateByExample(@Param("record") Zd record, @Param("example") ZdExample example);

    int updateByPrimaryKeySelective(Zd record);

    int updateByPrimaryKey(Zd record);
}
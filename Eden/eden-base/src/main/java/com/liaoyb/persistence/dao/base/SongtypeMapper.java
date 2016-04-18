package com.liaoyb.persistence.dao.base;

import com.liaoyb.persistence.domain.vo.base.Songtype;
import com.liaoyb.persistence.domain.vo.base.SongtypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongtypeMapper {
    int countByExample(SongtypeExample example);

    int deleteByExample(SongtypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Songtype record);

    int insertSelective(Songtype record);

    List<Songtype> selectByExample(SongtypeExample example);

    Songtype selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Songtype record, @Param("example") SongtypeExample example);

    int updateByExample(@Param("record") Songtype record, @Param("example") SongtypeExample example);

    int updateByPrimaryKeySelective(Songtype record);

    int updateByPrimaryKey(Songtype record);
}
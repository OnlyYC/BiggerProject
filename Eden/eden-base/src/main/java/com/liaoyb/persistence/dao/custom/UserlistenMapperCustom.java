package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Userlisten;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户播放历史查询
 * @author ybliao2
 */
public interface UserlistenMapperCustom {

    /**
     * 按条件查询
     * @param condition
     * @return
     */
    List<Userlisten>query(@Param("condition") Userlisten condition);
}

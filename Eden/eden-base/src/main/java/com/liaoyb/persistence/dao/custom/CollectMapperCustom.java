package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏扩展
 * @author ybliao2
 */
public interface CollectMapperCustom {
    /**
     * 收藏查找
     * @param condition
     * @return
     */
    public List<Collect>findCollect(@Param("condition") Collect condition);
}

package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.DynamicDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 动态
 * @author ybliao2
 */
public interface DynamicMapperCustom {

    /**
     * 用户相关的动态
     * @param userId
     * @return
     */
    public List<DynamicDto>findDynamicRelative(@Param("userId") Long userId);

    /**
     * 用户动态
     * @param userId
     * @return
     */
    public List<DynamicDto> findUserDynamic(@Param("userId") Long userId);
}

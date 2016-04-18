package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.DynamicDto;

import java.util.List;

/**
 * 动态service接口
 * @author ybliao2
 */
public interface DynamicService {

    /**
     * 用户相关的动态,分页
     * @param userId
     * @return
     */
    public Page<DynamicDto>findDynamicRelative(Page<DynamicDto> page, Long userId);

    /**
     * 用户动态
     * @param page
     * @param userId
     * @return
     */
    public Page<DynamicDto>findUserDynamic(Page<DynamicDto> page, Long userId);
}

package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.DynamicDto;
import com.liaoyb.persistence.domain.vo.base.Dynamic;

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


    /**
     * 发布动态
     * @param dynamic
     */
    public void submitDynaic(Dynamic dynamic);

    /**
     * 赞
     * @param id
     */
    public void praise(Long id);
}

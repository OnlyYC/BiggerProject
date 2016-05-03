package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.DynamicDto;
import com.liaoyb.persistence.domain.vo.base.User;
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

    /**
     * 赞
     * @param id
     */
    int praise(Long id);


    /**
     * 当用户信息改变时，修改动态相关信息
     * @param user
     * @return
     */
    int updateDynamicWhenUserInfoUpdate(@Param("user") User user);
}

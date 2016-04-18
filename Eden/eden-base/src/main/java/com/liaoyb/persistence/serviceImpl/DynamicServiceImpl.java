package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.custom.DynamicMapperCustom;
import com.liaoyb.persistence.domain.dto.DynamicDto;
import com.liaoyb.persistence.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ybliao2
 */
@Service
public class DynamicServiceImpl implements DynamicService {

    @Autowired
    private DynamicMapperCustom dynamicMapperCustom;
    /**
     * 用户相关的动态
     *
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<DynamicDto> findDynamicRelative(Page<DynamicDto> page, Long userId) {
        page.setResult(dynamicMapperCustom.findDynamicRelative(userId));
        return page;
    }

    /**
     * 用户动态
     *
     * @param page
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<DynamicDto> findUserDynamic(Page<DynamicDto> page, Long userId) {
        page.setResult(dynamicMapperCustom.findUserDynamic(userId));
        return page;
    }
}

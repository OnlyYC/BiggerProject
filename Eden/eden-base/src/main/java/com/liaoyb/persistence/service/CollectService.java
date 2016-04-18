package com.liaoyb.persistence.service;

import com.liaoyb.base.support.exception.CustomException;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.vo.base.Collect;

/**
 * 用户收藏
 * @author ybliao2
 */
public interface CollectService {
    /**
     * 添加到收藏
     * @param collect
     * @return
     */
    public Response andToCollect(Collect collect) throws CustomException;

    /**
     * 收藏是否已存在
     * @param collect
     * @return
     */
    public boolean isExistTheCollect(Collect collect);
}

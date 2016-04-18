package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.vo.base.Mess;

/**
 * 消息service
 * @author ybliao2
 */
public interface MessService {

    /**
     * 用户的所有消息
     * @param userId
     * @return
     */
    Page<Mess> findUserAllMess(Page<Mess>page,Long userId);

    /**
     * 用户最新信息
     * @param page
     * @param userId
     * @return
     */
    Page<Mess> findUserLastMess(Page<Mess> page, Long userId,Long lastTime);

    /**
     * 用户之前未读的信息
     * @param page
     * @param userId
     * @param previousTime
     * @return
     */
    Page<Mess> findUserPreviousMess(Page<Mess> page, Long userId, Long previousTime);

    /**
     * 把消息置为已读
     * @param userId
     * @param messId
     * @return
     */
    boolean readMess(Long userId, Long[] messId);
}

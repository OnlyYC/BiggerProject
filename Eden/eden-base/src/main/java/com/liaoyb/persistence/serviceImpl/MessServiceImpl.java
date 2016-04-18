package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.custom.MessMapperCustom;
import com.liaoyb.persistence.domain.vo.base.Mess;
import com.liaoyb.persistence.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author ybliao2
 */
@Service
public class MessServiceImpl implements MessService {


    @Autowired
    private MessMapperCustom messMapperCustom;
    /**
     * 用户的所有消息
     *
     * @param page
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Mess> findUserAllMess(Page<Mess> page, Long userId) {
        page.setResult(messMapperCustom.findUserAllMess(userId));
        return page;
    }

    /**
     * 用户最新信息
     *
     * @param page
     * @param userId
     * @param lastTime
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Mess> findUserLastMess(Page<Mess> page, Long userId, Long lastTime) {
        page.setResult(messMapperCustom.findUserLastMess(userId,lastTime));
        return page;
    }

    /**
     * 用户之前未读的信息
     *
     * @param page
     * @param userId
     * @param previousTime
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Mess> findUserPreviousMess(Page<Mess> page, Long userId, Long previousTime) {
        page.setResult(messMapperCustom.findUserPreviousMess(userId,previousTime));
        return page;
    }

    /**
     * 把消息置为已读
     *
     * @param userId
     * @param messId
     * @return
     */
    @Override
    public boolean readMess(Long userId, Long[] messId) {
        Assert.notNull(messId);
        int affect=messMapperCustom.updateMessRead(userId,messId);
        if(affect==messId.length){
            return true;
        }
        return false;
    }
}

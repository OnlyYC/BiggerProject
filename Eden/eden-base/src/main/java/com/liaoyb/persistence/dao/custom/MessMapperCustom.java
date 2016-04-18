package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Mess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 信息
 * @author ybliao2
 */
public interface MessMapperCustom {
    /**
     * 用户所有消息(发送给他的)
     * @param userId
     * @return
     */
    List<Mess> findUserAllMess(@Param("userId") Long userId);

    /**
     * 用户还未查看的信息
     * @param userId
     * @return
     */
    List<Mess>findUserMessNotLook(@Param("userId") Long userId);

    /**
     * 用户最新信息
     * @param userId
     * @param lastTime 用户那边最新时间
     * @return
     */
    List<Mess>findUserLastMess(@Param("userId")Long userId,@Param("lastTime")Long lastTime);

    /**
     * 用户之前的信息(未读)
     * @param userId
     * @param previousTime
     * @return
     */
    List<Mess> findUserPreviousMess(@Param("userId") Long userId, @Param("previousTime") Long previousTime);

    /**
     * 置消息为已读
     * @param userId
     * @param messId
     * @return
     */
    int updateMessRead(@Param("userId") Long userId,@Param("messId") Long[] messId);
}

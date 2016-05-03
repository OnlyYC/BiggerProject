package com.liaoyb.persistence.service;

/**
 * 定时任务service
 * @author ybliao2
 */
public interface MyJobService {



    /**
     * 登录超时检测
     */
    void sessionTimeOutDetect();



    /**
     * 每日推荐
     */
    void generateTipList();


    /**
     * 统计用户播放信息得到用户偏好
     */
    void generateUserPreference();
}

package com.liaoyb.persistence.service;

import com.liaoyb.persistence.domain.dto.UserStatisticsInfo;

/**
 * 统计service
 * @author ybliao2
 */

public interface StatisticsService {

    //用户各种统计信息(当前在线用户数，总用户数,今日新增用户数,最近20天用户登录登录情况,)
    UserStatisticsInfo userStatistics();




}

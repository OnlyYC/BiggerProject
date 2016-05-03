package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.UserStatisticsInfo;

/**
 * 统计mapper
 * @author ybliao2
 */
public interface StatisticsMapper {

    UserStatisticsInfo userStatistics();

    /**
     * 时间段用户的访问量
     * @param begTime
     * @param endTime
     * @return
     */
    int userAccessCount(Long begTime,Long endTime);
}

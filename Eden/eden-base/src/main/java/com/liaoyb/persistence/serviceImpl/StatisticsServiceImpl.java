package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.persistence.dao.custom.StatisticsMapper;
import com.liaoyb.persistence.domain.dto.UserStatisticsInfo;
import com.liaoyb.persistence.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ybliao2
 */
@Service
public class StatisticsServiceImpl implements StatisticsService{

    @Autowired
    private StatisticsMapper statisticsMapper;
    @Override
    public UserStatisticsInfo userStatistics() {
        return statisticsMapper.userStatistics();
    }
}

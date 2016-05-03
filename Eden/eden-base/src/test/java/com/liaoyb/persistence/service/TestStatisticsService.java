package com.liaoyb.persistence.service;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.domain.dto.UserStatisticsInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统计
 * @author ybliao2
 */
public class TestStatisticsService extends SpringTest{

    Logger logger= LoggerFactory.getLogger(TestStatisticsService.class);
    @Autowired
    private StatisticsService statisticsService;


    @Test
    public void tsetUserStatistics(){
        UserStatisticsInfo statisticsInfo=statisticsService.userStatistics();
        logger.debug("statisticsInfo{}",statisticsInfo);
    }

}

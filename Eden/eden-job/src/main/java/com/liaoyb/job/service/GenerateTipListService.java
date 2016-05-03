package com.liaoyb.job.service;

import com.liaoyb.persistence.service.MyJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 生成每日推荐列表
 * @author ybliao2
 */
public class GenerateTipListService {
    private static Logger logger= LoggerFactory.getLogger(GenerateTipListService.class);


    @Autowired
    private MyJobService myJobService;
    public void execute(){
        logger.debug("生成每日推荐列表开始");

        try {
            myJobService.generateUserPreference();
        }catch (Exception e){
            logger.error("生成每日推荐列表异常",e);
        }

        logger.debug("生成每日推荐列表结束");
    }
}

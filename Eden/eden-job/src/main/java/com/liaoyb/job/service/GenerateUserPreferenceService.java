package com.liaoyb.job.service;

import com.liaoyb.persistence.service.MyJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 统计用户播放记录生成用户偏好
 * @author ybliao2
 */
public class GenerateUserPreferenceService {
    private static Logger logger= LoggerFactory.getLogger(GenerateUserPreferenceService.class);

    @Autowired
    private MyJobService myJobService;

    public void execute(){
        logger.debug("生成用户偏好开始");

        try {
            myJobService.generateUserPreference();
        }catch (Exception e){
            logger.error("生成用户偏好异常",e);
        }

        logger.debug("生成用户偏好结束");
    }
}

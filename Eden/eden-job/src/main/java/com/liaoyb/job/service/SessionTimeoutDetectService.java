package com.liaoyb.job.service;

import com.liaoyb.persistence.service.MyJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 会话超时检测
 * @author ybliao2
 */
public class SessionTimeoutDetectService {
    private static Logger logger= LoggerFactory.getLogger(SessionTimeoutDetectService.class);

    @Autowired
    private MyJobService myJobService;
    public void execute(){
        logger.debug("会话超时检测开始");
        try {
            myJobService.sessionTimeOutDetect();
        }catch (Exception e){
            logger.error("会话超时检测异常",e);
        }
        logger.debug("会话超时检测结束");
    }
}

package com.liaoyb.job;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ybliao2
 */
public class Application {
    private static Logger logger= LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        try {

            ApplicationContext context =new ClassPathXmlApplicationContext("classpath:config/application.xml");
//            Scheduler a = (Scheduler) context.getBean("schedulerFactoryBean");
//            a.start();
            while (true) {
                try {
                    Thread.sleep(10 * 1000);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}

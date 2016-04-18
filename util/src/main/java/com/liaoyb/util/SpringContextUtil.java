package com.liaoyb.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring上下文
 * @author ybliao2
 */
public class SpringContextUtil implements ApplicationContextAware{
    private static ApplicationContext ctu;

    private SpringContextUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ctu = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return ctu;
    }
    public static Object  getBean(String id){
        return ctu.getBean(id);
    }

}

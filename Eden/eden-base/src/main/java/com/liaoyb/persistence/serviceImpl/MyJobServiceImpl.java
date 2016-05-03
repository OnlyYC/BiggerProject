package com.liaoyb.persistence.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liaoyb.persistence.dao.custom.UserMapperCustom;
import com.liaoyb.persistence.service.MyJobService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ybliao2
 */
@Service
public class MyJobServiceImpl implements MyJobService {

    @Autowired
    private UserMapperCustom userMapperCustom;
    /**
     * 登录超时检测
     */
    @Override
    public void sessionTimeOutDetect() {
        userMapperCustom.sessionTimeOutDetect();
    }

    /**
     * 每日推荐
     */
    @Override
    public void generateTipList() {
        userMapperCustom.generateTipList();
    }

    /**
     * 统计用户播放信息得到用户偏好
     */
    @Override
    public void generateUserPreference() {
        userMapperCustom.generateUserPreference();
    }
}

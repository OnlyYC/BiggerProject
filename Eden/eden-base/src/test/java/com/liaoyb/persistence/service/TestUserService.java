package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.domain.vo.base.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 测试userService
 *
 * @author liao
 * @create 2016-01-30-19:12
 **/
public class TestUserService extends SpringTest {

    @Autowired
    private UserService userService;

    @Test
    public void testfindUserPageUseExample(){
        Page<User> page=new Page<>();
        page=userService.findUserPageUseExample(page);
        System.out.println("page:"+page);
    }


    //添加歌曲到播放列表
    @Test
    public void testAddSongToUserPlay(){
        userService.addSongToUserPlay(1L,1L);

    }

}

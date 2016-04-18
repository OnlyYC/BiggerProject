package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.UserMapperCustom;
import com.liaoyb.persistence.domain.dto.SonglistCountDto;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.dto.UserInfo;
import com.liaoyb.persistence.domain.vo.base.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试用户
 *
 * @author ybliao2
 */
public class TestUserMapperCustom extends SpringTest {
    @Autowired
    private UserMapperCustom userMapperCustom;

    //测试用户登录
    @Test
    public void testUserLogin() {
        User user = new User();
        UserDto userDto = userMapperCustom.userLogin(user);
    }

    //用户创建的歌单
    @Test
    public void testFindSonglistsUserCreated() {
        List<SonglistCountDto> songlistCountDtos = userMapperCustom.findSonglistsUserCreated(1L);
        System.out.println("songlistCountDtos:" + songlistCountDtos);
    }

    //用户收藏的歌单
    @Test
    public void testFindSonglistUserCollected() {
        List<SonglistCountDto> songlistCountDtos = userMapperCustom.findSonglistUserCollected(20L);
        System.out.println("songlistCountDtos:" + songlistCountDtos);
    }

    //用户详细信息
    @Test
    public void testFindUserInfo() {

        UserInfo userInfo = userMapperCustom.findUserInfo(1L);
        System.out.println("userInfo:" + userInfo);
    }
}

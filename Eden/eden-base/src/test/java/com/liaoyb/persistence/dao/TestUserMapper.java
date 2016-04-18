package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.base.UserMapper;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.base.UserExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试UserMapper
 *
 * @author liao
 * @create 2016-01-30-18:27
 **/
public class TestUserMapper extends SpringTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFind(){
        User user=userMapper.selectByPrimaryKey(1L);
        System.out.println("user:"+user);
    }

    //批量插入
    @Test
    public void testBatchInsert(){

        for(int index=10;index<20;index++){
            User user=new User();
            user.setName("batch_name_"+index);
            user.setName("batch_username_"+index);
            userMapper.insertSelective(user);
            System.out.println("user:"+user);
        }

    }


    //查询
    @Test
    public void testQuery(){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andIdEqualTo(1L);
        List<User>users=userMapper.selectByExample(userExample);
        System.out.println("users:"+users);
    }

}

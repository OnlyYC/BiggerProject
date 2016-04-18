package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.SongMapperCustom;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 测试UserMapperCustom
 *
 * @author liao
 * @create 2016-01-31-20:42
 **/
public class TestSongMapperCustom extends SpringTest {

    @Autowired
    private SongMapperCustom songMapperCustom;


    //SongDto
    @Test
    public void testSongDto(){
        SongDto songDto=songMapperCustom.findSongDtoById(1L,null);
        System.out.println("songDto:"+songDto);
    }


    //主键查找
    @Test
    public void testFindById(){
        SongCustom songCustom=songMapperCustom.findSongCustomById(1L);
        System.out.println("songCustom"+songCustom);
    }


    //专辑中的音乐
    @Test
    public void testFindSongCustomsInAlbum(){
        List<SongCustom>songCustoms= songMapperCustom.findSongCustomsInAlbum(1L);
        System.out.println("songCustoms:"+songCustoms);
    }
}

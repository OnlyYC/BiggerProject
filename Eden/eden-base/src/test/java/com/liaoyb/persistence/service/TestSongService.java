package com.liaoyb.persistence.service;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.SongMapperCustom;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ybliao2
 */
public class TestSongService extends SpringTest {
    @Autowired
    private SongService songService;

    @Autowired
    private SongMapperCustom songMapperCustom;

    @Test
    public void testRandom(){
        Page<SongCustom> songCustomPage=new Page<>();
        songCustomPage=songService.findSongCustomsRandom(songCustomPage, SysCode.SONG_TYPE.SONG);
    }



    @Test
    public void testMapperRandom(){
        List<SongCustom>songCustoms= songMapperCustom.findSongCustomsRandom(SysCode.SONG_TYPE.SONG);
        System.out.println("songCustoms:"+songCustoms);
    }
}

package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.SonglistMapperCustom;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ybliao2
 */
public class TestSonglistMapperCustom extends SpringTest {
    @Autowired
    private SonglistMapperCustom songlistMapperCustom;

    @Test
    public void testFindSonglistUserLike(){
        List<Songlist>songlists =songlistMapperCustom.findSonglistUserLike(1L);
        System.out.println("songlists:"+songlists);
    }
}

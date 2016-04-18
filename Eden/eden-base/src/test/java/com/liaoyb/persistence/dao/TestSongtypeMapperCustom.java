package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.SongtypeMapperCustom;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybliao2
 */
public class TestSongtypeMapperCustom extends SpringTest {
    @Autowired
    private SongtypeMapperCustom songtypeMapperCustom;

    @Test
    public void testFindSongCustomsBySongtype(){
        List<Long>typeIds=new ArrayList<>();
//        typeIds.add(6L);
        typeIds.add(5L);
        List<SongCustom>songCustoms=songtypeMapperCustom.findSongCustomsBySongtype(typeIds,1L);
        System.out.println("songCustoms:"+songCustoms);
    }

    @Test
    public void testFindSonglistBySongtype(){
        List<Long>typeIds=new ArrayList<>();
        typeIds.add(4L);
        List<Songlist>songlists=songtypeMapperCustom.findSonglistBySongtype(typeIds);
        System.out.println("songlists:"+songlists);
    }
}

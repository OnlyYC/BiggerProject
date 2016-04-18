package com.liaoyb.persistence.service;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.domain.vo.custom.SongtypeCustom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ybliao2
 */
public class TestSongTypeService extends SpringTest {
    @Autowired
    private SongTypeService songTypeService;

    @Test
    public void testFindAllSongtype(){
        List<SongtypeCustom>songtypeCustoms=songTypeService.findAllSongtypeCustoms();
        System.out.println("songtypeCustoms:"+songtypeCustoms);
    }
}

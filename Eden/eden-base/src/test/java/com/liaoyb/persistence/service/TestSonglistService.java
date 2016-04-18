package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.domain.dto.SongDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ybliao2
 */
public class TestSonglistService extends SpringTest {
    @Autowired
    private SonglistService songlistService;

    @Test
    public void testSongDtoInSonglist(){
        Page<SongDto> songDtoPage=new Page<>();
        songDtoPage=songlistService.findSongDtoInSonglist(songDtoPage,1L,null);
        System.out.println("songDtoPage:"+songDtoPage);
    }
}

package com.liaoyb.persistence.dao;

import com.liaoyb.persistence.SpringTest;
import com.liaoyb.persistence.dao.custom.ArtistMapperCustom;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ybliao2
 */
public class TestArtistMapperCustom extends SpringTest {

    @Autowired
    private ArtistMapperCustom artistMapperCustom;

    @Test
    public void testFindArtistDto(){
        ArtistDto artistDto=artistMapperCustom.findArtistDtoById(1L);
        System.out.println("artistDto:"+artistDto);
    }
}

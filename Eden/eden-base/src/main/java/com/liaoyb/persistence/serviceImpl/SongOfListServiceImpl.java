package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.custom.SongOfListMapper;
import com.liaoyb.persistence.domain.dto.SongOfList;
import com.liaoyb.persistence.service.SongOfListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 榜单服务
 * @author ybliao2
 */
@Service
public class SongOfListServiceImpl implements SongOfListService{


    @Autowired
    private SongOfListMapper songOfListMapper;
    /**
     * 榜单中歌曲
     */
    @Override
    @PageAnnotation
    public Page<SongOfList> findSongInList(Page<SongOfList>page,Long listId) {
        List<SongOfList>songOfLists= songOfListMapper.findSongInList(listId);
        page.setResult(songOfLists);
        return page;
    }
}

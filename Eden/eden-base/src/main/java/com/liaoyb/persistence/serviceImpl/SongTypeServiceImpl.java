package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.custom.SongtypeMapperCustom;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.domain.vo.custom.SongtypeCustom;
import com.liaoyb.persistence.service.SongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类
 * @author ybliao2
 */
@Service
public class SongTypeServiceImpl implements SongTypeService {

    @Autowired
    private SongtypeMapperCustom songtypeMapperCustom;


    /**
     * 拿到全部类别
     * @return 所有类型扩展
     */
    @Override
    public List<SongtypeCustom> findAllSongtypeCustoms() {
        return songtypeMapperCustom.findAllSongtypeCustoms();
    }


    /**
     * 歌曲分类查找,分页
     * @param page 分页
     * @param songTypeIds 多个类型Id
     * @param type 歌曲类型，mv或歌曲
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsBySongType(Page<SongCustom> page, List<Long> songTypeIds, Long type) {

        List<SongCustom>songCustoms=songtypeMapperCustom.findSongCustomsBySongtype(songTypeIds,type);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 歌单分类查找，分页
     * @param page 分页
     * @param songTypeIds 多个类型Id
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Songlist> findSonglistBySongType(Page<Songlist> page, List<Long> songTypeIds) {

        List<Songlist>songlists=songtypeMapperCustom.findSonglistBySongtype(songTypeIds);
        page.setResult(songlists);
        return page;
    }
}

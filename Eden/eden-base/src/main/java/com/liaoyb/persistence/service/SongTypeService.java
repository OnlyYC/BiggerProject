package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.domain.vo.custom.SongtypeCustom;

import java.util.List;

/**
 * 分类service,歌曲,歌单
 * Created by  liao on 2016/2/5.
 */
public interface SongTypeService {

    //查询.............................................................


    /**
     * 拿到全部类别
     * @return 所有类型扩展
     */
    List<SongtypeCustom> findAllSongtypeCustoms();




    /**
     * 歌曲分类查找,分页
     * @param page 分页
     * @param songTypeIds 多个类型id
     * @param type 歌曲类型，mv或歌曲
     * @return 歌曲分页数据
     */
    Page<SongCustom> findSongCustomsBySongType(Page<SongCustom> page, List<Long> songTypeIds, Long type);




    /**
     * 歌单分类查找，分页
     * @param page 分页
     * @param songTypeIds 多个类型Id
     * @return 歌曲分页数据
     */
    Page<Songlist>findSonglistBySongType(Page<Songlist> page, List<Long> songTypeIds);




    //操作.............................................................

}

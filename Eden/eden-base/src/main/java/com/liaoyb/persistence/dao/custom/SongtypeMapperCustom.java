package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.domain.vo.custom.SongtypeCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 歌曲类型扩展dao
 * Created by  liao on 2016/2/5.
 */
public interface SongtypeMapperCustom {


    /**
     * 所有歌曲分类扩展
     * @return 分类扩展
     */
    public List<SongtypeCustom>findAllSongtypeCustoms();


    /**
     * 根据歌曲分类找到其中的歌曲扩展,type表示mv或歌曲
     * @param typeIds 多个类型id
     * @param type mv或歌曲
     * @return
     */
    public List<SongCustom>findSongCustomsBySongtype(@Param("typeIds") List<Long> typeIds, @Param("type") Long type);



    /**
     * 根据歌曲分类找到其中的歌单
     * @param typeIds 多个类型id
     * @return
     */
    public List<Songlist>findSonglistBySongtype(@Param("typeIds") List<Long> typeIds);

}

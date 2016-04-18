package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.base.SongMapper;
import com.liaoyb.persistence.dao.base.UserlistenMapper;
import com.liaoyb.persistence.dao.custom.SongMapperCustom;
import com.liaoyb.persistence.dao.custom.UserlistenMapperCustom;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.vo.base.Song;
import com.liaoyb.persistence.domain.vo.base.SongExample;
import com.liaoyb.persistence.domain.vo.base.Userlisten;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ybliao2
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapperCustom songMapperCustom;

    @Autowired
    private UserlistenMapperCustom userlistenMapperCustom;
    @Autowired
    private UserlistenMapper userlistenMapper;
    @Autowired
    private SongMapper songMapper;

    /**
     * 所有歌曲,分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findAllSongCustomsPage(Page<SongCustom> page, Long type) {
        Song song=new Song();
        song.setType(type);
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsQuery(song);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 通过歌曲id找到歌曲的详细信息
     * @param id 歌曲id
     * @return 歌曲扩展
     */
    @Override
    public SongCustom findSongCustomById(Long id) {

        return songMapperCustom.findSongCustomById(id);
    }

    /**
     * 歌曲(MV)播放量排名，降序,分页
     * @param area 地区，字典项
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongsRankByPlayCount(Page<SongCustom> page, Long type, Long area) {
        List<SongCustom>songCustoms=songMapperCustom.findSongsRankByPlayCount(type,area);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 最新的歌曲,根据发布时间排序,分页
     * @param page 分页
     * @param type 类型，字典项
     * @param area 地区  字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findlastSongs(Page<SongCustom> page, Long type, Long area) {
        List<SongCustom>songCustoms=songMapperCustom.findlastSongs(type,area);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 歌曲综合排名,分页
     * @param page 分页
     * @param type 类型，字典项
     * @param area 地区  字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSonsComprehensive(Page<SongCustom> page, Long type, Long area) {
        List<SongCustom>songCustoms=songMapperCustom.findSonsComprehensive(type, area);
        page.setResult(songCustoms);
        return page;
    }


    /**
     * 歌曲搜索,根据歌名进行查询,模糊查询,分页
     * @param page 分页
     * @param songName 歌名
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsQuery(Page<SongCustom> page, String songName, Long type) {
        Song song=new Song();
        song.setName(songName);
        song.setType(type);
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsQuery(song);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 歌曲推荐(整体推荐,根据播放量，用户收藏来决定),分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsRecommend(Page<SongCustom> page, Long type) {
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsRecommend(type);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 歌曲推荐(根据用户的喜好来推荐),分页
     * @param page 分页
     * @param userId 用户id
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsUserLike(Page<SongCustom> page, Long userId, Long type) {
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsUserLike(userId,type);
        page.setResult(songCustoms);
        return page;
    }


    /**
     * 相似歌曲推荐(相似算法),分页
     * @param page 分页
     * @param songId 歌曲id
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsSimilar(Page<SongCustom> page, Long songId) {
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsSimilar(songId);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 随机推荐，分页
     * @param page 分页
     * @param type 类型，字典项
     * @return 返回分页数据
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSongCustomsRandom(Page<SongCustom> page, Long type) {
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsRandom(type);
        page.setResult(songCustoms);
        return page;
    }

    /**
     * 播放音乐，，里面要对音乐播放量加1。如果用户id不为null，
     * 要给用户添加一条播放历史或者对播放历史里面的歌曲播放数加1
     * @param userId 用户Id
     * @param songId 歌曲id
     */
    @Override
    public void playSong(Long userId, Long songId) {
        //歌曲
        Song song=songMapper.selectByPrimaryKey(songId);

        //如果用户Id不为Null,添加播放历史
        if(userId!=null){
            Userlisten condition=new Userlisten();
            condition.setSongId(songId);
            condition.setUserId(userId);
            List<Userlisten> userlistens= userlistenMapperCustom.query(condition);
            if(userlistens.size()>0){
                //已经有这个历史,更新播放数
                Userlisten record=userlistens.get(0);
                record.setPlayCount(record.getPlayCount()+1);
                userlistenMapper.updateByPrimaryKeySelective(record);
            }else{
                //插入历史
                Userlisten record=new Userlisten();
                record.setUserId(userId);
                record.setSongId(songId);
                //设置歌曲名
                if(song!=null){
                    record.setSongName(song.getName());
                }

                record.setPlayCount(1L);
                //在播放列表中
                record.setFlag(SysCode.USER_LISTEN.EXIT_PLAYLIST);
                //插入记录
                userlistenMapper.insertSelective(record);
            }
        }

        if(song!=null){
            //对歌曲的播放数加1
            song.setPlayCount(song.getPlayCount()+1);
            songMapper.updateByPrimaryKeySelective(song);
        }



    }

    /**
     * 歌曲搜索
     * 区分歌曲、mv
     *
     * @param page
     * @param type       歌曲类型,1-歌曲，2-mv
     * @param searchText
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SongCustom> findSong(Page<SongCustom> page, Integer type, String searchText) {
        page.setResult(songMapperCustom.findSong(type,searchText));
        return page;
    }

    /**
     * 歌曲是否有效
     *
     * @param songId
     * @return
     */
    @Override
    public boolean isValid(Long songId) {
        SongExample songExample=new SongExample();
        SongExample.Criteria criteria=songExample.createCriteria();
        criteria.andIdEqualTo(songId);
        criteria.andFlagEqualTo(1L);
        List<Song>songs=songMapper.selectByExample(songExample);
        if(songs.size()==1){
            return true;
        }
        return false;
    }

    /**
     * 随机
     *
     * @param page
     * @param userId
     * @param type
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SongDto> findSongDtoRandom(Page<SongDto> page, Long userId, Long type) {
        page.setResult(songMapperCustom.findSongDtoRandom(userId,type));
        return page;
    }
}

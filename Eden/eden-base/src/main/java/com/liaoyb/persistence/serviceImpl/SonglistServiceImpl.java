package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.base.SonglistMapper;
import com.liaoyb.persistence.dao.base.SonglistWithSongMapper;
import com.liaoyb.persistence.dao.base.UserMapper;
import com.liaoyb.persistence.dao.custom.SongMapperCustom;
import com.liaoyb.persistence.dao.custom.SonglistMapperCustom;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.dto.SongDto;
import com.liaoyb.persistence.domain.dto.SonglistCountDto;
import com.liaoyb.persistence.domain.dto.SonglistDto;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.base.SonglistWithSong;
import com.liaoyb.persistence.domain.vo.base.SonglistWithSongExample;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.SonglistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 歌单服务
 * @author ybliao2
 */
@Service
public class SonglistServiceImpl implements SonglistService {


    @Autowired
    private SongMapperCustom songMapperCustom;
    @Autowired
    private SonglistMapperCustom songlistMapperCustom;
    @Autowired
    private SonglistMapper songlistMapper;

    @Autowired
    private SonglistWithSongMapper songlistWithSongMapper;


    @Autowired
    private UserMapper userMapper;

    /**
     * 歌单dto
     * @param songlistId
     * @param userId
     * @return
     */
    @Override
    public SonglistDto findSonglistDto(Long songlistId, Long userId) {
        return songlistMapperCustom.findSonglistDto(songlistId,userId);
    }

    /**
     * 歌单详情
     * @param songlistId
     * @return
     */
    @Override
    public Songlist findSonglistById(Long songlistId) {
        return songlistMapper.selectByPrimaryKey(songlistId);
    }

    /**
     * 根据歌单id找到歌单中的歌曲,分页
     * @param songlistId 歌单id
     * @return
     */
    @Override
    public List<SongCustom> findSongCustomsInSonglist(Long songlistId) {
        List<SongCustom>songCustoms= songMapperCustom.findSongCustomsInSonglist(songlistId);
        return songCustoms;
    }

    /**
     * 歌单中的音乐SongDto,分页
     * @param page
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SongDto> findSongDtoInSonglist(Page<SongDto> page, Long songlistId, Long userId) {
        List<SongDto>songDtos=songMapperCustom.findSongDtoInSonglist(songlistId,userId);
        page.setResult(songDtos);
        return page;
    }


    /**
     * 歌单推荐,根据播放量，收藏量,分页
     * @param page 分页
     * @return 歌单
     */
    @Override
    @PageAnnotation
    public Page<Songlist> findSonglistRecommend(Page<Songlist> page) {
        List<Songlist>songlists= songlistMapperCustom.findSonglistRecommend();
        page.setResult(songlists);
        return page;
    }

    /**
     * 歌单推荐(根据用户的喜好来推荐),不能是用户自己的歌单
     * @param page
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Songlist> findSonglistUserLike(Page<Songlist> page,Long userId) {
        List<Songlist>songlists=songlistMapperCustom.findSonglistUserLike(userId);
        page.setResult(songlists);
        return page;
    }


    /**
     * 包含这首歌的歌单,按播放量倒序，分页
     * @param page 分页
     * @param songId 歌曲id
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Songlist> findSonglistCustomsIncludeSong(Page<Songlist> page, Long songId) {
        List<Songlist>songlists= songlistMapperCustom.findSonglistCustomsIncludeSong(songId);
        page.setResult(songlists);
        return page;
    }

    /**
     * 官方榜单
     * @return 榜单
     */
    @Override
    public List<Songlist> findOfficialSonglist() {
        Songlist codition=new Songlist();
        codition.setType(SysCode.SONGLIST_TYPE.OFFICIAL_LIST);
        return songlistMapperCustom.findsonglistQuery(codition);
    }

    /**
     * 全球榜单
     * @return 榜单
     */
    @Override
    public List<Songlist> findGlobalSonglist() {
        Songlist condition=new Songlist();
        condition.setType(SysCode.SONGLIST_TYPE.GLOBAL_LIST);
        return songlistMapperCustom.findsonglistQuery(condition);
    }

    /**
     * 删除歌单,用户只能删除自己的歌单,只是把flag置为0
     * @param songlistId 歌单id
     * @return
     */
    @Override
    public boolean dealSonglistById(Long songlistId) {
        Songlist songlist=new Songlist();
        songlist.setId(songlistId);
        songlist.setFlag(SysCode.FLAG.INVALID);
        songlistMapper.updateByPrimaryKeySelective(songlist);
        return true;
    }


    /**
     * 创建歌单
     * @param songlist 歌单
     * @return
     */
    @Override
    public boolean addSonglist(Songlist songlist) {
        songlist.setCreateTime(new Date().getTime());
        songlist.setLastUpdate(new Date().getTime());
        songlist.setFlag(SysCode.FLAG.VALID);
        songlist.setType(SysCode.SONGLIST_TYPE.COMMON_LIST);
        songlist.setCollectCount(0L);

        //设置默认封面
        if(StringUtils.isEmpty(songlist.getCoverUrl())) {
            songlist.setCoverUrl(SysCode.DEFAUT_URL.SONGLIST_COVER);
        }
        //插入
        songlistMapper.insertSelective(songlist);
        return true;
    }


    /**
     * 修改歌单
     * @param songlist 歌单
     * @return
     */
    @Override
    public boolean updateSonglist(Songlist songlist) {
        songlist.setLastUpdate(new Date().getTime());
        songlistMapper.updateByPrimaryKeySelective(songlist);
        return true;
    }

    /**
     * 歌单搜索
     *
     * @param page
     * @param searchText
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SonglistCountDto> findSonglist(Page<SonglistCountDto> page, String searchText) {
        page.setResult(songlistMapperCustom.findSonglist(searchText));
        return page;
    }

    /**
     * 歌曲是否在歌单中存在
     *
     * @param songId
     * @param songlistId
     * @return
     */
    @Override
    public boolean isSongInSonglist(Long songId, Long songlistId) {
        SonglistWithSongExample songlistWithSongExample=new SonglistWithSongExample();
        SonglistWithSongExample.Criteria criteria=songlistWithSongExample.createCriteria();
        criteria.andSongIdEqualTo(songId);
        criteria.andSonglistIdEqualTo(songlistId);
        List<SonglistWithSong>songlistWithSongs=songlistWithSongMapper.selectByExample(songlistWithSongExample);
        if(songlistWithSongs.size()==1){
            return true;
        }
        return false;
    }

    /**
     * 创建歌单
     * 不能是【我喜欢】
     *
     * @param userId
     * @param listName
     * @return
     */
    @Override
    @Transactional
    public Response createSonglist(Long userId, String listName) throws Exception {
        if(StringUtils.isEmpty(listName)){
            return new Response().failure("歌单名不能为空");
        }
        if(SysCode.MUSIC_LIST.DEFAULT_LOVE.equals(listName)){
            return new Response().failure("不能创建【我喜欢】歌单");
        }

        //用户
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null){
            throw new Exception("用户不存在");
        }


        Songlist songlist=new Songlist();
        songlist.setUserId(userId);
        songlist.setCoverUrl(SysCode.DEFAUT_URL.SONGLIST_COVER);
        songlist.setFlag(SysCode.FLAG.VALID);
        songlist.setListName(listName);
        songlist.setCreateTime(new Date().getTime());
        songlist.setLastUpdate(new Date().getTime());
        songlist.setType(SysCode.SONGLIST_TYPE.COMMON_LIST);
        songlist.setUsername(user.getName());
        songlistMapper.insertSelective(songlist);
        return new Response().success("新建歌单成功",null);
    }
}

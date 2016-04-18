package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.base.support.utils.CollectionUtil;
import com.liaoyb.persistence.dao.base.*;
import com.liaoyb.persistence.dao.custom.SongMapperCustom;
import com.liaoyb.persistence.dao.custom.SonglistMapperCustom;
import com.liaoyb.persistence.dao.custom.UserMapperCustom;
import com.liaoyb.persistence.domain.dto.*;
import com.liaoyb.persistence.domain.vo.base.*;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.SongService;
import com.liaoyb.persistence.service.SonglistService;
import com.liaoyb.persistence.service.UserService;
import com.liaoyb.util.MD5Util;
import com.liaoyb.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 用户service
 *
 * @author liao
 * @create 2016-01-30-19:07
 **/
@Service
public class UserServiceImpl implements UserService {
    private static final String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserlistenMapper userlistenMapper;

    @Autowired
    private SongMapper songMapper;

    @Autowired
    private SongMapperCustom songMapperCustom;
    @Autowired
    private UserWithRoleMapper userWithRoleMapper;
    @Autowired
    private UserMapperCustom userMapperCustom;
    @Autowired
    private SonglistMapper songlistMapper;

    @Autowired
    private SonglistMapperCustom songlistMapperCustom;

    @Autowired
    private SongService songService;

    @Autowired
    private SonglistService songlistService;

    @Autowired
    private SonglistWithSongMapper songlistWithSongMapper;


    @Override
    @PageAnnotation
    public Page<User> findUserPageUseExample(Page<User> userPage) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        List<User>users =userMapper.selectByExample(userExample);
        userPage.setResult(users);
        return userPage;
    }

    /**
     * 用户
     * @param userId
     * @return
     */
    public User findUserById(Long userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 用户详细信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo findUserInfo(Long userId) {
        return userMapperCustom.findUserInfo(userId);
    }

    /**
     * 用户好友
     *
     * @param userId
     * @param condition 查询条件
     * @return
     */
    @Override
    public List<UserFriend> findUserFriend(Long userId,User condition) {
        return userMapperCustom.findUserFriend(userId,condition);
    }

    /**
     * 用户关注的用户
     * @param userId
     * @return
     */
    @Override
    public List<User> findUserFocus(Long userId) {
        return userMapperCustom.findUserFocus(userId);
    }

    /**
     * 用户的粉丝
     * @param userId
     * @return
     */
    @Override
    public List<User> findUserFans(Long userId) {
        return userMapperCustom.findUserFans(userId);
    }


    /**
     * 用户收藏的mv
     * @param page
     * @param userId
     * @return
     */
    @Override
    public Page<SongCustom> findUserMV(Page<SongCustom> page, Long userId) {
        List<SongCustom>songCustoms=userMapperCustom.findUserMV(userId);
        page.setResult(songCustoms);
        return page;
    }


    /**
     * 用户上传（音乐，mv）
     * @param page
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<SongDto>findUserUpload(Page<SongDto>page,Long userId){
        page.setResult(userMapperCustom.findUserUpload(userId));
        return page;
    }

    /**
     * 用户收藏的歌手
     * @param page
     * @param userId
     * @return
     */
    @Override
    @PageAnnotation
    public Page<ArtistDto> findUserArtist(Page<ArtistDto> page, Long userId) {
        List<ArtistDto>artistDtos=userMapperCustom.findUserArtist(userId);
        page.setResult(artistDtos);
        return page;
    }


    /**
     * 用户听歌排行,分页
     * @param page 分页
     * @param userId 用户id
     * @param type 类型，字典项
     * @return 分页数据
     */
    @Override
    @PageAnnotation
    public Page<Userlisten> findUserListenTop(Page<Userlisten> page, Long userId, Long type) {

        List<Userlisten>songCustoms=userMapperCustom.findUserListenTop(userId,type);
        page.setResult(songCustoms);

        return page;
    }

    /**
     * 用户登录
     * @param password 密码
     * @return 用户
     */
    @Override
    public UserDto userlogin(String email, String password) {
        //对密码进行md5加密
        password= MD5Util.MD5(password);
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);


        return userMapperCustom.userLogin(user);
    }


    /**
     * 用户的播放列表,userlisten中的flag表示是播放列表中的歌曲
     * @param userId 用户id
     * @return 歌曲
     */
    @Override
    public List<SongCustom> findSongCustomsInPlaylist(Long userId) {

        return userMapperCustom.findSongCustomsInPlaylist(userId);
    }

    /**
     * 用户的创建歌单
     * @param userId 用户id
     * @return 歌单
     */
    @Override
    public List<SonglistCountDto> findSonglistsUserCreated(Long userId) {
        return userMapperCustom.findSonglistsUserCreated(userId);
    }

    /**
     * 用户的收藏歌单
     * @param userId  用户id
     * @return
     */
    @Override
    public List<SonglistCountDto> findSonglistsUserCollected(Long userId) {
        return userMapperCustom.findSonglistUserCollected(userId);
    }

    /**
     * 喜欢这首歌曲的人，用户,就是播放了,这首歌曲的用户,按照播放次数排序,分页
     * @param page 分页
     * @param songId 歌曲id
     * @return
     */
    @Override
    @PageAnnotation
    public Page<UserPlay> findUsersLikeThisSong(Page<UserPlay> page, Long songId) {
        List<UserPlay>users=userMapperCustom.findUsersLikeThisSong(songId);
        page.setResult(users);
        return page;
    }


    /**
     * 注册用户
     * 是按邮箱注册
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Response register( User user) {
        //参数校验
        if(StringUtils.isEmpty(user.getEmail())||StringUtils.isEmpty(user.getPassword())){
            return new Response().failure("邮箱、密码不能为空");
        }
        if(!user.getEmail().matches(check)){
            return new Response().failure("邮箱格式有误");
        }

        //用户是否可用，是否可以注册
        if(!userAvailable(user)){
            //注册失败，用户已存在
            return new Response().failure("注册失败,此邮箱已被注册");
        }
        //清理此邮箱的垃圾注册（就是未激活置为无效）
        userMapperCustom.cleanOutOfDateRegistration(user.getEmail());


        //用户类型,普通用户
        //如果不存在头像，设置默认头像
        if(StringUtils.isEmpty(user.getAvatarUrl())){
            user.setAvatarUrl(SysCode.DEFAUT_URL.USER_AVATAR);
        }
        //注册时间
        user.setRegisterTime(new Date().getTime());
        //用户名默认
        user.setName("未知");
        user.setState(0L);
        //加密
        user.setPassword(MD5Util.MD5(user.getPassword()));
        //设置注册码
        String registerCode= UUIDUtil.getRandomStr();
        user.setRegisterCode(registerCode);
        //插入user表
        userMapper.insertSelective(user);
        //插入用户的权限
        UserWithRole userWithRole=new UserWithRole();
        userWithRole.setUserId(user.getId());
        userWithRole.setRoleId(SysCode.USER_ROLE.USER_ROLE_ID);

        //插入user_with_role表
        userWithRoleMapper.insertSelective(userWithRole);

        //插入默认歌单
        Songlist defaultLove=new Songlist();
        defaultLove.setCoverUrl(SysCode.DEFAUT_URL.SONGLIST_COVER);
        defaultLove.setListName(SysCode.MUSIC_LIST.DEFAULT_LOVE);
        defaultLove.setUserId(user.getId());
        defaultLove.setLastUpdate(new Date().getTime());
        defaultLove.setCreateTime(new Date().getTime());
        defaultLove.setUsername(user.getName());
        songlistMapper.insertSelective(defaultLove);




        return new Response().success("注册成功",null);
    }

    /**
     * 用户名是否可用
     * 邮箱是否已经注册，用户名是否重名
     * @param user
     * @return
     */
    @Override
    public boolean userAvailable(User user) {
        List<User>users=userMapperCustom.userAvailable(user);
        if(users.size()>0){
            //已经存在
            return false;
        }
        return true;
    }


    /**
     * //激活账号
     * @param email
     * @param registerCode
     * @return
     */
    @Override
    public boolean activateAccount(String email, String registerCode) {

        int result=userMapperCustom.activateAccount(email,registerCode);
        if(result>0){
            return true;
        }

        return false;
    }






    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUser(User user) {

        //更新密码
        if(!StringUtils.isEmpty(user.getPassword())){
            user.setPassword(MD5Util.MD5(user.getPassword()));
        }
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }


    /**
     * 添加歌曲，可以多首。到播放列表
     * @param userId
     * @param songids
     * @param cover 是否覆盖之前的播放列表
     */

    @Override
    public void addSongsToUserPlay(Long userId, Long[] songids, Boolean cover) {

        //这个可以写个存储过程
        // TODO: 2016/3/30  添加到播放列表，存储过程
    }

    //用户,添加歌曲到播放列表,会把之前的播放列表清空
    @Override
    public void addSongToUserPlay(Long userId, Long songId) {
        //找到歌曲
        Song song=songMapper.selectByPrimaryKey(songId);



        //先判断是否存在这首歌的播放记录
        UserlistenExample userlistenExample=new UserlistenExample();
        UserlistenExample.Criteria criteria=userlistenExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andSongIdEqualTo(songId);
        List<Userlisten>userlistens=userlistenMapper.selectByExample(userlistenExample);
        if(userlistens.size()>0){
            //存在，更新歌曲flag
            Userlisten record=userlistens.get(0);
            record.setFlag(1L);
            userlistenMapper.updateByPrimaryKeySelective(record);
        }else{
            //不存在，插入一条记录



            Userlisten userlisten=new Userlisten();
            userlisten.setUserId(userId);
            userlisten.setSongId(songId);
            if(song!=null){
                userlisten.setSongName(song.getName());
            }
            userlisten.setPlayCount(0L);
            userlisten.setFlag(1L);
            userlistenMapper.insertSelective(userlisten);

        }





    }

    //用户，添加歌单到播放列表,会把之前的播放列表清空
    @Override
    public void addSonglistToUserPlay(Long userId, Long songlistId) {

        //先找到歌单中的所有歌曲，再添加到播放列表中,调用上面的单条记录
        List<SongCustom>songCustoms=songMapperCustom.findSongCustomsInSonglist(songlistId);
        for(SongCustom songCustom:songCustoms){
            addSongToUserPlay(userId,songCustom.getId());
        }


    }

    /**
     * 搜索用户
     *
     * @param page
     * @param searchText
     * @return
     */
    @Override
    @PageAnnotation
    public Page<User> findUser(Page<User> page, String searchText) {
        page.setResult(userMapperCustom.findUser(searchText));
        return page;
    }

    /**
     * 添加歌曲到歌单
     *
     * @param songlistId
     * @param songId
     * @return
     */
    @Override
    @Transactional
    public Response addSongToSonglist(Long userId,Long songlistId, Long songId) {

        //歌单是否存在且有效且自己创建的
        if(!canAddSongToSonglist(userId,songlistId)){
            return new Response().failure("歌单无效");
        }
        if(!songService.isValid(songId)){
            return new Response().failure("歌曲无效");
        }
        //歌曲是否已经存在歌单中
        if(songlistService.isSongInSonglist(songId,songlistId)){
            return new Response().failure("歌单中已存在此歌曲");
        }


        //添加
        SonglistWithSong songlistWithSong=new SonglistWithSong();
        songlistWithSong.setSongId(songId);
        songlistWithSong.setSonglistId(songlistId);
        songlistWithSongMapper.insertSelective(songlistWithSong);

        //更新歌曲的收藏量
        songMapperCustom.addOneSongCollectCount(songId);
        return new  Response().success("成功添加到歌单",null);
    }

    /**
     * 歌单是否能添加歌曲
     *
     * @param userId
     * @param songlistId
     * @return
     */
    @Override
    public boolean canAddSongToSonglist(Long userId, Long songlistId) {
        //歌单是否存在且有效且自己创建的
        Songlist codition=new Songlist();
        codition.setId(songlistId);
        codition.setFlag(1L);
        codition.setUserId(userId);
        List<Songlist>songlists=songlistMapperCustom.findsonglistQuery(codition);
        if(songlists.size()==1){
            return true;
        }
        return false;
    }

    /**
     * toggle歌曲从我喜欢歌单中
     *
     * @param userId
     * @param songId
     * @return
     */
    @Override
    @Transactional
    public Response toggleSongFromLovelist(Long userId, Long songId) {
        //用户我喜欢歌单
        Songlist songlistLove=findMyLoveSonglist(userId);
        if(songlistLove==null){
            return new Response().failure("默认歌单不存在");
        }
        Long songlistId=songlistLove.getId();
        //如果存在，就移除
        if(songlistService.isSongInSonglist(songId,songlistId)){
            SonglistWithSongExample songlistWithSongExample=new SonglistWithSongExample();
            SonglistWithSongExample.Criteria criteria=songlistWithSongExample.createCriteria();
            criteria.andSongIdEqualTo(songId);
            criteria.andSonglistIdEqualTo(songlistId);

            songlistWithSongMapper.deleteByExample(songlistWithSongExample);
            return new Response().success("已从【我喜欢】中移除",null);
        }else{
            SonglistWithSong songlistWithSong=new SonglistWithSong();
            songlistWithSong.setSongId(songId);
            songlistWithSong.setSonglistId(songlistId);
            songlistWithSongMapper.insertSelective(songlistWithSong);

            //更新歌曲的收藏量
            songMapperCustom.addOneSongCollectCount(songId);
            return new Response().success("已添加到【我喜欢】",null);
        }

    }

    /**
     * 用户的我喜欢歌单（默认歌单）
     *
     * @param userId
     * @return
     */
    @Override
    public Songlist findMyLoveSonglist(Long userId) {
        SonglistExample songlistExample=new SonglistExample();
        SonglistExample.Criteria criteria=songlistExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andListNameEqualTo(SysCode.MUSIC_LIST.DEFAULT_LOVE);
        List<Songlist>songlists=songlistMapper.selectByExample(songlistExample);
        if(!CollectionUtil.isNotEmpty(songlists)){
            return null;
        }
        return songlists.get(0);
    }



}

package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.*;
import com.liaoyb.persistence.domain.vo.base.Songlist;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.base.Userlisten;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by  liao on 2016/1/30.
 */
@Service
public interface UserService {

    //测试
    Page<User>findUserPageUseExample(Page<User> userPage);

    //查询..............................................................


    /**
     * 用户
     * @param userId
     * @return
     */
    public User findUserById(Long userId);
    /**
     * 用户详细信息
     * @param userId
     * @return
     */
    public UserInfo findUserInfo(Long userId);


    /**
     * 用户好友
     * @param userId
     * @param condition 查询条件
     * @return
     */
    public List<UserFriend>findUserFriend(Long userId,User condition);

    /**
     * 用户关注的用户
     * @param userId
     * @return
     */
    public List<User>findUserFocus(Long userId);

    /**
     * 用户的粉丝
     * @param userId
     * @return
     */
    public List<User>findUserFans(Long userId);

    /**
     * 用户收藏的mv
     * @param page
     * @param userId
     * @return
     */
    public Page<SongCustom> findUserMV(Page<SongCustom> page, Long userId);


    /**
     * 用户上传（音乐，mv）
     * @param page
     * @param userId
     * @return
     */
    public Page<SongDto>findUserUpload(Page<SongDto>page,Long userId);


    /**
     * 用户收藏的歌手
     * @param page
     * @param userId
     * @return
     */
    public Page<ArtistDto> findUserArtist(Page<ArtistDto> page, Long userId);


    /**
     * 用户听歌排行,分页
     * @param page 分页
     * @param userId 用户id
     * @param type 类型，字典项
     * @return 分页数据
     */
    public Page<Userlisten>findUserListenTop(Page<Userlisten> page, Long userId, Long type);


    /**
     * 用户登录
     * @param usercode 用户名或邮箱
     * @param password 密码
     * @return 用户
     */
    public UserDto userlogin(String usercode, String password);



    /**
     * 用户的播放列表,userlisten中的flag表示是播放列表中的歌曲
     * @param userId 用户id
     * @return 歌曲
     */
    public List<SongCustom>findSongCustomsInPlaylist(Long userId);


    /**
     * 用户的创建歌单
     * @param userId 用户id
     * @return 歌单
     */
    public List<SonglistCountDto>findSonglistsUserCreated(Long userId);



    /**
     * 用户的收藏歌单
     * @param userId 用户id
     * @return 歌单
     */
    public List<SonglistCountDto>findSonglistsUserCollected(Long userId);



    /**
     * 喜欢这首歌曲的人，用户,就是播放了,这首歌曲的用户,按照播放次数排序,分页
     * @param page 分页
     * @param songId 歌曲id
     * @return
     */
    public Page<UserPlay>findUsersLikeThisSong(Page<UserPlay> page, Long songId);






    //操作.............................................................


    /**
     * 注册用户
     * @param user
     * @return
     */
    public Response register( User user);



    /**
     * 用户名是否可用
     * 邮箱是否已经注册，用户名是否重名
     * @param user
     * @return
     */
    public boolean userAvailable(User user);

    /**
     * 账号激活
     * @return
     */
    public boolean activateAccount(String email, String registerCode);



    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);


    /**
     * 添加歌曲，可以多首。到播放列表
     * @param userId
     * @param songids
     * @param cover 是否覆盖之前的播放列表
     */
    public void addSongsToUserPlay(Long userId, Long[] songids, Boolean cover);
    /**
     * 用户,添加歌曲到播放列表,会把之前的播放列表清空
     * @param userId 用户id
     * @param songId 歌曲id
     */
    public void addSongToUserPlay(Long userId, Long songId);



    /**
     * 用户，添加歌单到播放列表,会把之前的播放列表清空
     * @param userId 用户id
     * @param songlistId 歌单id
     */
    public void addSonglistToUserPlay(Long userId, Long songlistId);


    /**
     * 搜索用户
     * @param page
     * @param searchText
     * @return
     */
    Page<User> findUser(Page<User> page, String searchText);

    /**
     * 添加歌曲到歌单
     * @param songlistId
     * @param songId
     * @return
     */
    Response addSongToSonglist(Long userId,Long songlistId, Long songId);

    /**
     * 歌单是否能添加歌曲
     * @param userId
     * @param songlistId
     * @return
     */
    boolean canAddSongToSonglist(Long userId,Long songlistId);

    /**
     * toggle歌曲从我喜欢歌单中
     * @param userId
     * @param songId
     * @return
     */
    Response toggleSongFromLovelist(Long userId, Long songId);

    /**
     * 用户的我喜欢歌单（默认歌单）
     * @param userId
     * @return
     */
    Songlist findMyLoveSonglist(Long userId);
}

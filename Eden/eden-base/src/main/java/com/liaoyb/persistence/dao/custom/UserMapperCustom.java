package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.dto.*;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.base.Userlisten;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户扩展，查询用户相关信息
 * @author ybliao2
 */
public interface UserMapperCustom {

    /**
     * 用户详细信息
     * @param userId
     * @return
     */
    public UserInfo findUserInfo(@Param("userId") Long userId);



    /**
     * 用户听歌排行,分页
     * @param userId 用户id
     * @param type  类型，歌曲或MV,字典项
     * @return 播放历史
     */
    List<Userlisten> findUserListenTop(@Param("userId") Long userId, @Param("type") Long type);


    /**
     * 用户是否可用
     * @param user
     * @return
     */
    List<User> userAvailable(@Param("user") User user);


    /**
     * 清理邮箱之前的未激活的注册信息
     * @param email
     * @return
     */
    int cleanOutOfDateRegistration(@Param("email")String email);


    /**
     * 账号激活
     * @param email
     * @param registerCode
     * @return
     */
    int activateAccount(@Param("email") String email, @Param("registerCode") String registerCode);



    /**
     * 用户登录
     * @param user
     * @return
     */
    UserDto userLogin(@Param("user") User user);

    /**
     * 用户关注的用户
     * @param userId
     * @return
     */
    List<User>findUserFocus(@Param("userId")Long userId);

    /**
     * 用户的粉丝
     * @param userId
     * @return
     */
    List<User>findUserFans(@Param("userId")Long userId);

    /**
     * 用户好友
     * @param userId
     * @return
     */
    List<UserFriend>findUserFriend(@Param("userId")Long userId,@Param("condition") User condition);

    /**
     * 用户收藏的mv
     * @param userId
     * @return
     */
    List<SongCustom>findUserMV(@Param("userId") Long userId);

    /**
     * 用户上传的（音乐,mv）
     * @param userId
     * @return
     */
    List<SongDto>findUserUpload(@Param("userId")Long userId);


    /**
     * 用户收藏的歌手
     * @param userId
     * @return
     */
    List<ArtistDto>findUserArtist(@Param("userId") Long userId);

    /**
     * 用户的播放列表,userlisten中的flag表示是是否是播放列表中的歌曲
     * @param userId 用户id
     * @return
     */
    List<SongCustom>findSongCustomsInPlaylist(Long userId);



    /**
     * 用户的创建歌单
     * @param userId
     * @return
     */
    List<SonglistCountDto>findSonglistsUserCreated(Long userId);



    /**
     * 用户的收藏歌单
     * @param userId
     * @return
     */
    List<SonglistCountDto>findSonglistUserCollected(Long userId);


    /**
     * 喜欢这首歌曲的人，用户,就是播放了,这首歌曲的用户,按照播放次数排序
     * @param songId 歌曲id
     * @return
     */
    List<UserPlay> findUsersLikeThisSong(Long songId);


    /**
     * 搜索用户
     * @param searchText
     * @return
     */
    List<User> findUser(String searchText);
}

package com.liaoyb.web.page;

import com.alibaba.fastjson.JSON;
import com.liaoyb.base.Dictionary;
import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.dto.SonglistDto;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.dto.UserInfo;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.*;
import com.liaoyb.base.support.exception.SourcesNotFoundException;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author ybliao2
 */
@Controller
public class PageJumpController {


    @Autowired
    private SongService songService;

    @Autowired
    private SonglistService songlistService;
    @Autowired
    private ArtistService artistService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private SongTypeService songTypeService;
    @Autowired
    private UserService userService;




    //歌曲详细页面
    @RequestMapping("/song/{songId}")
//    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public String songInfo(@PathVariable Long songId,Map map) throws SourcesNotFoundException {

        SongCustom songCustom=songService.findSongCustomById(songId);
        if(songCustom==null){
            //如果歌曲不存在,报异常
            throw new SourcesNotFoundException();
        }


        //把歌曲详细放到域中
        map.put("songInfo",songCustom);
        map.put("songJson", JSON.toJSONString(songCustom));

        if(SysCode.SONG_TYPE.SONG.equals(songCustom.getType())){
            //如果是歌曲，跳转到歌曲详细
            return "songInfo";
        }else{
            //如果是mv,跳转到mv详细
            return "mvInfo";
        }



    }

    //歌单页面
    @RequestMapping("/songlist/{songlistId}")
    public String songlist(HttpServletRequest request, @PathVariable Long songlistId, Map map) throws SourcesNotFoundException {
        User currentUser= WebUtils.getCurrentUser(request);
        SonglistDto songlistDto=songlistService.findSonglistDto(songlistId,currentUser!=null?currentUser.getId():null);
        if(songlistDto==null){
            //如果歌单不存在,报一个异常，资源未找到
            throw new SourcesNotFoundException();
        }
        map.put("songlist",songlistDto);
        map.put("songlistJson", JSON.toJSONString(songlistDto));
        return "songlist";


    }


    //歌手页面
    @RequestMapping("/artist/{artistId}")
    public String artist(HttpServletResponse response,@PathVariable Long artistId,Map map) throws SourcesNotFoundException {
        ArtistDto artistDto=artistService.findArtistDtoById(artistId);
        if(artistDto==null){
            //如果歌手不存在,报一个异常，资源未找到
            throw new SourcesNotFoundException();
        }
        map.put("artist",artistDto);
        map.put("artistJson",JSON.toJSONString(artistDto));
        return "artist";
    }


    //专辑页面
    @RequestMapping("/album/{albumId}")
    public String album(HttpServletResponse response,@PathVariable Long albumId,Map map) throws SourcesNotFoundException {
        Album album=albumService.findAlbumById(albumId);
        if(album==null){
            throw new SourcesNotFoundException();
        }
        map.put("album",album);
        map.put("albumJson",JSON.toJSONString(album));
        return "album";
    }



    /**
     * 我的mv,需要用户登录
     * @param response
     * @return
     */
    @RequestMapping("/myMV")
    @AuthPassport
    public String myMV(HttpServletResponse response){
        return "myMV";

    }


    /**
     * 我的歌手,需要用户登录
     * @return
     */
    @RequestMapping("/myArtist")
    @AuthPassport
    public String myArtist(){
        return "myArtist";
    }


    //mv页面
    @RequestMapping("/mv")
    public String mv(Map map){
        //把地区放在域中
        map.put("areas", Dictionary.Area.values());
        return "mv";
    }

    //discover页面
    @RequestMapping("/discover")
    public String discover(Map map,String defaultActive){
        //把歌曲分类放在域中
        map.put("songTypes",songTypeService.findAllSongtypeCustoms());
        //官方榜单
        map.put("offical_list",songlistService.findOfficialSonglist());
        //全球榜单
        map.put("global_list",songlistService.findOfficialSonglist());
        //把地区放在域中
        map.put("areas", Dictionary.Area.values());
        //默认激活的tab
        if(defaultActive!=null){
            map.put("defaultActive",defaultActive);
        }

        return "discover";
    }


    /**
     * 用户主页
     * @param map
     * @param request
     * @param userId
     * @return
     * @throws SourcesNotFoundException
     */
    @RequestMapping("/userHome/{userId}")
    public String userHome(Map map,HttpServletRequest request,@PathVariable Long userId) throws SourcesNotFoundException {

        UserInfo userInfo=userService.findUserInfo(userId);
        if(userInfo==null){
            throw new SourcesNotFoundException();
        }
        map.put("userInfo",userInfo);
        //如果是当前用户
        UserDto userDto=WebUtils.getCurrentUser(request);
        if(userDto!=null&&userInfo.getId().equals(userDto.getId())){
            return "userHome";
        }

        return "otherUserHome";
    }

    /**
     * 用户关注
     * @param map
     * @param request
     * @param userId
     * @return
     * @throws SourcesNotFoundException
     */
    @RequestMapping("/userFocus/{userId}")
    public String userFocus(Map map,HttpServletRequest request,@PathVariable Long userId) throws SourcesNotFoundException {
        User user=userService.findUserById(userId);
        if(user==null){
            throw new SourcesNotFoundException();
        }
        map.put("user",user);
        return "focus";
    }

    /**
     * 用户粉丝
     * @param map
     * @param request
     * @param userId
     * @return
     * @throws SourcesNotFoundException
     */
    @RequestMapping("/userFans/{userId}")
    public String userFans(Map map,HttpServletRequest request,@PathVariable Long userId) throws SourcesNotFoundException {
        User user=userService.findUserById(userId);
        if(user==null){
            throw new SourcesNotFoundException();
        }
        map.put("user",user);
        return "fans";
    }

    /**
     * 我的上传页面
     * @return
     */
    @RequestMapping("/myUpload")
    @AuthPassport
    public String myUpload(){
        return "myUpload";
    }


    /**
     * 我的朋友页面
     * 需要登录
     * @return
     */
    @RequestMapping("/friend")
    @AuthPassport
    public String friend(){
        return "friend";
    }


    /**
     * 用户的动态
     * @param map
     * @param userId
     * @return
     */
    @RequestMapping("/dynamic/{userId}")
    public String dynamic(Map map, @PathVariable Long userId)throws SourcesNotFoundException{

        //用户
        User user=userService.findUserById(userId);
        if(user==null){
            throw new SourcesNotFoundException();
        }
        map.put("user",user);

        return "dynamic";
    }


    /**
     * 搜索结果
     * @param map
     * @param s
     * @return
     */
    @RequestMapping("/search")
    public String search(Map map, String s){
        map.put("searchText",s);
        return "search";
    }




    //404页面
    @RequestMapping("/notFound")
    public String notFound(){
        return "/common/404";
    }

    //错误页面
    @RequestMapping("/error")
    public String error(){
        return "/common/error";
    }

}

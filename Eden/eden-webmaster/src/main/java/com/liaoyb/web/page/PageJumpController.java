package com.liaoyb.web.page;

import com.alibaba.fastjson.JSON;
import com.liaoyb.base.Dictionary;
import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.enums.UserRoleTypeEnum;
import com.liaoyb.base.support.exception.SourcesNotFoundException;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.dto.SonglistDto;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.dto.UserInfo;
import com.liaoyb.persistence.domain.vo.base.Album;
import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.*;
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





    //登录页面
    @RequestMapping("/signin")
    public String signin(){
        return "/signin";
    }


    //首页
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    @RequestMapping(value = {"/","","index"})
    public String index(){
        return "index";
    }



    /**
     * 数据分析页面
     * @return
     */
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    @RequestMapping("/statistics")
    public String statistics(){
        return "statistics";
    }


    //歌曲操作页面
    @RequestMapping("/operation/song")
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public String songOperateiono(){

        return "song";
    }
    //添加音乐
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    @RequestMapping("/operation/addSong")
    public String addSong(){
        return "addSong";
    }

    //编辑音乐
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    @RequestMapping("/operation/editSong/{songId}")
    public String editSong(@PathVariable Long songId,Map map){
        SongCustom songCustom=songService.findSongCustomById(songId);
        map.put("song",songCustom);

        if(songCustom.getType().equals(SysCode.SONG_TYPE.SONG)){
            return "editSong";
        }else{
            return "editMV";
        }

    }


    //mv操作页面
    @RequestMapping("/operation/mv")
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public String mvOperateiono(){

        return "mv";
    }


    //添加mv
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    @RequestMapping("/operation/addMV")
    public String addMV(){
        return "addMV";
    }


    //歌手操作页面
    @RequestMapping("/operation/artist")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public String artistOperateiono(){
        return "artist";
    }

    //歌手编辑页面
    @RequestMapping("/operation/editArtist/{artistId}")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public String editArtist(@PathVariable Long artistId,Map map) throws SourcesNotFoundException {
        Artist artist=artistService.findArtistById(artistId);
        if(artist==null){
            throw new SourcesNotFoundException();
        }
        map.put("artist",artist);
        return "editArtist";
    }

    //歌手添加页面
    @RequestMapping("/operation/addArtist")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public String addArtist(){
        return "addArtist";
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

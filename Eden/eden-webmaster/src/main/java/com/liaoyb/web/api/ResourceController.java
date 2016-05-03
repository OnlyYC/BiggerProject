package com.liaoyb.web.api;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.domain.Page;
import com.liaoyb.base.enums.UserRoleTypeEnum;
import com.liaoyb.base.support.exception.SourcesNotFoundException;
import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.filestore.service.FileStoreService;
import com.liaoyb.persistence.domain.dto.ArtistDto;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.vo.base.Artist;
import com.liaoyb.persistence.domain.vo.base.Song;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.ArtistService;
import com.liaoyb.persistence.service.SongService;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源操作
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/resource")
public class ResourceController {
    @Autowired
    private FileStoreService fileStoreService;
    @Autowired
    private SongService songService;

    @Autowired
    private ArtistService artistService;


    /**
     * 所有歌曲
     * @param request
     * @param response
     * @param page
     * @param search
     */
    @RequestMapping("/allSong")
    public void allSong(HttpServletRequest request, HttpServletResponse response, Page<SongCustom> page,Integer start,Integer length,@RequestBody @RequestParam(value ="search[value]") String search){
        Integer pageNumber=start/length+1;
        page.setPageNumber(pageNumber);
        page.setPageSize(length);
        page=songService.findSong(page,SysCode.SONG_TYPE.SONG.intValue(),search);
        MyResultUtil.sendPage(response,page);
    }

    /**
     * 所有歌曲
     * @param request
     * @param response
     * @param page
     * @param search
     */
    @RequestMapping("/allMV")
    public void allMV(HttpServletRequest request, HttpServletResponse response, Page<SongCustom> page,Integer start,Integer length,@RequestBody @RequestParam(value ="search[value]") String search){
        Integer pageNumber=start/length+1;
        page.setPageNumber(pageNumber);
        page.setPageSize(length);
        page=songService.findSong(page,SysCode.SONG_TYPE.MV.intValue(),search);
        MyResultUtil.sendPage(response,page);
    }

    /**
     * 所有歌手
     * @param request
     * @param response
     * @param page
     * @param search
     */
    @RequestMapping("/allArtist")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public void allArtist(HttpServletRequest request, HttpServletResponse response, Page<ArtistDto> page, Integer start, Integer length, @RequestBody @RequestParam(value ="search[value]") String search){
        Integer pageNumber=start/length+1;
        page.setPageNumber(pageNumber);
        page.setPageSize(length);
        page=artistService.findArtist(page,search);
        MyResultUtil.sendPage(response,page);
    }


    /**
     * 添加歌手信息
     * @param response
     * @param request
     * @param artist
     * @param coverKey
     * @throws Exception
     */
    @RequestMapping("/addArtist")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public void addArtist(HttpServletResponse response, HttpServletRequest request, Artist artist, String coverKey) throws Exception {
        FileCloudInfo coverFileInfo=fileStoreService.getFileCLoudInfo(coverKey);
        if(coverFileInfo==null){
            MyResultUtil.sendFail(response,"添加歌手失败,封面添加失败");
            return;
        }
        artist.setPosterUrl(coverFileInfo.getUrl());
        artistService.addArtist(artist);
        MyResultUtil.sendSuccess(response,"歌手添加成功");
    }


    /**
     * 编辑歌手信息
     * @param response
     * @param request
     * @param artist
     * @param coverKey
     * @throws Exception
     */
    @RequestMapping("/editArtist")
    @AuthPassport(UserRoleTypeEnum.Admin)
    public void editArtist(HttpServletResponse response, HttpServletRequest request, Artist artist, String coverKey) throws Exception {
        if(!StringUtils.isEmpty(coverKey)){
        FileCloudInfo coverFileInfo=fileStoreService.getFileCLoudInfo(coverKey);
        if(coverFileInfo==null){
            MyResultUtil.sendFail(response,"添加歌手失败,封面添加失败");
            return;
        }
        artist.setPosterUrl(coverFileInfo.getUrl());
        }

        boolean isSuccess=artistService.updateArtist(artist);
        if(isSuccess){
            MyResultUtil.sendSuccess(response,"歌手添加成功");
        }else{
            MyResultUtil.sendFail(response,"歌手添加失败");
        }

    }


    @RequestMapping("/addSong")
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public void addSong(HttpServletResponse response, HttpServletRequest request, Song song, String coverKey,String songKey) throws Exception {
        //封面
        FileCloudInfo coverFileInfo=fileStoreService.getFileCLoudInfo(coverKey);
        //歌曲
        FileCloudInfo songFileInfo=fileStoreService.getFileCLoudInfo(songKey);

        if(coverFileInfo==null||songFileInfo==null){
            MyResultUtil.sendFail(response,"添加歌曲失败,封面、音乐添加失败");
            return;
        }
        //设置文件信息
        song.setSongUrl(songFileInfo.getUrl());
        song.setSongFileKey(songFileInfo.getKey());
        song.setCoverUrl(coverFileInfo.getUrl());

        //当前用户
        UserDto userDto= WebUtils.getCurrentUser(request);
        song.setUserId(userDto.getId());
        song.setType(SysCode.SONG_TYPE.SONG);
        songService.addSong(song);
        MyResultUtil.sendSuccess(response,"添加歌曲成功");
    }


    @RequestMapping("/addMV")
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public void addMV(HttpServletResponse response, HttpServletRequest request, Song song, String coverKey,String songKey) throws Exception {
        //封面
        FileCloudInfo coverFileInfo=fileStoreService.getFileCLoudInfo(coverKey);
        //歌曲
        FileCloudInfo songFileInfo=fileStoreService.getFileCLoudInfo(songKey);

        if(coverFileInfo==null||songFileInfo==null){
            MyResultUtil.sendFail(response,"添加MV失败,封面、音乐添加失败");
            return;
        }
        //设置文件信息
        song.setSongUrl(songFileInfo.getUrl());
        song.setSongFileKey(songFileInfo.getKey());
        song.setCoverUrl(coverFileInfo.getUrl());

        //当前用户
        UserDto userDto= WebUtils.getCurrentUser(request);
        song.setUserId(userDto.getId());
        song.setType(SysCode.SONG_TYPE.MV);
        songService.addSong(song);
        MyResultUtil.sendSuccess(response,"添加MV成功");
    }


    @RequestMapping("/editSong")
    @AuthPassport(value = UserRoleTypeEnum.Admin)
    public void editSong(HttpServletResponse response, HttpServletRequest request, Song song, String coverKey,String songKey) throws Exception {
        //封面
        if(!StringUtils.isEmpty(coverKey)){
            FileCloudInfo coverFileInfo=fileStoreService.getFileCLoudInfo(coverKey);
            if(coverFileInfo==null){
                MyResultUtil.sendFail(response,"添加歌曲失败,封面、音乐添加失败");
                return;
            }
            song.setCoverUrl(coverFileInfo.getUrl());
        }
        if(!StringUtils.isEmpty(songKey)){
            FileCloudInfo songFileInfo=fileStoreService.getFileCLoudInfo(songKey);
            if(songFileInfo==null){
                MyResultUtil.sendFail(response,"添加歌曲失败,封面、音乐添加失败");
                return;
            }
            song.setSongFileKey(songFileInfo.getKey());
            song.setSongUrl(songFileInfo.getUrl());
        }


        if(song.getId()==null){
            throw new  SourcesNotFoundException();
        }

        //当前用户
        UserDto userDto= WebUtils.getCurrentUser(request);
        song.setUserId(userDto.getId());
        song.setType(SysCode.SONG_TYPE.SONG);
        songService.updateSong(song);
        MyResultUtil.sendSuccess(response,"更新歌曲信息成功");
    }
}

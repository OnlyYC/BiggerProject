package com.liaoyb.web.api;

import com.alibaba.fastjson.JSON;
import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.persistence.domain.vo.base.Song;
import com.liaoyb.persistence.service.FileService;
import com.liaoyb.support.utils.MyResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试用的控制器
 *
 * @author liao
 * @create 2016-02-01-16:52
 **/
@Controller
@RequestMapping("/test")
public class TestController {
    private static Logger logger= LoggerFactory.getLogger(TestController.class);
    @Autowired
    private FileService fileService;

    @RequestMapping("/sendMap")
    public void testsendMap(HttpServletResponse response){
        Map map=new HashMap<>();
        map.put("test1","GG");
        List<Song>songs=new ArrayList<>();
        Song song=new Song();
        song.setId(1L);
        song.setName("测试歌曲");
        song.setSongUrl("/sources/mp3/11.mp3");
        song.setCoverUrl("/sources/images/22.jpg");
        songs.add(song);
        map.put("test2",songs);
        MyResultUtil.sendMap(response,map);
    }

    @RequestMapping("/testUpload")
    public void testUpload(HttpServletResponse response) throws Exception {
        FileCloudInfo fileCloudInfo=fileService.upload(null);
        logger.debug(JSON.toJSONString(fileCloudInfo));
        MyResultUtil.sendObject(response,fileCloudInfo);
    }

    @RequestMapping("/testView")
    public String testView(){
        return "test";
    }
}

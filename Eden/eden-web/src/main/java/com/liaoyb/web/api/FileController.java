package com.liaoyb.web.api;

import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.persistence.service.FileService;
import com.liaoyb.support.utils.MyResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件服务
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/file/")
public class FileController {
    @Autowired
    private FileService fileService;


    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, HttpServletResponse response,MultipartFile file) throws Exception {
        FileCloudInfo fileCloudInfo=fileService.upload(file);
        MyResultUtil.sendObject(response,fileCloudInfo);
    }
}

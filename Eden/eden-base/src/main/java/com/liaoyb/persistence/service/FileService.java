package com.liaoyb.persistence.service;

import com.liaoyb.filestore.model.FileCloudInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件的上传与下载
 * @author ybliao2
 */
public interface FileService {

    /**
     * 上传,把文件放到上传路径中，插入记录
     *
     * @param fileUpload
     * @return
     */
    FileCloudInfo upload(MultipartFile fileUpload) throws Exception;



}

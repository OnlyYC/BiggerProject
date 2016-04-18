package com.liaoyb.filestore.service;


import com.liaoyb.filestore.model.FileCloudInfo;

import java.io.InputStream;

/**
 * 高级文件服务
 * @author ybliao2
 */
public interface DvancedFileService {
    /**
     * 上传文件
     * @param originalfileName 原来的文件名(包括后缀)，用于判断文件类型，后缀会最后新文件的后缀
     * @param input 文件内容流，内部自动close
     * @return
     */
    FileCloudInfo upload(String originalfileName, InputStream input)throws Exception;


    /**
     * 下载
     * @param key
     * @return 返回InputStream
     */
    InputStream download(String key)throws Exception;
}

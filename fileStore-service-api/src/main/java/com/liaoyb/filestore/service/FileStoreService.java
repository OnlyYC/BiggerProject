package com.liaoyb.filestore.service;

import com.liaoyb.filestore.model.FileCloudInfo;

/**
 * 文件服务接口
 * @author ybliao2
 */
public interface FileStoreService extends DirectFileService,DvancedFileService {

    //根据code返回文件的信息(访问url,下载url,上传时间，大小,文件类型)

    FileCloudInfo getFileCLoudInfo(String key)throws Exception;


    /**
     * 添加文件的信息
     * @param originalfileName
     * @param fileSize
     * @return
     */
    FileCloudInfo addFileInfo(String originalfileName,Integer fileSize);




}

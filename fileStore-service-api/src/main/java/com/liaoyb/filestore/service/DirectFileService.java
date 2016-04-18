package com.liaoyb.filestore.service;


import com.liaoyb.filestore.model.FileCloudInfo;

/**
 * 直连的文件服务（适用于小文件）
 * @author ybliao2
 */
public interface DirectFileService {

    //上传文件，直接把文件的byte数组给我,返回上传文件信息
    FileCloudInfo upload(String originalfileName, byte[] fileBytes)throws Exception;




    //根据code返回文件的byte数组
    byte[]getFileBytes(String key)throws Exception;



}

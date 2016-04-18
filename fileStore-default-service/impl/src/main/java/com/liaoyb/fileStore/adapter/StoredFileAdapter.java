package com.liaoyb.fileStore.adapter;

import com.liaoyb.fileStore.domain.StoredFile;
import com.liaoyb.filestore.enums.FileTypeEnum;
import com.liaoyb.filestore.model.FileCloudInfo;

/**
 * @author ybliao2
 */
public class StoredFileAdapter {
    public static FileCloudInfo convertToFileCloudInfo(StoredFile storedFile){
        FileCloudInfo cloudInfo=null;
        if(storedFile==null){
            return null;
        }
        cloudInfo=new FileCloudInfo();
        cloudInfo.setUrl(storedFile.getUrl());
        cloudInfo.setKey(storedFile.getKey());
        cloudInfo.setFileType(FileTypeEnum.getObject(storedFile.getFileType()));
        cloudInfo.setFileSize(storedFile.getFileSize());
        cloudInfo.setDownloadUrl(storedFile.getDownloadUrl());
        return cloudInfo;
    }
}

package com.liaoyb.filestore.model;

import com.liaoyb.filestore.enums.FileTypeEnum;

import java.io.Serializable;

/**
 * 文件信息
 * @author ybliao2
 */
public class FileCloudInfo implements Serializable {
    //原始文件名
    private String originalFileName;

    //保存的地址
    private String savePath;
    //文件的key
    private String key;
    //文件类型
    private FileTypeEnum fileType;
    //访问url
    private String url;
    //下载url
    private String downloadUrl;
    private Long fileSize;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public FileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(FileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}

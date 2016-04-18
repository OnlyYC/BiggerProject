package com.liaoyb.filestore.model;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author ybliao2
 */
public class FileCloudObject implements Serializable {
    //文件的key
    private String key;
    //文件所包含的内容
    private InputStream fileContent;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public InputStream getFileContent() {
        return fileContent;
    }

    public void setFileContent(InputStream fileContent) {
        this.fileContent = fileContent;
    }
}

package com.liaoyb.fileStore.domain;

import com.liaoyb.filestore.enums.FileTypeEnum;
import com.liaoyb.util.SpringContextUtil;

/**
 * @author ybliao2
 */
public class UploadConfig {

    private String saveBasePath;
    private String baseUrl;

    public UploadConfig(String saveBasePath, String baseUrl) {
        this.saveBasePath = saveBasePath;
        this.baseUrl = baseUrl;
    }

    public UploadConfig() {
    }

    public String getSaveBasePath() {
        return saveBasePath;
    }

    public void setSaveBasePath(String saveBasePath) {
        this.saveBasePath = saveBasePath;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public static UploadConfig convertConfigBaseOnFileType(FileTypeEnum fileTypeEnum){
        String saveBasePath=null;
        String baseUrl=null;
        switch (fileTypeEnum){
            case DOC:
                saveBasePath= (String) SpringContextUtil.getBean("uploadDocPath");
                baseUrl=(String)SpringContextUtil.getBean("docUrl");
                break;
            case PICTURE:
                saveBasePath= (String) SpringContextUtil.getBean("uploadImagePath");
                baseUrl=(String)SpringContextUtil.getBean("imageUrl");
                break;
            case AUDIO:saveBasePath= (String) SpringContextUtil.getBean("uploadMusicPath");
                baseUrl=(String)SpringContextUtil.getBean("musicUrl");
                break;
            case VIDEO:saveBasePath= (String) SpringContextUtil.getBean("uploadVideoPath");
                baseUrl=(String)SpringContextUtil.getBean("videoUrl");
                break;
            case OTHER:saveBasePath= (String) SpringContextUtil.getBean("uploadOtherPath");
                baseUrl=(String)SpringContextUtil.getBean("otherUrl");
                break;

        }
        return new UploadConfig(saveBasePath,baseUrl);
    }

}

package com.liaoyb.fileStore.service.impl;

import com.liaoyb.fileStore.adapter.StoredFileAdapter;
import com.liaoyb.fileStore.dao.StoredFileMaper;
import com.liaoyb.fileStore.domain.StoredFile;
import com.liaoyb.fileStore.util.RecognizeFile;
import com.liaoyb.filestore.enums.FileTypeEnum;
import com.liaoyb.filestore.exception.FileNotExistException;
import com.liaoyb.filestore.exception.UnSupportException;
import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.filestore.service.FileStoreService;
import com.liaoyb.util.SpringContextUtil;
import com.liaoyb.util.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.File;
import java.io.InputStream;

/**
 * @author ybliao2
 */
@Service
public class DefaultFileServiceImpl implements FileStoreService {



    @Autowired
    private StoredFileMaper storedFileMaper;


    private static Logger logger= LoggerFactory.getLogger(DefaultFileServiceImpl.class);
    @Override
    public FileCloudInfo getFileCLoudInfo(String key) throws Exception {
        StoredFile storedFile=storedFileMaper.findByKey(key);
        if(storedFile==null)
            throw new FileNotExistException();
        return StoredFileAdapter.convertToFileCloudInfo(storedFile);
    }

    @Override
    public FileCloudInfo upload(String originalfileName, byte[] fileBytes) throws Exception {
        //根据文件名后缀判断类型

        Assert.hasLength(originalfileName);
        Assert.notNull(fileBytes);
        StoredFile storedFile=new StoredFile();
        FileTypeEnum fileTypeEnum=RecognizeFile.IdentifyFileType(originalfileName);
        storedFile.setFileType(fileTypeEnum.value());
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
        String key=UUIDUtil.getRandomStr();
        String fileName= key+originalfileName.substring(originalfileName.lastIndexOf("."));

        storedFile.setUrl(baseUrl+"/"+fileName);
        storedFile.setKey(key);
        storedFile.setFileSize(new Long(fileBytes.length));
        storedFile.setLocation(saveBasePath+"/"+fileName);

        //保存文件
        FileUtils.writeByteArrayToFile(new File(saveBasePath+"/"+fileName),fileBytes);

        //插入

        storedFileMaper.insertSelective(storedFile);

        return StoredFileAdapter.convertToFileCloudInfo(storedFile);
    }

    @Override
    public byte[] getFileBytes(String key) throws Exception {
        //查找
        StoredFile storedFile=storedFileMaper.findByKey(key);
        if(storedFile==null){
            throw new FileNotExistException();
        }
        return FileUtils.readFileToByteArray(new File(storedFile.getLocation()));
    }

    /**
     * 上传文件
     *
     * @param originalfileName 原来的文件名(包括后缀)，用于判断文件类型，后缀会最后新文件的后缀
     * @param input            文件内容流，内部自动close
     * @return
     */
    @Override
    public FileCloudInfo upload(String originalfileName, InputStream input) throws Exception {
        throw new UnSupportException();
    }

    /**
     * 下载
     *
     * @param key
     * @return 返回InputStream
     */
    @Override
    public InputStream download(String key) throws Exception {
        throw new UnSupportException();
    }
}

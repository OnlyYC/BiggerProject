package com.liaoyb.fileStore.service.impl;

import com.liaoyb.fileStore.adapter.StoredFileAdapter;
import com.liaoyb.fileStore.dao.StoredFileMaper;
import com.liaoyb.fileStore.domain.StoredFile;
import com.liaoyb.fileStore.domain.UploadConfig;
import com.liaoyb.fileStore.util.RecognizeFile;
import com.liaoyb.filestore.enums.FileTypeEnum;
import com.liaoyb.filestore.exception.FileNotExistException;
import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.filestore.service.FileStoreService;
import com.liaoyb.util.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

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


    /**
     * 保存信息
     * @param originalfileName
     * @param fileSize 文件大小
     * @return
     */
    @Transactional
    @Override
    public FileCloudInfo addFileInfo(String originalfileName, Integer fileSize) {
        Assert.hasLength(originalfileName);
        Assert.notNull(fileSize);
        StoredFile storedFile=new StoredFile();
        FileTypeEnum fileTypeEnum=RecognizeFile.IdentifyFileType(originalfileName);
        storedFile.setFileType(fileTypeEnum.value());

        UploadConfig uploadConfig=UploadConfig.convertConfigBaseOnFileType(fileTypeEnum);
        String saveBasePath=uploadConfig.getSaveBasePath();
        String baseUrl=uploadConfig.getBaseUrl();

        String key=UUIDUtil.getRandomStr();
        String fileName= key+originalfileName.substring(originalfileName.lastIndexOf("."));

        storedFile.setUrl(baseUrl+"/"+fileName);
        storedFile.setKey(key);
        storedFile.setOriginalFileName(originalfileName);
        storedFile.setFileSize(new Long(fileSize));
        storedFile.setLocation(saveBasePath+"/"+fileName);
        storedFile.setAddTime(new Date().getTime());


        //插入

        storedFileMaper.insertSelective(storedFile);

        return StoredFileAdapter.convertToFileCloudInfo(storedFile);
    }

    @Override
    @Transactional
    public FileCloudInfo upload(String originalfileName, byte[] fileBytes) throws Exception {
        //根据文件名后缀判断类型

        Assert.hasLength(originalfileName);
        Assert.notNull(fileBytes);
        StoredFile storedFile=new StoredFile();
        FileTypeEnum fileTypeEnum=RecognizeFile.IdentifyFileType(originalfileName);
        storedFile.setFileType(fileTypeEnum.value());

        UploadConfig uploadConfig=UploadConfig.convertConfigBaseOnFileType(fileTypeEnum);
        String saveBasePath=uploadConfig.getSaveBasePath();
        String baseUrl=uploadConfig.getBaseUrl();

        String key=UUIDUtil.getRandomStr();
        String fileName= key+originalfileName.substring(originalfileName.lastIndexOf("."));

        storedFile.setUrl(baseUrl+"/"+fileName);
        storedFile.setKey(key);
        storedFile.setOriginalFileName(originalfileName);
        storedFile.setFileSize(new Long(fileBytes.length));
        storedFile.setLocation(saveBasePath+"/"+fileName);
        storedFile.setAddTime(new Date().getTime());

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
        //根据文件名后缀判断类型

        Assert.hasLength(originalfileName);
        StoredFile storedFile=new StoredFile();
        FileTypeEnum fileTypeEnum=RecognizeFile.IdentifyFileType(originalfileName);
        storedFile.setFileType(fileTypeEnum.value());

        UploadConfig uploadConfig=UploadConfig.convertConfigBaseOnFileType(fileTypeEnum);
        String saveBasePath=uploadConfig.getSaveBasePath();
        String baseUrl=uploadConfig.getBaseUrl();

        String key=UUIDUtil.getRandomStr();
        String fileName= key+originalfileName.substring(originalfileName.lastIndexOf("."));

        storedFile.setUrl(baseUrl+"/"+fileName);
        storedFile.setKey(key);
        storedFile.setOriginalFileName(originalfileName);

        storedFile.setLocation(saveBasePath+"/"+fileName);
        storedFile.setAddTime(new Date().getTime());

        File saveFile=new File(saveBasePath+"/"+fileName);
        //保存文件
        FileUtils.copyInputStreamToFile(input,saveFile);
        storedFile.setFileSize(FileUtils.sizeOf(saveFile));
        //插入

        storedFileMaper.insertSelective(storedFile);

        return StoredFileAdapter.convertToFileCloudInfo(storedFile);
    }

    /**
     * 下载
     *
     * @param key
     * @return 返回InputStream
     */
    @Override
    public InputStream download(String key) throws Exception {
        StoredFile storedFile=storedFileMaper.findByKey(key);
        if(storedFile==null){
            throw new FileNotExistException();
        }
        return  FileUtils.openInputStream(new File(storedFile.getLocation()));
    }
}

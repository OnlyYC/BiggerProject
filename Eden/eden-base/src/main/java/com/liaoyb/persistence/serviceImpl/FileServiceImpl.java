package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.filestore.service.FileStoreService;
import com.liaoyb.persistence.service.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ybliao2
 */
@Service
public class FileServiceImpl implements FileService {

    //存储服务
    @Autowired
    private FileStoreService fileStoreService;

    /**
     * 上传,把文件放到上传路径中，插入记录
     *
     * @param fileUpload
     * @return
     */
    @Override
    @Transactional
    public FileCloudInfo upload(MultipartFile fileUpload) throws Exception {
//        String contentType=fileUpload.getContentType();

        String fileName="test.mp3";
        byte[]bytes= FileUtils.readFileToByteArray(new File("E:\\test.mp3"));

        FileCloudInfo fileCloudInfo=fileStoreService.upload(fileName,bytes);
        System.out.println("fileCloudInfo:"+fileCloudInfo);

        return fileCloudInfo;
    }


}

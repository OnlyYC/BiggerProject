package com.liaoyb.persistence.serviceImpl;

import com.alibaba.dubbo.common.utils.Assert;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.liaoyb.filestore.model.FileCloudInfo;
import com.liaoyb.filestore.service.FileStoreService;
import com.liaoyb.persistence.service.FileService;
import com.liaoyb.util.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
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

        Assert.notNull(fileUpload,"上传文件不能为空");
        byte[]bytes=fileUpload.getBytes();

        String originalFilename=fileUpload.getOriginalFilename();
        if(StringUtils.isEmpty(originalFilename)||originalFilename.indexOf(".")<0){
            originalFilename="裁剪.png";
        }
        FileCloudInfo fileCloudInfo=fileStoreService.addFileInfo(originalFilename,bytes.length);


        //保存
        FileUtils.writeByteArrayToFile(new File(fileCloudInfo.getSavePath()),fileUpload.getBytes());

        return fileCloudInfo;
    }


}

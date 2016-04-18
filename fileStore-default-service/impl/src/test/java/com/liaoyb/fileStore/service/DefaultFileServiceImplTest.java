package com.liaoyb.fileStore.service;

import com.liaoyb.fileStore.service.impl.DefaultFileServiceImpl;
import com.liaoyb.filestore.model.FileCloudInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author ybliao2
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext-dao.xml","classpath:spring/applicationContext-service.xml" })
public class DefaultFileServiceImplTest  extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private DefaultFileServiceImpl fileServiceImpl;
    @Test
    public void test() throws Exception {
        String fileName="test.mp3";
        byte[]bytes= FileUtils.readFileToByteArray(new File("E:\\test.mp3"));

        FileCloudInfo fileCloudInfo=fileServiceImpl.upload(fileName,bytes);
        System.out.println("fileCloudInfo:"+fileCloudInfo);
    }
}

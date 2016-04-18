package com.liaoyb.fileStore.dao;

import com.liaoyb.fileStore.domain.StoredFile;
import org.apache.ibatis.annotations.Param;

/**
 * @author ybliao2
 */
public interface StoredFileMaper {

    //插入
    int insertSelective(StoredFile storedFile);

    //查找
    StoredFile findByKey(@Param("key") String key);
}

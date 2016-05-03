package com.liaoyb.fileStore.util;

import com.liaoyb.filestore.enums.FileTypeEnum;
import org.springframework.util.Assert;

/**
 * @author ybliao2
 */
public class RecognizeFile {
    private static final String PICTURE_RegEx=".+\\.(JPEG|jpeg|JPG|jpg|GIF|gif|BMP|bmp|PNG|png)$";
    private static final String DOC_RegEx=".+\\.(txt|doc|excel)$";
    private static final String AUDIO_RegEx=".+\\.(mp3|wav)$";
    private static final String VIDEO_RegEx=".+\\.mp4$";
    public static FileTypeEnum IdentifyFileType(String fileName){
        Assert.hasLength(fileName);

        if(fileName.matches(PICTURE_RegEx)){
            return FileTypeEnum.PICTURE;
        }
        if(fileName.matches(DOC_RegEx)){
            return FileTypeEnum.DOC;
        }
        if(fileName.matches(AUDIO_RegEx)){
            return FileTypeEnum.AUDIO;
        }
        if(fileName.matches(VIDEO_RegEx)){
            return FileTypeEnum.VIDEO;
        }
        return FileTypeEnum.OTHER;


    }
}

package com.liaoyb.filestore.enums;

/**
 * @author ybliao2
 */
public enum FileTypeEnum {
    DOC(0),
    PICTURE(1),
    AUDIO(2),
    VIDEO(3),
    OTHER(4);
    private int value;

    FileTypeEnum(int value) {
        this.value=value;
    }
    public int value(){
        return this.value;
    }

    /**
     * 根据枚举值获取枚举对象
     * @param value
     * @return
     */
    public static FileTypeEnum getObject(int value) {
        for (FileTypeEnum c : FileTypeEnum.values()) {
            if (c.value() == value) {
                return c;
            }
        }
        return null;
    }

}

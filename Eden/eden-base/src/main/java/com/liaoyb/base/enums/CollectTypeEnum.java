package com.liaoyb.base.enums;

/**
 * @author ybliao2
 */
public enum CollectTypeEnum {
    SONGLIST(1L),
    ALBUM(2L),
    Artist(3L),
    MV(4L),
    USER(5L);
    private Long value;
    CollectTypeEnum(Long value) {
        this.value=value;
    }
    public Long value(){
        return value;
    }
}

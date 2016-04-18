package com.liaoyb.base.enums;

/**
 * 用户角色类型
 * 用户,管理员
 * @author ybliao2
 */
public enum  UserRoleTypeEnum {
    //用户
    User(1L),
    //管理员
    Admin(2L);
    private Long value;

    private UserRoleTypeEnum(Long value) {
        this.value = value;
    }

    public Long value(){
        return value;
    }
}

package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.User;

import java.util.List;

/**
 * @author ybliao2
 */
public class UserDto extends User{
    //角色类型
    private List<Long>roleType;

    public List<Long> getRoleType() {
        return roleType;
    }

    public void setRoleType(List<Long> roleType) {
        this.roleType = roleType;
    }
}

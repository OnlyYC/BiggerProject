package com.liaoyb.persistence.domain.vo.base;

public class Role {
    private Long id;

    private String roleName;

    private Long roleType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }
}
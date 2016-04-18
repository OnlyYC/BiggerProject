package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.User;

/**
 * 用户详细信息
 * @author ybliao2
 */
public class UserInfo extends User{

    private Integer dynamicCount;//动态数量
    private Integer focusCount;//我关注的用户个数
    private Integer fansCount;//粉丝个数（即我被关注的个数）

    private String countryText;//国家，字典项对应文字

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }

    public Integer getDynamicCount() {
        return dynamicCount;
    }

    public void setDynamicCount(Integer dynamicCount) {
        this.dynamicCount = dynamicCount;
    }

    public Integer getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Integer focusCount) {
        this.focusCount = focusCount;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }
}

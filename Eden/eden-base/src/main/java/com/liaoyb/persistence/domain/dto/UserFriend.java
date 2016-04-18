package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.User;

/**
 * 用户好友
 * @author ybliao2
 */
public class UserFriend extends User {
    private String countryText;//国家，字典项对应文字

    public String getCountryText() {
        return countryText;
    }

    public void setCountryText(String countryText) {
        this.countryText = countryText;
    }
}

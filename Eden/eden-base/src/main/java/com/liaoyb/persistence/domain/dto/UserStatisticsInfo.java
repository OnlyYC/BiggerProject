package com.liaoyb.persistence.domain.dto;

import java.util.List;

/**
 * 统计用户
 * @author ybliao2
 */
public class UserStatisticsInfo {
    //在线用户
    private Integer onlineCount;
    //总用户数
    private Integer allCount;
    //男
    private Integer manCount;
    //女
    private Integer womanCount;
    //未知
    private Integer unKnowCount;
    //今日新增用户
    private Integer todayIncreaseCount;

    //最近10天用户的访问量
    private List<Integer>userAccessCountTenDay;

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getManCount() {
        return manCount;
    }

    public void setManCount(Integer manCount) {
        this.manCount = manCount;
    }

    public Integer getWomanCount() {
        return womanCount;
    }

    public void setWomanCount(Integer womanCount) {
        this.womanCount = womanCount;
    }

    public Integer getUnKnowCount() {
        return unKnowCount;
    }

    public void setUnKnowCount(Integer unKnowCount) {
        this.unKnowCount = unKnowCount;
    }

    public List<Integer> getUserAccessCountTenDay() {
        return userAccessCountTenDay;
    }

    public void setUserAccessCountTenDay(List<Integer> userAccessCountTenDay) {
        this.userAccessCountTenDay = userAccessCountTenDay;
    }

    public Integer getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(Integer onlineCount) {
        this.onlineCount = onlineCount;
    }


    public Integer getTodayIncreaseCount() {
        return todayIncreaseCount;
    }

    public void setTodayIncreaseCount(Integer todayIncreaseCount) {
        this.todayIncreaseCount = todayIncreaseCount;
    }
}

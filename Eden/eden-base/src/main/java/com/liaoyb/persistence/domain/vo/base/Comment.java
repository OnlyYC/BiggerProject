package com.liaoyb.persistence.domain.vo.base;

public class Comment {
    private Long id;

    private Long addDate;

    private Long belong;

    private String content;

    private Long fatherCommentId;

    private Long praiseCount;

    private Long type;

    private String userAvatarUrl;

    private Long userId;

    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddDate() {
        return addDate;
    }

    public void setAddDate(Long addDate) {
        this.addDate = addDate;
    }

    public Long getBelong() {
        return belong;
    }

    public void setBelong(Long belong) {
        this.belong = belong;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getFatherCommentId() {
        return fatherCommentId;
    }

    public void setFatherCommentId(Long fatherCommentId) {
        this.fatherCommentId = fatherCommentId;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl == null ? null : userAvatarUrl.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
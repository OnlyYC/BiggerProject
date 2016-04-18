package com.liaoyb.persistence.domain.dto;

import com.liaoyb.persistence.domain.vo.base.Dynamic;

/**
 * 动态dto
 * @author ybliao2
 */
public class DynamicDto extends Dynamic{

    private int commentCount;

    /**
     * 评论数（不算子评论）
     * @return
     */
    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}

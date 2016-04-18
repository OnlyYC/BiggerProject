package com.liaoyb.persistence.domain.vo.custom;

import com.liaoyb.persistence.domain.vo.base.Comment;

import java.util.List;

/**
 * 评论扩展
 *
 * @author liao
 * @create 2016-01-30-15:44
 **/
public class CommentCustom extends Comment {


    //子评论数量
    private int childCommentCount;

    public int getChildCommentCount() {
        return childCommentCount;
    }

    public void setChildCommentCount(int childCommentCount) {
        this.childCommentCount = childCommentCount;
    }

    //子评论，评论扩展
    private List<CommentCustom>childComments;

    public List<CommentCustom> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<CommentCustom> childComments) {
        this.childComments = childComments;
    }


}

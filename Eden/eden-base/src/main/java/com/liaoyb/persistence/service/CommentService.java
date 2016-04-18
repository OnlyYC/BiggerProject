package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.vo.base.Comment;
import com.liaoyb.persistence.domain.vo.custom.CommentCustom;

/**
 * 评论service
 * Created by  liao on 2016/2/5.
 */
public interface CommentService {

    //查询......................................................

    /**
     * 评论,type类型区分是歌曲还是歌单的评论,分页
     * @param page 分页
     * @param belongId 所属id
     * @param type 评论类型
     * @return 评论分页数据
     */
    Page<CommentCustom> findCommentCustomsPage(Page<CommentCustom> page, Long belongId, Long type);



    //操作.......................................................

    /**
     * 用户添加评论,也可以是回复
     * @param comment 评论
     */
    void addUserComment(Comment comment);



    /**
     * 赞评论
     * @param commentId 评论id
     */
    void praiseComment(Long commentId);


    /**
     * 发表评论、回复评论
     * @param userId
     * @param type
     * @param targetId
     * @param commType 0--发表评论，1--回复评论
     * @return
     */
    Response submitComment(Long userId, Long type, Long targetId,String content, String commType) throws Exception;
}

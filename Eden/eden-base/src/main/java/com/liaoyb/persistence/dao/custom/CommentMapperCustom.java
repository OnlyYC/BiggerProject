package com.liaoyb.persistence.dao.custom;

import com.liaoyb.persistence.domain.vo.base.Comment;
import com.liaoyb.persistence.domain.vo.custom.CommentCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论扩展dao
 * Created by  liao on 2016/1/31.
 */
public interface CommentMapperCustom {


    //子评论
    List<Comment>findChildComments(@Param("fatherCommentId") Long fatherCommentId);


    /**
     * 查找评论扩展,根据所属id和类型,默认按照时间排序
     * @param belongId
     * @param type
     * @return
     */
    List<CommentCustom> findCommentCustoms(@Param("belongId") Long belongId, @Param("type") Long type);


    /**
     * 最热门评论,根据所属id和类型,按照赞的数量排序
     * @param belongId
     * @param type
     * @return
     */
    List<CommentCustom> findCommentCustomsHot(@Param("belongId") Long belongId, @Param("type") Long type);


    /**
     * 赞评论
     * @param commentId
     */
    int praiseComment(@Param("commentId") Long commentId);


}

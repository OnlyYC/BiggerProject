package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.dao.base.CommentMapper;
import com.liaoyb.persistence.dao.base.UserMapper;
import com.liaoyb.persistence.dao.custom.CommentMapperCustom;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.vo.base.Comment;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.CommentCustom;
import com.liaoyb.persistence.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 评论服务
 * @author ybliao2
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapperCustom commentMapperCustom;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 评论,type类型区分是歌曲还是歌单的评论,分页
     * @param page 分页
     * @param belongId 所属id
     * @param type 评论类型
     * @return 评论分页数据
     */
    @Override
    @PageAnnotation
    public Page<CommentCustom> findCommentCustomsPage(Page<CommentCustom> page, Long belongId, Long type) {
        List<CommentCustom>commentCustoms= commentMapperCustom.findCommentCustoms(belongId,type);
        page.setResult(commentCustoms);
        return page;
    }


    /**
     * 用户添加评论,也可以是回复
     * @param comment 评论
     */
    @Override
    @Transactional
    public void addUserComment(Comment comment) {
        comment.setAddDate(new Date().getTime());
        comment.setPraiseCount(0L);
        commentMapper.insertSelective(comment);
    }

    /**
     * 赞评论
     * @param commentId 评论id
     */
    @Override
    @Transactional
    public void praiseComment(Long commentId) {
        commentMapperCustom.praiseComment(commentId);
    }

    /**
     * 发表评论、回复评论
     *
     * @param userId
     * @param type
     * @param targetId
     * @param commType      0--发表评论，1--回复评论
     * @return
     */
    @Override
    @Transactional
    public Response submitComment(Long userId, Long type, Long targetId,String content, String commType) throws Exception {
        //用户
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null){
            throw  new Exception("用户不存在");
        }
        if(StringUtils.isEmpty(content)){
            return new Response().failure("评论不能为空");
        }

        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setUsername(user.getName());
        comment.setUserAvatarUrl(user.getAvatarUrl());

        comment.setContent(content);
        comment.setAddDate(new Date().getTime());
        if("0".equals(commType)){
            comment.setType(type);
            comment.setBelong(targetId);
            commentMapper.insertSelective(comment);
            return new Response().success("评论成功",null);
        }else if("1".equals(commType)){
            comment.setFatherCommentId(targetId);
            commentMapper.insertSelective(comment);
            return new Response().success("回复成功",null);
        }else{
            throw new Exception("发表评论失败");
        }
    }


}

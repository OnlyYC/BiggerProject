package com.liaoyb.web.api;

import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.CommentCustom;
import com.liaoyb.persistence.service.CommentService;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 评论
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查找评论,type区分类型
     * @param response
     * @param page
     * @param belongId
     * @param type
     */
    @RequestMapping("/findComments")
    public void findComments(HttpServletResponse response, Page<CommentCustom> page, Long belongId, Long type){
        page=commentService.findCommentCustomsPage(page,belongId,type);
        MyResultUtil.sendPage(response,page);
    }


    /**
     * 发表评论、回复评论
     * @param response
     * @param type
     * @param targetId
     * @param commType 0--发表评论，1--回复评论
     */
    @RequestMapping("/submitComment")
    @AuthPassport
    public void submitComment(HttpServletRequest request, HttpServletResponse response, Long type,String content, Long targetId, String commType) throws Exception {
        User currentUser= WebUtils.getCurrentUser(request);
        Response res=commentService.submitComment(currentUser.getId(),type,targetId,content,commType);
        MyResultUtil.sendResponse(response,res);
    }



    /**
     *
     * 赞评论
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/praiseComment")
    public void praiseComment(HttpServletRequest request, HttpServletResponse response,Long commentId) throws Exception {
        commentService.praiseComment(commentId);
        MyResultUtil.sendSuccess(response,"你赞了该用户评论");
    }


}

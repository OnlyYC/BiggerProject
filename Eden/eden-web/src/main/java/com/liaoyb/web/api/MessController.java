package com.liaoyb.web.api;

import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.vo.base.Mess;
import com.liaoyb.persistence.service.MessService;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/mess")
public class MessController {

    @Autowired
    private MessService messService;


    /**
     * 我的所有信息
     * @param request
     * @param response
     * @param page
     */
    @RequestMapping("/showMyAllMess")
    @AuthPassport
    public void showMyAllMess(HttpServletRequest request, HttpServletResponse response, Page<Mess>page){
        UserDto currentUser= WebUtils.getCurrentUser(request);
        page=messService.findUserAllMess(page,currentUser.getId());
        MyResultUtil.sendPage(response,page);
    }


    /**
     * 用户最新信息
     * @param request
     * @param response
     * @param page
     * @param lastTime
     */
    @RequestMapping("/showMyLastMess")
    @AuthPassport
    public void showMyLastMess(HttpServletRequest request, HttpServletResponse response, Page<Mess>page,Long lastTime){
        UserDto currentUser= WebUtils.getCurrentUser(request);
        page=messService.findUserLastMess(page,currentUser.getId(),lastTime);
        MyResultUtil.sendPage(response,page);
    }
    //用户之前的信息(未读)
    @RequestMapping("/showMyUreadMessPrevious")
    @AuthPassport
    public void showMyUreadMessPrevious(HttpServletRequest request, HttpServletResponse response, Page<Mess>page,Long previousTime){
        UserDto currentUser= WebUtils.getCurrentUser(request);
        page=messService.findUserPreviousMess(page,currentUser.getId(),previousTime);
        MyResultUtil.sendPage(response,page);
    }

    /**
     * 把消息置为已读
     * @param request
     * @param response
     * @param messId
     */
    @RequestMapping("/readMess")
    @AuthPassport
    public void readMess(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "messId[]",required = false)Long []messId){


        if(messId==null||messId.length==0){
            MyResultUtil.sendFail(response,"已没有未读消息了");
        }

        UserDto currentUser= WebUtils.getCurrentUser(request);
        boolean isSuccess=messService.readMess(currentUser.getId(), messId);
        if(isSuccess){
            MyResultUtil.sendSuccess(response,"已设置为已读");
        }else{
            MyResultUtil.sendSuccess(response,"消息已读设置失败");
        }


    }


}

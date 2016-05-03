package com.liaoyb.web.api;

import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.domain.Page;
import com.liaoyb.base.support.exception.CustomException;
import com.liaoyb.base.support.exception.SourcesNotFoundException;
import com.liaoyb.persistence.domain.dto.*;
import com.liaoyb.persistence.domain.vo.base.Collect;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.custom.SongCustom;
import com.liaoyb.persistence.service.CollectService;
import com.liaoyb.persistence.service.UserService;
import com.liaoyb.persistence.serviceImpl.UserServiceImpl;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import com.liaoyb.util.BaseWebUtils;
import com.liaoyb.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author liao
 * @create 2016-01-30-19:19
 **/
@Controller
@RequestMapping("/api/admin")
public class AdminController {
    private static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserService userService;

    @Autowired
    private CollectService collectService;








    /**
     * 管理员登录
     * 返回登陆信息
     * @param email
     * @param password
     * @return
     */
    @RequestMapping("/adminLogin")
    public void adminLogin(HttpServletRequest request,HttpServletResponse response,String email,String password) throws Exception {



        UserDto userDto=userService.adminLogin(email,password, BaseWebUtils.getIP(request));

        if(userDto!=null){
            //登录成功
            MyResultUtil.sendSuccess(response,"登录成功");
            WebUtils.setCurrentUser(request,userDto);
        }else{
            //登录失败
            MyResultUtil.sendFail(response,"登录失败,请重新登陆");
        }


    }

    /**
     * 管理员退出
     * @param response
     */
    @RequestMapping("/adminLogout")
    public void adminLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        //添加历史
        UserDto userDto=WebUtils.getCurrentUser(request);
        if(userDto!=null){
            userService.adminLogout(userDto,BaseWebUtils.getIP(request));
        }
        //session失效
        session.invalidate();
        MyResultUtil.sendSuccess(response,"退出成功");
    }







}

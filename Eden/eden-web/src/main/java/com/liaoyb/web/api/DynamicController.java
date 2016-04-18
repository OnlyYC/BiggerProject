package com.liaoyb.web.api;

import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.DynamicDto;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.service.DynamicService;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 动态Controller
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/dynamic")
public class DynamicController {

    @Autowired
    private DynamicService dynamicService;



    /**
     * 当前用户
     * 与用户相关的动态包含官方动态
     * @param page
     */
    @RequestMapping("/findDynamicRelative")
    @AuthPassport
    public void findDynamicRelative(HttpServletRequest request, HttpServletResponse response, Page<DynamicDto> page){
        UserDto userDto= WebUtils.getCurrentUser(request);
        page=dynamicService.findDynamicRelative(page,userDto.getId());
        MyResultUtil.sendPage(response,page);
    }


    /**
     * 用户动态
     * @param request
     * @param response
     * @param page
     * @param userId
     */
    @RequestMapping("/userDynamic")
    public void findUserDynamic(HttpServletRequest request, HttpServletResponse response, Page<DynamicDto> page,Long userId){
        page=dynamicService.findUserDynamic(page,userId);
        MyResultUtil.sendPage(response,page);
    }

}

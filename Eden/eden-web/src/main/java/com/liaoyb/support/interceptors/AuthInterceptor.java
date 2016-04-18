package com.liaoyb.support.interceptors;

import com.liaoyb.base.annotation.AuthPassport;
import com.liaoyb.base.enums.UserRoleTypeEnum;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.base.support.exception.NotLoginException;
import com.liaoyb.base.support.exception.PermissionDeniedException;
import com.liaoyb.support.utils.WebUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限验证拦截器
 * @author ybliao2
 */
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);
            //是否拦截，默认拦截
            boolean result = false;
            if(authPassport!=null) {
                //拿到当前用户
                UserDto userDto= WebUtils.getCurrentUser(request);
                if(userDto==null){

                    //未登录
                    throw new NotLoginException();
                }
                for(UserRoleTypeEnum roleType:authPassport.value()){
                    if(!userDto.getRoleType().contains(roleType.value())){
                        //不包含此权限
                        throw new PermissionDeniedException();
                    }
                }

            }




        }
        return true;
    }
}

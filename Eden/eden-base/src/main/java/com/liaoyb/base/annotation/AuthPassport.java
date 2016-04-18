package com.liaoyb.base.annotation;

import com.liaoyb.base.enums.UserRoleTypeEnum;

import java.lang.annotation.*;

/**
 * 权限验证注解
 * @author ybliao2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthPassport {

    UserRoleTypeEnum[]value() default {UserRoleTypeEnum.User};
}

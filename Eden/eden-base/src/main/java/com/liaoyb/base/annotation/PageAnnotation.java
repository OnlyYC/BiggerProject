package com.liaoyb.base.annotation;

import java.lang.annotation.*;

/**
 * Created by  liao on 2016/1/27.
 * 在方法上使用此注解可以进行分页,参数中必须要有Page类型的形参，返回值为Page类型
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageAnnotation {
}

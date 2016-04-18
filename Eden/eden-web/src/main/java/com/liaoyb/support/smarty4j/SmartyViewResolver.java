package com.liaoyb.support.smarty4j;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

/**
 * 基于smarty4j模板的springmvc视图解析器
 * @author ybliao2
 */
public class SmartyViewResolver extends AbstractTemplateViewResolver {
    public SmartyViewResolver() {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return SmartyView.class;
    }
}

package com.liaoyb.support.smarty4j;

import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.support.utils.WebUtils;
import org.lilystudio.smarty4j.Context;
import org.lilystudio.smarty4j.Engine;
import org.lilystudio.smarty4j.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContextException;
import org.springframework.web.servlet.view.AbstractTemplateView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 基于smarty4j模板的视图
 * @author ybliao2
 */
public class SmartyView extends AbstractTemplateView {

    private static String webRootPath;

    //web请求根地址
    private static String webRootUrl;
    //smarty的模板引擎
    private static Engine smartyEngine;
    //是否已经初始化好了
    private static boolean isInited=false;

    //初始化并发锁
    private static final Object lock=new Object();
    private static Logger logger=LoggerFactory.getLogger(SmartyView.class.getName());


    @Override
    protected void renderMergedTemplateModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(!isInited){
            synchronized (lock){
                if(!isInited){
                    //初始化配置
                    init(request);
                    logger.debug("初始化");
                    isInited=true;
                }
            }
        }

        Template template=smartyEngine.getTemplate(this.getUrl());
        Context context=new Context();

        //把model中设置的值放到smarty的上下文中
        for(Map.Entry<String,Object>entry:model.entrySet()){
            context.set(entry.getKey(),entry.getValue());
        }
        context.set("baseUrl",webRootUrl);

        //设置当前用户

        //测试复杂对象,是否支持el中的写法
        UserDto userDto=WebUtils.getCurrentUser(request);
        if(userDto!=null){
            context.set("currentUser",userDto);
        }


        response.setCharacterEncoding(smartyEngine.getEncoding());
        template.merge(context,response.getOutputStream());
    }

    /**
     * 初始化
     * @param request HttpServletRequest
     */
    synchronized private void init(HttpServletRequest request) {

        extractConfigs(request);
        autodetectEngine();
    }


    /**
     * 从spring的ApplicationContext中得到smarty4j的模板引擎
     */
    private void autodetectEngine() {
        try {
            if (smartyEngine == null) {
                smartyEngine = BeanFactoryUtils.beanOfTypeIncludingAncestors(getApplicationContext(), Engine.class, true, false);
                smartyEngine.setTemplatePath(webRootPath + smartyEngine.getTemplatePath());
            }
        }catch (NoSuchBeanDefinitionException ex){
            throw new ApplicationContextException("Must define a single org.lilystudio.smarty4j.Engine bean in this web application context "
                    + "(may be inherited): org.lilystudio.smarty4j.Engine is the usual implementation. " + "This bean may be given any name.", ex);
        }
    }


    /**
     * 加载配置信息，放到smarty的context中
     * @param request HttpServletRequest
     */
    private void extractConfigs(HttpServletRequest request) {
        if(webRootPath==null){
            webRootPath=request.getSession().getServletContext().getRealPath("/");
        }
        if(webRootUrl==null){
            webRootUrl=request.getSession().getServletContext().getContextPath();
        }
        logger.debug("webRootPath:"+webRootPath+";webRootUrl:"+webRootUrl);
    }







}

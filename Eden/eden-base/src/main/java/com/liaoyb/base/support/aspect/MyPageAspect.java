package com.liaoyb.base.support.aspect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author liao
 * @create 2016-01-27-18:19
 **/
@Component
@Aspect
public class MyPageAspect {
    private static Logger logger= LoggerFactory.getLogger(MyPageAspect.class);



    @Around("@annotation(com.liaoyb.base.annotation.PageAnnotation)&&@annotation(pa)")
    public Object disposePage(ProceedingJoinPoint pjd, PageAnnotation pa){

        Object result=null;
        //获取参数
        Object[]args=pjd.getArgs();
        //遍历参数拿到page
        Page page=null;
        for(Object obj:args){
            if(obj instanceof Page){
                page= (Page) obj;
            }
        }

        try {
            if (page == null) {
                logger.error("没有Page类型的分页参数");
                result = pjd.proceed();
            } else {
                PageHelper.startPage(page.getPageNumber(), page.getPageSize());

                //排序
                if (!StringUtils.isEmpty(page.getOrderBy())) {
                    PageHelper.orderBy(page.getOrderBy());
                }
                //执行目标方法
                result = pjd.proceed();
                PageInfo pageInfo = new PageInfo( ((Page)result).getResult());
                System.out.println("pageinfo:" + pageInfo);

                page.setResult(pageInfo.getList());
                page.setTotalCount(pageInfo.getTotal());
                result=page;
            }
        }catch (Throwable e){
            logger.error("分页发生异常了");
            throw new RuntimeException(e);
        }


        //返回
        return result;
    }
}

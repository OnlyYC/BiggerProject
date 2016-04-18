package com.liaoyb.support.filter;

import com.liaoyb.base.support.utils.CollectionUtil;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CorsFilter implements Filter {

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowOrigin = filterConfig.getInitParameter("allowOrigin");
        allowMethods = filterConfig.getInitParameter("allowMethods");
        allowCredentials = filterConfig.getInitParameter("allowCredentials");
        allowHeaders = filterConfig.getInitParameter("allowHeaders");
        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (!StringUtils.isEmpty(allowOrigin)) {
            List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
            if (CollectionUtil.isNotEmpty(allowOriginList)) {
                String currentOrigin = request.getHeader("Origin");
                if(allowOrigin.isEmpty()||allowOrigin.equals("*")){
                	  response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                }else  if (allowOriginList.contains(currentOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                }
            }
        }
        if (!StringUtils.isEmpty(allowMethods)) {
            response.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        if (!StringUtils.isEmpty(allowCredentials)) {
            response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        }
        if (!StringUtils.isEmpty(allowHeaders)) {
            response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        }
        if (!StringUtils.isEmpty(exposeHeaders)) {
            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        chain.doFilter(req, res);
    }



    @Override
    public void destroy() {
    }
}

package com.liaoyb.support.utils;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class WebUtils {
	private static final String SESSION_KEY_CURRENT_USER ="SESSION_KEY_CURRENT_USER";
	private static final String SESSION_KEY_VERIFY_CODE= "SESSION_KEY_VERIFY_CODE";


	public static final String CONTENTTYPE_TEXTJSON = "application/json";
	public static final String CONTENT_CHARSET_UTF8 = "UTF-8";
	public static final String CONTENTTYPE_TEXTHTML = "text/html";

	public static Logger logger= LoggerFactory.getLogger(WebUtils.class);





	/**
	 * 从Session中获取用户信息
	 *
	 * @param request request
	 * @return 用户信息
	 */
	public static UserDto getCurrentUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute(SESSION_KEY_CURRENT_USER);


//		userDto=new UserDto();
//		userDto.setId(1L);
//		userDto.setUsername("GG");
//		userDto.setRoleType(Arrays.asList(1L));


		return userDto;
	}


	/**
	 * 设置当前用户
	 * 用户登陆后，把用户信息放到session中
	 * @param request
	 * @param userDto
     */
	public static void setCurrentUser(HttpServletRequest request,UserDto userDto){
		HttpSession session=request.getSession();
		session.setAttribute(SESSION_KEY_CURRENT_USER,userDto);
	}


	/**
	 * 保存验证码到session
	 * @param request
	 * @param code
     */
	public static void setVerifyCodeSession( HttpServletRequest request,String code) {
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_KEY_VERIFY_CODE, code);
	}



	/**
	 * 根据request拿到验证码
	 * @param request
	 * @return
     */
	public static String getVerifyCode(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object object = session.getAttribute(SESSION_KEY_VERIFY_CODE);
		return object == null ? null : object.toString();
	}


	/**
	 * 网站基本路径
	 * @param request
	 * @return
     */
	public static String baseUrl(HttpServletRequest request){
		return request.getRequestURL().substring(0,request.getRequestURL().indexOf(request.getServletPath()));
	}


	/**
	 * 设置分页参数
	 * @param page
	 * @param request
     */
	public static void setPage(Page page,HttpServletRequest request){
		String strStart=request.getParameter("start");
		String strLength=request.getParameter("length");
		if(strLength!=null&&strStart!=null){
			Integer start=Integer.valueOf(request.getParameter("start"));
			Integer length=Integer.valueOf(request.getParameter("length"));
			if(page!=null){
				Integer pageNumber=start/length+1;
				page.setPageNumber(pageNumber);
				page.setPageSize(length);
			}
		}

	}




}

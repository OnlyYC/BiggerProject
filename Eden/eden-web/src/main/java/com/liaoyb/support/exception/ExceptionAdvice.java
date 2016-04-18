package com.liaoyb.support.exception;

import com.liaoyb.base.support.exception.CustomException;
import com.liaoyb.base.support.exception.NotLoginException;
import com.liaoyb.base.support.exception.PermissionDeniedException;
import com.liaoyb.base.support.exception.SourcesNotFoundException;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.support.utils.MyResultUtil;
import com.liaoyb.support.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理异常行为
 * 
 * @author liao
 *
 */
@ControllerAdvice
public class ExceptionAdvice {

	protected final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class.getName());

	/**
	 * 400 - Bad Request
	 * 校验失败
	 */
	@ExceptionHandler(BindException.class)
	public void handleHttpMessageNotReadableException(HttpServletResponse response, BindException e) {
		// 校验信息
		BindingResult bindingResult = e.getBindingResult();
		
		
		//放入出错信息
		Map<String,String>errorMess=new HashMap<String,String>();
		
		
		// 获取校验出错信息
		if (bindingResult.hasErrors()) {
			// 输出错误信息
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			for (FieldError fieldError : fieldErrors) {
				// 输出错误信息
				System.out.println("error:" + fieldError.getField() + "=" + fieldError.getDefaultMessage());
				errorMess.put(fieldError.getField(), fieldError.getDefaultMessage());
			}

		}
		logger.error("参数验证失败", e);
		MyResultUtil.sendResponse(response,new Response().failureValidate("validation_exception", errorMess));;
	}

	@ExceptionHandler(TypeMismatchException.class)
	public void typeMismatchException(HttpServletRequest requeset, HttpServletResponse response, TypeMismatchException e) throws ServletException, IOException {
		logger.error("参数转换失败");
		if(WebUtils.isAjaxRequest(requeset)){
			//ajax请求

			MyResultUtil.sendResponse(response,new Response().failure("参数转换失败"));
		}else{
			//转发到404页面
			requeset.getRequestDispatcher(requeset.getContextPath()+"/notFound").forward(requeset,response);
		}
	}
	/**
	 * 400 - Bad Request
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public void handleHttpMessageNotReadableException(HttpServletResponse response,MissingServletRequestParameterException e) {
		 logger.error("参数绑定失败", e);
		MyResultUtil.sendResponse(response,new Response().failure("could_bind_param"));
	}

	/**
	 * 400 - Bad Request
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public void handleHttpMessageNotReadableException(HttpServletResponse response,HttpMessageNotReadableException e) {
		logger.error("参数解析失败", e);
		MyResultUtil.sendResponse(response,new Response().failure("could_not_read"));
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public void handleHttpRequestMethodNotSupportedException(HttpServletResponse response,HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法", e);
		MyResultUtil.sendResponse(response, new Response().failure("request_method_not_supported"));
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public void handleHttpMediaTypeNotSupportedException(HttpServletResponse response,Exception e) {
		logger.error("不支持当前媒体类型", e);
		MyResultUtil.sendResponse(response,new Response().failure("content_type_not_supported"));
	}


	/**
	 * 未登录异常
	 * @param response HttpServletResponse
	 * @param e NotLoginException
     */
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NotLoginException.class)
	public void handleNotLoginException(HttpServletResponse response,NotLoginException e) {


		logger.debug("未登录");
		MyResultUtil.sendResponse(response,new Response().notLogin());
	}


	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PermissionDeniedException.class)
	public void handlePermissionDeniedException(HttpServletResponse response,PermissionDeniedException e) {


		logger.debug("权限不足");
		MyResultUtil.sendResponse(response,new Response().permissionDenied());
	}

	//资源未找到
	@ExceptionHandler(SourcesNotFoundException.class)
	public void handleSourcesNotFoundException(HttpServletRequest request, HttpServletResponse response, SourcesNotFoundException e) throws ServletException, IOException {
		logger.debug("请求资源未找到");
		if(WebUtils.isAjaxRequest(request)){
			//ajax请求

			MyResultUtil.sendResponse(response,new Response().failure("请求资源未找到"));
		}else{
			//转发到404页面
			request.getRequestDispatcher(request.getContextPath()+"/notFound").forward(request,response);
		}
	}


	/**
	 * 500 - Internal Server Error
	 */
	@ExceptionHandler(Exception.class)
	public void handleException(HttpServletRequest request,HttpServletResponse response,Exception e) throws ServletException, IOException {


		//自定义异常
		logger.error("服务运行异常", e);

		if(WebUtils.isAjaxRequest(request)){
			//ajax请求

			if(e instanceof CustomException){
				MyResultUtil.sendResponse(response,new Response().failure(e.getMessage()));
			}else{
				//未知异常
				MyResultUtil.sendResponse(response,new Response().failure("很抱歉的通知您,出现未知错误了"));
			}
		}else{
			//转发到错误页面
			request.getRequestDispatcher(request.getContextPath()+"/error").forward(request,response);
		}



	}
}

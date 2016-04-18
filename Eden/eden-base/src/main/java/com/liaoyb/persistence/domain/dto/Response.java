package com.liaoyb.persistence.domain.dto;

import java.util.Map;

/**
 * 返回到客户端的类,用来统一发送的格式
 * @author liao
 *
 */
public class Response {

	private static final String OK="ok";
	private static final String ERROR = "error";


	/**
	 * 结果标示
	 */
	private boolean flag;

	/**
	 * 结果详细
	 */
	private String message;
	
	/**
	 * 需要传回页面的数据
	 */
	private Object data;


	//未登陆
	private Boolean notLogin;

	//权限
	private Boolean permissionDenied;


	//校验
	private Map<String,String> validate;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getNotLogin() {
		return notLogin;
	}

	public void setNotLogin(Boolean notLogin) {
		this.notLogin = notLogin;
	}

	public Boolean getPermissionDenied() {
		return permissionDenied;
	}

	public void setPermissionDenied(Boolean permissionDenied) {
		this.permissionDenied = permissionDenied;
	}

	public Map<String, String> getValidate() {
		return validate;
	}

	public void setValidate(Map<String, String> validate) {
		this.validate = validate;
	}

	public boolean isFlag() {
		return flag;
	}



	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Response(boolean flag, String message, Object data) {
		super();
		this.flag = flag;
		this.message = message;
		this.data = data;
	}
	public Response(boolean flag, String message) {
		super();
		this.flag = flag;
		this.message = message;
		
	}


	/**
	 * 未登录
	 * @return Response
     */
	public Response notLogin(){
		this.flag=false;
		this.message="Not Login";
		this.notLogin=Boolean.TRUE;
		return this;
	}

	/**
	 * 权限不足
	 * @return
     */
	public Response permissionDenied(){
		this.flag=false;
		this.message="Permission Denied";
		this.permissionDenied=Boolean.TRUE;
		return this;
	}

	public Response success(Object data) {
		this.flag=true;
		this.data = data;
		this.message=OK;
		return this;
	}

	public Response success(String message, Object data) {
		this.flag=true;
		this.data = data;
		this.message=message;
		return this;
	}

	public Response failureValidate(String message, Map<String,String> validate) {
		this.validate=validate;
		this.flag=false;
		return this;
	}

	public Response failure(String message) {
		this.flag=false;
		this.message=message;
		return this;
	}


}  
package com.liaoyb.support.utils;

import com.alibaba.fastjson.JSONObject;
import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.dto.DtoPage;
import com.liaoyb.persistence.domain.dto.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 往客户端发送json数据
 * 
 * 
 * @author liao
 *
 */
public class MyResultUtil {


	
	
	

	/**
	 * 操作成功，但是是自定义消息
	 * 发送消息,没有data信息
	 * @param response
	 * @param message
	 */
	public static void sendSuccess(HttpServletResponse response, String message) {
		Response res=new Response(true, message);
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}
	
	
	/**
	 * 操作失败，但是是自定义消息
	 * 发送消息,没有data信息
	 * @param response
	 * @param message
	 */
	public static void sendFail(HttpServletResponse response, String message) {
		Response res=new Response(false, message);
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}
	
	
	
	

	/**
	 * 
	 * 封装失败消息
	 * 
	 * @param msg
	 *            消息
	 * @return
	 * @author hyzha
	 * @created 2014年9月2日 下午4:15:12
	 * @lastModified
	 * @history
	 */
	public static Response fail(String msg) {
		Response response = new Response();
		response.setFlag(false);
		response.setMessage(msg);
		return response;
	
	}

	
	/**
	 * 默认失败消息
	 * @return
	 */
	
	public static Response fail() {
		Response response = new Response();
		response.setFlag(false);
		response.setMessage("操作失败");
		return response;
	
	}
	/**
	 * 封装成功消息
	 * 
	 * @param msg
	 *            消息结果
	 * @param data
	 *            需要返回的数据
	 * @return 结果对象
	 * @created 2014年9月5日 下午2:23:49
	 * @lastModified
	 * @history
	 */
	public static Response success(String msg, Object data) {
		return new Response(true, msg, data);
	}

	public static Response success(Object data) {
		return new Response(true, "操作成功", data);
	}

	


	/**
	 * 
	 * 构造空page
	 * 
	 * @param <T>
	 *            模板
	 * @param page
	 *            分页实体
	 * @return 构造后page
	 * @author xkfeng@iflytek.com
	 * @created 2013-11-22 下午01:10:46
	 * @lastModified
	 * @history
	 */
	public static <T> Page<T> emptyPage(Page<T> page) {
		page.setResult(new ArrayList<T>(0));
		page.setTotalCount(0l);
		return page;
	}

	

	

	/**
	 * 操作成功
	 * @param response
	 */
	public static void sendOperationSuccess(HttpServletResponse response){
		Response res=new Response(true, "操作成功");
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}

	
	/**
	 * 操作失败
	 * @param response
	 */
	public static void sendOperationFail(HttpServletResponse response){
		Response res=new Response(false, "操作失败");
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}

	
	

	/**
	 * 
	 * 回复列表
	 * 
	 * @param response
	 *            回执对象
	 * @param list
	 *            列表
	 * @author hyzha@iflytek.com
	 * @throws Exception
	 * @created 2013-4-3 上午10:05:37
	 * @lastModified
	 * @history
	 */
	public static void sendList(HttpServletResponse response, List list)  {
		
		

		Response res=success("信息获取成功", list);
		
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}

	/**
	 * 
	 * 回复对象
	 * 
	 * @param response
	 *            回执对象
	 * @param obj
	 *            对象
	 * @author hyzha@iflytek.com
	 * @throws Exception
	 * @created 2013-4-3 上午10:16:09
	 * @lastModified
	 * @history
	 */
	public static void sendObject(HttpServletResponse response, Object obj) {

		
//		List<Object> objlist=new ArrayList<Object>();
//		objlist.add(obj);
//		sendList(response,objlist);
		Response res=success("信息获取成功", obj);

		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());


	}

	

	/**
	 * 
	 * 回复分页
	 * 
	 * @param response
	 *            回执对象
	 * @param page
	 *            分页对象
	 * @author hyzha@iflytek.com
	 * @throws Exception
	 * @created 2013-4-3 上午11:06:45
	 * @lastModified
	 * @history
	 */
	public static <T>  void sendPage(HttpServletResponse response, Page<T> page)  {



		//设置size,total,page

		
		Response res=success("信息获取成功", page.getResult());
		DtoPage dtoPage=new DtoPage(page.getTotalCount(),new Long(page.getPageSize()),new Long(page.getPageNumber()),page.getResult());
		res.setData(dtoPage);

		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}
	
	

	

	/**
	 * 
	 * 回复MAP
	 * 
	 * @param response
	 * @param map
	 * @author hyzha
	 * @created 2014年9月2日 下午4:18:47
	 * @lastModified
	 * @history
	 */
	public static void sendMap(HttpServletResponse response, Map map) {
		
		
		Response res=success("信息获取成功", map);
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}


	/**
	 * 直接
	 * @param response
	 * @param res
     */
	public static void sendResponse(HttpServletResponse response,Response res){
		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTJSON, WebUtils.CONTENT_CHARSET_UTF8,
				JSONObject.toJSONString(res).toString());
	}
	

	
	
}





package com.liaoyb.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;

/**
 * 基本的网络工具
 * @author ybliao2
 */
public class BaseWebUtils {
    public static final String CONTENTTYPE_TEXTJSON = "application/json";
    public static final String CONTENT_CHARSET_UTF8 = "UTF-8";
    public static final String CONTENTTYPE_TEXTHTML = "text/html";
    public static Logger logger= LoggerFactory.getLogger(BaseWebUtils.class);

    public static void sendDirectToClient(HttpServletResponse response, String contenttypeTextjson,
                                          String contentCharsetUtf8, String jsonResult) {
        try {
            response.setCharacterEncoding(contentCharsetUtf8);
            response.setContentType(contenttypeTextjson);
            Writer writer = response.getWriter();
            writer.write(jsonResult);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 当前请求是否为ajax异步请求。
     * @param request 当前request
     * @return 如果当前请求为ajax请求，返回true，否则返回false
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request
                .getHeader("x-requested-with"));
    }


    /**
     * 得到客户端ip
     * @param request
     * @return
     */
    public static String getIP(HttpServletRequest request) {
        String ipAddress = null;
        String unknown = "unknown";
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || unknown.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
    /**
     *
     * @param fileName 文件名
     * @param inputStream 文件流
     * @param response
     */
    public static void  download(String fileName, InputStream inputStream, HttpServletRequest request, HttpServletResponse response){

        OutputStream toClient=null;
        try {
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment;filename=" + encodeFileName(request,fileName));
            response.addHeader("Content-Length", "" + inputStream.available());
            toClient = new BufferedOutputStream(response.getOutputStream());

            byte[] data = new byte[2048];
            int len = 0;
            while ((len = inputStream.read(data)) > 0) {
                toClient.write(data, 0, len);
            }


        }catch (Exception e){
            logger.error("文件下载失败",e);
        }finally {
            if(toClient!=null){
                try {
                    toClient.flush();
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }


    /**
     * 下载，字节数组方式
     * @param fileName
     * @param bytes
     * @param request
     * @param response
     */
    public static void  download(String fileName, byte[]bytes, HttpServletRequest request, HttpServletResponse response){

        OutputStream toClient=null;
        try {
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment;filename=" + encodeFileName(request,fileName));
            response.addHeader("Content-Length", "" + bytes.length);
            toClient = new BufferedOutputStream(response.getOutputStream());

            toClient.write(bytes);

        }catch (Exception e){
            logger.error("文件下载失败",e);
        }finally {
            if(toClient!=null){
                try {
                    toClient.flush();
                    toClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }
    //解决不同浏览器下载中文名乱码问题
    private static   String encodeFileName(HttpServletRequest req, String name)
            throws UnsupportedEncodingException {

        String agent = req.getHeader("USER-AGENT").toLowerCase();
        System.out.println(agent);
        if (agent != null && agent.indexOf("firefox") < 0
                && agent.indexOf("safari") < 0) {
            return URLEncoder.encode(name, "UTF8");
        }

        return new String(name.getBytes("UTF-8"), "ISO8859-1");

    }
}

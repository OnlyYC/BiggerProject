package com.liaoyb.util;

import com.liaoyb.persistence.domain.dto.EmailConfigDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * @author ybliao2
 */
public class MailUtil {

    /**
     * 发送邮件的props文件
     */
    private static final transient Properties props = new Properties();
    /**
     * 邮件服务器登录验证
     */
//    private static transient MailAuthenticator authenticator;
//
    private static transient EmailConfigDto emailConfigDto;

    /**
     * 邮箱session
     */
//    private static transient Session session;

    private static Logger logger= LoggerFactory.getLogger(MailUtil.class);

    /**
     * 获取EmailConfigDto
     * @return EmailConfigDto
     */
    private static void  initConfig() {
        if(emailConfigDto!=null)
            return;
        try {
            ApplicationContext ctx  = new ClassPathXmlApplicationContext("config/emailconfig.xml");
             emailConfigDto= (EmailConfigDto) ctx.getBean("emailConfigDto");

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

    }

    /**
     * 初始化邮件发送器
     *
     *  SMTP邮件服务器地址
     *  发送邮件的用户名(地址)
     *  发送邮件的密码
     */
    private static void init() {

        //初始化邮件配置
        initConfig();


        // 初始化props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", emailConfigDto.getSmtp());

    }

    /**
     * 发送邮件
     *
     * @param to 收件人
     * @param title 邮件主题
     * @param content 邮件内容
     * @throws MessagingException MessagingException
     */
    public static void send(String to, String title, String content) throws MessagingException {

        // 初始化邮件发送器
        init();
        // 验证
        MailAuthenticator authenticator = new MailAuthenticator(emailConfigDto.getSender(), emailConfigDto.getPassword());
        // 创建session
        Session session = Session.getInstance(props, authenticator);

        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(emailConfigDto.getShowSender()));
        // 设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        // 设置主题
        message.setSubject(title);
        // 设置邮件内容
        message.setContent(content, "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }

    /**
     * 群发邮件
     *
     * @param tos 收件人们
     * @param title 邮件主题
     * @param content 邮件内容
     * @throws MessagingException MessagingException
     */
    public static void send( List<String> tos, String title, String content) throws MessagingException {

        // 初始化邮件发送器
        init();
        MailAuthenticator authenticator = new MailAuthenticator(emailConfigDto.getSender(), emailConfigDto.getPassword());
        // 创建session
        Session session = Session.getInstance(props, authenticator);
        // 创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        // 设置发信人
        message.setFrom(new InternetAddress(emailConfigDto.getShowSender()));
        // 设置收件人们
        final int num = tos.size();
        InternetAddress[] addresses = new InternetAddress[num];
        for (int i = 0; i < num; i++) {
            addresses[i] = new InternetAddress(tos.get(i));
        }
        message.setRecipients(RecipientType.TO, addresses);
        // 设置主题
        message.setSubject(title);
        // 设置邮件内容
        message.setContent(content, "text/html;charset=utf-8");
        // 发送
        Transport.send(message);
    }
}

/**
 * 服务器邮箱登录验证
 */
class MailAuthenticator extends Authenticator {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 初始化邮箱和密码
     *
     * @param username 邮箱
     * @param password 密码
     */
    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 获取密码
     *
     * @return 密码
     */
    String getPassword() {
        return password;
    }

    /**
     * 获取认证
     *
     * @return 结果
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    String getUsername() {
        return username;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

}

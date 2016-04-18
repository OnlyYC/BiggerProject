package com.liaoyb.persistence.domain.dto;

/**
 * 邮件配置Dto
 * @author shuangwang
 *
 */
public class EmailConfigDto {

	/**
	 * smtp
	 */
	private String smtp;
	
	/**
	 *发件人
	 */
	private String sender;
	
	/**
	 * 显示的发件人（名称）
	 */
	private String showSender;
	
	/**
	 * password
	 */
	private String password;


	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getShowSender() {
		return showSender;
	}

	public void setShowSender(String showSender) {
		this.showSender = showSender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

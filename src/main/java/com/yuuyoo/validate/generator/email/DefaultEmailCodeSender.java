package com.yuuyoo.validate.generator.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认的短信验证码发送器
 * 
 * @author zhailiang
 *
 */
public class DefaultEmailCodeSender implements EmailCodeSender {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void send(String code, String title, String content, String sender, String recipient) {
		logger.warn("请配置真实的短信验证码发送器(SmsCodeSender)");
		logger.info(sender + "向"+title);
		logger.info("邮件内容"+String.format(content,code));
	}
}

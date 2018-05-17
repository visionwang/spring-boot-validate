/**
 * 
 */
package com.yuuyoo.validate.generator.email;

/**
 * @author zhailiang
 *
 */
public interface EmailCodeSender {

	/**
	 * 邮件发送
	 * @param code
	 * @param title 邮件标题
	 * @param content 邮件内容
	 * @param sender 邮件发送者
	 * @param recipient 邮件接收者
	 */
	void send(String code, String title, String content, String sender, String recipient);

}

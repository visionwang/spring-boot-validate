package com.yuuyoo.validate.generator;

import com.yuuyoo.validate.generator.email.DefaultEmailCodeSender;
import com.yuuyoo.validate.generator.email.EmailCodeSender;
import com.yuuyoo.validate.generator.image.ImageCodeGenerator;
import com.yuuyoo.validate.generator.sms.DefaultSmsCodeSender;
import com.yuuyoo.validate.generator.sms.SmsCodeSender;
import com.yuuyoo.validate.properties.ValidateCodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置。
 * 
 * @author zhailiang
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private ValidateCodeProperties validateCodeProperties;
	
	/**
	 * 图片验证码图片生成器
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageValidateCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setValidateCodeProperties(validateCodeProperties);
		return codeGenerator;
	}
	
	/**
	 * 短信验证码发送器
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}

	/**
	 * 邮件发送器
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(EmailCodeSender.class)
	public EmailCodeSender emailSender(){
		return new DefaultEmailCodeSender();
	}
}

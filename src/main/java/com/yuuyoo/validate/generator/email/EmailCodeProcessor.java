package com.yuuyoo.validate.generator.email;

import com.yuuyoo.validate.generator.AbstractValidateProcessor;
import com.yuuyoo.validate.generator.ValidateCode;
import com.yuuyoo.validate.generator.sms.SmsCodeSender;
import com.yuuyoo.validate.properties.ValidateCodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码处理器
 * 
 * @author
 *
 */
@Component("emailValidateCodeProcessor")
public class EmailCodeProcessor extends AbstractValidateProcessor<EmailCode> {

	/**
	 * 短信验证码发送器
	 */
	@Autowired
	private EmailCodeSender emailCodeSender;

	@Autowired
	private ValidateCodeProperties validateCodeProperties;
	
	@Override
	protected void send(ServletWebRequest request, EmailCode emailCode) throws Exception {
		String paramName = "email";
		String email = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);

		emailCodeSender.send(
				emailCode.getCode(),
				validateCodeProperties.getEmail().getTitle(),
				validateCodeProperties.getEmail().getContent(),
				validateCodeProperties.getEmail().getSender(),
				email);
	}

}

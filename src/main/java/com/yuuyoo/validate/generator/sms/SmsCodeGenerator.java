package com.yuuyoo.validate.generator.sms;

import com.yuuyoo.validate.generator.ValidateCode;
import com.yuuyoo.validate.generator.ValidateCodeGenerator;
import com.yuuyoo.validate.properties.ValidateCodeProperties;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 短信验证码生成器
 * 
 * @author zhailiang
 *
 */
@Component("smsValidateCodeGenerator")
@Data
public class SmsCodeGenerator implements ValidateCodeGenerator {

	@Autowired
	private ValidateCodeProperties validateCodeProperties;
	

	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(validateCodeProperties.getSms().getLength());
		return new ValidateCode(code, validateCodeProperties.getSms().getExpireIn());
	}
	
	

}

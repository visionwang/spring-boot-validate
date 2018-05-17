package com.yuuyoo.message.generator;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * 抽象的图形验证码处理器
 * @Description:
 * @Auther: dave
 * @Date: 2018/5/16 14:33
 */
public abstract class AbstractValidateProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
   */
  @Autowired
  private Map<String, ValidateCodeGenerator> validateCodeGenerators;


  @Override
  public String create(ServletWebRequest request) throws Exception {
    C validateCode = generate(request);
    String response_type = request.getHeader("type");
    if("json".equals(response_type)){
      return validateCode.getCode();
    }
    send(request, validateCode);
    return null;
  }

  /**
   * 生成校验码
   *
   * @param request
   * @return
   */
  @SuppressWarnings("unchecked")
  private C generate(ServletWebRequest request) {
    String type = getValidateCodeType(request).toString().toLowerCase();
    String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
    ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
    if (validateCodeGenerator == null) {
      throw new ValidateException("验证码生成器" + generatorName + "不存在");
    }
    return (C) validateCodeGenerator.generate(request);
  }

  /**
   * 发送校验码，由子类实现
   *
   * @param request
   * @param validateCode
   * @throws Exception
   */
  protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

  /**
   * 根据请求的url获取校验码的类型
   *
   * @param request
   * @return
   */
  private ValidateType getValidateCodeType(ServletWebRequest request) {
    String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
    return ValidateType.valueOf(type.toUpperCase());
  }

}

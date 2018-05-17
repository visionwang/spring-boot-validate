package com.yuuyoo.validate.generator;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 校验码处理器，封装不同校验码的处理逻辑
 * @Auther: dave
 * @Date: 2018/5/16 13:15
 */
public interface ValidateCodeProcessor<C extends ValidateCode> {

  /**
   * 创建校验码
   *
   * @param request
   * @throws Exception
   */
  C create(ServletWebRequest request) throws Exception;

  /**
   * 校验验证码
   *
   * @param servletWebRequest
   * @throws Exception
   */
  void validate(ServletWebRequest servletWebRequest);
}

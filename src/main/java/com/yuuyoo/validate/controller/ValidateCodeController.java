package com.yuuyoo.validate.controller;

import com.yuuyoo.validate.generator.ValidateCode;
import com.yuuyoo.validate.generator.ValidateProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @Auther: dave
 * @Date: 2018/5/17 14:18
 */
@RestController
public class ValidateCodeController {

  @Autowired
  private ValidateProcessorHolder validateProcessorHolder;

  @GetMapping("/code/{type}")
  public ValidateCode createCode(
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String type)
      throws Exception {
    return validateProcessorHolder.findValidateProcessor(type).create(new ServletWebRequest(request, response));
  }

  @GetMapping("/validate/{type}")
  public void validateCode(
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String type) {
    validateProcessorHolder.findValidateProcessor(type).validate(new ServletWebRequest(request, response));
  }

}

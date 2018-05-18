package com.yuuyoo.validate.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
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
  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/code/{type}")
  public String createCode(
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String type)
      throws Exception {
    ValidateCode validateCode = validateProcessorHolder.findValidateProcessor(type).create(new ServletWebRequest(request, response));
    String rst = JSON.toJSONString(validateCode);
    return rst;
  }

  @GetMapping("/validate/{type}")
  public void validateCode(
      HttpServletRequest request,
      HttpServletResponse response,
      @PathVariable String type) {
    validateProcessorHolder.findValidateProcessor(type).validate(new ServletWebRequest(request, response));
  }

}

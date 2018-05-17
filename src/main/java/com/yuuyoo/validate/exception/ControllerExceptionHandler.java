package com.yuuyoo.validate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 异常捕捉
 * @Auther: dave
 * @Date: 2018/5/17 17:27
 */
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ValidateException.class)
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, Object> handleValidateException(ValidateException ex) {
    Map<String, Object> result = new HashMap<>();
    result.put("message", ex.getMessage());
    return result;
  }

}

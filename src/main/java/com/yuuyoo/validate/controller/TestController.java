package com.yuuyoo.validate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: dave
 * @Date: 2018/5/28 07:05
 */
@RestController
public class TestController {

  @GetMapping("/test")
  public Map test(){
    System.out.println("it's test");
    Map result = new HashMap();
    result.put("who","dave");
    return result;
  }

}

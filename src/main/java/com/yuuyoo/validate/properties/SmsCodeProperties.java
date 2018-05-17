package com.yuuyoo.validate.properties;

import lombok.Data;

/**
 * @Description: 短信验证码配置项
 * @Auther: dave
 * @Date: 2018/5/16 15:22
 */
@Data
public class SmsCodeProperties {

  /**
   * 验证码长度
   */
  private int length = 6;
  /**
   * 过期时间
   */
  private int expireIn = 60;

  public SmsCodeProperties() {

  }
}

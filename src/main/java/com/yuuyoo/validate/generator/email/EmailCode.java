package com.yuuyoo.validate.generator.email;

import com.yuuyoo.validate.generator.ValidateCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Auther: dave
 * @Date: 2018/5/16 17:49
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class EmailCode extends ValidateCode {
  public EmailCode(String code, int expireIn) {
    super(code, expireIn);
  }

  public EmailCode(String code, LocalDateTime expireTime) {
    super(code, expireTime);
  }

  private String title;
  private String content;
  private String sender;
  private String recipient;
}

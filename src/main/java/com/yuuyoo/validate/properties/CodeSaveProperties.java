package com.yuuyoo.validate.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

/**
 * @Description: 校验码存储配置
 * @Auther: dave
 * @Date: 2018/5/17 17:03
 */
@Data
@Component
@EqualsAndHashCode
public class CodeSaveProperties {

  private boolean enable = false;

  private String type = "redis";

}

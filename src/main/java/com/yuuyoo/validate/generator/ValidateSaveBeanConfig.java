package com.yuuyoo.validate.generator;

import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置
 * @Auther: dave
 * @Date: 2018/5/17 16:57
 */
@Configuration
public class ValidateSaveBeanConfig {

  /**
  @Bean
  @ConditionalOnMissingBean(ValidateCodeRepository.class)
  public ValidateCodeRepository validateCodeRepository(){
    return new RedisValidateCodeRepository();
  }
  **/

}

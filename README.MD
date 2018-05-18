验证服务

包括图形校验码/短信验证码/邮件验证码

自定义存储方式：
实现ValidateCodeRepository接口

###短信校验码配置###
validate.code.sms.length = 4 #校验码长度

validate.code.sms.expireIn = 5 #过期时间，单位：分钟

###图形校验码配置###
validate.code.image.length = 4 #校验码长度

validate.code.image.expireIn = 5 #过期时间，单位：分钟

validate.code.image.width = 100  #图片宽度

validate.code.image.height = 30  #图片高度

###邮件校验码配置###
validate.code.email.length = 4 #校验码长度

validate.code.email.expireIn = 5 #过期时间，单位：分钟

validate.code.email.title = 'welcome' #邮件主题

validate.code.email.content = 'welcome to yuuyoo, your code is %s'. #邮件内容

validate.code.email.sender = 'dave@yuuyoo.com' #发件人

###校验码存储配置###
validate.code.save.enable = false #是否开启存储

validate.code.save.type = redis  #存储方式


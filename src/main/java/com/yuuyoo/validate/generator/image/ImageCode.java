package com.yuuyoo.validate.generator.image;

import com.yuuyoo.validate.generator.ValidateCode;
import lombok.Data;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;


/**
 * 图片验证码
 * @author zhailiang
 *
 */
@Data
public class ImageCode extends ValidateCode {

	private static final long serialVersionUID = -6020470039852318468L;

	private String image;
	
	public ImageCode(String image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}
	
	public ImageCode(String image, String code, LocalDateTime expireTime){
		super(code, expireTime);
		this.image = image;
	}

}

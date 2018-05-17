package com.yuuyoo.validate.generator.image;

import com.yuuyoo.validate.generator.ValidateCode;
import com.yuuyoo.validate.generator.ValidateCodeGenerator;
import com.yuuyoo.validate.properties.ValidateCodeProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Base64;
import java.util.Random;

/**
 * 默认的图片验证码生成器
 * @author zhailiang
 *
 */
@Component("imageValidateCodeGenerator")
@Data
public class ImageCodeGenerator implements ValidateCodeGenerator {

	/**
	 * 系统配置
	 */
	@Autowired
	private ValidateCodeProperties validateCodeProperties;

	@Override
	public ValidateCode generate(ServletWebRequest request) {
		int width = ServletRequestUtils.getIntParameter(request.getRequest(), "width",
				validateCodeProperties.getImage().getWidth());
		int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height",
				validateCodeProperties.getImage().getHeight());
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		Random random = new Random();

		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		String sRand = "";
		for (int i = 0; i < validateCodeProperties.getImage().getLength(); i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}

		g.dispose();

		String imageString = imgToBase64String(image,"PNG");

		return new ImageCode(imageString, sRand, validateCodeProperties.getImage().getExpireIn());
	}

	/**
	 * 图形码生成字符串
	 * @param img
	 * @param formatName
	 * @return
	 */
	public static String imgToBase64String(final RenderedImage img, final String formatName)
	{
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		try
		{
			ImageIO.write(img, formatName, os);
			return Base64.getEncoder().encodeToString(os.toByteArray());
		}
		catch (final IOException ioe)
		{
			throw new UncheckedIOException(ioe);
		}
	}

	/**
	 * 生成随机背景条纹
	 * 
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}

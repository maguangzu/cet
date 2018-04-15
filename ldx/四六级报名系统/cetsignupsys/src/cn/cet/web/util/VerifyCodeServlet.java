package cn.cet.web.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet {

private String verifyCode;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用生成图片的方法,返回一个缓存流图片(存放在内存),大小为170像素*35像素
		BufferedImage verifyImg = getVerifyImg(170,35);
		//存放验证码到Session中去
		request.getSession().setAttribute("VerifyCode", verifyCode);
		//调用图片流IO,将验证码图以JPEG类型输出到页面去
		ImageIO.write(verifyImg, "JPEG", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	/**
	 * 这个方法将返回一个简单验证码图
	 * @author xs
	 * @return 验证码图
	 */
	protected BufferedImage getVerifyImg(int width,int height){
		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//拿到2D画笔
		Graphics2D g = (Graphics2D) result.getGraphics();
		//背景色为灰色
		g.setColor(new Color(96,96,96));
		g.fillRect(0, 0, width, height);
		//随便写点字,风格大小随便
		g.setColor(Color.WHITE);
		verifyCode = randomNumber();
		g.drawString(verifyCode, 10, 20);
		return result;
	}

	/**
	 * 将随机产生一个4位数
	 * @return
	 */
	private String randomNumber(){
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<4;i++){
			sb.append("  ");
			sb.append(r.nextInt(10));
		}
		return sb.toString();
	}

}

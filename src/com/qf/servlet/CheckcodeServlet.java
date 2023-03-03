package com.qf.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*一.绘图 
		 * 1.创建内存映像对象（画布）  rgb三基色 红绿蓝*/
		BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
		//2.获得画笔
		Graphics g = image.getGraphics();
		//3.给笔设置颜色（白色）
		g.setColor(new Color(255,255,255));
		//4.设置背景颜色(矩形)
		g.fillRect(0, 0, 60, 20);
		//5.设置字体颜色
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		//6.绘图(验证码随机数)
		//设置字体（字体，风格，大小）
		g.setFont(new Font(null, Font.ITALIC, 20));
		//调用方法获取长度为4的随机字符串
		String number = getNumber(4);
		//获得 当前请求 对应的 会话对象
		HttpSession  session=request.getSession();
		session.setAttribute("number",number);
		//x,y基于左下角来算
		g.drawString(number, 3, 20);
		//7.加一些干扰线（6条干扰线，两点确认一条直线）
		for(int i = 0;i < 6; i++){
			g.drawLine(r.nextInt(60), r.nextInt(20), r.nextInt(60), r.nextInt(20));
		}
		
		
		/*二.将图片压缩并发送给浏览器 */
		response.setContentType("image/jpeg");
		//字节输出流
		OutputStream ops = response.getOutputStream();
		//压缩图片(jdk5.0后才有的,会将原始图片image按照指定的算法"jpeg"压缩，然后输出)
		javax.imageio.ImageIO.write(image, "jpeg", ops);
		ops.close();
	}
	
	//返回长度为size，随机从A~Z 0~9中选取生成验证码
	private String getNumber(int size) {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			//charAt获取指定索引处的字符
			number += str.charAt(r.nextInt(str.length()));
		}
		return number;
	}
}

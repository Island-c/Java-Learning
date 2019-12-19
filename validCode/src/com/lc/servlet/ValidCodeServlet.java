package com.lc.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建一张图片
		BufferedImage image= new BufferedImage(200,60,BufferedImage.TYPE_INT_RGB);
		
		//透明的玻璃
		//向画板上画内容之前必须先设置画笔
		Graphics2D gra= image.createGraphics();
		
		gra.setColor(Color.WHITE);
		
		//从哪个坐标开始填充，
		gra.fillRect(0,0, 200, 60);
		//设置颜色
		
		//设置字体
		gra.setFont(new Font("宋体",Font.ITALIC|Font.BOLD,30));
		Color[] colors= new Color[] {Color.BLUE,Color.BLACK,Color.DARK_GRAY,Color.GRAY,Color.ORANGE};
		Random random = new Random();
		List<String> randList = new ArrayList<>();
		for(int i =0 ;i<4 ; ++i) {
			randList.add(random.nextInt(10)+""); //生成0-9的随机数
			
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(randList.get(i), i*40+10, 50+(random.nextInt(20)-10));
		}
		
		//画横线
		for(int i=0; i<2 ; ++i) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
		}

		
		
		ServletOutputStream outputstream = resp.getOutputStream();
		
		//工具类
		ImageIO.write(image,"jpg", outputstream);
		
		//验证码放入session
		HttpSession hs = req.getSession();
		hs.setAttribute("code", ""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));
	}
}

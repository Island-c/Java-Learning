package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏物体的父类
 * @author liu01
 *
 */
public class GameObject {
	Image img;
	double x,y;
	int speed=3;
	int width,height;
	
	public void drawSelf(Graphics g)
	{
		//画自己
		g.drawImage(img, (int)x,(int)y,null);
	}

	public GameObject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public GameObject() {
		
	}
	
	
	/**
	 * 返回物体所在矩形，便于后续碰撞检测
	 * @return
	 */
	public Rectangle getRect()
	{
		return new Rectangle((int)x,(int)y,width,height);
	}
	
}

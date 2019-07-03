package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * @author liu01
 *
 */
public class Shell extends GameObject{
	
	double degree; //角度
	
	public Shell()
	{
		x=Math.random()*500;
		y=Math.random()*500;
		width=10;
		height=10;
		speed=2;
		
		degree = Math.random()*2*Math.PI; //弧度
	}
	
	public void draw(Graphics g)
	{
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x,(int) y, width, height);
		
		//炮弹沿任意方向飞
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(x<0 || x>Constant.GAME_WIDTH-width)
		{
			degree = Math.PI - degree; //角度反转
			
		}
		if(y<30 || y>Constant.GAME_HEIGHT-height)
		{
			degree = -degree; 
		}
		
		
		
		g.setColor(c);
	}
	
}

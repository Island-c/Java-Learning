package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * �ڵ���
 * @author liu01
 *
 */
public class Shell extends GameObject{
	
	double degree; //�Ƕ�
	
	public Shell()
	{
		x=Math.random()*500;
		y=Math.random()*500;
		width=10;
		height=10;
		speed=2;
		
		degree = Math.random()*2*Math.PI; //����
	}
	
	public void draw(Graphics g)
	{
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		
		g.fillOval((int)x,(int) y, width, height);
		
		//�ڵ������ⷽ���
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(x<0 || x>Constant.GAME_WIDTH-width)
		{
			degree = Math.PI - degree; //�Ƕȷ�ת
			
		}
		if(y<30 || y>Constant.GAME_HEIGHT-height)
		{
			degree = -degree; 
		}
		
		
		
		g.setColor(c);
	}
	
}

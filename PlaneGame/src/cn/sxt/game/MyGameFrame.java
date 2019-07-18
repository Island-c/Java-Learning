package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.util.Date;

/**
 * �ɻ���Ϸ��������
 * @author liu01
 *
 */

public class MyGameFrame extends Frame{
	
	Image planeImg = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane = new Plane(planeImg,250,250);
	Shell[] shells=new Shell[50];
	Explode bao;
	Date startTime=new Date();
	Date endTime;
	int period;
	@Override
	public void paint(Graphics g) { //�Զ������ã� g�൱�ڻ���
		Color c=g.getColor();
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		for(int i=0;i<shells.length ;++i)
		{
			shells[i].draw(g);
			
			//�ɻ����ڵ�����ײ���
			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if(peng)
			{
				plane.live=false;
				if(bao==null)
				{
					bao = new Explode(plane.x,plane.y);	
					endTime = new Date();
					period=(int)((endTime.getTime() - startTime.getTime())/1000);
				}
				bao.draw(g);
			}
			if(!plane.live)
			{
				g.setColor(Color.RED);
				Font f= new Font("����",Font.BOLD,50);
				g.setFont(f);
				g.drawString("��Ϸʱ�䣺"+period+"s", 100, 250);
			}

			
		}
		g.setColor(c);
	}
	
	//ʹ��һ���̷߳����ػ����ڣ��ظ�����paint������
	class PaintThread extends Thread
	{
		@Override
		public void run()
		{
			while(true)
			{
				//System.out.println("repaint one time");
				repaint(); //�ػ�
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}// ��Ϣ40ms
			}
				
		}
	}
	
	//������̼����ڲ���
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
	}
	
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("�ɻ���Ϸ");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				//���ڹر�
				System.exit(0);		
			}
		});//�����ڲ���
		
		new PaintThread().start(); //�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());//���������Ӽ��̼���
		
		
		//��ʼ���ڵ�
		for(int i=0; i<shells.length; i++)
		{
			shells[i]=new Shell();
		}
		
	}
	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	
	
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ�Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	
}

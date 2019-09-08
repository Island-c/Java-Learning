package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登陆 单向
 * @author Ice
 *
 */
public class LoginServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("server");
		 //1。使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		boolean isRunning =true;
		
		while(isRunning)
		{
			Socket client = server.accept();
			new Thread(new Channel(client)).start();
		}
		server.close();
	}
	
	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;
		private String data;
		private DataOutputStream dos;
		
		
		
		public Channel(Socket c) {
			this.client = c;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				release();
			}
		}
		
		private String receive() {
			//接收数据
			String datas="";
			try {
				datas=dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return datas;
		}
		
		private void send(String msg) {
			
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private void release() {
			// * 4。释放资源
			try {
				if(null != dos)
					dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				if(null != dis)
					dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(null != client)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 //* 2. 阻塞式等待连接 accept
			System.out.println("一个客户端建立了连接");
			// * 3. 操作：输入输出流操作
			
			
			String uname="";
			String upwd="";
			//分析
			String[] dataArray=receive().split("&");
			for(String info : dataArray) {
				String[] userinfo = info.split("=");
				System.out.println(userinfo[0]+"-->"+userinfo[1]);
				if(userinfo[0].equals("uname")) {
					System.out.println("你的用户名为"+userinfo[1]);
					uname=userinfo[1];
				}else if(userinfo[0].equals("upwd")) {
					System.out.println("你的密码为"+userinfo[1]);
					upwd = userinfo[1];
				}
			}
			if(uname.equals("asdf") && upwd.equals("asdf"))
			{
				//成功
				send("登陆成功");
			
			}else
			{
				//失败
				send("用户名或密码错误");
			}

			release();
		}
	}
}

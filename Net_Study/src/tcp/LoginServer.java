package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���½ ����
 * @author Ice
 *
 */
public class LoginServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("server");
		 //1��ʹ��serversocket����������
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
			//��������
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
			// * 4���ͷ���Դ
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
			 //* 2. ����ʽ�ȴ����� accept
			System.out.println("һ���ͻ��˽���������");
			// * 3. �������������������
			
			
			String uname="";
			String upwd="";
			//����
			String[] dataArray=receive().split("&");
			for(String info : dataArray) {
				String[] userinfo = info.split("=");
				System.out.println(userinfo[0]+"-->"+userinfo[1]);
				if(userinfo[0].equals("uname")) {
					System.out.println("����û���Ϊ"+userinfo[1]);
					uname=userinfo[1];
				}else if(userinfo[0].equals("upwd")) {
					System.out.println("�������Ϊ"+userinfo[1]);
					upwd = userinfo[1];
				}
			}
			if(uname.equals("asdf") && upwd.equals("asdf"))
			{
				//�ɹ�
				send("��½�ɹ�");
			
			}else
			{
				//ʧ��
				send("�û������������");
			}

			release();
		}
	}
}

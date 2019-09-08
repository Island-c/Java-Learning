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
public class LoginMultiServer {
	public static void main(String[] args) throws IOException {
		
		System.out.println("server");
		 //1。使用serversocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		 //* 2. 阻塞式等待连接 accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// * 3. 操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data =  dis.readUTF();
		String uname="";
		String upwd="";
		//分析
		String[] dataArray=data.split("&");
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
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("asdf") && upwd.equals("asdf"))
		{
			//成功
			dos.writeUTF("登陆成功");
		
		}else
		{
			//失败
			dos.writeUTF("用户名或密码错误");
		}

		// * 4。释放资源
		dis.close();
		client.close();
		server.close();
	}
}

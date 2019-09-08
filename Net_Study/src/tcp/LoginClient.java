package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  * 模拟登陆 单向
 * @author Ice
 *
 */
public class LoginClient { 
	public static void main(String[] args) throws IOException {
		System.out.println("client");
		
		 //* 1. 建立连接：使用Socket创建客户端 + 服务器的地址和端口
		Socket client = new Socket ("localhost",8888);
		 //* 2. 操作：输入输出流
		Send s=new Send(client);
		s.send();
		Receive r=new Receive(client);
		String result = r.read();
		System.out.println(result);
		
		/// * 3.释放资源
		s.release();
		r.release();
		client.close();
	}
}
class Send{
	private Socket client;
	private DataOutputStream dos;
	private BufferedReader console;
	private String uname;
	private String upwd;
	public Send(Socket client) {
		init();
		this.client = client;
		try {
			dos= new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send( ) {
		try {
			dos.writeUTF("uname="+uname +"&"+"upwd="+upwd);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void init() {
		console= new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("用户名: ");
			uname = console .readLine();
			System.out.println("密码: ");
			upwd = console.readLine(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void release()
	{
		try {
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	
class Receive{
	private Socket client;
	private DataInputStream dis;
	public Receive (Socket client) throws IOException {
		this .client = client;
		this.dis = new DataInputStream(client.getInputStream());
	}
	
	public String read() {
		try {
			return dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public void release()
	{
		try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}


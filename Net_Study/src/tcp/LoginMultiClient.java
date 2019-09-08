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
public class LoginMultiClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client");
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("用户名: ");
		String uname = console .readLine();
		System.out.println("密码: ");
		String upwd = console.readLine(); 
		
		 //* 1. 建立连接：使用Socket创建客户端 + 服务器的地址和端口
		Socket client = new Socket ("localhost",8888);
		 //* 2. 操作：输入输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("uname="+uname +"&"+"upwd="+upwd);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result =  dis.readUTF();
		System.out.println(result);
		/// * 3.释放资源
		dos.close();
		client.close();
	}
}

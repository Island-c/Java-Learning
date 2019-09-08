package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 流程
 * 1。使用serversocket创建服务器
 * 2. 阻塞式等待连接 accept
 * 3. 操作：输入输出流操作
 * 4。释放资源
 * @author Ice
 *
 */
public class FileServer {
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
		System.out.println(data);
		
		// * 4。释放资源
		dis.close();
		client.close();
		server.close();
	}

}

package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����
 * 1��ʹ��serversocket����������
 * 2. ����ʽ�ȴ����� accept
 * 3. �������������������
 * 4���ͷ���Դ
 * @author Ice
 *
 */
public class FileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("server");
		 //1��ʹ��serversocket����������
		ServerSocket server = new ServerSocket(8888);
		
		 //* 2. ����ʽ�ȴ����� accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		// * 3. �������������������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data =  dis.readUTF();
		System.out.println(data);
		
		// * 4���ͷ���Դ
		dis.close();
		client.close();
		server.close();
	}

}

package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  * ģ���½ ����
 * @author Ice
 *
 */
public class LoginMultiClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client");
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�û���: ");
		String uname = console .readLine();
		System.out.println("����: ");
		String upwd = console.readLine(); 
		
		 //* 1. �������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
		Socket client = new Socket ("localhost",8888);
		 //* 2. ���������������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("uname="+uname +"&"+"upwd="+upwd);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String result =  dis.readUTF();
		System.out.println(result);
		/// * 3.�ͷ���Դ
		dos.close();
		client.close();
	}
}

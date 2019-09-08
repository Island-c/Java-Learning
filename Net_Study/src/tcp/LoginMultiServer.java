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
public class LoginMultiServer {
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
		String uname="";
		String upwd="";
		//����
		String[] dataArray=data.split("&");
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
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("asdf") && upwd.equals("asdf"))
		{
			//�ɹ�
			dos.writeUTF("��½�ɹ�");
		
		}else
		{
			//ʧ��
			dos.writeUTF("�û������������");
		}

		// * 4���ͷ���Դ
		dis.close();
		client.close();
		server.close();
	}
}

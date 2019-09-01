package NewIo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesGenerate_1 {
	public static void main(String[] args) {
		String Path="C:\\Users\\11\\Desktop\\a\\";
		for(int i=0;i<100;++i) {
			File tmp=new File(Path+"temp"+i+".txt");
			
			try {
				System.out.println(tmp.createNewFile());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				FileOutputStream os = new FileOutputStream(tmp);
				String msg="込込込込込込込込込";
				byte[] m=msg.getBytes();
				os.write(m);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

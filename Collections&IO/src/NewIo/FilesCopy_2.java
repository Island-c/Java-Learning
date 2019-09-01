package NewIo;

/**
 * �ļ��п���(�ļ��ں����ļ����ļ���)
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FilesCopy_2 {
    //�����
    public static void main(String[] args) throws Exception {
        //���Ʒ���
        copy("C:\\Users\\11\\Desktop\\a","C:\\Users\\11\\Desktop\\b");
        //��ӡ���
        System.out.println("�ļ��������!");
    }

    //���Ʒ���
    public static void copy(String src, String des) throws Exception {
        //��ʼ���ļ�����
        File file1=new File(src);
        //���ļ��������ݷŽ�����
        File[] fs=file1.listFiles();
        //��ʼ���ļ�ճ��
        File file2=new File(des);
        //�ж��Ƿ�������ļ��в���û�д���
        if(!file2.exists()){
            file2.mkdirs();
        }
        //�����ļ����ļ���
        for (File f : fs) {
            if(f.isFile()){
                //�ļ�
                fileCopy(f.getPath(),des+"\\"+f.getName()); //�����ļ������ķ���
            }else if(f.isDirectory()){
                //�ļ���
            	
            	
            	
            	
            	
            	
            	
                copy(f.getPath(),des+"\\"+f.getName());//�������ø��Ʒ���      �ݹ�ĵط�,�Լ������Լ��ķ���,�Ϳ��Ը����ļ��е��ļ�����
                
                
                
                
                
                
                
                
                
                
            }
        }
        
    }

    /**
     * �ļ����Ƶľ��巽��
     */
    private static void fileCopy(String src, String des) throws Exception {
        //io���̶���ʽ
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));
        int i = -1;//��¼��ȡ����
        byte[] bt = new byte[2014];//������
        while ((i = bis.read(bt))!=-1) {
            bos.write(bt, 0, i);
        }
        bis.close();
        bos.close();
        //�ر���
    }

}
/*
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilesCopy_2 {
	private static List<File> list = new LinkedList<File>();
	
	
	public static void main(String[] args) {
		String srcPath="C:\\Users\\11\\Desktop\\a";
		String desPath="C:\\Users\\11\\Desktop\\b";
		File src = new File(srcPath);
		
		list.add(src);
		int i=0;
		while (i<list.size()){
			File file=list.get(i++);
			System.out.println("aaaa   "+file.getAbsolutePath());
			
			//��ȡĿ¼�������ļ���
			File[] tempList = file.listFiles();
			System.out.println(tempList.length);
			
			for(File f: tempList) {
				
				if(f.isFile()) {
					System.out.println("�ļ�"+f.getPath());
					//FileStreamTest_0.copyFile(f.getPath(),des);
				}else if (f.isDirectory()) {
					System.out.println("Ŀ¼"+f.getAbsolutePath());
					System.out.println("Ŀ¼"+f.getName());
					File tempFile=new File(f.getName());
					list.add(tempFile);
				}
			}
		}
	}
	

}*/

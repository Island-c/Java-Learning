package cn.lc.myCollection;

/**
 * �Զ���HashMap
 * @author liu01
 *
 */

public class MyHashMap {

	Node2[] table;//λͰ����
	
	int size; //��ŵļ�ֵ�Ը���
	public MyHashMap(){
		table = new Node2[16];
		
	}
	
	public void put (Object key, Object value)
	{
		Node2 newNode= new Node2();
		newNode.hash = myHash(key.hashCode(), table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		if(temp == null)
		{
			table[newNode.hash]=newNode; //Ϊ��    ��ֱ�ӷ�
		}
		else
		{
			
			while (temp.next!=null)
			{
				if(temp.key.equals(key)) {
					System.out.println("key"+temp.key);
					System.out.println("key�ظ�");
				}
				
				temp=temp.next;
			}

			temp.next=newNode;
		}
	}
	
	public int myHash(int v, int length)
	{
		//System.out.println(v&(length-1));
		//System.out.println(v%length);
		return v&(length-1);
	}
	
	public static void main(String[] args) { 
		MyHashMap m=new MyHashMap();
		m.put(10, "aa");
		m.put(10, "aa");
	}
}

package cn.lc.myCollection;

import java.util.ArrayList;

public class MyArrayList<E> {

	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY =10;
	
	public MyArrayList () //�ӷ���
	{
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity)
	{
		if (capacity <=0)
			throw new RuntimeException("������������Ϊ����");
		else 
			elementData=new Object[capacity];
	}
	public void remove (E element)
	{
		for (int i=0 ; i<size ; i++)
		{
			if (element.equals(get(i)))
			{
				//�Ƴ�Ԫ��
				remove(i);
			}
		}
	}
	
	public void remove(int index )
	{
		//a,b,c,d,e,f,g
		//0,1,2,3,4,5,6 ;; size ==7 ; 
		rangeCheck(index);
		int numMoved= elementData.length - index -1;
		if (numMoved >0) {
			System.arraycopy(elementData, index+1, elementData, index, size-index-1);
		}
		elementData[--size]=null;
	}
	
	ArrayList<String > i =null;
	@SuppressWarnings("unchecked")
	public E get(int index)
	{
		if(rangeCheck(index))
			return (E)elementData[index];
		else 
			return null;
	}
	
	public boolean isEmpty()
	{
		return size==0?true:false; 
	}
	
	public void set ( E element ,int index)
	{
		if(rangeCheck(index))
			elementData[index]= element;
	}
	public boolean rangeCheck (int index)
	{
		if (index <0 || index > size-1)
			throw new RuntimeException("�����Ƿ�" + index);
			
		else return true;
	}
	
	public void add(E obj)
	{
		//����
		if(size == elementData.length)
		{

			Object[] newArray= new Object[elementData.length + (elementData.length >> 1)]; //����1λ ���һ���� 10+10/2 �� ע���������ȼ���������
			System.arraycopy(elementData, 0, newArray, 0, elementData.length); //����
			elementData = newArray; //��ֵ
		}

		elementData[size++] = obj;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(int i=0; i<size ; ++i)
		{
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']'); //�����á��� �� ������''
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyArrayList<String> s1= new MyArrayList<String>(20);
		for(int i=0; i<4 ; ++i)
		{
			s1.add("l"+ i);
		}
		s1.remove(1);
		System.out.println(s1);
	}
}

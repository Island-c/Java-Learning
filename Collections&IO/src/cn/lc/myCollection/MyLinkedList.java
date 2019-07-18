package cn.lc.myCollection;



public class MyLinkedList<E> {
	
	private Node first;
	private Node last;
	
	private int size;

	public void add(E obj)
	{
		Node node= new Node(obj);
		if(first == null)
		{		
			first = node;
			last=node;
		}else
		{
			last.next=node;
			node.previous=last;
			node.next=null;
			
			last=node;
		}
		size++;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder();
		sb.append('[');
		Node node=first;
		while (node!=null)
		{
			sb.append(node.element+",");
			node=node.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
		
	}
	
	public E get(int index)
	{
		rangeCheck(index);
		
		return (E) getNode(index).element;
	}
	public void rangeCheck(int index)
	{
		if(index < 0 || index > size-1)
			throw new RuntimeException("下标越界"+index);
	}
	public Node getNode(int index)
	{
		rangeCheck(index);
		Node node=first;

		for(int i=0;i<index;++i)
		{
			node=node.next;
		}
		return node;
	}

	public void remove(int index)
	{
		rangeCheck(index);
		Node temp=getNode(index);
		
		if(temp != null)
		{

			if(temp.previous != null)
				temp.previous.next=temp.next;
			else
				first=first.next;
			
			if(temp.next != null)
				temp.next.previous=temp.previous;
			else
				last=temp.previous;
			size--;
		}
		
		
		
	}
	
	public void add(int index, E element)
	{
		rangeCheck(index);
		Node node=getNode(index);
		Node newNode=new Node(element);
		if(node.previous != null)   
		{
			node.previous.next=newNode;
			newNode.previous=node.previous;
			node.previous=newNode;
			newNode.next=node;
		}
		else
		{
			first=newNode;
			newNode.next=node;
			node.previous=newNode;
		}
		
		size ++;
		
		
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> list=new MyLinkedList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		System.out.println(list);
		list.add(0,"qqqq");
		System.out.println(list);
		list.add(3,"fff");
		
		System.out.println(list);
	}
	
}

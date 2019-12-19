package com.lc.pojo;

public class People {

	private int id;
	private String name;
	private Desk desk;
	
	public int getId() {
		return id;
	}
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", desk=" + desk + "]";
	}
	public People() {

		super();
		System.out.println("执行无参构造方法。");
	}
	public People(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("执行有参构造 111");
	}
	
	public People(String name,int id) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("执行有参构造 222");
	}
	
}

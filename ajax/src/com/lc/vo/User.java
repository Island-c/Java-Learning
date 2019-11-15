package com.lc.vo;

public class User {
	private int uid;
	private String uname;
	private double price;
	private String location;
	private String des;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, double price, String location, String des) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.price = price;
		this.location = location;
		this.des = des;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesc() {
		return des;
	}
	public void setDesc(String desc) {
		this.des = desc;
	}
	
	
}

package com.lc.pojo;

public class Log {

	private int id;
	private String accIn;
	private String accOut;
	private double money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccIn() {
		return accIn;
	}
	public void setAccIn(String accIn) {
		this.accIn = accIn;
	}
	public String getAccOut() {
		return accOut;
	}
	public void setAccOut(String accOut) {
		this.accOut = accOut;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Log(int id, String accIn, String accOut, double money) {
		super();
		this.id = id;
		this.accIn = accIn;
		this.accOut = accOut;
		this.money = money;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", accIn=" + accIn + ", accOut=" + accOut + ", money=" + money + "]";
	}
	
	

	
}

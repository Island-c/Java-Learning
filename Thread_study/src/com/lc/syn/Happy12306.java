package com.lc.syn;


public class Happy12306 {
	public static void main(String[] args) {
		HWeb12306 c = new HWeb12306(2, "happy");
		new Passenger(c, "高", 2).start();
		new Passenger(c, "飞", 1).start();
	}
}

class Passenger extends Thread {
	int seats;

	public Passenger(Runnable target, String name, int seats) {
		super(target, name);
		this.seats = seats;
	}

}

class HWeb12306 implements Runnable {
	int available;
	String name;

	public HWeb12306(int available, String name) {
		this.available = available;
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Passenger p = (Passenger) Thread.currentThread();
		boolean flag = this.bookTickets(p.seats);
		if (flag) {
			System.out.println("出票成功-->" + Thread.currentThread().getName() + "-->位置为" + p.seats);
		} else {
			System.out.println("出票失败-->" + Thread.currentThread().getName() + "-->位置不够");
		}
	}

	public synchronized boolean bookTickets(int seats) {
		System.out.println("可用位置为:" + available);
		if (seats > available)
			return false;
		available -= seats;
		return true;

	}

}
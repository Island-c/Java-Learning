package com.lc.syn;


public class Happy12306 {
	public static void main(String[] args) {
		HWeb12306 c = new HWeb12306(2, "happy");
		new Passenger(c, "��", 2).start();
		new Passenger(c, "��", 1).start();
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
			System.out.println("��Ʊ�ɹ�-->" + Thread.currentThread().getName() + "-->λ��Ϊ" + p.seats);
		} else {
			System.out.println("��Ʊʧ��-->" + Thread.currentThread().getName() + "-->λ�ò���");
		}
	}

	public synchronized boolean bookTickets(int seats) {
		System.out.println("����λ��Ϊ:" + available);
		if (seats > available)
			return false;
		available -= seats;
		return true;

	}

}
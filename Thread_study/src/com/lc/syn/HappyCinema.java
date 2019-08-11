package com.lc.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
	public static void main(String[] args) {
		List<Integer> available=new ArrayList<Integer>();
		for(int i=1;i<8;i++)
		{
			available.add(i);
		}
		
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(5);
		seats2.add(6);
		
		
		HiCinema c= new HiCinema(available,"hahaha");
		new Thread(new HappyCustomer(c,seats1),"��").start();
		new Thread(new HappyCustomer(c,seats2),"��").start();
		
		
	}
}

class HappyCustomer implements Runnable{
	
	HiCinema cinema;
	List<Integer> seats;
	
	
	
	public HappyCustomer(HiCinema cinema, List<Integer> seats) {
		this.cinema = cinema;
		this.seats = seats;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(cinema) {
			boolean flag= cinema.bookTickets(seats);
		
			if(flag)
			{
				System.out.println("��Ʊ�ɹ�-->"+Thread.currentThread().getName()+"->λ��Ϊ"+seats);
			}
			else {
				System.out.println("��Ʊʧ��-->"+Thread.currentThread().getName());
			}

		}	
	}
}

class HiCinema{
	List<Integer> available; //���õ�λ��
	String name;
	
	public HiCinema(List<Integer> available, String name) {
		this.available=available;
		this.name=name;
	}
	
	public boolean bookTickets(List<Integer> seats) {
			System.out.println("����λ��Ϊ"+available);
			List<Integer> copy = new ArrayList<Integer>();
			copy.addAll(available);
			
			//���
			copy.removeAll(seats);
			//�жϴ�С
			if(available.size() - copy.size() != seats.size()) {
				return false;
			}
			//�ɹ�
			available=copy;
			return true;
	}
}
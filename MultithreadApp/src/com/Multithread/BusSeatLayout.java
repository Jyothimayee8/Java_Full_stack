package com.Multithread;

public class BusSeatLayout implements Runnable{
    // business logic
	public void run() {
		for(int i= 1; i<36;i++) {
			System.out.println("Seat: "+i);
		}
	}
	public static void main(String[] args) {
		BusSeatLayout b = new BusSeatLayout();
		Thread t = new Thread(b,"balayya");
		//b.setName("Balayya"); //setting new name 1 method
		t.start();
		//b. start(); 
		BusSeatLayout b1 = new BusSeatLayout();
		Thread t1 = new Thread(b1,"chiru"); // method2 
		t1.start();
		
	//	b1. start();//Acts as thread
		System.out.println(Thread.activeCount());
	//	System.out.println(b.getName()); // get thread
	//	System.out.println(b1.getName());
		
	}

}

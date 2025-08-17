package com.Multithread;
/*
 1.Extend class using thread class
 2.override run()
 3.call run() using start()
 */
public class ConcurrentDemo extends Thread{
	//method
	//over ride run method
	public void run() {
		for (int i = 1;i<=10;i++) {
			System.out.println("Realme model: "+i);
		}
	}

	public static void main(String[] args) {
		ConcurrentDemo s = new ConcurrentDemo();
		//call run() by using start()
		s.start();
		for (int i = 1;i<=10;i++) {
			System.out.println("Oneplus model: "+i);
		} 
	}

}

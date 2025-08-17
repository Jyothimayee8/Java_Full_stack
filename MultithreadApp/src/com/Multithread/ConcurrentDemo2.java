package com.Multithread;

class Demo extends Thread{
	public void run() {
		for (int i = 1;i<=10;i++) {
			System.out.println("Samsung model: "+i);
		}

	}
}
public class ConcurrentDemo2 implements Runnable{ // unable to call start method directly
	//method
	//over ride run method
	public void run() {
		for (int i = 1;i<=10;i++) {
			System.out.println("Realme model: "+i);
		}
		
	}
	public static void main(String[] args) {
		ConcurrentDemo2 s = new ConcurrentDemo2();
		
		//Take the support of thread class 
		Thread t = new Thread(s); // runnable target
		
		//call run() by using start()
		t.start();
		
		Demo d = new Demo();
		d.start();
		System.out.println(Thread.activeCount());//to know how many threads are running
		for (int i = 1;i<=10;i++) {
			System.out.println("Oneplus model: "+i);
		} 
	}
}
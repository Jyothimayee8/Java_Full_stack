// creating a thread method 2
// 1. implements runnable interface
//2. override run ()
// 3. calling run() using start()
package com.Multithread;

	public class ConcurrentDemo1 implements Runnable{
		//method
		//over ride run method
		public void run() {
			for (int i = 1;i<=10;i++) {
				System.out.println("Realme model: "+i);
			}
		}

		public static void main(String[] args) {
			ConcurrentDemo1 s = new ConcurrentDemo1();
			
			//Take the support of thread class 
			Thread t = new Thread(s); // runnable target
			
			//call run() by using start()
			t.start();
			for (int i = 1;i<=10;i++) {
				System.out.println("Oneplus model: "+i);
			} 
		}

	}


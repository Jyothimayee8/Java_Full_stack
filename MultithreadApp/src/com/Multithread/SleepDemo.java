package com.Multithread;
class SleepDemo implements Runnable{
	public void run() {
		
			for(int i =1;i<=35;i++) {
				System.out.println("please wait"+i);
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
	}
	public static void main(String[] args) {
		SleepDemo m = new SleepDemo();
		Thread t = new Thread(m);
		t.start();
	}

}
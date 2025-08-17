package com.Multithread;
class MovieNames implements Runnable{
	public void run() {
		if(Thread.currentThread().getName().equals("balayya")) {
			for(int i =1;i<=35;i++) {
				System.out.println("balayya movies"+i);
			}
		}
		else {
		for(int j =1;j<=35;j++) {
			System.out.println("chiru movies"+j);
		}
		
	}
	}
	public static void main(String[] args) {
		MovieNames m = new MovieNames();
		Thread t = new Thread(m,"balayya");
		t.start();
		MovieNames b1 = new MovieNames();
		Thread t1 = new Thread(b1,"chiru"); // method2 
		t1.start();
		System.out.println(Thread.activeCount());
	}

}
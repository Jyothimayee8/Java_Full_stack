package com.Multithread;

public class SequentialDemo {
	//method
	
	void pro_details() {
		for (int i = 1;i<=10;i++) {
			System.out.println("Realme model: "+i);
		}
	}

	public static void main(String[] args) {
		SequentialDemo s = new SequentialDemo();
		s.pro_details();
		System.out.println();
		for (int i = 1;i<=10;i++) {
			System.out.println("Oneplus model: "+i);
		} 
	}

}

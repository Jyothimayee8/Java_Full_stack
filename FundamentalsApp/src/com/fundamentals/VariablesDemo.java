package com.fundamentals;

public class VariablesDemo {
	int c = 9;//non-static
	static int d = 19;//STATIC variable 
	public void show() {
		int a = 10;//local
		System.out.println("a val is: "+a);
		System.out.println("c val is: "+c);
		System.out.println("d val is: "+d);
		
	}
         public static void main(String[] args) {
        	 int b = 0;
        	 VariablesDemo vd = new VariablesDemo();
        	 vd.show();
         }
}

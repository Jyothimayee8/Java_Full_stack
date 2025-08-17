package com.demo;
public abstract class Demo {
	int a = 10;
}
 class Demo1 extends Demo {

	 void first(){
		 System.out.println("a value is : "+a);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d = new Demo1();
	}
 }


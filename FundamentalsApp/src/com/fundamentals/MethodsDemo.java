package com.fundamentals;
/*
 A method is used whenever we want to provide some functionality 
 methods are two types 1. static and 2 . non-static
 if static keyword is there before the method then the method is called static method other wise non static method 
 */
public class MethodsDemo {
	void first() { //non - static method
		System.out.println("This is non static method");
	}
	static void second() { // static method
		System.out.println("This is a static method");
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo md = new MethodsDemo();
		md.first();
		MethodsDemo.second();

	}

}

package com.fundamentals;
 
/* 
 Constuctor is a special and there is no need to instantiate separately whenever we create an object then automatically the instantiation is done
 constructor should be instantiated using class name 
 two types of constructors in java 1. default and 2. parameterised constructor 
  */

public class ConstructorDemo {
	 
	ConstructorDemo(){   // default constructor
		System.out.println("this is default constructor");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ConstructorDemo();

	}

}
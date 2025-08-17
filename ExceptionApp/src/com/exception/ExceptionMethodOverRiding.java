/*
 Rules: 
 1. if super class method doesn't declare any exception
  then it's sub class dont't declare compile time exception
 2. If super class method does not declare any exception 
 then it's sub class method can declare run time exception
 3. If super class method declares any exception 
 then in sub class we need to  declare same exception or sub exception but not super exception
 
*/
package com.exception;

import java.io.IOException;

class Test{
	// method
	void show() throws IOException{
		System.out.println("HI");
	}
}

public class ExceptionMethodOverRiding extends Test {
	
	//method
	
	void show() throws IOException{
		System.out.println("HELLO");
	}
	public static void main(String[] args) {
		//ExcpetionMethodOverRiding e = new ExcpetionMethodOverRiding
		//ref var
		Test t;
		t = new Test();
		t.show();
		t = new ExceptionMethodOverRiding();
		t.show();
	}

}
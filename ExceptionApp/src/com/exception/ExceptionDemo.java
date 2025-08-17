package com.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		try {
			
		int c = a/b; // runtime or unchecked exception
		System.out.println(c);
		}
		catch(ArithmeticException e) {
			System.out.println("error:Arithmetic exception occured");
			
		}
		finally {
			System.out.println("exception handling done successfully");
		}
	}

}

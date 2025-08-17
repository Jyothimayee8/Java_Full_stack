package com.exception;

public class MultipleTryCatch {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		// Arithmetic Exception 
		
		try {
			System.out.println(a/b);
			System.out.println("this is try block");
		}
	
		catch(Exception ae) {
			ae.printStackTrace();
		}
		System.out.println("Hi");
		System.out.println("hello");
		
		//ArrayIndexOutOfBoundsException
		
		int array[] = {1,2,3};
		try {
			System.out.println(array[5]);

	}
		catch(Exception e) {
			e.printStackTrace();

}
System.out.println("Hello");

	}

}

/*
 finally can be done in two ways:
  1.try with finally-> only try block and finally but no exception details
  2.try-catch finally ->
 */
package com.exception;

public class Finally_Demo {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		try {
			
		int c = a/b; // runtime or unchecked exception
		System.out.println(c);
		}
		catch(ArithmeticException e) {
			System.out.println("error:Arithmetic exception occured");
			e.printStackTrace();
			
		}
		
		//Guarantee Executable block and used to deal with memory related resources(like objects etc)
		
		finally {
			System.out.println("exception handling done successfully");
		}
	}

}
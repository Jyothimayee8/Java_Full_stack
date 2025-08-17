package com.exception;

public class ExceptionDemo4 {

	public static void main(String[] args) {
			int a = 10;
			int b = 0;
			try {
				
			int c = a/b; // runtime or unchecked exception
			System.out.println(c);
			}
			catch(Exception e) {
				//System.out.println("error:Arithmetic exception occured");
				//System.out.println(e);
				e.printStackTrace();//new way
				
			}
			finally {
				System.out.println("exception handling done successfully");
			}

	}

}

/*
 diff btw the printstacktrace and sysout is --> in printstacktrace it clearly shows the line number and the exception but not in sysout)
*/
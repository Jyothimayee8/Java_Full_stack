package com.exception;

public class MultipleTimeCatch {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		try {
			System.out.println(a/b);
			System.out.println("this is try block");
		}
	
		catch(ArrayIndexOutOfBoundsException aoe) { //sub exception
			aoe.printStackTrace();
		}

		catch(Exception ae) { //super exception
			ae.printStackTrace();

}
System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

	}

}

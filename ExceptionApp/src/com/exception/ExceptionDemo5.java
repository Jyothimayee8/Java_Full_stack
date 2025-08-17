package com.exception;

public class ExceptionDemo5 {
	void show() {
		System.out.println("Welcome to java fsd");
	}

	public static void main(String[] args) {
		//create object
		ExceptionDemo5 ed = null;//nullPointerException
		ed.show();
	}

}
/* without creating object and calling the method then nullpointerexception occurs
 */

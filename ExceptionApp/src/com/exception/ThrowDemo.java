// voting app using exception handling 
package com.exception;

public class ThrowDemo {
	 static void check_eligibility(int age){
		 if (age < 18) {
			 throw new ArithmeticException("Not eligible to vote"); //exception using throw keyword
		 }
		 else {
			 System.out.println("Eligible to vote");
		 }
		 
	 }
	public static void main(String[] args) {
		check_eligibility(13);
	}

}

package com.fundamentals;

// when there is data in the object then we can use the enhanced for loop not for simple requirements

public class EnhancedForloop {
 public static void main(String[] args) {
	 int rollno[] = {101,102,103,104,105};
	 // plain for loop
	 for (int i =0;i<rollno.length;i++) {
		 System.out.println(rollno[i]);
	 }
	 //enhanced for loop
	 
	 for(int roll:rollno) {
		 System.out.println(roll);
	 }
 }
}

package com.string;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		if we use scp,it checks whether the string is created or not ,if not created then creates ,,insted of creting multiple location or references 
		if we use object syntax the momery is created for every string 
		literal syntax is best
		and string is immutable
		*/
		
		//Literal syntax
		
		String sname = "jyothi mayee"; // SCP(STRING CONSTANT POOL) area 
		System.out.println(sname);
		
		//object syntax
		
		String sname1 = new String("jyothi"); //Heap area
		System.out.println(sname1);
	
	String sname2 = "jyothi";
	String sname3 = new String("Mayee");
	System.out.println(sname2);
	
	 //strings are immutable
	
	sname.concat(" uppalapati");
	System.out.println(sname);
	
	
	// to implement mutable WE USE STRINGBUFFER(not thread safe),STRING BUILDER(thread safe)  and append
	  StringBuffer b = new StringBuffer("jyothi");
	  b.append(" uppalapati");
	  System.out.println(b);
	  
	//-------------------------String methods------------------------------------- 
	  
	  /*  CONCAT
	     1. +
	     2. concat() 
	   */
	  System.out.println(sname+ " + sname3");
	 
	  /* to get part of a string 
	   subString()2 parameters , subStr() in js , subsequence()
	   */
	  String course = "Java full stack";
	  System.out.println(course.substring(5));
	  System.out.println(course.substring(5,9));
	  
	  /*Replacing 
	   */
	 System.out.println(course.replace("full stack", "fsd"));
	  
	 /*comparing
	   1. using == 
	      -> it focuses on both values and references 
	   2. using equals()
	   	->Focuses on only values
	  */
	 System.out.println(sname == sname1);
	 System.out.println(sname.equals(sname1));
	 
	 /* to get index value
	 1. using indexOf()
	 2. lastIndexOf() 
	  */
	 
	 String msg = "Welcome to RISE Welcome to java fsd";
	 System.out.println(msg.indexOf("Welcome"));
	 System.out.println(msg.lastIndexOf("Welcome"));
	 
	 /*
	  
	  TO CHECK PART OF THE STRING --> USING contains()
	  
	  */
	 System.out.println(msg.contains("java"));
	 
	 /* to trim the string-->removes the first and last spaces of the string 
	  --> using trim()
	  */
	 String product = " RealMe ";
	 System.out.println(product.length());
	 System.out.println(product.trim());
	 System.out.println(product.trim().length());
	 
	 
	 /*
	  To check new methods of the string
	  1.startsWith()
	  2.endsWith()
	  */
	
	  System.out.println(msg.startsWith("Welcome"));
	  System.out.println(msg.endsWith("fsd"));
	}
}
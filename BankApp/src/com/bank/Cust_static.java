package com.bank;

//Example for the static variables and static methods

import java.util.Scanner;

public class Cust_static {

	//fields

	int cid;   // initialisation
	String cname;
	String address;
	long mobilenumber; // non - static variable
	static String bankname = "STATE BANK OF INDIA";//static variable
	
	//methods
	
	void setCustomerDetails(int a ,String b,String c,long d)
	{
		cid=a;
		cname=b;
		address=c;
		mobilenumber=d;
	}
	
	void getCustomerDetails()
	
	{
		System.out.println("Cid is: "+cid);
		System.out.println("Cname is: "+cname);
		System.out.println("Address is: "+address);
		System.out.println("Mobile Number is: "+mobilenumber);
	}
	
   // using Static methods
	static void suggestionsToCustomer() {
		System.out.println("Never Share OTP To Anyone!");
		
	}
	//Main Method 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To "+bankname);
		System.out.println("Please Register With Your Details Below!");
		System.out.println("Enter your id: ");
		int a = sc.nextInt();
		System.out.println("Enter your Name: ");
		String b = sc.next();
		System.out.println("Enter your Address: ");
		String c = sc.next();
		System.out.println("Enter your Mobile: ");
		long d = sc.nextLong();
		
		//creating  object || instatiation
		Customer c1 = new Customer();
		c1.setCustomerDetails(a,b,c,d);
		c1.getCustomerDetails();
		sc.close();
	
		
	}

}


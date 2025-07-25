package com.bank;

import java.util.Scanner;

public class Cust_details_runtime {

		//fields
	
		int cid;   // initialisation
		String cname;
		String address;
		long mobilenumber; // non - static variable
		
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
		
		//Main Method 
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Register With Your Details Below!");
			System.out.println("Enter your id: ");
			int a = sc.nextInt();
			System.out.println("Enter your Name: ");
			String b = sc.next();
			System.out.println("Enter your Address: ");
			String c = sc.next();
			System.out.println("Enter your Mobile: ");
			long d = sc.nextLong();
			
			//creating  object || instantiation
			Customer c1 = new Customer();
			c1.setCustomerDetails(a,b,c,d);
			c1.getCustomerDetails();
			sc.close();
		
			
		}

	}


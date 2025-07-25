//BANKAPP
package com.bank;


  public class Customer {

	//fields
	int cid;
	String cname;
	String address;
	long mobilenumber;
	
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
	
	public static void main(String[] args) {
		
		//create object
		Customer c= new Customer();
		c.setCustomerDetails(101, "junn", "ong", 1234567890);
		c.getCustomerDetails();

	}

}


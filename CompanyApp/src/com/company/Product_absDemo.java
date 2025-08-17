package com.company;

	public class Product_absDemo implements Product_abs{

	//fields
	int pid;
	String pname;
	double price;

	//constructor
	Product_absDemo(int pid,String pname,double price)
	{
	this.pid=pid;
	this.pname=pname;
	this.price=price;
	}

	@Override
	public void getProductDetails() {
	System.out.println("pid is:"+pid);
	System.out.println("product name is:"+pname);
	System.out.println("price is:"+price);
	}

	@Override
	public void offerdetails() {
	System.out.println("50% off on every day!!!");

	}

	public static void main(String[] args) {
	Product_abs p=new Product_absDemo(1001,"lg",20000);
	p.getProductDetails();
	p.offerdetails();

	}



	}


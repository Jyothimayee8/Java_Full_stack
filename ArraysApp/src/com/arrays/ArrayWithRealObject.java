package com.arrays;

public class ArrayWithRealObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product[] products = new Product[3];
		
		//create product objects
		
		Product p = new Product(1001,"samsung",30000);
		Product p1 = new Product(1002,"godrej",50000);
		Product p2 = new Product(1003,"Whirpool",45000);
		
		//insert 
		
		products[0] = p;
		products[1] = p1;
		products[2] = p2;
		
		// Display --> using enhanced for loop
		 for(Product pro : products) {
			 System.out.println(pro.getPid()+" "+pro.getPname()+" "+pro.getPrice());
		 }
		
	}

}

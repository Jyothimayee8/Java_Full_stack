package com.arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		//-----------Literal syntax-----------------------
		String[] names = {"narayan","krishna","shiva","vishnu"};
		
		// to get specific index value of data(index starts with 0)
		
		System.out.println(names[1]);
		
		//To get all elements--> using for each or enhanced for loop
		
		for(String name: names) {
			System.out.println(name);
		}
		
		//----------------- object syntax------------------------
		int rollnos[] = new int[3];
		rollnos[0] = 1001;
		rollnos[1] = 1002;
		rollnos[2] = 1003;
		// System.out.println(rollnos[3]); // array index out of bounds exception
		System.out.println(rollnos[2]);
		
		
		
	}

}

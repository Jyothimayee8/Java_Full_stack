package com.casting;
//type casting ---> conversion of one dtype to another dtype
public class Demo {

	public static void main(String[] args) {
		int a = 10;
		double b;
		b = a;
		System.out.println("b value : "+b); // widening casting (lower data type to higher data type called as implicit casting)
		
		double c = 50.0;
		int d;
		d = (int)c;//narrow casting(higher data type to lower data type is called explicit casting)
		System.out.println("d value : "+d);
	}

}

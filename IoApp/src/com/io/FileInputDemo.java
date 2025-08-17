package com.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputDemo {

	public static void main(String[] args) throws IOException {
		//defining data to insert into a file
		 
		String msg = "Welcome to java full stack";
		
		//to input data into file
		
		FileOutputStream fos = new FileOutputStream("Input.txt");
		//convert string to byte
		byte[]b = msg.getBytes();
		//to write data
		
		fos.write(b);
		//for confirmation
		
		System.out.println("Operation successfull");
		
		// close objects 
		fos.close();
	}

}

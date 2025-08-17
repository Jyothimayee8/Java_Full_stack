package com.io;

import java.io.FileInputStream;
import java.io.IOException;

public class InputDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// File input stream 
		
		FileInputStream fis = new FileInputStream("Demo.txt");
		
		// to read 
		int i ;
		while((i = fis.read())!= -1) {
			System.out.print((char)i);
			
		}
		fis.close();
	}

}

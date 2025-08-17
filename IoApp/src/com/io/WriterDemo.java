package com.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {  // will be better to use writer than output stream. because, no need to convert into bytes

	public static void main(String[] args) throws IOException {
		// Data
		
		String msg = "Welcome to risee";
		
		// to write into a file
		FileWriter fw = new FileWriter("Demo.txt");
		
		// to write
		fw.write(msg);
		
		// confirmation
		
		System.out.println("operation successfull");
		
		// closing the objects
		
		fw.close();
	}

}

package com.io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {

	public static void main(String[] args) throws IOException {
		// Reader class
		
		FileReader fr = new FileReader("Input.txt");
		//to read
		
	int i;
	while((i= fr.read())!= -1) {
		System.out.print((char)i);
	}
	fr.close();
	}
	//close object

}

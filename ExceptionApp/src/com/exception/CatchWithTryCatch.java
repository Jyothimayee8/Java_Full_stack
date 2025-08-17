package com.exception;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class CatchWithTryCatch {

	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		try {
			System.out.println(a/b);
			System.out.println("this is try block");
		}
	
		catch(Exception e) { 
			
			// writing data into a file
			try {
				
			FileWriter fw = new FileWriter("Exception_info.txt");
			Date d = new Date();
			//convert exception object data into string
			String msg = e.toString();
			String msg1 = d.toString();
			
			//to write 
			
			fw.write(msg);
			fw.write(msg1);
			
			// to close object
			
			}
			catch(IOException i ) {
				i.printStackTrace();
		}
			finally {
				try {
					fw.close(); //--> cant be resolved coz fw is in try block so,,we should make the  try block global
				}
System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiii");

	}

}


	}

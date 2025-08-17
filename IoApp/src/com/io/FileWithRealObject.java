//Serialization 
package com.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWithRealObject {

	public static void main(String[] args) throws IOException {
		// create object with required details
		Employee e = new Employee(1001,"jyothi",555554423);
		//to write object info into a file
		
		FileOutputStream fos = new FileOutputStream("Employee_info.txt");
		
		// to write an object we should create a new class
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		//to write 
		oos.writeObject(e);
		
		// to confirm
		
		System.out.println("successs");
		fos.close();
		oos.close();
	}

}

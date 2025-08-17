package com.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TO read from  file
		FileInputStream fis = new FileInputStream("Employee_info.txt");
		// to read from object
		ObjectInputStream ois = new ObjectInputStream(fis);
		//to read 
		Employee e = (Employee) ois.readObject();
		System.out.println(e.getEid()+" "+e.getEname()+" "+e.getMobno());
		// to confirm
		System.out.println("successs");
		
		fis.close();
		ois.close();
	}

}

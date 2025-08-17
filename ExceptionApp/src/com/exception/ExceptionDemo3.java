package com.exception;
//compile time exception (sql exception)

import java.sql.Connection;
import java.sql.DriverManager;

public class ExceptionDemo3 {

	public static void main(String[] args) {
		Connection con = DriverManager.getConnection(null);
		System.out.println("hi");
	}
	
}
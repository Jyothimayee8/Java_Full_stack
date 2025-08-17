package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertionTest {

	public static void main(String[] args) {
		//global objects
		Connection con = null;
		Statement st = null;
		try {
			//1.load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.establish connection
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/amazon",
					"root","root");
			//3. sql query
			
			String qry = "Insert into product values(2002,'sony')";
			
			//4. create stmt(vehicle)
			
			st = con.createStatement();
			
			// 5. execute and process result
			
			int result = st.executeUpdate(qry);
			
			//Business logic
			if(result!=0) {
				System.out.println("record inserted");
			}
			else {
				System.out.println("record not inserted");
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
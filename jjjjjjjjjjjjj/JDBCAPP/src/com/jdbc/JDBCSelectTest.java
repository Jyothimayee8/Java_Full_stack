package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCSelectTest {

		public static void main(String[] args) {
			//global objects
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
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
				
				rs= st.executeQuery(qry);
				
				//Business logic
				while(rs.next()) {
					System.out.println(rs.getInt(1)+ " "
							+ rs.getString(1));
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			
			finally {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
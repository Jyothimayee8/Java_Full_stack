package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCPreparedStmt {
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
					
					String qry = "Insert into product values(?,?)";// ? are the place holders
					Scanner sc = new(System.in);
					System.out.println("Welcome to amazon portal");
					System.out.println("please enter product details! ");
					System.out.println("Enter prodcut id:");
					id = sc.nextInt();
					System.out.println("Enter prodcut name:");
					name = sc.next();
				
					
					//4. create stmt obj(vehicle)
					
					st = con.prepareStatement(q);
					//set values
					
					ps.setInt(1,3001);
					ps.setInt(2,3003);
					ps.setInt(3,3005);
					
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
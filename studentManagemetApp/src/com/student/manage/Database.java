package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;


public class Database {

	static Connection con;
	 public static Connection creatC(){
		 try {
			 //Load the driver
			 Class.forName("com.mysql.jdbc.Driver");
			 //Create the Connection.....
			 String user = "root";
			 String password = "root";
			 String url = "jdbc:mysql://localhost:3306/student_manage";
			 System.out.println("connected");
			 con = DriverManager.getConnection(url, user, password);
			 
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 return con;
	 }
	 
}

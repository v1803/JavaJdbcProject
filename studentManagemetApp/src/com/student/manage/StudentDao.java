package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st) {
		
		boolean f = false;
		//jdbc code...
		try {	
		Connection con = Database.creatC();
		String q = "insert into students(sname, sphone, scity) values(?,?,?)";
		
		//Prepared statement..
		PreparedStatement pstmt = con.prepareStatement(q);
		
		//Set the value of parameter
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		//execute..
		pstmt.executeUpdate();
		f = true;
		
	}
	 catch(Exception e){
		 e.printStackTrace();
	 }
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		//jdbc code...
		try {	
		Connection con = Database.creatC();
		String q = "delete from students where sid=?";
		
		//Prepared statement..
		PreparedStatement pstmt = con.prepareStatement(q);
		
		//Set the value of parameter
		pstmt.setInt(1, userId);
		
		
		//execute..
		pstmt.executeUpdate();
		f = true;
		
	}
	 catch(Exception e){
		 e.printStackTrace();
	 }
		return f;
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		boolean f = false;
		//jdbc code...
		try {	
		Connection con = Database.creatC();
		String q = "select * from students";
		
		Statement stmt = (Statement) con.createStatement();
		ResultSet set = stmt.executeQuery(q);
		
		while(set.next()) {
			int id = set.getInt(1);
			String name = set.getString(2);
			String phone = set.getString(3);
			String city = set.getString(4);
			
			System.out.println("ID : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone : "+phone);
			System.out.println("City : "+city);
			System.out.println("++++++++++++++++++++++++++");
		}
	
		
	}
	 catch(Exception e){
		 e.printStackTrace();
	 }
		
	}
}

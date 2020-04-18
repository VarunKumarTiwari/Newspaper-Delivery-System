package com.bdonor.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bdonor.Data.Data;



public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.hsqldb.jdbcDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		
		return conn;
	}

	public static void insertDonor (Data donor)  {
		
				try {
					
					Connection conn = getConnection() ;
			
					Statement stmt = conn.createStatement();
					System.out.println("in insert");
					String sql = "INSERT INTO BDONOR VALUES ('" + donor.getId() + "','" + donor.getName() + "','" + donor.getBgroup() + "','" + donor.getGender() + "','" + donor.getAge() + "')";
					
					System.out.println(sql);
					stmt.executeUpdate(sql);
					 
					stmt.close();
					conn.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
	}

/*	public static void deleteBook(int id) {
		// TODO Auto-generated method stub
		
	
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
		
			Statement stmt = conn.createStatement();
			System.out.println("de");
			String sql = "DELETE FROM Book where id= '" + id + "'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void updateBook(Data bk) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			System.out.println("in update");
			String sql = "UPDATE Book SET author = '" + bk.getAuthor() + "',  title = '" + bk.getTitle() + "', year = '" + bk.getYear() + "' where id = '" +  bk.getId() + "'";
			
			System.out.println(sql);
			stmt.executeUpdate(sql);
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	public static Data selectBook(int id) {
		Data bk = new Data(); 
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
	
			Statement stmt = conn.createStatement();
			System.out.println("in select");
			String sql = "SELECT * from Book where id = '" + id +"'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			if (rs.next()) {
			 
				bk.setId(Integer.parseInt(rs.getString("id")));
				bk.setAuthor(rs.getString("author"));
				bk.setTitle(rs.getString("title"));
				bk.setYear(Integer.parseInt(rs.getString("year")));
					
			} 
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return bk;
	
		
	}
*/
	public static List<Data> selectAllDonor() {
		// TODO Auto-generated method stub
		List<Data> books= new ArrayList<Data>();
		
		try {
			Connection conn = getConnection() ;
			
			Statement stmt = conn.createStatement();
			
			System.out.println("in select");
			String sql = "SELECT * from BDONOR";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			while (rs.next()) {
				Data bk = new Data(rs.getInt("AUTOID"), rs.getString("NAME"), rs.getString("BGROUP"), rs.getString("GENDER"), rs.getInt("AGE"));
				
				books.add(bk);	
			} 
			 
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
		
	}

}

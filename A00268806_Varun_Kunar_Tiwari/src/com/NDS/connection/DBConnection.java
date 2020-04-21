package com.NDS.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.NDS.Data.Data;



public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.hsqldb.jdbcDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		
		return conn;
	}

	public static void insertPublication (Data pub)  {
		
				try {
					
					Connection conn = getConnection() ;
			
					Statement stmt = conn.createStatement();
					System.out.println("in insert");
					String sql = "INSERT INTO MANDPUB(Autoid, name, frequency, amount , price) VALUES ('" + pub.getId() + "','" + pub.getName() + "','" + pub.getFrequecny() + "','" + pub.getAmount() + "','" + pub.getPrice() + "')";
					
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
	public static boolean ifExist(int id) 
	{
		boolean result = false;
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("in ifExist");
			ResultSet rs = stmt.executeQuery("SELECT AUTOID FROM MANDPUB");
			
			while (rs.next()) {
				
				Integer autoID = rs.getInt("AUTOID");
				if(id == autoID)
				{
					result = true;
					System.out.println(id);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return result;
	}

	public static void deletePub(int id) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("delete");
			String sql = "DELETE FROM MANDPUB where AUTOID= '" + id + "'";
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

	public static void updatePub(Data bk) {
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			System.out.println("in update");
			String sql = "UPDATE MANDPUB SET name = '" + bk.getName() + "', frequency = '" + bk.getFrequecny() + "',  amount = '" + bk.getAmount()+"', price = '" + bk.getPrice() +"' where AUTOID = '" +  bk.getId() + "'";
			
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
	
	
	public static Data selectPublication(int id) {
		Data bk = new Data(); 
		try {
			Connection conn = getConnection() ;
			
			Statement stmt = conn.createStatement();
			System.out.println("in select");
			String sql = "SELECT * from MANDPUB where Autoid = '" + id +"'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			if (rs.next()) {
			 
				bk.setId(Integer.parseInt(rs.getString("AUTOID")));
				bk.setName(rs.getString("NAME"));
				bk.setFrequecny(rs.getString("frequency"));
				bk.setAmount(rs.getInt("amount"));
				bk.setPrice(Integer.parseInt(rs.getString("Price")));
					
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

	public static List<Data> selectAllPublication() {
		// TODO Auto-generated method stub
		List<Data> publication= new ArrayList<Data>();
		
		try {
			Connection conn = getConnection() ;
			
			Statement stmt = conn.createStatement();
			
			System.out.println("in select");
			String sql = "SELECT * from MANDPUB";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			
			while (rs.next()) {
			//	Data bk = new Data(rs.getInt("AUTOID"), rs.getString("NAME"), rs.getString("BGROUP"), rs.getString("GENDER"), rs.getInt("AGE"));
				Data bk = new Data();
				bk.setId(Integer.parseInt(rs.getString("AUTOID")));
				bk.setName(rs.getString("NAME"));
				bk.setFrequecny(rs.getString("frequency"));
				bk.setAmount(rs.getInt("amount"));
				bk.setPrice(Integer.parseInt(rs.getString("Price")));
				publication.add(bk);	
				//books.add(bk);	
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
		
		return publication;
		
	}

}

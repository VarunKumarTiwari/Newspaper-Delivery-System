package com.NDS.AutoID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.NDS.connection.DBConnection;

public class IDGenerater {
	private static ArrayList<Integer> IDarr = new ArrayList<Integer>(30);
	private int counter = 0;
	private int autoID = 0;

	public int autoIDGenerate() {
		try {
		
		Connection conn = DBConnection.getConnection() ;

		Statement stmt = conn.createStatement();
		System.out.println("in insert");
		ResultSet rs = stmt.executeQuery("SELECT AUTOID FROM MANDPUB");
		
		while (rs.next()) {
			Integer idd = rs.getInt("AUTOID");
			IDarr.add(idd);
			System.out.println(idd);
		}
		
		
		
		boolean flag = true;
		int id = (int) (Math.random() * (1 - 50) + 50);
		if(IDarr==null)
		{
			autoID = id;
		}
		else {
		for (Integer number : IDarr) {
			if (number == id) {
				flag = false;
			}
		}
		}
		
		if (flag == true) {
				autoID = id;
				System.out.println(autoID);
		} else {
			
			System.out.println("run again");
				
			
		}
		
		
		
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	

		return autoID;
		
	}
	public void addToList(int id)
	{
		IDarr.add(id);
		
	}
	
	public void deleteToList(int id)
	{
		IDarr.remove(id);
		for(int number:IDarr)
		{
			System.out.println(IDarr);
		}
		
	}
	public static void main(String[] args) {
		int autoID = 0;
		try {
			
			Connection conn = DBConnection.getConnection() ;
	
			Statement stmt = conn.createStatement();
			System.out.println("in insert");
			ResultSet rs = stmt.executeQuery("SELECT AUTOID FROM BDONOR");
			
			while (rs.next()) {
				Integer idd = rs.getInt("AUTOID");
				IDarr.add(idd);
				System.out.println(idd);
			}
			
			
			
			boolean flag = true;
			int id = (int) (Math.random() * (1 - 50) + 50);
			if(IDarr==null)
			{
				autoID = id;
			}
			else {
			for (Integer number : IDarr) {
				if (number == id) {
					flag = false;
				}
			}
			}
			
			if (flag == true) {
					autoID = id;
					System.out.println(autoID);
			} else {
				
				System.out.println("run again");
					
				
			}
			
			
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}

}

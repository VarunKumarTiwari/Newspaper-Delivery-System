package com.bdonor.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws Exception {
		String name = "Rob";
		String address = "Athlone";
		
		// Class.forName("org.hsqldb.jdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "sa", "");
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO USER (name, address) VALUES ('" + name + "', '" + address + "')");
		stmt.executeUpdate("INSERT INTO USER (name, address) VALUES ('Thiago', 'Dublin')");
		
		stmt.close();
		conn.close();
	}
}

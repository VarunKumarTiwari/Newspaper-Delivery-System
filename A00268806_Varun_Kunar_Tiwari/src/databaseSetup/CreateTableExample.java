package databaseSetup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {

	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS BDonor(Autoid INTEGER NOT NULL, name VARCHAR(32) NOT NULL, bgroup VARCHAR(32) NOT NULL, gender VARCHAR(32) NOT NULL, age INTEGER NOT NULL)");
		
		System.out.println("Table created");
	}

}

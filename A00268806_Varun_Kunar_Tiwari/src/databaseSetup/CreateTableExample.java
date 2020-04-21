package databaseSetup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableExample {

	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MANDPUB(Autoid INTEGER NOT NULL, name VARCHAR(32) NOT NULL, frequency VARCHAR(32) NOT NULL, amount VARCHAR(32) NOT NULL, price INTEGER NOT NULL)");
		
		System.out.println("Table created");
	}

}

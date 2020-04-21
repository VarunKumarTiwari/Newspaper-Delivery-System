package com.NDS.Data;

import java.sql.SQLException;
import java.util.*;

import com.NDS.connection.DBConnection;

public enum PubDao {
	INSTANCE;
	
	//private Map<Integer, Data> booksMap = new HashMap<Integer, Data>();
	
	/*private BDonorDao() {
		
		Data book1 = new Data();
		book1.setId(1);
		book1.setTitle("RESTful Java with JAX-RS");
		book1.setAuthor("Bill Burke");
		book1.setYear(2009);
		
		booksMap.put(1, book1);
		
		Data book2 = new Data();
		book2.setId(2);
		book2.setTitle("Java message service");
		book2.setAuthor("David A. Chappell, Richard Monson-Haefel");
		book2.setYear(2000);
		
		booksMap.put(2, book2);
	}*/
	
	public List<Data> getAllDonor() {
		System.out.println("getall");
		List<Data> publication = DBConnection.selectAllPublication();
	//	books.addAll(booksMap.values());
		return publication;
	}
	
	public Data getDonor(int id) {
		//return booksMap.get(id);
		System.out.println("get");
		return DBConnection.selectPublication(id);
	}
	
	public void create(Data pub) {
		//booksMap.put(book.getId(), book);
		System.out.println("create");
		DBConnection.insertPublication(pub);
		
	}
	
	public List<Data> display() {
		//booksMap.put(book.getId(), book);
		System.out.println("select");
		return DBConnection.selectAllPublication();
	}
	
	public boolean ifExist(int ID)
	{
		return DBConnection.ifExist(ID); 
	}
	
	public void delete(int id) {

		System.out.println("delete");
		DBConnection.deletePub(id);
		
	}

	public void update(Data book) {
		System.out.println("update");
		DBConnection.updatePub(book);
		
	}
}

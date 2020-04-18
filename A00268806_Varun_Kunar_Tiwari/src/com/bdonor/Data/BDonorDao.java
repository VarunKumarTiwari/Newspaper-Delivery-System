package com.bdonor.Data;

import java.sql.SQLException;
import java.util.*;

import com.bdonor.connection.DBConnection;

public enum BDonorDao {
	INSTANCE;
	
	private Map<Integer, Data> booksMap = new HashMap<Integer, Data>();
	
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
	
/*	public List<Data> getBooks() {
		System.out.println("getall");
		List<Data> books = DBConnection.selectAllBooks();
	//	books.addAll(booksMap.values());
		return books;
	}
	
	public Data getBook(int id) {
		//return booksMap.get(id);
		System.out.println("get");
		return DBConnection.selectBook(id);
	}
	*/
	public void create(Data book) {
		//booksMap.put(book.getId(), book);
		System.out.println("create");
		DBConnection.insertDonor(book);
		
	}
	
	public List<Data> display() {
		//booksMap.put(book.getId(), book);
		System.out.println("select");
		return DBConnection.selectAllDonor();
	}
	
/*	public void delete(int id) {

		System.out.println("delete");
		DBConnection.deleteBook(id);
		
	}

	public void update(Data book) {
		System.out.println("update");
		DBConnection.updateBook(book);
		
	}*/
}

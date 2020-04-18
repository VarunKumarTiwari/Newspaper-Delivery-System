package com.bdonor.Data;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

@Path("/books")
public class BDonorResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Data>getBooks(){
		return BDonorDao.INSTANCE.getBooks();
	}
/*	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{bookId}")
	public Data getBook(@PathParam("bookId") String id){
		return BDonorDao.INSTANCE.getBook(Integer.parseInt(id));
	}*/
	
/*	@POST
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void postBook(@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("author") String author,
			@FormParam("year") String year,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("Inside POST id = " + id);
		System.out.println("Title = " + title);
		
		Data book = new Data();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setYear(Integer.parseInt(year));
		
		BDonorDao.INSTANCE.create(book);
		servletResponse.sendRedirect("../createBook.html");
		
	}
/*	
	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Path("{bookId}")
	public void deleteBook(@PathParam("bookId") String id) throws IOException {
		System.out.println("Delete id: " + id);
		BDonorDao.INSTANCE.delete(Integer.parseInt(id));
	}
	
	@PUT
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Path("{bookId}")
	public static void putBook(@PathParam("bookId") String id,
			@FormParam("title") String title,
			@FormParam("author") String author,
			@FormParam("year") String year,
			@Context HttpServletResponse servletResponse) throws IOException {
		System.out.println("PUT id = " + id);
		
		Data book = new Data();
		book.setId(Integer.parseInt(id));
		book.setTitle(title);
		book.setAuthor(author);
		book.setYear(Integer.parseInt(year));
		BDonorDao.INSTANCE.update(book);
	}*/
}

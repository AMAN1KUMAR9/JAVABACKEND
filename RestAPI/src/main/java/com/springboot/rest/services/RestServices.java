package com.springboot.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.rest.dao.Dao;
import com.springboot.rest.entity.Book;

@Service
public class RestServices {
	@Autowired
	private Dao dao;
//	private static List<Book> books = new ArrayList<>();
//	
//	static {
//		
//		books.add(new Book(12 , "Java book" , "sharma"));
//		books.add(new Book(14 , "python book" , "pandit"));
//		books.add(new Book(16 , "C++ book" , "prajapati"));
//	}
	
	
	
	public List<Book> getAllBooks() {
		
		
//		System.out.println(books);
	List<Book> list = (List<Book>) dao.findAll();
		return list;
		
	}
	
	public Book getBook(int id)
	{
//		Book book = books.stream().filter(b -> b.getId() == id).findFirst().get();
//		return book;
		
		Book byId = dao.findById(id);
		return byId;
	}
	
	public Book addBook(Book book) {
//		books.add(book);
		
		return dao.save(book);
	}
	
	public void deleteBook(int id ) {
	
//		    books.removeIf(book -> book.getId() == id);
		dao.deleteById(id);
		}
	
	
	public Book update (Book book , int id) {
//	for (Book book2 : books) {
//		if (book2.getId() == id) {
//			book2.setAuthor(book.getAuthor());
//			book2.setTitle(book.getTitle());
//			return book;
//		}
//	}
//		return null;
		if (book.getId() == id)
		dao.save(book);
		return book;
		
		
	}

	}



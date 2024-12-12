package com.springboot.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.rest.entity.Book;
import com.springboot.rest.services.RestServices;




@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	 private RestServices restServices;
	@GetMapping("/books")
	public ResponseEntity<List<Book> >getbooks( ) {
		List<Book> list = restServices.getAllBooks();
		if (list.size()<= 0) {return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
		
		 return  ResponseEntity.of(Optional.of(list))  ;
	}
	
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = restServices.getBook(id);
		
		if (book == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		//TODO: process POST request
		Book b = null;
		try {
			
			b = this.restServices.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
		try {
			
			restServices.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return  ResponseEntity.internalServerError().build();
		}
	}
	
	
	@PutMapping("books/{id}")
	public ResponseEntity<Book> putMethodName(@PathVariable("id") int id, @RequestBody Book book) {
		//TODO: process PUT request
		try {
			 restServices.update(book, id);
			
			return ResponseEntity.ok().body(book) ; 
		}catch (Exception e) {
			return  ResponseEntity.internalServerError().build();
		}
		
	}

}

package com.springboot.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.entity.Book;

@Repository
public interface Dao extends CrudRepository<Book, Integer> {

	public Book findById(int id) ;
		
}

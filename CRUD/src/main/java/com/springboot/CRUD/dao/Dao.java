package com.springboot.CRUD.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.CRUD.entity.User;


public interface Dao extends CrudRepository<User, Integer>{
	public Iterable<User> findByName(String name);
	
	// Native SQL query to find by last name or first name
	@Query(value = "SELECT * FROM user p WHERE p.name = :name", nativeQuery = true)
	List<User> findByLastnameOrFirstname(@Param("name") String name);

	// JPQL query to find by last name or first name
	@Query("SELECT p FROM User p WHERE p.name = :name")
	List<User> findByLastnameORFirstname(@Param("name") String name);

}

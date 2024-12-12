package com.contactmanager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.dao.ContactsDao;
import com.contactmanager.dao.Dao;
import com.contactmanager.entities.Contacts;
import com.contactmanager.entities.User;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class SearchController {
	
	@Autowired
	private ContactsDao contactsDao;
	
	@Autowired
	private Dao dao;
	
	
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<Contacts>> search(@PathVariable("keywords") String keywords , Principal principal  ) {
		System.out.println(keywords);
		
		User user = dao.getUserByEmail(principal.getName());
		
		List<Contacts> contacts = contactsDao.findByNameContainingAndUser(keywords, user);
		
		
		
		return ResponseEntity.ok(contacts);
		
	}
	
}

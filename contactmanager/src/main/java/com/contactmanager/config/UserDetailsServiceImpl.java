package com.contactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contactmanager.dao.Dao;
import com.contactmanager.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	Dao dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = dao.getUserByEmail(username);
		if (user  == null) {
			throw new UsernameNotFoundException("Could not find user!");
		}
		
		UserDetailsImpl  userDetails = new  UserDetailsImpl(user);
		return userDetails ;
	}

}

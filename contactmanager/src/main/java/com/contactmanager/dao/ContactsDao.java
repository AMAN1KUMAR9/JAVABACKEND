package com.contactmanager.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contactmanager.entities.Contacts;
import com.contactmanager.entities.User;


@Repository
public interface ContactsDao extends JpaRepository<Contacts, Integer> {

    // Correct query for fetching user by email
    @Query("from Contacts as u where u.user.id = :UserId")
    public  Page<Contacts> getContactsByUserId(@Param("UserId") int userId , Pageable pageRequest);
    
    public List<Contacts> findByNameContainingAndUser(String keywords , User user);
 
}
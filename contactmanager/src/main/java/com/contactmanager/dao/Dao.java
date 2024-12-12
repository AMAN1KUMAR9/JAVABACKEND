

package com.contactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.contactmanager.entities.User;
import java.util.List;


@Repository
public interface Dao extends JpaRepository<User, Integer> {

    // Correct query for fetching user by email
    @Query("select u from User u where u.email = :email")
    public User getUserByEmail(@Param("email") String email);
    
    public List<User> findByEmail(String email);

}


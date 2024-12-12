package com.springboot.CRUD; // Package declaration



import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication; // Import for SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication; // Import for Spring Boot Application annotation
import org.springframework.context.ApplicationContext;

import com.springboot.CRUD.dao.Dao;
import com.springboot.CRUD.entity.User;

// Main application class
@SpringBootApplication
public class CrudApplication {

    // Main method - entry point for the Spring Boot application
    public static void main(String[] args) {
        ApplicationContext  context = SpringApplication.run(CrudApplication.class, args);
        
      Dao dao  = context.getBean(Dao.class);
//      
//      User user = new User();
//      user.setName("Aman");
//      user.setAddress("kolkata");
//      user.setStatus("java developer");
//      
//       User user1 = dao.save(user);
//       System.out.println(user1);
       
//       User user2 = new User();
//       user2.setName("Aditya");
//       user2.setAddress("bhopal");
//       user2.setStatus("python developer");
       
//       User user_2 = dao.save(user2);
//       System.out.println(user_2);
       
       
       
//       dao.deleteById(2);
//       
//      Iterable< User> users = List.of(user , user2);
//      dao.saveAll(users);
//      
//      users.forEach( userr ->
//      {
//    	  System.out.println(userr);
//      }) ;
      
      // updation

//     Optional<User> optional= dao.findById(1);
//     User user = optional.get();
//     System.out.println(user);
//     
//   user.setAddress("punjab");
//     User user1 = dao.save(user);
//     System.out.println(user1);
      
      
//      Iterable<User> it= dao.findByName("aman");
//      Iterable<User> it= dao.findByLastnameOrFirstname("aman");
      Iterable<User> it= dao.findByLastnameORFirstname("aditya");
      
      
      it.forEach(user ->{
    	  System.out.println(user);
      });
    }
    
    
}

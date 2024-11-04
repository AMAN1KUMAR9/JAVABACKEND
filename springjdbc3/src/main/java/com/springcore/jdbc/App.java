package com.springcore.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springcore.jdbc.dao.Dao;
import com.springcore.jdbc.dao.DaoImple;
import com.springcore.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(jdbcconfig.class);
        
        Dao  dao = context.getBean("dao" ,DaoImple.class );
       
      
     
      
//      student.setId(345);
//      student.setName("Aditya");
//      student.setCity("Bhopal");
//      int rs = dao.insert(student);
      
//      int rs = dao.updatee(student);
//      int rs = dao.del(345);
//      System.out.println(rs);
//        
//        Student student = dao.getStudent(123);
       List<Student> ls = dao.getListOfStudent();
       System.out.println(ls);
    
        
    }

   
}

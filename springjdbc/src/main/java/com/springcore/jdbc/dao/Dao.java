package com.springcore.jdbc.dao;

import java.util.List;

import com.springcore.jdbc.entities.Student;


public interface Dao {
	public int insert(Student student);
	public int updatee(Student student);
	public int del (int id);
	public Student getStudent (int StudentID );
	public List<Student> getListOfStudent();
	
}

package com.springcore.jdbc.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springcore.jdbc.entities.Student;

public class DaoImple implements Dao{
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	public int insert(Student student) {
		  String query = "insert into studentdetails(id,name,city) values(?,?,?)";
		  int res = this.jdbcTemplate.update(query ,student.getId() , student.getName() , student.getCity());
	
	return res;
	
}
	@Override
	public int updatee(Student student) {

		String query = "UPDATE studentdetails SET name=?, city=? WHERE id=?";

		int rs = this.jdbcTemplate.update(query ,student.getName(), student.getCity() , student.getId());
		return rs;
	}
	
	
	@Override
	public int del(int id ) {
		String query = "Delete from studentdetails where id = ?";
		return this.jdbcTemplate.update(query,id);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Student getStudent(int StudentID) {
		String querty = "select * from studentdetails where id = ?";
		RowMapper<Student> RM = new RowMapperImple();
		Student student = this.jdbcTemplate.queryForObject(querty, RM , StudentID);
		return student;
	}
	@Override
	public List<Student> getListOfStudent() {
		String query = "select * from studentdetails";
		
		 List<Student> student = this.jdbcTemplate.query(query, new RowMapperImple() );
		return student;
		
	}


}

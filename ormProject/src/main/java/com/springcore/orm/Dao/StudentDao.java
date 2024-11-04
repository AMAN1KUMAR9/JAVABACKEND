package com.springcore.orm.Dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springcore.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert (Student student) {
		
		int i = (Integer)this.hibernateTemplate.save(student);
		return i ;
	}
	
	public Student getStudent(int id) {
		return this.hibernateTemplate.get(Student.class, id);
		
	}
	
	public List <Student> getAllStudent() {
		return this.hibernateTemplate.loadAll(Student.class);
		
	}
	@Transactional
	public void  update(Student student) {
		this.hibernateTemplate.update(student);
	}
	@Transactional
	public void  delete(int id) {
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Student.class, id));
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	

}

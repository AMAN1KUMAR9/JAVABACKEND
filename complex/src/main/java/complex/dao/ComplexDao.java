package complex.dao;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import complex.model.Complex;




@Repository
public class ComplexDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional
	public Long insert(Complex complex) {
	    Long id = (Long) this.hibernateTemplate.save(complex);
	    return id;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}

package CRUD.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import CRUD.model.ProductModel;

@Repository
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate ;
	@Transactional
	public void insert (ProductModel model) {
		this.hibernateTemplate.saveOrUpdate(model);
	}
	
	
	public ProductModel getProduct(int id) {
		return this.hibernateTemplate.get(ProductModel.class, id);
	}
	
	public List<ProductModel> getAllProduct() {
		return this.hibernateTemplate.loadAll(ProductModel.class);
	}
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Transactional
	public void delete(int id) {
		this.hibernateTemplate.delete(this.hibernateTemplate.load(ProductModel.class, id));
	}
}

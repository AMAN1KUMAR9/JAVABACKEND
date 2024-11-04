package CRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CRUD.dao.ProductDao;
import CRUD.model.ProductModel;
@Service
public class ProductServices {
	
	@Autowired
	private ProductDao dao;
	
	
	public void productInsert(ProductModel PM) {
		dao.insert(PM);
	}
	public void productUpdate(int id) {
		
		dao.insert(dao.getProduct(id));
	}
	public void productDelete(int id) {
		dao.delete(id);
	}
	public ProductModel productGet(int id) {
		return dao.getProduct(id);
	}
	public List<ProductModel> productGetAll() {
		return dao.getAllProduct();
	}
	public ProductDao getDao() {
		return dao;
	}
	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

}

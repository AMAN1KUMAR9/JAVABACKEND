package springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;

import springmvc.dao.Dao;
import springmvc.model.User;

@org.springframework.stereotype.Service
public class UserService {
	
	@Autowired
	private Dao dao;
	public int insertUser (User user) {
		return (Integer)this.dao.insert(user);
	}
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}



}

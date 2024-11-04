package complex.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import complex.dao.ComplexDao;
import complex.model.Complex;



@Service
public class ComplexServices {
	@Autowired
	private ComplexDao comdao;
	public Long insertUser (Complex complex) {
		return (Long)this.comdao.insert(complex);
	}
	public ComplexDao getDao() {
		return comdao;
	}
	public void setDao(ComplexDao dao) {
		this.comdao = dao;
	}

}

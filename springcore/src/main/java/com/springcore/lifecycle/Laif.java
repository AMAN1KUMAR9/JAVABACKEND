

package com.springcore.lifecycle;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Laif  implements InitializingBean , DisposableBean{
	
	private String Name;
	private String Address;
	
	public Laif(String name, String address) {
		super();
		Name = name;
		Address = address;
	}

	public Laif() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "lifecycle [Name=" + Name + ", Address=" + Address + "]";
	}
	
	public void afterPropertiesSet ()throws Exception {
		System.out.println("init interface");
	}
	
	
	public void destroy() throws Exception {
		System.out.println("destroy interface");
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
//

//	
	

}


package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotLifecycle {
	private String Name;
	private String Address;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public AnnotLifecycle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "AnnotLifecycle [Name=" + Name + ", Address=" + Address + "]";
	}
	public AnnotLifecycle(String name, String address) {
		super();
		Name = name;
		Address = address;
	}
	@PostConstruct
	public void init() {
		System.out.println("init Annot");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy Annot");
	}

}

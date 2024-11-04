package com.springcore.lifecycle;

public class Lifecycle {
	
	private String Name;
	private String Address;
	
	public Lifecycle(String name, String address) {
		super();
		Name = name;
		Address = address;
	}

	public Lifecycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "lifecycle [Name=" + Name + ", Address=" + Address + "]";
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destroy");
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
	
	

}

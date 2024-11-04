package com.springcore.springcore;

public class Student {
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int Id;
	private String Name;
	private String Address;
	
	public Student(int id, String name, String address) {
		super();
		Id = id;
		Name = name;
		Address = address;
	}
	public int getId() {
	
		return Id;
	}
	public void setId(int id) {
		System.out.println("id");
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		System.out.println("name");
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		System.out.println("address");
		Address = address;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", Address=" + Address + "]";
	}
}

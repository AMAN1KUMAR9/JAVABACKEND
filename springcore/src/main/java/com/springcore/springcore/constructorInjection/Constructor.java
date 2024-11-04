package com.springcore.springcore.constructorInjection;

public class Constructor {
	private int no1;
	private int no2;
	public Constructor(int no1, int no2) {
		super();
		System.out.println("integer");
		this.no1 = no1;
		this.no2 = no2;
	}
	public Constructor(String no1, String no2) {
		super();
		System.out.println("string");
		this.no1 = Integer.parseInt(no1);
		this.no2 = Integer.parseInt(no2);
	}
	public Constructor(double no1, double no2) {
		
		super();
		System.out.println("double");
		this.no1 = (int)no1;
		this.no2 = (int)no2;
	}
	
	public int addition() {
		return this.no1 + this.no2;
	}
	public Constructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Constructor [no1=" + no1 + ", no2=" + no2 + "]";
	}

	
}

package com.springcore.springcore.ref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Reef {

	
	@Autowired
//	@Qualifier("ref2")
	private Ref ref2;


	public Ref getRef2() {
		return ref2;
	}
	public void setRef2(Ref ref2) {
		System.out.println("setting vals");
		this.ref2 = ref2;
	}
	@Override
	public String toString() {
		return "Reef [ ref2=" + ref2 + "]";
	}
	
	public Reef( Ref ref2) {
		super();
		System.out.println("con vals");
		this.ref2 = ref2;
	}
	public Reef() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

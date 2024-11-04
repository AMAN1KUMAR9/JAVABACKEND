package com.springcore.springcore.compoClass;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("com")
public class Compo {
	@Value("#{T(java.lang.Math).sqrt(34)}")
	private Double X;
	@Value("#{ new String('heeeyy')}")
	private String Y;
	@Value("#{hi}")
	private List<Integer> list;
	
	
	@Value("#{mp}")
	private Map mp;
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Compo [X=" + X + ", Y=" + Y + ", list=" + list + ", mp=" + mp + "]";
	}

	public Double getX() {
		return X;
	}
	public void setX(Double x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}

	
	
	

}

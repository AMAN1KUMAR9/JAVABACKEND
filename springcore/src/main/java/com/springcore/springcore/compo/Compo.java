package com.springcore.springcore.compo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("compo")
public class Compo {
	@Value("#{T(java.lang.Math).sqrt(34)}")
	private Double X;
	@Value("#{ new String('heeeyy')}")
	private String Y;
	@Value("#{ls}")
	private List<Integer> list;
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Compo [X=" + X + ", Y=" + Y + ", list=" + list + "]";
	}
	public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public String getY() {
		return Y;
	}
	public void setY(String y) {
		Y = y;
	}

	
	
	

}

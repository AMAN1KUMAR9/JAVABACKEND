package com.springcore.springcore.ref;

public class Ref {
public Ref(String y) {
		super();
		Y = y;
	}

private String Y;

@Override
public String toString() {
	return "Ref [Y=" + Y + "]";
}

public String getY() {
	return Y;
}

public void setY(String y) {
	Y = y;
}

public Ref() {
	super();
	// TODO Auto-generated constructor stub
}
}

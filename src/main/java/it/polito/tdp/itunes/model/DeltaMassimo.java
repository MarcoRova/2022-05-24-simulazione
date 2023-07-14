package it.polito.tdp.itunes.model;

public class DeltaMassimo {
	
	String t1;
	String t2;
	double delta;
	public DeltaMassimo(String t1, String t2, double delta) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.delta = delta;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public double getDelta() {
		return delta;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	

}

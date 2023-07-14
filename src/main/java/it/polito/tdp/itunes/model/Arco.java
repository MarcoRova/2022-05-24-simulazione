package it.polito.tdp.itunes.model;

public class Arco {
	
	private int t1;
	private int t2;
	private double delta;
	
	public Arco(int t1, int t2, double delta) {
		super();
		this.t1 = t1;
		this.t2 = t2;
		this.delta = delta;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public int getT2() {
		return t2;
	}

	public void setT2(int t2) {
		this.t2 = t2;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	
	
	

}

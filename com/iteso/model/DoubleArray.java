package com.iteso.model;

public class DoubleArray {

	private int      id;
	private double[] array;
	
	public DoubleArray(int id, int length) {
		this.id = id;
		if(length < 1) length = 1;
		this.array = new double[length];
		System.out.println("Se creó " + id);
	}
	
	protected void finalize() {
		System.out.println("Se eliminó " + id);
	}
	
}

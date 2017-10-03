package com.iteso.model;

public class ColorOutOfBoundsException extends RuntimeException {
	
	private int colorValue;
	
	public ColorOutOfBoundsException(int cv) {
		this.colorValue = cv;
	}
	
	public String toString() {
		return super.toString() + 
			   "\nColor out of bounds: " + this.colorValue; 
	}
	
}

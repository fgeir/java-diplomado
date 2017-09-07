package com.iteso.model;

public class Buffer {
	
	private Object objectInBuffer = null;
	
	public Object peek() {
		return this.objectInBuffer;
	}
	
	public void store(Object obj) {
		if(this.objectInBuffer == null)
			this.objectInBuffer = obj;
	}
	
	public Object extract() {
		Object tmp = this.objectInBuffer;
		this.objectInBuffer = null;
		return tmp;
	}
	
}

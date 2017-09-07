package com.iteso.model;

public class GBuffer<Type> {

	private Type objectInBuffer = null;
	
	public String toString() {
		if(this.objectInBuffer == null) return "Cajón vacío";
		return "Cajón de: " + this.objectInBuffer;
	}
	
	public Type peek() {
		return this.objectInBuffer;
	}
	
	public void store(Type obj) {
		if(this.objectInBuffer == null)
			this.objectInBuffer = obj;
	}
	
	public Type extract() {
		Type tmp = this.objectInBuffer;
		this.objectInBuffer = null;
		return tmp;
	}

}

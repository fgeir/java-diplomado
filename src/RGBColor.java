package com.iteso.model;

public class RGBColor {

	private int red     = 127;
	private int green   = 127;
	private int blue    = 127;
	private String name = "Gris";

	public RGBColor() {
	}
	
	public RGBColor(int red, int green, int blue) 
	  throws ColorOutOfBoundsException {
		setRed(red);
		setGreen(green);
		setBlue(blue);	
	}
	
	public RGBColor(int red, int green, int blue, String name) 
	  throws ColorOutOfBoundsException {
		this(red, green, blue);  // Llama al constructor anterior
		setName(name);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) throws ColorOutOfBoundsException {
		if(red >= 0 && red <= 255) this.red = red;
		else throw new ColorOutOfBoundsException(red);
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) throws ColorOutOfBoundsException {
		if(green < 0 || green > 255) throw new ColorOutOfBoundsException(green);
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) throws ColorOutOfBoundsException {
		if(blue < 0 || blue > 255) throw new ColorOutOfBoundsException(blue);
		this.blue = blue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null) this.name = name;
	}
	
	public int getCyan() {
		return 255 - this.red;
	}
	
	public int getMagenta() {
		return 255 - this.green;
	}
	
	public int getYellow() {
		return 255 - this.blue;
	}
	
	public int getRGB() {
		return this.blue + (this.green << 8) + (this.red << 16);
	}
	
	public String toString() {
		return String.format("{red: %d, green: %d, blue: %d, name: '%s'}", 
				              this.red, this.green, this.blue, this.name);
	}
	
	public boolean equals(Object o) {
		if(o instanceof RGBColor) {
			RGBColor c = (RGBColor) o;
			return c.blue  == this.blue  && c.red == this.red && 
				   c.green == this.green && c.name.equals(this.name);
		}
		return false;
	}
	
	public RGBColor clone() {
		RGBColor c = null;
		try {
			c = new RGBColor(this.red, this.green, this.blue, this.name);
		} catch (ColorOutOfBoundsException e) {}
		return c;
	}
	
}







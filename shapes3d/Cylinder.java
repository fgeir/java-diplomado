package shapes3d;

public class Cylinder extends Shape3D {

	private double radius = 1, height = 1;
	
	public Cylinder(double x, double y, double z, double radius, double height) {
		super(x, y, z);
		if(radius > 0) this.radius = radius;
		if(height > 0) this.height = height;
	}

	public double getRadius() {
		return this.radius;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void resize(double dr, double dh) {
		if(this.radius + dr > 0) this.radius += dr;
		if(this.height + dh > 0) this.height += dh;
	}
	
	@Override
	public double area() {
		return 2 * Math.PI * this.radius * this.radius + 
			   2 * Math.PI * this.radius * this.height;
	}

	@Override
	public double volume() {
		return this.height * Math.PI * this.radius * this.radius;
	}

	@Override
	public String toString() {
		String format = "CILINDRO\n Radio de la base: %.1f\n Altura: %.1f\n %s";
		return String.format(format, this.radius, this.height, super.toString());
	}
	
}

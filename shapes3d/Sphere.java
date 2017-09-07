package shapes3d;

public class Sphere extends Shape3D {

	private double radius = 1;
	
	public Sphere(double x, double y, double z, double radius) {
		super(x, y, z);
		if(radius > 0) this.radius = radius; 
	}

	public double getRadius() {
		return this.radius;
	}
	
	public void resize(double dr) {
		if(this.radius + dr > 0) this.radius += dr; 
	}
	
	@Override
	public double area() {
		return 4 * Math.PI * this.radius * this.radius;
	}

	@Override
	public double volume() {
		return 4.0 / 3 * Math.PI * Math.pow(this.radius, 3);
	}

	@Override
	public String toString() {
		String format = "ESFERA\n Radio: %.1f\n %s";
		return String.format(format, this.radius, super.toString());
	}

}

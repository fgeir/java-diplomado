package shapes3d;

public abstract class Shape3D {

	protected double x, y, z;
	
	public Shape3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
	
	public void move(double dx, double dy, double dz) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	
	public String toString() {
		String format = "Coordenadas: <%.1f, %.1f, %.1f>\n Area = %.2f\n Volumen = %.2f";
		return String.format(format, this.x, this.y, this.z, area(), volume());
	}
	
	public abstract double area();
	
	public abstract double volume();

}

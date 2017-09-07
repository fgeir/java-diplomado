package shapes2d;

public class Rectangle {
	
	private double base   = 1;
	private double height = 1;
	
	public Rectangle() {
//		setBase(1);
//		setHeight(1);
	}
	
	public Rectangle(double base, double height) {
		setBase(base);
		setHeight(height);
	}
	
	public Rectangle(double base) {
		setBase(base);
	}
	
//	Error al añadir este constructor porque ya existe otro que recibe un double
//	Sobrecarga de constructores: la lista de argumentos debe ser diferente 
//	public Rectangle(double height) {
//		setHeight(height);
//	}
	
	public void setBase(double base) {
		if(base >= 1 && base <= 100) this.base = base;
	}
	
	public double getBase() {
		return this.base;
	}
	
	public double getHeight() {
		return this.height;
	}

	public void setHeight(double height) {
		if(height >= 1 && height <= 100) this.height = height;
	}

	public double area() {
		double area = this.base * this.height;
		return area;
	}
	
	public double perimeter() {
		return 2 * (this.base + this.height);
	}
	
	public void print() {
		System.out.printf("[base: %.2f, height: %.2f, area: %.2f, perimeter = %.2f]\n",
			                this.base, this.height, area(), perimeter());
	}
	
	@Override
//	Esta anotación produce un error de sintaxis si no se sobrescribe el método correctamente
	public String toString() {
		return String.format("{base: %.1f, height: %.1f}", this.base, this.height);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle r = (Rectangle) o; 
			return this.base   == r.getBase() &&
				   this.height == r.getHeight();
		}
		if(o instanceof Vec2) {
			Vec2 v = (Vec2) o;
			return this.base   == v.getX() &&
				   this.height == v.getY();			
		}
		return false;
	}
	
	public Rectangle clone() {
		return new Rectangle(this.base, this.height);
	}
	
	protected void finalize() {
		System.out.println("Se destruye: " + this);
	}
	
}

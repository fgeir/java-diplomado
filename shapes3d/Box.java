package shapes3d;

public class Box extends Shape3D {

	private double width = 1, height = 1, depth = 1;
	
	public Box(double x, double y, double z, double width, double height, double depth) {
		super(x, y, z);
		if(width  > 0) this.width  = width;
		if(height > 0) this.height = height;
		if(depth  > 0) this.depth  = depth;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double getDepth() {
		return this.depth;
	}
	
	public void resize(double dw, double dh, double dd) {
		if(this.width  + dw > 0) this.width  += dw;
		if(this.height + dh > 0) this.height += dh;
		if(this.depth  + dd > 0) this.depth  += dd;
	}

	@Override
	public double area() {
		return 2 * (width * height + width * depth + height * depth);
	}

	@Override
	public double volume() {
		return width * height * depth;
	}

	@Override
	public String toString() {
		String format = "CAJA\n Anchura: %.1f\n Altura: %.1f\n Grosor: %.1f\n %s";
		return String.format(format, this.width, this.height, this.depth, super.toString());
	}
	
}

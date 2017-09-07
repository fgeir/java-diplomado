package shapes2d;

public class Vec2 {

	private double x, y;
	private static int instances = 0;

	public Vec2() {
		this.x = 0;
		this.y = 0;
		instances ++;
//		this.instances ++;
//		Vec2.instances ++;
	}
	
	public Vec2(double x, double y) {
		setX(x);
		setY(y);
		instances ++;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public static int getInstances() {
		return Vec2.instances;
	}
	
	public static void main(String[] args) {
//		setY(1.5);
		System.out.println(getInstances());
	}
}

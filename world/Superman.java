package world;

public class Superman extends Man implements Flyable {

	private double height = 0;
	private int    power  = 20;
	
	@Override
	public void rise() {
		this.height = MAX_HEIGHT;
		System.out.println("Supermán elevándose");
	}

	@Override
	public void descend() {
		this.height = 0;
		System.out.println("Supermán descendiendo");
	}

	@Override
	public double getHeight() {
		return this.height;
	}
	
	public void runFast() {
		super.status = 5;
		System.out.println("Superman corriendo rápido");
	}
	
	public void losePower(double krypto) {
		super.status = 6;
		this.power -= krypto;
		System.out.println("¡Superman perdiendo poder! Le queda: " + this.power);
	}
	
}

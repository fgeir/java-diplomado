package world;

public class Vehicle {
	
	protected double fuel  = 0;
	protected double speed = 0;
	
	public void speedUp() {
		this.speed ++;
		System.out.println("Vehículo acelerando");
	}
	
	public void slowDown() {
		this.speed --;
		System.out.println("Vehículo frenando");
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void loadFuel(double f) {
		this.fuel += f;
		System.out.println("Vehículo cargando combustible");
	}
	
}

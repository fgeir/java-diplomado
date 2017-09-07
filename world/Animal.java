package world;

public abstract class Animal {

	protected int status = 0;
	
	public void sleep() {
		this.status = 1;
		System.out.println("Animal durmiendo");
	}
	
	public void die() {
		this.status = 2;
		System.out.println("Animal muerto");		
	}
	
	public abstract void move();
	
}

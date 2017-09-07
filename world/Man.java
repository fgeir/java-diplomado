package world;

public class Man extends Animal {

	public void think() {
		super.status = 4;
		System.out.println("Hombre pensando");
	}
	
	@Override
	public void move() {
		super.status = 3;
		System.out.println("Hombre caminando");
	}

}

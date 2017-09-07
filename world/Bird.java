package world;

public class Bird extends Animal implements Flyable {

	private double height = 0;

	public void rise() {
		if(this.height < MAX_HEIGHT) {
			this.height ++;
			System.out.println("Ave subiendo");
		}
	}

	public void descend() {
		if(this.height > 0) {
			this.height --;
			System.out.println("Ave bajando");
		}
	}

	public double getHeight() {
		return this.height;
	}

	public void move() {
		super.status = 3;
		System.out.println("Ave volando");
	}

}

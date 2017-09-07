package world;

public class Jet extends Vehicle implements Flyable {

	private double height = 0;
	
	@Override
	public void rise() {
		if(this.height <= MAX_HEIGHT - 10) {
			this.height += 10;
			System.out.println("Avión elevándose");
		}
	}

	@Override
	public void descend() {
		if(this.height >= 10) {
			this.height -= 10;
			System.out.println("Avión descendiendo");
		}
	}

	@Override
	public double getHeight() {
		return this.height;
	}

}

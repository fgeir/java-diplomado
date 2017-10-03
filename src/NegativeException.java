
public class NegativeException extends Exception {
	
	private double negativeValue;
	
	public NegativeException(double nv) {
		this.negativeValue = nv;
	}
	
	public String toString() {
		return super.toString() + 
			   "\nNegative value found: " + this.negativeValue; 
	}
	
}


public class Utils {

//	Método que lanza una excepción
	public static double squareRoot(double d) throws NegativeException {
		if(d < 0) throw new NegativeException(d);
		return Math.sqrt(d);
	}
	
//	Método que propaga una excepción recibida (no la maneja)
	public static double chicharronero(double a, double b, double c) 
	                                        throws NegativeException {
		assert b * b - 4 * a * c >= 0;
		return (-b + squareRoot(b * b - 4 * a * c)) / (2 * a);
	}
	
	public static double magnitude(double x, double y) {
		double m = 0;
		try {
			m = squareRoot(x * x + y * y);
		} catch(NegativeException exc) {}
		return m;
	}
	
	public static void main(String[] args) { //throws NegativeException {
		double m = magnitude(-0.01, 0.1);
		System.out.println(m);
		
//		double sr = squareRoot(4.5);
//		System.out.println(sr);
//		double x  = chicharronero(5, 4, 2);
//		System.out.println(x);
		
		try {
			double x  = chicharronero(1, 4, 2);
			System.out.println(x);
		} catch (NegativeException e) {
			System.out.println("No tiene solución");
//			e.printStackTrace();
		}
		
		System.out.println("Seguimos en el método main");		
		
	}

}

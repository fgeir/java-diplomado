
import com.iteso.model.DoubleArray;
import com.iteso.model.RGBColor;

import shapes2d.Rectangle;
import shapes2d.Vec2;

public class Sesion5 {

	public static void toUnit(double x, double y) {
		double m = Math.sqrt(x * x + y * y);
		x /= m;
		y /= m;
	}
	
//	Sobrecarga del método toUnit
	public static void toUnit(Vec2 v) {
		double m = Math.sqrt(v.getX() * v.getX() + 
				             v.getY() * v.getY());
		v.setX((v.getX() / m));
		v.setY((v.getY() / m));
	}

//	Sobrecarga del método toUnit
	public static void toUnit(double[] vec2) {
		double m = Math.sqrt(vec2[0] * vec2[0] + vec2[1] * vec2[1]);
		vec2[0] /= m;
		vec2[1] /= m;
	}
	
//	Deja intacto al objeto original, por usar el operador igual
//	El esquema correcto debió devolver al Vec2 creado  
	public static void create(Vec2 v) {
		v = new Vec2();  // v --> <0.0, 0.0> 
	}
	
	public static void main(String[] args) {
		double x = 3, y = 4;
		toUnit(x, y);  // pase por valor
		System.out.printf("<%.2f, %.2f>\n", x, y);
		
		Vec2 v1 = new Vec2(x, y);
		toUnit(v1);     // pase por referencia
		System.out.printf("<%.2f, %.2f>\n", v1.getX(), v1.getY());
		
		double[] arr = {x, y};
		toUnit(arr);   // pase por referencia
		System.out.printf("<%.2f, %.2f>\n", arr[0], arr[1]);
		
		Vec2 v2 = null;
		create(v1);
		create(v2);
		System.out.println("-----------------");
		System.out.printf("<%.2f, %.2f>\n", v1.getX(), v1.getY()); // imprime: <0.6, 0.8>
//		System.out.printf("<%.2f, %.2f>\n", v2.getX(), v2.getY()); // Excepción
		System.out.println(v1);
		System.out.println(v2);
		
		Rectangle r1 = new Rectangle(4.6, 9.56);
		System.out.println(r1);  // Llamada implícita a toString()
//		JOptionPane.showMessageDialog(null, r1); // Llamada implícita a toString()
		
		Vec2 v3 = new Vec2(4.6, 9.56); 
		Rectangle r2 = new Rectangle(4.6, 9.56);
		System.out.println(r1.equals(r2));      // true  : equals de Rectangle
		System.out.println(r1.equals(v3));      // true  : equals de Rectangle
		System.out.println(r1.equals("hola"));  // false : equals de Rectangle
		System.out.println(r1.equals(null));	// false : equals de Rectangle 
		
		System.out.println(r2.equals(r1));      // true  : equals de Rectangle
		System.out.println(v3.equals(r1));      // false : equals de Object porque Vec2 no tiene
		System.out.println("hola".equals(r1));  // false : equals de String
		
		r2 = new Rectangle(8.6, 6.5);  // Pérdida del alcance del objeto: <4.6, 9.56>
		r2 = null;                     // Pérdida del alcance del objeto: <8.6, 6.5>
		System.gc();				   // Llama al recolector de basura, el cual eliminará de
									   // memoria a los objetos fuera del alcance. Previamente
									   // invocará al método destructor: finalize()
		
		Rectangle r3 = r1.clone();
//		r3.setBase(6);
		System.out.println(r1);
		System.out.println(r3);
		System.out.println(r1 == r3);       // false 
		System.out.println(r1.equals(r3));  // true
		
		Rectangle r4 = r1;
		System.out.println(r1 == r4);       // true
		System.out.println(r1.equals(r4));  // true		

//		double[] bigArray = null;
//		for(int i = 0; i < 10_000; i ++) {
//			bigArray = new double[10_000_000];
//			bigArray[0] = Math.random();
//			System.out.println(i);
//		}
//		System.out.println(bigArray[0]);
		
		RGBColor pink   = new RGBColor(255, 175, 200, "Rosa");
		System.out.println(pink);
		RGBColor orange = new RGBColor(255, 180,  50, "Naranja");
		System.out.println(pink.equals(orange));
		RGBColor rosa   = pink.clone();
		System.out.println(pink.equals(rosa));
		
		
		DoubleArray da = null;
		for(int i = 1; i <= 1000; i ++) {
			da = new DoubleArray(i, 10_000_000);
//			Después de 35 arreglos creados, se efectuó la primera eliminación
//			Sin embargo, no se eliminó al primer arreglo creado
//			En ese momento, se ocupaban 2.6 GB de memoria RAM
//			No hubo necesidad de llamar al GC porque llegamos al límite de espacio disponible
		}
		
		for(int i = 1; i <= 1000; i ++) {
			da = new DoubleArray(i, 10_000_000);
			System.gc();
//			Se crea el arreglo i, se elimina el arreglo i - 1
		}
	}

}

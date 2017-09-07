package tests;

import shapes3d.Box;
import shapes3d.Cylinder;
import shapes3d.Shape3D;
import shapes3d.Sphere;

public class TestShape3D {

	public static void main(String[] args) {
		Sphere   s1 = new Sphere  ( 1,  2, -1, 5.3);
		Cylinder c2 = new Cylinder( 0,  4,  2, 3.5, 15.7);
		Box      b3 = new Box     (-2, -3,  3, 6.2,  3.6, 5.8); 
		Sphere   s4 = new Sphere  ( 0,  0,  0, 1.0);
		Box      b5 = new Box     ( 4, -1,  2, 2.0,  2.0, 2.0);
		
		Shape3D[] shapes = { s1, c2, b3, s4, b5 };
		double sum = 0;
		for(Shape3D sh : shapes) {
//			Invoca toString() de la clase a la que pertenece el objeto apuntado por sh
//			Las figuras 3D concretas no necesariamente tienen un toString()
			System.out.println(sh); 
			System.out.println("--------------");
			
//			Invoca volume() de la clase a la que pertenece el objeto apuntado por sh
//			Toda figura 3D concreta debe tener un método volume()
			sum += sh.volume();
			
//			Busca el método move() en la clase a la que pertenece el objeto apuntado por sh
//			Sin embargo, no lo va a encontrar en dicha clase
//			Entonces busca el método move() en la superclase (Shape3D) y ahí si lo encuentra
			sh.move(1, 0, 0);
			
			if(sh instanceof Sphere) {
				Sphere sphere = (Sphere) sh;
				sphere.resize(1);
				System.out.println("Se redimensionó una esfera a: " + sphere.getRadius());
			}
		}
		System.out.printf("Volumen total: %.1f\n", sum);
	}

}

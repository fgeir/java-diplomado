package world;

import com.iteso.model.Date;

public class World {

	public static void flyToTop(Flyable f) {
		while(f.getHeight() < Flyable.MAX_HEIGHT) {
			f.rise();
		}
	}
	
//	f puede ser un avión, supermán o un ave: Polimorfismo
	public static void land(Flyable f) {
		while(f.getHeight() > 0) {
			f.descend();
		}
	}
	
//	v puede ser un vehículo o un avión
	public static void reachSpeed(Vehicle v, double sp) {
		while(v.getSpeed() < sp) {
			v.speedUp();
		}
	}
	
	public static void stop(Vehicle v) {
		while(v.getSpeed() > 0) {
			v.slowDown();
		}
	}
	
	public static void main(String[] args) {
		Bird     piolín = new Bird();
		Man      dilón  = new Man();
		Jet      boeing = new Jet();
		Vehicle  rayoMc = new Vehicle();
		Superman clark  = new Superman();
		
		piolín.move();
		dilón.move();
		clark.move();
		clark.runFast();
		rayoMc.speedUp();
		boeing.speedUp();
		
		flyToTop(piolín);
		land(piolín);
		flyToTop(boeing);
		land(boeing);
		flyToTop(clark);
		land(clark);
		
		reachSpeed(rayoMc, 5);
		stop(rayoMc);
		reachSpeed(boeing, 8);
		stop(boeing);
		
//		zancudo pertenece a una clase anónima que implementa a la interfaz Flyer
//		Para tal clase se creó el archivo World$1.class
		Flyable zancudo = new Flyable() {
			private double altura = 1;
//			Constructor de una clase anónima
			{
				System.out.println("Listo para ch.. gente un día más");
			}			
			public void rise() {
				this.altura += 0.2;
				System.out.println("Zancudo ch.. gente y subiendo");
			}
			public void descend() {
				this.altura -= 0.2;
				System.out.println("Zancudo ch.. gente y bajando");
				if(this.altura <= 0) kill();
			}
			public double getHeight() {
				return this.altura;
			}
//			Método que no puede ser invocado desde un objeto por no ser parte de Flyable
//			Añadir otro método tiene aplicación si es invocado desde alguno de los 3 de Flyable
//			No tiene sentido que kill() fuera público
			private void kill() {
				System.out.println("Matando al zancudo");
			}
		};
		
		zancudo.rise();
		System.out.println(zancudo.getHeight());
		land(zancudo);		
		
		Animal snoopy = new Animal() {
			public void move() {
				System.out.println("Perrito moviendo la colita");
			}
			public void sleep() {
				super.sleep();
				System.out.println("Ladrando por pesadillas");
			}
		};
		snoopy.move();
		snoopy.sleep();
		
		Date fecha = new Date(25, 2, 2017) {
//			super refiere a Date porque esta clase anónima es subclase de Date
			public String toString() {
				super.setFormat(2);
				return "[" + super.toString() + "]";
			}
		};
		System.out.println(fecha);
		
		
	}

}

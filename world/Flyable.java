package world;

public interface Flyable {

//	Los atributos son public static final
	double MAX_HEIGHT = 100;
	
//	Los métodos son public abstract
	void   rise();
	void   descend();
	double getHeight();
	
}


public class Carta {

	private int    numero;
	private Figura figura;
	
	public Carta(int n, Figura f) {
		this.numero = n;
		this.figura = f;
	}
	
	public String toString() {
		return this.numero + " de " + this.figura;
	}
	
	public static void main(String[] args) {
//		Se crean 3 cartas y 4 figuras
//		Las figuras se crearon en el primer uso de Figura: Figura.CORAZON
		Carta c1 = new Carta(8, Figura.CORAZON);
		System.out.println(c1);
		Figura diamante = Figura.DIAMANTE;
		Carta c2 = new Carta(5, diamante);
		Carta c3 = new Carta(9, diamante);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(diamante);
		
		System.out.println(diamante.carta("As"));
		System.out.println(Figura.TREBOL.carta("Rey"));
		
	}
	
	

}

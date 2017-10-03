
public enum Figura { 
	CORAZON ("Coraz�n"),   // llamada al constructor
	DIAMANTE("Diamante"), 
	ESPADA  ("Espada"), 
	TREBOL  ("Tr�bol");
	
	private final String nombreFigura;
	
	private Figura(String nf) {
		this.nombreFigura = nf;
	}
	
	public String toString() {
		return this.nombreFigura;
	}
	
	public String carta(String n) {
		return n + " de " + this.nombreFigura;
	}
	
}


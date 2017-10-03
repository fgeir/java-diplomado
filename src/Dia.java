
public enum Dia {

	LUNES     ("Lunes",     "Lundi",    "Monday"),
	MARTES    ("Martes",    "Mardi",    "Tuesday"),
	MIERCOLES ("Miércoles", "Mercredi", "Wednesday"),
	JUEVES    ("Jueves",    "Jeudi",    "Thursday"),
	VIERNES   ("Viernes",   "Vendredi", "Friday"),
	SABADO    ("Sábado",    "Samedi",   "Saturday"),
	DOMINGO   ("Domingo",   "Dimanche", "Sunday");
	
	private final String díaEspañol;
	private final String díaFrancés;
	private final String díaInglés;
	private Idioma idioma = Idioma.ESPAÑOL;
	
	private Dia(String de, String df, String di) {
		díaEspañol = de;
		díaFrancés = df;
		díaInglés  = di;
	}
	
	public void cambiarIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public String toString() {
//		La sentencia switch admite enumeraciones
		switch(this.idioma) {
			case ESPAÑOL : return this.díaEspañol;
			case FRANCES : return this.díaFrancés;
			default      : return this.díaInglés;
		}
	}
	
}

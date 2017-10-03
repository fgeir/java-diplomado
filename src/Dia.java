
public enum Dia {

	LUNES     ("Lunes",     "Lundi",    "Monday"),
	MARTES    ("Martes",    "Mardi",    "Tuesday"),
	MIERCOLES ("Mi�rcoles", "Mercredi", "Wednesday"),
	JUEVES    ("Jueves",    "Jeudi",    "Thursday"),
	VIERNES   ("Viernes",   "Vendredi", "Friday"),
	SABADO    ("S�bado",    "Samedi",   "Saturday"),
	DOMINGO   ("Domingo",   "Dimanche", "Sunday");
	
	private final String d�aEspa�ol;
	private final String d�aFranc�s;
	private final String d�aIngl�s;
	private Idioma idioma = Idioma.ESPA�OL;
	
	private Dia(String de, String df, String di) {
		d�aEspa�ol = de;
		d�aFranc�s = df;
		d�aIngl�s  = di;
	}
	
	public void cambiarIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public String toString() {
//		La sentencia switch admite enumeraciones
		switch(this.idioma) {
			case ESPA�OL : return this.d�aEspa�ol;
			case FRANCES : return this.d�aFranc�s;
			default      : return this.d�aIngl�s;
		}
	}
	
}

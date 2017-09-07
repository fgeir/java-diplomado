import java.util.Arrays;

/** Este es mi primer programa en Java 
 *  Soy feliz porque pude saludar al mundo con Java
 * @author Hugo Iván Piza Dávila
 * @version 1.0
 */

// Ctrl + s/S        --> Guardar todo (y compilar)
// Ctrl + Shift + 7  --> Comentar línea
// Sysout Ctrl Space --> System.out.println

public class Sesion1 {

	/** Este método es invocado automáticamente al ejecutar una clase en Java.
	 * @param args Lista de argumentos separados por espacio incluidos en la ejecución del programa
	 * @return No devuelve nada porque la aplicación acaba al terminar este método
	 */
	
	public static void main(String[] args) {
/*		Para enviar argumentos a main:
 * 		Menú + Run + Run Configurations + Arguments + Program Arguments
 */
		int x = /* holaa! */ 3;
		
		System.out.println("Hola mundo");
		System.out.println("Adiós mundo");
//		Imprimir el contenido del primer elemento de args
		System.out.println(args[0]);
//		Imprimir el número de elementos de args
		System.out.println(args.length);
//		Imprimir todos los elementos del arreglo
		System.out.println(Arrays.toString(args));
		System.out.println(args);
		
// 		L --> usar 64 bits para almacenar un dato
		long l = 3_000_000_000L;  
		
//		primitivo --> Wrapper
//		int       --> Integer
//		short     --> Short
// 		Imprimir máximo valor asignable a un int: 2,147'483,647
		System.out.println(Integer.MAX_VALUE); 
		
//		      32bits <-- 64bits (no cabe)
//		float estatura = 1.75;
		
//		      32bits <-- 32bits (sí cabe)
		float estatura = 1.75f;
		
		boolean yaCasiAcabamos = false;
		boolean aguantan_mas_tiempo = false;
		
		char enter = '\n';
		char arroba = 64;
		System.out.println(enter);
		System.out.println(arroba);
		char pi = 'π'; //960;
		System.out.println(pi);
		
		String s1 = " Hola ";
		char c3 = s1.charAt(3);  // c3 = 'l'
		System.out.println(c3);
		int len = s1.length();   // len = 6 
		System.out.println(len);
		String s2 = s1.toUpperCase();  // s2 = " HOLA "
		System.out.println(s2);
		String s3 = s1.trim();  // s3 = "Hola"
		System.out.println(s3);
		
		float   miEstatura      = 1.75f;
		char    teclaPresionada = 'k';
		boolean esAñoBisiesto   = false;
		String  rfcCliente      = "ABC280792Y6R";
		long    poblaciónChina  = 1_400_000_000;
		double  masaSaturno     = 6e26;
		byte    miEdad          = 39;
		int     dirección       = 0x3F_789A;
		
	}

}

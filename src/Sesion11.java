import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.iteso.model.Date;
import com.iteso.model.DateTime;

public class Sesion11 {

//	public static double average(int a, int b) {
//		return (a + b) / 2.0; 
//	}
//	
//	public static double average(int a, int b, int c) {
//		return (a + b + c) / 3.0; 
//	}
//	
//	public static double average(int[] numbers) {
//		int sum = 0;
//		for(int n : numbers) sum += n;
//		return (double) sum / numbers.length;		
//	}
	
	public static double average(int ... numbers) {
		if(numbers.length == 0) return 0.0;
		int sum = 0;
		for(int n : numbers) sum += n;
		return (double) sum / numbers.length;
	}
	
//	Error de sintaxis: el "varargs" tiene que ser el último argumento
//	¿Cómo sabrías dónde termina numbers1 y comienza numbers2?
//	public static int interseccion(int ... numbers1, int ... numbers2)
//	public static int frequency(int ... numbers, int key)	
	public static int frequency(int key, int ... numbers) {
		int count = 0;
		for(int n : numbers) if(n == key) count ++;
		return count;
	}
	
//	public static double greatest(Number ... numbers) {
//	admite también instancias de BigInteger, BigDecimal
	public static double greatest(double ... numbers) {
		if(numbers.length == 0) return Double.NaN;
		double g = numbers[0];
		for(double n : numbers) if(n > g) g = n;  
		return g;
	}
	
	public static void main(String[] args) {
		// d1 apunta al mismo lugar que Dia.MIERCOLES
		Dia d1 = Dia.MIERCOLES;  
		System.out.println(d1);  			// imprime Miércoles
		
		d1.cambiarIdioma(Idioma.FRANCES);
		System.out.println(d1);  			// imprime Mercredi
		System.out.println(Dia.MIERCOLES);  // imprime Mercredi
		
		Dia.MIERCOLES.cambiarIdioma(Idioma.INGLES);
		System.out.println(d1);  			// imprime Wednesday
	}
	
	public static void main1(String[] args) {
		HashMap<String, Integer> map1 = new HashMap<>();
		map1.put("Uno",  1);
		map1.put("Dos",  2);
		map1.put("Tres", 3);
//		Como ya existe la clave "Uno", reemplaza el valor
		map1.put("Uno",  4);  
		System.out.println(map1.size());
		int value = map1.get("Uno");
		System.out.println(value);
		value = map1.get("Dos");
		System.out.println(value);
		value = map1.get("Tres");
		System.out.println(value);
		
//		HashMap devuelve null si la clave no existe
		System.out.println(map1.get("Cuatro"));
//		unboxing: de Integer a int --> anInteger.intValue();
//		pero anInteger es null --> NullPointerException
//		value = map1.get("Cuatro");
//		System.out.println(value);
		
		Set<String> keys = map1.keySet();
//		keys pertenece a la clase HashMap$KeySet que implementa a Set
		System.out.println(keys.getClass());
		for(String k : keys) {
			int v = map1.get(k);
			System.out.println(k + ", " + v);
		}
		
		HashSet<Date> dateSet = new HashSet<Date>();
		dateSet.add(new Date());
		dateSet.add(new Date(16,  9, 2017));
		dateSet.add(new Date(15, 10, 2017));
		dateSet.add(new Date());
		dateSet.add(new Date(16,  9, 2017));
		System.out.println(dateSet.size());
		for(Date d : dateSet) System.out.println(d);
		
		System.out.println(new Date(16,  9, 2017).hashCode());
		System.out.println(new Date(16,  9, 2017).hashCode());
		System.out.println(new Date(15, 10, 2017).hashCode());
		
		System.out.println("-------------");
		LinkedList<Date> dates = new LinkedList<Date>();
		dates.add(new Date());
		dates.add(new Date(16,  9, 2017));
		dates.add(new Date(20, 11, 2015));
		dates.add(new Date( 7,  4, 2012));
//		<T> boolean addAll(Collection<? super T> c, T ... a)
		Collections.addAll(dates, new DateTime(), new DateTime(15, 6, 46, 27, 6, 2008)); 
		for(Date d : dates) System.out.println(d);
//		Error de sintaxis: T es String, Date no es super de String
//		Collections.addAll(dates, "Hoy", "Mañana");
		
//		Alternativa eficiente para recorrer un LinkedList, 
//		sin acceder a índices. Ahora el for-each lo resuelve
//		Iterator<Date> ite = dates.iterator();
		
		double g = greatest(1600, 1_200_450L, 6784.56f, 8.6e7);
		System.out.println(g);
		g = greatest();
		System.out.println(g);
		
		int f = frequency(3);   // 3, 5, 8, 3, 4, 8, 9, 8, 3 );
		System.out.println(f);
		
		double av = average(10, 9);
		System.out.println(av);
		av = average(10, 9, 7);
		System.out.println(av);
		int[] numbers = { 6, 10, 8, 9, 7, 10, 9, 6 };
		av = average(numbers);
		System.out.println(av);
		av = average(10);
		System.out.println(av);
		av = average(10, 9, 7, 6, 5);
		System.out.println(av);
		av = average();
		System.out.println(av);		

		
	}

}

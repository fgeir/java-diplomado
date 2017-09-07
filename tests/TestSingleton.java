package tests;

import java.util.Calendar;

import com.iteso.model.Date;
import com.iteso.model.Singleton;

public class TestSingleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); //new Singleton();
		Singleton s2 = Singleton.getInstance(); //new Singleton();
		System.out.println(s1 == s2);

		s1.setUsername("admin");
		s1.setPassword("hola123");
		System.out.println(s2.getUsername());
		System.out.println(s2.getPassword());
		
		Singleton.getInstance().setUsername("Admin");
		System.out.println(s1.getUsername());
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		System.out.println(c1 == c2);
		System.out.println(c1.get(Calendar.DAY_OF_MONTH));
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));
		System.out.println(c1.get(Calendar.HOUR));
		System.out.println(c1.get(Calendar.MINUTE));
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));  // Domingo = 1, Sábado = 7
		System.out.println(c1.get(Calendar.MONTH));  // Enero = 0, Diciembre = 11
//		¿En qué día de la semana nací?
		c2.set(Calendar.YEAR, 1977);
		c2.set(Calendar.MONTH, 6);
		c2.set(Calendar.DAY_OF_MONTH, 23);
		System.out.println(c2.get(Calendar.DAY_OF_WEEK));
		
//		Obtener cuántos años han sucedido desde la fecha de referencia: 1/1/1970
//		a una fecha específica
		long millis = c2.getTimeInMillis();
		System.out.println(millis);
		long seconds = millis / 1000;
		long hours   = seconds / 3600;
		long days    = hours / 24;
		long years   = days / 365;
		System.out.println(years);
		
		Date today = new Date();
		today.setFormat(2);
		System.out.println(today);
		
	}

}

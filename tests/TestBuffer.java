package tests;

import com.iteso.model.Buffer;
import com.iteso.model.Date;
import com.iteso.model.GBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		Buffer cajon1 = new Buffer();
		
		String str1   = "Hola";
		cajon1.store(str1);
//		No se añade date1 porque el cajón contiene a str1
		Date   date1  = new Date();
		cajon1.store(date1);
		
//		obj2 apunta en realidad a un String pero lo trata como Object
		Object obj2  = cajon1.peek();
		System.out.println(obj2);
		
//		str2 apunta al mismo String pero lo trata como un String
		String str2  = (String) cajon1.peek();
		System.out.println(str2.toUpperCase());
		
//		Excepción porque en el cajón había un String y
//		se quiso tratar como un Date (incompatibles): INSEGURIDAD DE TIPOS
//		Date   date2 = (Date) cajón1.peek();
//		date2.setFormat(2);
//		System.out.println(date2);
		
		GBuffer<String> cajon2 = new GBuffer<>();
		cajon2.store("hola mundo");
//		cajón2.store(date1);  ERROR DE SINTAXIS porque cajón2 admite sólo String
		String str3 = cajon2.extract();  // Seguridad de tipos, no necesita cast
		System.out.println(str3);
		String str4 = cajon2.peek();     // Seguridad de tipos, no necesita cast
		System.out.println(str4);		
		
		GBuffer<Date> cajon3 = new GBuffer<>();
		cajon3.store(date1);
//		cajón3.store("hola mundo");  ERROR DE SINTAXIS porque cajón3 admite sólo Date
		Date date2 = cajon3.peek();  // Seguridad de tipos, no necesita cast
		System.out.println(date2);
		
//		Java no permite un tipo primitivo: Buffer<int>, por eso existen los wrappers
		GBuffer<Integer> cajon4 = new GBuffer<>();
		cajon4.store(300);         // auto-boxing:    int --> Integer
		int i = cajon4.extract();  // auto-unboxing:  Integer --> int
		System.out.println(i);
		
//		GBuffer<Double> cajónDeNúmerosReales = new GBuffer<Double>();
//		cajónDeNúmerosReales.store(Math.PI);
//		GBuffer<GBuffer<Double>> cajónDeCajonesDeNúmerosReales = new GBuffer<>();		
//		cajónDeCajonesDeNúmerosReales.store(cajónDeNúmerosReales);
//		
//		GBuffer<Number> cajónDeNúmeros = new GBuffer<>();
////		cajónDeNúmeros.store(56.7f);      // float --> Float --> Number
//		cajónDeNúmeros.store(8_500_000L); // long  --> Long  --> Number
//		
//		Number n = cajónDeNúmeros.peek();
//		short sh = n.shortValue();        // Number --> short
//		System.out.println(sh);
//		
//		double d = n.doubleValue();       // Number --> double
//		System.out.println(d);
//		
//		System.out.println(cajón2);
//		System.out.println(cajón3);
//		System.out.println(cajónDeNúmerosReales);
//		System.out.println(cajónDeCajonesDeNúmerosReales);
//		System.out.println(cajónDeNúmeros);
//		
//		GBuffer<Object> cajónParadójico = new GBuffer<>();
//		cajónParadójico.store(cajónParadójico);
//		System.out.println(cajónParadójico);
//		
	}

}

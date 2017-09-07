import javax.swing.JOptionPane;

public class Sesion2 {

	public static void main(String[] args) {
//		Solicitar nombre de mes.
//		Solicitar año (si el mes es Febrero)
//		Desplegar el número de días del mes
		String mes = JOptionPane.showInputDialog("Nombre del mes:").trim();
		int dias = 0;
		switch(mes.toLowerCase()) {
			case "abril"      :
			case "junio"      :
			case "septiembre" :
			case "noviembre"  : dias = 30; 
			                    break;

			case "febrero"    : String añoStr = JOptionPane.showInputDialog("Año:").trim();
							    int    año    = Integer.parseInt(añoStr);
							    dias = (año % 400 == 0 || año % 4 == 0 && año % 100 != 0)? 29 : 28;
							    break;
				
			default           : dias = 31;
		}
		JOptionPane.showMessageDialog(null, mes + " tiene " + dias + " días.");
	}
	
	public static void main4(String[] args) {
//		Ejercicios integradores con if y else if
//		1. Temperatura
		double fahrenheit = 78.5;
		double celsius    = (fahrenheit - 32) * 5 / 9; // 0.5555555
		if(celsius > 30)
			System.out.println("Está haciendo calor");
		
//		2. Velocidad
		double velocidad     = 150;  // km/h
		double distancia     = 100;  // km
		double tiempoDeseado =  20;  // minutos
		double tiempoReal    =  distancia / velocidad * 60;
		if(tiempoReal > tiempoDeseado)
			System.out.println("No llegarás a tiempo");
		else  
			// tiempoReal <= tiempoDeseado
			System.out.println("Sí llegaras a tiempo");
		
//		variable = expresion? valor1: valor2;
		String msg = tiempoReal > tiempoDeseado? "No" : "Sí";
		System.out.println(msg + " llegarás a tiempo");
		
//		3. ISR
		double sueldo = 15000;
		double limiteInferior = 0, cuotaFija = 0, pctExcedente = 0;
		if(sueldo <= 496.07) {
			limiteInferior =     0.01;
			cuotaFija      =     0.00;
			pctExcedente   =     1.92;
		} else if(sueldo  <=  4210.41) {
			limiteInferior =   496.08;
			cuotaFija      =     9.52;
			pctExcedente   =     6.40;			
		} else if(sueldo  <=  7399.42) {
			limiteInferior =  4210.42;
			cuotaFija      =   247.23;
			pctExcedente   =    10.88;						
		} else if(sueldo  <=  8601.50) {
			limiteInferior =  7399.43;
			cuotaFija      =   594.24;
			pctExcedente   =    16.00;						
		} else if(sueldo  <= 10298.35) {
			limiteInferior =  8601.51;
			cuotaFija      =   786.55;
			pctExcedente   =    17.92;						
		} else if(sueldo  <= 20770.29) {
			limiteInferior = 10298.36;
			cuotaFija      =  1090.62;
			pctExcedente   =    21.36;						
		} else if(sueldo  <= 32736.83) {
			limiteInferior = 20770.30;
			cuotaFija      =  3327.42;
			pctExcedente   =    23.52;						
		} else {
			limiteInferior = 32736.84;
			cuotaFija      =  6141.95;
			pctExcedente   =    30.00;			
		}
		double ISR = cuotaFija + (sueldo - limiteInferior) * pctExcedente / 100;  
		System.out.printf("Sueldo: $%9.2f\n   ISR: $%9.2f\n", sueldo, ISR);
		System.out.printf("Proporción: %.1f%%\n", ISR / sueldo * 100);
	}
	
	public static void main3(String[] args) {
		String str1 = "hola";   // string pool
		String str2 = "hola";   // string pool
		String str3 = new String("hola");
		String str4 = "adios";  // string pool
		
		System.out.println(str1 == str2);       // sí apuntan al mismo lugar
		System.out.println(str1 == str3);       // no apuntan al mismo lugar
		System.out.println(str1.equals(str3));  // sí tienen el mismo contenido
		System.out.println(str1.equals(str4));  // no tienen el mismo contenido
		System.out.println(!str1.equals(str3)); // no son diferentes en contenido
		System.out.println(!str1.equals(str4)); // sí son diferentes en contenido
		
		System.out.println(str1.equals("hola"));  // sí tienen el mismo contenido
		System.out.println("hola".equals(str1));  // sí tienen el mismo contenido
//		Reflexivo:  a.equals(a) <--> true
//		Simétrico:  a.equals(b) <--> b.equals(a)
//		Transitivo: a.equals(b) y b.equals(c) --> a.equals(c)
		
		System.out.println("--------------");
//		hashCode() de clase String está en función de los caracteres, no de la dirección
		System.out.printf("%X\n", str1.hashCode());
		System.out.printf("%X\n", str2.hashCode());
		System.out.printf("%X\n", str3.hashCode());
		System.out.printf("%X\n", str4.hashCode());
		System.out.println("--------------");
//		System.identityHashCode() invoca a hashCode() de clase Object
		System.out.printf("%X\n", System.identityHashCode(str1));
		System.out.printf("%X\n", System.identityHashCode(str2));
		System.out.printf("%X\n", System.identityHashCode(str3));
		System.out.printf("%X\n", System.identityHashCode(str4));
		System.out.println("--------------");
		String str5 = "hola" + "hola";  // string pool
		String str6 = "holahola";       // string pool
		String str7 = str1   + "hola";
		System.out.printf("%X\n", System.identityHashCode(str5));
		System.out.printf("%X\n", System.identityHashCode(str6));
		System.out.printf("%X\n", System.identityHashCode(str7));
		
		
	}
	
	public static void main2(String[] args) {
//		Ejercicios integradores
//		1. Solicite nombre y apellidos.
//		   Despliegue el nombre completo en mayúsculas comenzando por los apellidos,
//		   separándolos del nombre con una coma
		String nombre      = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
		String apellidos   = JOptionPane.showInputDialog("¿Cuáles son tus apellidos?");
		String nombreCompleto = (apellidos + ", " + nombre).toUpperCase();
		
//		JOptionPane.showMessageDialog(null, String.format("%s, %s".toUpperCase(), apellidos, nombre));
		JOptionPane.showMessageDialog(null, nombreCompleto, "Nombre completo", 
				                      JOptionPane.INFORMATION_MESSAGE);
		
//		2. Solicite año de nacimiento y año de referencia.
//		   Despliegue las edades que podría tener en el de referencia.
		String añoNacStr = JOptionPane.showInputDialog("Año de nacimiento: ");
		String añoRefStr = JOptionPane.showInputDialog("Año de referencia: ");
		int añoNac = Integer.parseInt(añoNacStr);
		int añoRef = Integer.parseInt(añoRefStr);
		int edad1  = añoRef - añoNac - 1;
		int edad2  = añoRef - añoNac;
		String msg = String.format("En el año %d puedes tener %d y %d años", añoRef, edad1, edad2);
		JOptionPane.showMessageDialog(null, msg);
		
//		3. Solicite el precio de un producto. Luego, despliegue sus centavos
//		Estrategia: calcular la resta entre el precio y la parte entera del mismo (cast)
//		Convertir el resultado a base 100
		String precioStr = JOptionPane.showInputDialog("Precio del producto: ");
		double precio    = Double.parseDouble(precioStr);
//		De double a int exige cast que elimina la parte decimal
		int    pesos     = (int) precio;
		int    centavos  = (int) (100 * (precio - pesos));
		JOptionPane.showMessageDialog(null, "Centavos: " + centavos);
	}
	
	public static void main1(String[] args) {
//		String nombre = "Iván";
//		int edad = 39;
//		double estatura = 1.758;
		
		String nombre      = JOptionPane.showInputDialog("¿Cómo te llamas?");
		String edadStr     = JOptionPane.showInputDialog("¿Cuántos años tienes?");
		String estaturaStr = JOptionPane.showInputDialog("¿Cuánto mides (en metros)?");
		
		int edad           = Integer.parseInt(edadStr); 
		double estatura    = Double.parseDouble(estaturaStr);
		
//		Formato {nombre: Iván, edad: 39, estatura: 1.75}
		
		System.out.print("{nombre: \"" + nombre + "\", edad: " + edad +
				         ", estatura: " + estatura + "}\n");
		
		System.out.printf("{nombre: \"%s\", edad: %d, estatura: %.2f}",
				          nombre,  edad, estatura);
	
		String json = String.format("{nombre: \"%s\", edad: %d, estatura: %.2f}",
		                             nombre,  edad, estatura);
		
		JOptionPane.showMessageDialog(null, json, "Mis datos", 
				                            JOptionPane.INFORMATION_MESSAGE); 
		
	}

}

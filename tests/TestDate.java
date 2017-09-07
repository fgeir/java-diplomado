package tests;

import com.iteso.model.Date;

//import static javax.swing.JOptionPane.showMessageDialog;
//import static javax.swing.JOptionPane.ERROR_MESSAGE;

//importa todos los miembros static de JOptionPane, pero no importa la palabra JOptionPane
import static javax.swing.JOptionPane.*;
// importa el nombre de la clase JOptionPane
import javax.swing.JOptionPane;

import static java.lang.System.out;

public class TestDate {

	public static void main(String[] args) {
		out.println("hola mundo");
		
		JOptionPane.showInputDialog("hola");
		showMessageDialog(null, "Error", "Fecha incorrecta", ERROR_MESSAGE);
		
		Date d1 = new Date();
		Date d2 = new Date(31, 12, 2016);
		Date d3 = d1.clone();
//		Crear d4: con el día de d1, el mes de d2, el año de d3 y el formato 1
		Date d4 = new Date(d1.getDay(), d2.getMonth(), d3.getYear(), 1);
//		Crear d5 y asignar la fecha correspondiente al siguiente día de d2
		Date d5 = d2.clone();
		d5.next();
//		Cambiar el mes de d3 a Abril
		d3.setMonth(4);
//		Imprimir el resultado de comparar d1 y d3: ¿1/1/2017 = 1/4/2017? false
		System.out.println(d1.equals(d3));  
//		Imprimir el resultado de comparar d1 y d5: ¿1/1/2017 = 1/1/2017? true
		System.out.println(d1.equals(d5));	
//		Desplegar d1, d2, d3, d4, d5 en los 3 formatos
//		Utilice un arreglo de fechas y ciclos anidados
		Date[] dates = { d1, d2, d3, d4, d5 };
		for(int d = 0; d < dates.length; d ++) {
			for(int f = 0; f < 3; f ++) {
				dates[d].setFormat(f);
				System.out.println(dates[d]);
			}
			System.out.println("----------");
		}
		System.out.println(Date.CONSTANTE_CLASE);
		System.out.println(d1.constanteObjeto);
		System.out.println(d2.constanteObjeto);
		
		System.out.println(Date.isLeap(1900));
		System.out.println(Date.isLeap(1992));
		System.out.println(Date.isLeap(2000));
		System.out.println(d1.isLeap());
		System.out.println(d2.isLeap());
		System.out.println(d3.isLeap());
		System.out.println("------------------");
		System.out.println(Date.isValidDate(28, 2, 1976));
		System.out.println(Date.isValidDate(28, 2, 1977));
		System.out.println(Date.isValidDate(29, 2, 1976));
		System.out.println(Date.isValidDate(29, 2, 1977));
		System.out.println(Date.isValidDate(30, 2, 1976));
		System.out.println(Date.isValidDate(30, 2, 1977));
		System.out.println(Date.isValidDate(30, 4, 1977));
		System.out.println(Date.isValidDate(31, 4, 1977));
		System.out.println(Date.isValidDate(32, 1, 1977));
		System.out.println(Date.isValidDate(25, 8, 1877));
		System.out.println(Date.isValidDate(15, 0, 2013));
		
		Date d6 = new Date(31, 5, 2017);
		System.out.println(d6);
		d6.setMonth(4);   // no debe aceptar este cambio: 31/4/2017 no es fecha válida
		System.out.println(d6);
		
		Date d7 = new Date(29, 2, 2016);
		System.out.println(d7);
		d7.setYear(2015);  // no debe aceptar este cambio: 29/2/2015 no es fecha válida
		System.out.println(d7);

		showMessageDialog(null, d7);
		
		
	}

}

package com.iteso.model;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class Date implements Comparable<Date> {
	
	public int compareTo(Date d) {
		if(this.year  != d.getYear())  return this.year  - d.getYear();
		if(this.month != d.getMonth()) return this.month - d.getMonth();
		return this.day - d.getDay();
	}
	
	public double a1 = 100;
	
	private int    day = 1, month = 1, year = 2017;
//	private String monthName = "Enero";
	private int    format = 0;
	
	private static final String[] MONTH_NAMES = {
		"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
		"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
	};
	
	public static final int MIN_YEAR;
	public static final int MAX_YEAR;
	
	public final String constanteObjeto; // = "hola";
	public static final String CONSTANTE_CLASE = "valor";
	
//	Se ejecuta en el primer uso de Date en la aplicación
	static {
//		System.out.println("Constructor static de Date");
//		String minYearStr = JOptionPane.showInputDialog("Año mínimo permitido: ");
//		String maxYearStr = JOptionPane.showInputDialog("Año máximo permitido: ");
//		int minYear, maxYear;
//		try {
//			minYear = Integer.parseInt(minYearStr);
//		} catch(Exception ex) {
//			minYear = 1900;
//		}
//		try {
//			maxYear = Integer.parseInt(maxYearStr);
//		} catch(Exception ex) {
//			maxYear = 3000;
//		}
//		MIN_YEAR = minYear;
//		MAX_YEAR = maxYear;
		MIN_YEAR = 1000;
		MAX_YEAR = 3000;
//		MIN_YEAR = 1800;  No válido porque sería su segunda asignación
	}
	
	public Date() {
//		Sets system date
		Calendar c = Calendar.getInstance();
		setYear(c.get(Calendar.YEAR));
		setMonth(c.get(Calendar.MONTH) + 1);
		setDay(c.get(Calendar.DAY_OF_MONTH));
		constanteObjeto = "adios";
	}

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
		constanteObjeto = "bye";
	}

	public Date(int day, int month, int year, int format) {
		this(day, month, year);  // invoca al constructor anterior
		setFormat(format);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(isValidDate(day, this.month, this.year)) this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(isValidDate(this.day, month, this.year)) {
			this.month = month;
//			switch(this.month) {
//				case  1: this.monthName = "Enero"; 		break; 
//				case  2: this.monthName = "Febrero"; 	break;
//				case  3: this.monthName = "Marzo"; 		break;
//				case  4: this.monthName = "Abril"; 		break;
//				case  5: this.monthName = "Mayo"; 		break;
//				case  6: this.monthName = "Junio";      break;
//				case  7: this.monthName = "Julio";      break;
//				case  8: this.monthName = "Agosto";     break;
//				case  9: this.monthName = "Septiembre"; break;
//				case 10: this.monthName = "Octubre";    break;
//				case 11: this.monthName = "Noviembre";  break;
//				default: this.monthName = "Diciembre";
//			}
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(isValidDate(this.day, this.month, year)) this.year = year;
	}

	public int getFormat() {
		return format;
	}

	public void m() {
		System.out.println("m() de Date");
	}
	
	public void n() {
		System.out.println("n() de Date");
		m();
	}
	
	public void setFormat(int format) {
		if(format >= 0 && format <= 2) this.format = format;
	}

	public String getMonthName() {
		return MONTH_NAMES[this.month - 1];
	}
	
	@Override
	public String toString() {
//		"05/09/06", si format = 0
//		"5-Sep-2006", si format = 1
//		"5 de septiembre de 2006", si format = 2
		switch(this.format) {
			case 0  : return String.format("%02d/%02d/%02d", this.day, this.month, this.year % 100);
			case 1  : return String.format("%d-%s-%d", this.day, getMonthName().substring(0, 3), this.year);
			default : return String.format("%d de %s de %d", this.day, getMonthName().toLowerCase(), this.year);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Date)) return false;
		Date d = (Date) o;
		return this.day == d.day && this.month == d.month && this.year == d.year;
	}

	@Override
	public Date clone() {
		return new Date(this.day, this.month, this.year, this.format);
	}
	
	public void next() {
		int dd = this.day;
		int mm = this.month;
		int yy = this.year;
		dd ++;
		if(!isValidDate(dd, mm, yy)) {
			dd = 1;
			mm ++;
			if(mm > 12) {
				mm = 1;
				yy ++;
			}
		}
		this.day = dd;
		setMonth(mm);
		this.year = yy;
	}
	
	public static boolean isLeap(int yy) {
//		  4,   8, ...,  92,  96, *100*, 104, 108, ..., 192, 196, *200*, ...
//		204, 208, ..., 292, 296, *300*, 304, 308, ..., 392, 396,  400, ...
		return yy % 400 == 0 || yy % 4 == 0 && yy % 100 != 0; 
	}
	
	public boolean isLeap() {
		return isLeap(this.year);
	}

//	Innecesario porque siempre debe devolver verdadero
//	public boolean isValidDate() {
//		return isValidDate(this.day, this.month, this.year);
//	}
	
	public static boolean isValidDate(int day, int month, int year) {
//		Validar que los tres datos son correctos de forma independiente
		if(year  < MIN_YEAR || year  > MAX_YEAR) return false;
		if(month < 1        || month >   12) return false;
		if(day   < 1        || day   >   31) return false;
//		Validar que los tres datos son correctos cuando se integran
// 		Es febrero
		if(month == 2) {
			if(isLeap(year)) return day <= 29;
			else return day <= 28;
		}
//		Es un mes de 30 días
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			return day <= 30;
		}
//		Es un mes de 31 días
		return true;
	}
	
}

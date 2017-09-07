package tests;

import com.iteso.model.Date;
import com.iteso.model.DateTime;

public class TestDateTime {

	public static void main(String[] args) {
		Date     date1 = new Date();
		DateTime time1 = new DateTime();
		date1.n();
		System.out.println("-------");
		time1.n();
		
		System.out.println(date1.a1);  // a1 de Date
		System.out.println(time1.a1);  // a1 de DateTime
//		Si a1 no fuera public en DateTime, lo anterior es un error de sintaxis
//		porque canceló el acceso a a1 de Date
	}
	
	public static void main2(String[] args) {
		DateTime time1 = new DateTime();  						  // hora actual,   fecha actual
//		time1 = [ 5-ago-2017, 13:33:00] 
		DateTime time2 = new DateTime(0, 26, 3);  				  // hora recibida, fecha actual
//		time2 = [ 5-ago-2017,  0:26:03]
		DateTime time3 = new DateTime(23, 59, 59, 31, 12, 2017);  // hora recibida, fecha recibida
//		time3 = [31-dic-2017, 23:59:59]
		DateTime time4 = time3.clone();
		time4.next();
//		time4 = [ 1-ene-2018,  0:00:00]
		Date date5 = new Date(31, 12, 2017);
//		date5 = [31-dic-2017]
		Date date6 = time3.toDate();
		date6.next();
//		date6 = [ 1-ene-2018]
		DateTime time6 = time3.clone();
		time6.setDay  (date6.getDay());
		time6.setMonth(date6.getMonth());
		time6.setYear (date6.getYear());
//		time6 = [ 1-ene-2018, 23:59:59]
		
		System.out.println("¿time2 es igual a su clon? " + time2.equals(time2.clone()));
		System.out.println("¿time3 es igual a date5? " + time3.equals(date5));
		System.out.println("¿date5 es igual a time3? " + date5.equals(time3));
		System.out.println("¿fecha de time3 es igual a date5? " + time3.toDate().equals(date5));
		System.out.println();
		Date[] datesAndTimes = { time1, time2, time3, time4, date5, date6, time6 };
		for(int d = 0; d < datesAndTimes.length; d ++) {
			for(int f = 0; f <= 2; f ++) {
				datesAndTimes[d].setFormat(f);
				System.out.println(datesAndTimes[d]);
			}
			System.out.println("---------------");
		}
		
	}
	
	public static void main1(String[] args) {
		DateTime now = new DateTime();
		now.setFormat(1);
		System.out.println(now);
		now.setHours(12);
		now.setMinutes(7);
		now.setSeconds(8);
		now.setFormat(0);
		System.out.println(now);
		now.setFormat(1);
		System.out.println(now);
		now.setFormat(2);
		System.out.println(now);
//		System.out.printf("%d:%02d:%02d\n", now.getHours(), 
//				                            now.getMinutes(), 
//				                            now.getSeconds());
	}

}

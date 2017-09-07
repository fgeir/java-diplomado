package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.iteso.model.Date;

public class TestCollection {

	public static void copyFirst(List<? super   Number> dest,
			                     List<? extends Number> src) {
//		dest = Vector<Number>, ArrayList<Object>   
//		src  = Vector<Number>, ArrayList<Integer>, LinkedList<Float>
		Number srcFirst = src.get(0);
		dest.add(0, srcFirst);
	}
	
	public static void print(List<?> list) {
		for(int i = 0; i < list.size(); i ++) {
			Object o = list.get(i);
			System.out.printf("[%2d] %s\n", i, o);
		}
		System.out.println("-------");
	}
	
	public static double max1(List<Number> list) {
		Number first = list.get(0);
		double max   = first.doubleValue();
		for(int i = 1; i < list.size(); i ++) {
			Number current = list.get(i);
			double value   = current.doubleValue();
			if(value > max) max = value;
		}
		list.add(100);  // int -> Integer -> Number
		return max;
	}
	
	public static double max2(List<? extends Number> list) {
//		list puede ser: Vector<Number>
//		list puede ser: Vector<Integer>
//		list puede ser: Vector<Double>		
		Number first = list.get(0);
		double max   = first.doubleValue();
		for(int i = 1; i < list.size(); i ++) {
//				    humano = mujer
			Number current = list.get(i);
			double value   = current.doubleValue();
			if(value > max) max = value;
		}
		
//		mujer = humano : no siempre se puede, particular = general
//		humano = mujer :    siempre se puede, general = particular 
//		list.add(15.56); // double -> Double   
		
		return max;
	}
	
	public static <T> int indexOf(List<T> list, T key) {
		for(int i = 0; i < list.size(); i ++) {
			T o = list.get(i);
			if(o.equals(key)) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Vector<String> strVector = new Vector<>();
		strVector.add("Uno");
		strVector.add("Dos");
		strVector.add("Tres");
		strVector.add("Cuatro");
		strVector.add("Tres");
		for(int i = 0; i < strVector.size(); i ++) {
			String s = strVector.get(i);
			System.out.println(s);
		}
		System.out.println("-----");
		for(String s : strVector) System.out.println(s); 
		System.out.println("-----");
		System.out.println(strVector.indexOf("Tres"));   // imprime 2
		System.out.println(strVector.indexOf("Cinco"));  // imprime -1
		System.out.println(strVector.contains("Tres"));  // imprime true
		System.out.println(strVector.contains("Cinco")); // imprime false
		
		System.out.println(strVector.capacity());  // imprime 10
//		Al añadir el sexto "hola", la capacidad del vector será rebasada
//		Por tanto, se crea un arreglo de 20 elementos y se copian los elementos
		for(int i = 0; i < 6; i ++) strVector.add("hola");
		System.out.println(strVector.size());  	   // imprime 11
		System.out.println(strVector.capacity());  // imprime 20
		
		print(strVector);
		System.out.println(indexOf(strVector, "Cuatro"));
		System.out.println(indexOf(strVector, "Cero"));
//		Error de sintaxis: 400 no es String, o strVector no es Integer
//		System.out.println(indexOf(strVector, 400));
		
		ArrayList<Number> numList = new ArrayList<Number>();
		numList.add(Math.PI); 		// double
		numList.add(567);			// int
		numList.add(7.8f);			// float
		numList.add((short) 15000);	// short
		numList.add(12000L);		// long
		print(numList);
		double m = max1(numList);	// m = 15000.0 (double)
		System.out.println(m);
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(15);
		intList.add(32);
		intList.add(24);
		intList.add(47);
		intList.add(18);
		print(intList);
//		Error de sintaxis porque se esperaba lista de <Number>
//		m = max1(intList);
//		El método debería recibir lista de <Number o subclase>
		m = max2(intList);
		System.out.println(m);
		m = max2(numList);
		System.out.println(m);
		
		copyFirst(numList, intList);
		print(numList);
//		Error de sintaxis: el 1er argumento debe ser Number o superclase
//		copyFirst(intList, numList);
		Collections.shuffle(strVector);
		print(strVector);
		Collections.swap(intList, 0, 1);
		print(intList);
		
		int f = Collections.frequency(strVector, "hola");
		System.out.println(f);
		f = Collections.frequency(strVector, "Tres");
		System.out.println(f);
		f = Collections.frequency(strVector, 4);  // 4-int-Integer-Object
		System.out.println(f);
		
//		copy: reemplaza cada numList(i) por intList(i)
		Collections.copy(numList, intList);
		print(numList);
//		Collections.copy(intList, numList);   Number no es más específico que Integer
//		Collections.copy(numList, strVector); String no es más específico que Number
		List<Date> dateList = Collections.nCopies(8, new Date());
		print(dateList);
//		¿A qué clase pertenece dateList? se sabe que implementa a List
		System.out.println(dateList.getClass());
//		pertenece a: java.util.Collections$CopiesList
//		CopiesList es una clase anidada en la clase Collections
		
//		Crear una cola de números reales
		LinkedList<Double> dblQueue = new LinkedList<Double>();
		dblQueue.offer(Math.PI);
		dblQueue.offer(Math.E);
		dblQueue.offer(45.76);
		dblQueue.offer(-126.78);
		double p = dblQueue.poll();
		System.out.println("Atendido: " + p);
		print(dblQueue);
		
		Collections.sort(strVector);
		print(strVector);
		Collections.sort(dblQueue);
		print(dblQueue);
		
//		Integer implementa Comparable<Integer>
		int max = Collections.max(intList);  // Integer -> int
		System.out.println(max);
		
//		Error de sintaxis: Number no implementa Comparable<Number>
//		Collections.min(numList);
		
//		Ordenamiento inverso: de mayor a menor
		Comparator<Integer> intComparator = new Comparator<Integer>() {
			public int compare(Integer i0, Integer i1) {
				return i1.intValue() - i0.intValue();
			}
		};
//		Utiliza el criterio implementado en Integer
		Collections.sort(intList); 
		print(intList);
//		Utiliza el criterio implementado en intComparator
		Collections.sort(intList, intComparator);
		print(intList);
		
//		¿Cómo ordenamos una lista de Date?
		Vector<Date> dateVector = new Vector<Date>();
		dateVector.add(new Date());
		dateVector.add(new Date(28,  9, 2017));
		dateVector.add(new Date(30,  7, 2017));
		dateVector.add(new Date( 1,  1, 2018));
		dateVector.add(new Date());
		dateVector.add(new Date(12, 12, 2016));
		Collections.sort(dateVector);
		print(dateVector);
	
		
	}

}


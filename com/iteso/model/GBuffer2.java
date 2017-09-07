package com.iteso.model;

public class GBuffer2<Type1, Type2> {
	
	private Type1 object1 = null;
	private Type2 object2 = null;
	
	public void store1(Type1 obj1) {
		this.object1 = obj1;
	}
	
	public void store2(Type2 obj2) {
		this.object2 = obj2;
	}
	
	public Type1 peek1() {
		return this.object1;
	}
	
	public Type2 peek2() {
		return this.object2;
	}	
	
	public static void main(String[] args) {
		GBuffer2<String, Integer> caj�n1 = new GBuffer2<>();
		caj�n1.store1("Cuarenta");
		caj�n1.store2(40);  		// int --> Integer (boxing)
		String s = caj�n1.peek1();
		int    i = caj�n1.peek2();  // Integer --> int (unboxing)
		System.out.println(s + ", " + i);

		GBuffer2<Date, Number> caj�n2 = new GBuffer2<>();
		caj�n2.store1(new Date());  //      boxing    generalizaci�n
		caj�n2.store2(6719.34);  	// double --> Double --> Number
		
		GBuffer2<GBuffer2<String, Integer>, Object> megaCaj�n = new GBuffer2<>();
		megaCaj�n.store1(caj�n1);
		megaCaj�n.store2(megaCaj�n);
		
//		metaCaj�n1 y metaCaj�n2 almacenan los mismos tipos: Object
		GBuffer2                 metaCaj�n1 = new GBuffer2  ();
		GBuffer2<Object, Object> metaCaj�n2 = new GBuffer2<>();
		Object o = new Object();
		metaCaj�n1.store1(o);
		metaCaj�n2.store1(o);
		metaCaj�n1.store2("hola");
		metaCaj�n2.store2("hola");
		
		o = metaCaj�n1.peek1();
		o = metaCaj�n2.peek1();
		s = (String) metaCaj�n1.peek2();  // cast -> inseguridad de tipos
		s = (String) metaCaj�n2.peek2();
		
	}
	
	
	
	
	
	
	
	

}

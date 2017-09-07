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
		GBuffer2<String, Integer> cajón1 = new GBuffer2<>();
		cajón1.store1("Cuarenta");
		cajón1.store2(40);  		// int --> Integer (boxing)
		String s = cajón1.peek1();
		int    i = cajón1.peek2();  // Integer --> int (unboxing)
		System.out.println(s + ", " + i);

		GBuffer2<Date, Number> cajón2 = new GBuffer2<>();
		cajón2.store1(new Date());  //      boxing    generalización
		cajón2.store2(6719.34);  	// double --> Double --> Number
		
		GBuffer2<GBuffer2<String, Integer>, Object> megaCajón = new GBuffer2<>();
		megaCajón.store1(cajón1);
		megaCajón.store2(megaCajón);
		
//		metaCajón1 y metaCajón2 almacenan los mismos tipos: Object
		GBuffer2                 metaCajón1 = new GBuffer2  ();
		GBuffer2<Object, Object> metaCajón2 = new GBuffer2<>();
		Object o = new Object();
		metaCajón1.store1(o);
		metaCajón2.store1(o);
		metaCajón1.store2("hola");
		metaCajón2.store2("hola");
		
		o = metaCajón1.peek1();
		o = metaCajón2.peek1();
		s = (String) metaCajón1.peek2();  // cast -> inseguridad de tipos
		s = (String) metaCajón2.peek2();
		
	}
	
	
	
	
	
	
	
	

}

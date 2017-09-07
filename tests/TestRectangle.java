package tests;

import shapes2d.Rectangle;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();  // base =  1.0, height =  1.0
//		r1.base   = 10;					 
//		r1.height = -6.5;				 
		r1.setBase(10);					 // base = 10.0, height =  1.0
		r1.setHeight(-6.5); 			 // base = 10.0, height =  1.0
		r1.setHeight(250); 			 	 // base = 10.0, height =  1.0
		r1.setHeight(6.5); 			 	 // base = 10.0, height =  6.5
		r1.print();
		
		Rectangle r2 = new Rectangle();  // base =  1.0, height =  1.0
		r2.print();
//		r2.base   = r1.perimeter() / 2;
//		r2.height = r1.height * 2;		
		r2.setBase(r1.perimeter() / 2);   // base = 16.5, height =  1.0
		r2.setHeight(r1.getHeight() * 2); // base = 16.5, height = 13.0
		r2.print();
		
		Rectangle r3 = new Rectangle();	 // base =  1.0, height =  1.0
//		r3.base   = r2.base;
//		r3.height = r1.area();			 	 
		r3.setBase(r2.getBase());	     // base = 16.5, height =  1.0
		r3.setHeight(r1.area());	 	 // base = 16.5, height = 65.0
		r3.print();
		
		Rectangle r4 = new Rectangle(75, 45);  // base = 75.0, height = 45.0
		r4.print();
		
		Rectangle r5 = new Rectangle(46.2);    // base = 46.2, height = 1.0
		r5.print();
		
	}

}

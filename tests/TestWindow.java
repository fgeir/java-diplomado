package tests;

import windows.BasicWindow;
import windows.ExtendedWindow;

public class TestWindow {

	public static void main(String[] args) {
		BasicWindow bw1 = new BasicWindow(120, 75, 600, 300);
		bw1.resize(-50, 30);
		bw1.display();
		BasicWindow bw2 = new BasicWindow();
		bw2.resize(30, -5);
		bw2.display();
		System.out.println("Min width: "  + BasicWindow.MIN_WIDTH);
		System.out.println("Min height: " + BasicWindow.MIN_HEIGHT);
		
		ExtendedWindow ew3 = new ExtendedWindow("Ventana 3");
		ew3.display();
		
		ExtendedWindow ew4 = new ExtendedWindow(250, 385, 100, 100, "Ventana 4");
		ew4.move(50, -85);
		ew4.resize(50, -50);
		ew4.display();
		
	}

}

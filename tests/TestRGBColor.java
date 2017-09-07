package tests;

import com.iteso.model.RGBColor;

public class TestRGBColor {

	public static void main(String[] args) {
		RGBColor c1 = new RGBColor();  // <127, 127, 127, 'Gris'>
		RGBColor c2 = new RGBColor( 80, 200, 120, "Esmeralda");
		RGBColor c3 = new RGBColor(220,  20,  60, "Carmesí");
		RGBColor c4 = new RGBColor( 18,  10, 143, "Azul marino");
		RGBColor c5 = new RGBColor(c2.getCyan(), c2.getMagenta(), 
				                   c2.getYellow(), "Esmeralda impreso");
		
		System.out.printf("%d, %d, %d\n", c3.getRed(), c3.getGreen(), c3.getBlue());
		
		System.out.printf("%08X\n", c1.getRGB());
		System.out.printf("%08X\n", c2.getRGB());
		System.out.printf("%08X\n", c3.getRGB());
		System.out.printf("%08X\n", c4.getRGB());
		System.out.printf("%08X\n", c5.getRGB());
		
		RGBColor orange = new RGBColor(255, 150, 0);
		System.out.printf("%08X\n", orange.getRGB());
	}

}

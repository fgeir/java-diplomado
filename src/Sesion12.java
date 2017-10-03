import java.util.List;

import com.iteso.model.ColorOutOfBoundsException;
import com.iteso.model.RGBColor;

public class Sesion12 {

	public static void main(String[] args) {
		int a = 3, b = 0;
//		c:\>java Sesion12 -ea   {enable assertions}
//		Si la expesión lógica es falsa se lanza AssertionError
		assert b != 0;   // suponemos que b es diferente que cero
		int c = a / b;
		System.out.println(c);

		
		
//		Como es RuntimeException, no estamos obligados a manejar la exepción
//		Conviene cuando estamos seguros que los argumentos son correctos
		RGBColor c0 = new RGBColor(220, 120, 56, "Super red");
		System.out.println(c0);
		
//		Conviene manejar la excepción cuando los argumentos del color 
//		provienen del usuario y pretendemos informarle
		try {
			RGBColor c1 = new RGBColor(320, 120, 56, "Super red");
			c1.setGreen(15);
			System.out.println(c1);
		} catch(ColorOutOfBoundsException ex) {
			System.out.println(ex);
		}
		System.out.println("Aquí");
				
	}
		
		

	
}

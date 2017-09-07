import java.util.Arrays;

import javax.swing.JOptionPane;

public class Sesion3 {

	public static void main(String[] args) {
		double[][] A = { { 1.5, 2.5, 3.2 },
				         { 3.4, 6.2, 1.6 }
		};
		double[][] B = { { 3.5, 2.5, 1.8 },
		                 { 4.6, 1.8, 6.4 }
		};
		double[][] C = new double[2][3];  //[A.length][A[0].length];
		for(int i = 0; i < A.length; i ++) {
			for(int j = 0; j < A[i].length; j ++) {
				C[i][j] = A[i][j] + B[i][j];
				System.out.printf("%.1f  ", C[i][j]);
			}
			System.out.println();
		}
		
		short[] V = { 5, 10, 3, 25, 18, 6, 30, 16 };
		int x = 15;
		short[] V1, V2;
		int l1 = 0, l2 = 0;
		for(int i = 0; i < V.length; i ++) {
			if(V[i] > x) l1 ++;
			if(V[i] % 2 == 1) l2 ++;
		}
		V1 = new short[l1];
		V2 = new short[l2];
		for(int i = 0, j = 0, k = 0; i < V.length; i ++) {
			if(V[i] > x)      V1[j ++] = V[i];  
			if(V[i] % 2 == 1) V2[k ++] = V[i]; 
		}		
		System.out.println(Arrays.toString(V1));
		System.out.println(Arrays.toString(V2));
		
		String sPalabras = JOptionPane.showInputDialog(null, "¿Cuántas palabras vas a capturar?");
		int    palabras  = Integer.parseInt(sPalabras);
		char[][] matriz  = new char[palabras][];
		
		for(int p = 0; p < palabras; p ++) {
			String palabra = JOptionPane.showInputDialog("Ingresa palabra " + (p + 1) + ":");
			if(palabra == null || palabra.equals("")) {
				p --;
				continue;
			}
			matriz[p] = new char[palabra.length()];
			for(int c = 0; c < palabra.length(); c ++) 
				matriz[p][c] = palabra.charAt(c);
			
			System.out.println(Arrays.toString(matriz[p]));
		}
		System.out.println(Arrays.toString(matriz));
	}
	
	public static void main2(String[] args) {
		int precision = 0;
		do {
			String sPrecision = JOptionPane.showInputDialog("Precisión para PI Leibniz:");
			try {
				precision = Integer.parseInt(sPrecision);
			} catch(NumberFormatException e) {
			}
			if(precision <= 0) JOptionPane.showMessageDialog(null, "Precisión no válida");
		} while(precision <= 0);
		
		double PI = 0;
		for(int i = 1, d = 1; i <= precision; i ++, d += 2) {
			double f = 1.0 / d;
			if(i % 2 != 0) PI += f;
			else PI -= f;
		}
		PI *= 4;
		JOptionPane.showMessageDialog(null, "Valor aproximado  de PI: " + PI + "\n" + 
				                            "Valor más preciso de PI: " + Math.PI);
		
	}
	
	public static void main1(String[] args) {
		byte b1 = 0b101_1001;  // 89
		byte b2 = 0b011_0101;  // 53
		int  ba = b1 & b2;     // 00010001 = 17
		System.out.println(ba);
		int  bo = b1 | b2;     // 01111101 = 125
		System.out.println(bo);
		byte bx = (byte) (b1 ^ b2);  // 01101100 = 108
		System.out.println(bx);
		byte bsr = (byte) (b1 >> 3); // 00001011 = 11
		System.out.println(bsr);
		byte bsl = (byte) (b1 << 3); // 10 1100 1000  (-1) 
		System.out.println(bsl);     //    1100 0111  (comp)
		                             //    0011 1000 --> -56
		int  isl = b1 << 3;
		System.out.println(isl);     // 10 1100 1000
		
		int bsr2 = bsl >>> 2;        // 11111111 11111111 11111111 11001000
		System.out.println(bsr2);    // 00111111 11111111 11111111 11110010

		int bsr3 = bsl >>  2;        // 11111111 11111111 11111111 11001000
		System.out.println(bsr3);    // 11111111 11111111 11111111 11110010

		String bs = Integer.toBinaryString(bsl);
		System.out.println(bs);
		
		System.out.println(Integer.toHexString(bsr2)); // 3ffffff2
		System.out.println(Integer.toHexString(bsr3)); // fffffff2
		
		for(int i = 1; i <= 20; i ++) {
			if(i % 7 == 0) continue;  // nos manda a i++
			System.out.println("i = " + i);
		}
		
		for(int i = 1; i <= 20; i ++) {
			if(i % 7 != 0)  // nos manda a i++
				System.out.println("i = " + i);
		}
		
		int i, j = 0, k = 0;
		bucle1: for(i = 1; i <= 100; i ++) {
//			if(i == 3) continue;
			bucle2: for(j = 1; j <= 100; j ++) {
				if(i + j == 7) continue;  // se pasa a j++
				bucle3: for(k = 1; k <= 100; k ++) {
					if(i * i + j * j == k * k) break bucle1;
				}
			}
		}
		System.out.println(i + ", " + j + ", " + k);
		
		while(true) {
			String clave = JOptionPane.showInputDialog(null, "¿Cuál es la clave?");
			if(clave.equals("hola123")) break;
		}

		String clave;
		do {
			clave = JOptionPane.showInputDialog(null, "¿Cuál es la clave?");
		} while(!clave.equals("hola123"));
		
		
//		Utilizando do/while, break, continue, try/catch
//		Solicitar el precio de un producto
//		Preguntar otra vez, si se cumple alguna de estas tres
//		a) Se pulsa Enter
//		b) El precio no es mayor que $0.00
//		c) El precio no es un número real válido
//		Para los casos b y c, informar del error sucedido
//		Si se rinde, que presione Esc para salir o cancelar
//		Si capturó el precio correctamente, desplegar el precio + IVA
		
		double precio = 0;
		do {
			String sPrecio = JOptionPane.showInputDialog("Precio del producto:");
			if(sPrecio == null) break;
			if(sPrecio.trim().equals("")) continue;
			try {
				precio = Double.parseDouble(sPrecio);
				if(precio <= 0) JOptionPane.showMessageDialog(null, "El precio debe ser mayor que $0.00");
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "El precio debe ser un número real válido");
			}
		} while(precio <= 0);
		
		if(precio > 0)
			JOptionPane.showMessageDialog(null, "Precio más IVA: " + precio * 1.16);
		
	}

}

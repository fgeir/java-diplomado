import java.util.Arrays;

public class Sesion4 {

	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4};
		System.out.println(System.identityHashCode(a1));
		int[] a2 = {5, 6, 7};
//		a1 = a2           // a1 apuntará al arreglo apuntado por a2
		a1 = a2.clone();  // a1 apuntará a un clon de tal arreglo
		a1[0] = 8;
//		System.out.println(a2[0]);
		System.out.println("a1 = " + Arrays.toString(a1));
		System.out.println("a2 = " + Arrays.toString(a2));
		System.out.println(System.identityHashCode(a1));
		System.out.println(System.identityHashCode(a2));
		
		char[][] texto1 = { {'h', 'o', 'l', 'a' },
				            {'m', 'u', 'n', 'd', 'o' },
				            {'c', 'r', 'u', 'e', 'l' }
		};
		char[][] texto2 = texto1.clone();
		for(int r = 0; r < texto1.length; r ++) {
			texto2[r] = texto1[r].clone();
		}
		texto2[1][3] = 'b';
		System.out.println(texto1[1][3]);
		System.out.println(texto1[1]);
		System.out.println(texto2[1]);
		
		for(int v : a1) System.out.println(v);
		
		double[] estaturas = { 1.75, 1.68, 1.80, 1.65, 1.72, 1.70, 1.93, 1.78, 1.74, 1.57};
		double suma = 0;
		for(double e : estaturas) {
			suma += e;
//			e += 0.10;  // El valor en el arreglo quedó intacto, se sumó 0.10 a la copia
		}
		double promedio = suma / estaturas.length;
		System.out.println(promedio);
		suma = 0;
		for(double e : estaturas) {
			suma += Math.pow(e - promedio, 2);
		}
		double desviacion = Math.sqrt(suma / estaturas.length);
		System.out.println(desviacion);
		
		int[] a3  = {5, 12, 8, 1,  6, 17};
		int[] a4  = {1,  8, 5, 6, 12,  3};
		int k = 5;
		int[] a3k = Arrays.copyOf(a3, k);   // a3k = {5, 12, 8, 1,  6}   O(k)
		int[] a4k = Arrays.copyOf(a4, k);   // a4k = {1,  8, 5, 6, 12}   O(k)
		Arrays.sort(a3k);  					// a3k = {1,  5, 6, 8, 12}   O(k lg k)
		Arrays.sort(a4k);  					// a4k = {1,  5, 6, 8, 12}   O(k lg k)
		boolean iguales = Arrays.equals(a3k, a4k);					//   O(k)
		System.out.println("¿Son iguales? " + iguales);				//   Total: O(k lg k)
		
		double[][] m1 = { { 1.5, 2.5}, {-3.6, 4.8 } };
		double[][] m2 = { { 1.5, 2.5}, {-3.6, 4.8 } };
		
		System.out.println(Arrays.equals(m1, m2));     // Compara referencia de cada fila
		System.out.println(Arrays.deepEquals(m1, m2)); // Compara valor de cada celda
		
	}

}

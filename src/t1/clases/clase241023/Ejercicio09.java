package t1.clases.clase241023;

public class Ejercicio09 {

  	public static void main(String[] args) {
		/*
		 *
		 * 1. Declara dos variables int llamadas a y b con los valores 7 y 9
		 * respectivamente.
		 * 2. Intercambia los valores de a y b sin usar una variable
		 * temporal.
		 * 3. Imprime los valores de a y b después del intercambio.
		 *
		 */

    int a = 7;
		int b = 9;

    b = a + b;

    a = b - a;

    b = b - a;

		System.out.println("a = " + a + " y b = " + b);

	}

}

package t1.clases.clase241030;

import java.util.Scanner;

public class ComprobadorPositivoNegativo {

  @SuppressWarnings("ConvertToTryWithResources")

  public static void main(String[] args) {
        // Enunciado:
        // Escribe un programa que solicite al usuario ingresar un número entero.
        // Si el número es positivo, el programa debe mostrar "El número es positivo".
        // Si es negativo, debe mostrar "El número es negativo".
        // Si el número es cero, debe mostrar "El número es cero".

		// Creo el escaner
		Scanner escaner = new Scanner(System.in);

    // Mando las instrucciones al usuario
		System.out.println("Escribe un número entero, positivo, negativo o cero:");

    // Guardo el valor introducido por el usuario

    while(true) {
			if(escaner.hasNextInt()) {
				int number = escaner.nextInt();
				if(number > 0) { // Si es mayor que 0 es positivo
					System.out.println("El número es positivo");
				} else if (number < 0) { // Si es menor que 0 es negativo
					System.out.println("El número es negativo");
				} else { // Si es igual a 0 es cero
					System.out.println("El número es cero");
				}
				break;
			} else {
				System.out.println("ERROR: No has introducido un número entero");
				System.out.println("Escribe un número entero, positivo, negativo o cero:");
				escaner.next();
			}
		}


    // Cierro el escaner
		escaner.close();

	}

}

package t1.clases.clase241030;

import java.util.Scanner;

public class ContadorDeNumeros {

  	public static void main(String[] args) {
        // Enunciado:
        // Escribe un programa que solicite al usuario un número entero positivo.
        // Luego, el programa debe imprimir todos los números del 1 hasta ese número.
        // Usa un bucle for para imprimir los números uno por uno en líneas separadas.

    /*
		Usar Scanner para pedir entero al usuario
		Guardar la variable en una variable n
		Crear un bucle desde 1 a n.
			Imprimir cada numero por pantalla
		 */

    System.out.println("¡Hola! escribe un número entero para imprimir la secuencia hasta ese número:");

    Scanner escaner = new Scanner(System.in);

    int number = escaner.nextInt();

    for(int i = 1; i <= number; i++) {
			System.out.println("*".repeat(i));
		}
		escaner.close();
	}

}

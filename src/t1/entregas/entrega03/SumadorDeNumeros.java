package t1.entregas.entrega03;

import java.util.Scanner;

public class SumadorDeNumeros {

  public static void main(String[] args) {

		/**
    @author		Sergio Ruiz de León
    @version	1.0
    @date		2024-11-01

    Escribe un programa que permita al usuario ingresar una serie de números enteros.
		El programa debe seguir pidiendo números hasta que el usuario ingrese "0". Una vez
		que se ingresa "0", el programa debe mostrar la suma total de todos los números
		ingresados (sin contar el 0 final).

    */


    Scanner escaner = new Scanner(System.in);

    int number;		// variable para alojar el input del usuario
		int suma = 0; 	// variable para sumar los inputs
		int count = 0;	// contador para el primer mensaje o resto mensajes

    do {
			if(count == 0) { // si contador es 0 es el primer mensaje al usuario
				System.out.println("Introduce un número entero");
				// incrementamos para que no salga más el primer mensaje
				count++;
			} else { // resto de mensajes
				System.out.println("Ingresa otro número o pulsa 0 para cerrar.");
			}

			// guardamos el input del usuario
			number = escaner.nextInt();

			// lo sumanos a al resto de números
			suma += number;

    } while (number != 0); // si el usuario introduce 0 paramos el bucle

    // mostramos por pantalla el resultado de la suma
		System.out.println("El resultado de la suma es: " + suma);

    // cerramos el escaner
		escaner.close();
	}


}

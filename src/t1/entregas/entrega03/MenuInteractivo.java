package t1.entregas.entrega03;

import java.util.Scanner;

public class MenuInteractivo {

  public static void main(String[] args) {

    /**
    @author		Sergio Ruiz de León
    @version	1.0
    @date		2024-11-03

    Diseña un programa que muestre un menú interactivo con tres opciones:
		1. Saludar
		2. Despedirse
		3. Salir
		El programa debe permitir al usuario elegir una opción y responder en consecuencia
		(por ejemplo, “¡Hola!” o “Adiós”). Este menú debe seguir apareciendo hasta que el
		usuario seleccione la opción “Salir”. Si el usuario selecciona una opción inválida, el
		programa debe mostrar un mensaje de error e invitar a elegir nuevamente.

    */

    Scanner escaner = new Scanner(System.in);

    int number = 0;				// Variable para almacenar el número de la opción que se quiere dar
		String instruction = null;	// Variable para almacenar el String de la opción que se quiere dar
		boolean firstRun = true;	// Variable para discriminar si se trata del primer arranque o sucesivos

    // lanzamos la bienvenida
		System.out.println("¡Te damos la bienvenida!");

    // comenzamos un bucle
		do {

      // si no fuera el primer run
			if(!firstRun) {
				// imprimimos pantalla
				System.out.println("¿Deseas continuar?");
			}
			// imprimimos las instrucciones
			System.out.println("Elige una de estas opciones introduciendo el número o el texto de la opción:");
			System.out.println("1. Saludar");
			System.out.println("2. Despedirse");
			System.out.println("3. Salir");

			// cambiamos firstRun a false
			firstRun = false;

      // si el input es un número entero
			if(escaner.hasNextInt()) {
				number = escaner.nextInt();
				if(number == 1) {
					System.out.println("¡Hola!");
				} else if (number == 2) {
					System.out.println("¡Adiós!");
				} else if (number == 3) {
					break;
				} else {
					System.out.println("ERROR: Número fuera del rango de opciones");
				}
			}
			// si el input no es un entero
			else {
				// guardamos la instucción
				instruction = escaner.nextLine();
				// si el comando de texto es igual que a una de las opciones, imprimimos por pantalla el saludo o adiós
				if(instruction.contentEquals("Saludar") || instruction.contentEquals("SALUDAR") || instruction.contentEquals("saludar")) {
					System.out.println("¡Hola!");
				} else if(instruction.contentEquals("Despedirse") || instruction.contentEquals("DESPEDIRSE") || instruction.contentEquals("despedirse")) {
					System.out.println("¡Adiós!");
				} else if(instruction.contentEquals("Salir") || instruction.contentEquals("SALIR") || instruction.contentEquals("salir")) {
					// rompemos el bucle
					break;
				} else {
					// si ha habido un error lo imprimimos por pantalla
					System.out.println("ERROR: No se ha reconocido la instrucción.");
				}
			}
			// bucle mientras no se den alguna de esas variables
		} while (instruction != "Salir" || number != 3);

    // cerramos el escaner
		escaner.close();

  }

}

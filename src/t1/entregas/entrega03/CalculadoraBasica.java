package t1.entregas.entrega03;

import java.util.Scanner;

public class CalculadoraBasica {

  public static void main(String[] args) {

    /**
    @author		Sergio Ruiz de León
    @version	1.0
    @date		2024-11-03

    Crea un programa que solicite al usuario ingresar dos números y un símbolo de
		operación (+, -, *, /). El programa debe realizar la operación especificada entre los dos
		números y mostrar el resultado. Si el usuario ingresa un símbolo que no sea válido, el
		programa debe mostrar un mensaje de error.

    */

    Scanner escaner = new Scanner(System.in);

    int firstNumber = 0;		// variable que guarda el primer número
		int secondNumber = 0;		// variable que guarda el segundo número
		String operation = null;	// variable que guarda el operador
		byte counter = 0;			// contador que ayuda con la fase del programa

    // bucle infinito
		while (true) {

      // en el caso inicial pedimos el primer número
			if(counter == 0) {
				System.out.println("Ingresa el primer número:");

        // si hay un input de tipo int
				if(escaner.hasNextInt()) {
					// asignamos el valor a la variable firstNumber
					firstNumber = escaner.nextInt();
					// aumentamos el counter para pasar a la siguiente fase del programa
					counter++;
				} else {
					// si no ha sido un número entero, mandamos un mensaje de error
					System.out.println("Error: no has introducido un número");
					// consumimos la entrada de consola y esperamos a la siguiente entrada
					escaner.next();
				}

      }
			// en la siguiente fase pedimos el operador de la calculadora
			else if (counter == 1) {
				System.out.println("Ingresa la operación con el símbolo: +, -, * o /");

				// asignamos la siguiente entrada a operation
				operation = escaner.next();

        // si la entrada es de sólo 1 caracter y coincide con los simbolos: +-*/
				if(operation.length() == 1 && operation.charAt(0) == '+' || operation.charAt(0) == '-' || operation.charAt(0) == '*' || operation.charAt(0) == '/') {
					// aumentamos el counter para pasar a la siguiente fase del programa
					counter++;
				} else {
					// si no ha sido uno de esos simbolos o ha habido más de un caracter, mandamos mensaje error
					System.out.println("Error: no has introducido correctamente el orerador.");
				}

      }
			// en la última fase del programa
			else if (counter == 2) {
				System.out.println("Ingresa el segundo número:");

        // si el input es un número entero
				if(escaner.hasNextInt()) {
					// asignamos el número a la variable secondNumber
					secondNumber = escaner.nextInt();

          // creamos una variable local para almacenar el resultado
					int result = 0;

          // cotejamos el simbolo de la operación con un switch o if anidado.
					switch(operation.charAt(0)) {
						case '+':
							result = firstNumber + secondNumber;
							break;
						case '-':
							result = firstNumber - secondNumber;
							break;
						case '*':
							result = firstNumber * secondNumber;
							break;
						case '/':
							result = firstNumber / secondNumber;
							break;
					}

          // imprimimos el resultado junto con el tipo de operación
					System.out.println("El resultado de la (" + operation.charAt(0) + ") es: " + result);

          // rompemos el bucle infinito del while
					break;

        }
			}

    }

    // cerramos el escaner
		escaner.close();

	}


}

package t1.clases.clase241030;

import java.util.Scanner;

public class ConversorDeUnidades {


  public static void main(String[] args) {
        // Enunciado:
        // Escribe un programa que muestre un menú de opciones para convertir unidades:
        // 1. Kilómetros a millas
        // 2. Grados Celsius a Fahrenheit
        // 3. Kilogramos a libras
        // 4. Salir
        // El programa debe solicitar al usuario la cantidad a convertir y mostrar el resultado.
        // Usa un bucle for para repetir el menú hasta que el usuario elija salir.

    try(Scanner input = new Scanner(System.in)) {

    String instruction = null;
		int number = 0;

    do {
			if(number == 0) {
				System.out.println("Elige el tipo de conversión que quieres realizar:");
				System.out.println("1. Kilómetros a millas");
				System.out.println("2. Grados Celsius a Fahrenheit");
				System.out.println("3. Kilogramos a libras");
				System.out.println("4. Salir");
			}

      if(input.hasNextInt()) {
				number = input.nextInt();
				if(number < 1 || number > 4) {
					System.out.println("ERROR: no se ha introducido un número correcto");
					continue;
				} else {
					if(number == 4) {
						break;
					}
				}
			} else {
				instruction = input.next();
				if(instruction.equalsIgnoreCase("Kilómetros a millas") || instruction.equalsIgnoreCase("Grados Celsius a Fahrenheit") || instruction.equalsIgnoreCase("Kilogramos a libras") || instruction.equalsIgnoreCase("Salir")) {
					if(instruction.equalsIgnoreCase("Kilómetros a millas"))
						number = 1;
					if(instruction.equalsIgnoreCase("Grados Celsius a Fahrenheit"))
						number = 2;
					if(instruction.equalsIgnoreCase("Kilogramos a libras"))
						number = 3;
					if(instruction.equalsIgnoreCase("Salir"))
						number = 4;

          if(number == 4) {
						break;
					}

        } else {
					System.out.println("ERROR: no se ha introducido la opción correctamente");
					continue;
				}
			}

      System.out.println("Introduce la cantidad a convertir en número decimal:");

      float numberToConvert;

      if(input.hasNextFloat()) {
				numberToConvert = input.nextFloat();
			} else {
				System.out.println("ERROR: no se ha introducido un número decimal válido");
				continue;
			}

      switch(number) {
			case 1:
				System.out.println("Kilómetros: " + numberToConvert + " equivale a Millas: " + (numberToConvert * 0.621371));
				break;
			case 2:
				System.out.println("Grados celsius: " + numberToConvert + " equivale a Fahrenheit: " + ((numberToConvert * (9/5)) + 32));
				break;
			case 3:
				System.out.println("Kilogramos: " + numberToConvert + " equivale a Libras: " + (numberToConvert * 2.20462));
				break;

      }

      break;


    } while (!instruction.equals("Salir") || number != 4);

    input.close();

  }

  }

}

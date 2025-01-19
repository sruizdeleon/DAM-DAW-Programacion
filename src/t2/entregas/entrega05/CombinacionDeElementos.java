package t2.entregas.entrega05;

import java.util.Scanner;

public class CombinacionDeElementos {

  /* ENUNCIADO */

  // Escribe un programa que calcule las combinaciones posibles de n elementos tomados de k en k utilizando recursividad. Una combinación es un subconjunto de tamaño k extraído de un conjunto den elementos.

  /* Requisitos */

  // El usuario debe ingresar n (el tamaño del conjunto) y k (el tamaño del subconjunto).
  // Usa recursividad para calcular el número total de combinaciones.
  // Muestra el número total de combinaciones posibles.


  public static void main(String[] args) {

    /* Variables globales */
    final String ROJO = "\u001B[31m";
    final String AZUL = "\u001B[34m";
		final String RESET = "\u001B[0m";
    Scanner entrada = new Scanner(System.in);
    int conjunto = 0;
    int subconjunto = 0;
    boolean salir = false;



    /* Instrucciones para el usuario */
    System.out.println("---- COMBINACIÓN DE ELEMENTOS ----");
    System.out.println("Bienvenido al programa de combinación de elementos. Te vamos a solicitar que introduzcas dos números: el conjunto y el subcojunto.");
    System.out.println("Criterios que deben de cumplir:");
    System.out.println("- Ambos números deben ser positivos y enteros.");
    System.out.println("- El conjunto debe ser mayor o igual que el subcojunto.");
    System.out.println("Una vez introducidos los números calcularemos el número de combinaciones posibles de elegir subcojuntos diferentes en base al cojunto dado. Recuerda que en cualquier momento puedes escribir exactamente \"Salir\" para cerrar el programa.\n");
    System.out.println("¡Perfecto! Comencemos.");


    /* Pedimos al usuario el conjunto */
    do {
      System.out.println("Introduce el número para el Conjunto:");
      if(!entrada.hasNextInt()){ // Si no es un entero
          System.out.println(ROJO+"\nError:"+RESET+" no has introducido un número entero.\n");
          entrada.next(); // Consumimos la entrada
      } else {
        conjunto = entrada.nextInt();
        if(conjunto == -1) { // Salimos del programa
          salir = true;
          break;
        } else if(conjunto < 0) { // Error negativo
          System.out.println(ROJO+"\nError:"+RESET+" el número introducido es negativo\n");
        } else {
          break;
        }
      }
    } while (!salir);


    /* Pedimos al usuario el subconjunto */
    while (!salir) {
      System.out.println("Introduce el número para el Subconjunto:");

      if(!entrada.hasNextInt()){ // Si no es un entero
          System.out.println(ROJO+"\nError:"+RESET+" no has introducido un número entero.\n");
          entrada.next(); // Consumimos la entrada
      } else {
        subconjunto = entrada.nextInt();
        if(subconjunto == -1) { // Salimos del programa
          salir = true;
          break;
        } else if(subconjunto<0) { // Error negativo
          System.out.printf(ROJO+"\nError:"+RESET+" el número introducido es negativo\n\n");
        } else if(subconjunto>conjunto) { // Error subconjunto mayor a conjunto
          System.out.println(ROJO+"\nError:"+RESET+" el número introducido mayor que el conjunto\n");
        } else {
          break;
        }
      }
    }

    if(salir == false) { // Si el usuario no ha indicado Salir

      // Cálculo:
      int resultado = factorial(conjunto) / (factorial(subconjunto) * (factorial(conjunto - subconjunto)));

      // Resultados al usuario:
      System.out.println("\nRESULTADO: El número de formas que podemos elegir " + AZUL + subconjunto + RESET + " elementos de un conjunto de " + AZUL + conjunto + RESET + ", es de: " + AZUL + resultado + RESET + " combinaciones.");
    }

    System.out.println("¡Hasta pronto!\n"); // Despedida

    entrada.close(); // Cerramos el programa
  }


  // Función de cálculo factorial recursiva
  public static int factorial(int numero) {
    // Caso de que valga 0 o 1
    if (numero == 0 || numero == 1) return 1;
    // Resto de casos
    return numero * factorial(numero - 1);
  }

}

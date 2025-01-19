package t1.simulacros.simulacro01;

import java.util.Scanner;

public class BuscaManzapanes {

  public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);

    int[][] tablero = new int[4][4];
		int intentos = 8;
		int aciertos = 0;

    // Rellenar el tablero

		for(int i=0; i < tablero.length; i++) {
			for(int j=0; j<tablero[i].length;j++) {
				tablero[i][j] = 0;
			}
		}

    // Colocar posiciones

    tablero[0][1] = 1;
		tablero[0][2] = 1;
		tablero[0][3] = 1;

    // Comienzo del programa

    System.out.println("Bienvenido al Buscador de Mazapanes");

		while(intentos != 8 || aciertos != 3) {

      System.out.println("Introduce la fila que quieres descubrir del 1 al 4:");
			int filaUsuario = entrada.nextInt()-1;

      if(filaUsuario < 0 || filaUsuario >3) {
				System.out.println("-ERROR- El número está fuera de los parámetros.");
				continue;
			}

      System.out.println("Introduce la columna que quieres descubrir del 1 al 4:");
			int columnaUsuario = entrada.nextInt()-1;

			if(columnaUsuario < 0 || filaUsuario >3) {
				System.out.println("-ERROR- El número está fuera de los parámetros.");
				continue;
			}

      switch(tablero[filaUsuario][columnaUsuario]) {
				case 2:
					System.out.println("\n-ERROR- Ya has comprobado esta posición.");
					break;

        case 1:
					intentos--;
					aciertos++;
					tablero[filaUsuario][columnaUsuario] = 2;
					System.out.println("\n¡ACIERTO!");
					System.out.println("- Te quedan: "+intentos+" intentos.");
					System.out.println("- Te quedan: "+(3-aciertos)+" mazapanes por encontrar.\n\n");
					break;

        default:
					intentos--;
					tablero[filaUsuario][columnaUsuario] = 2;
					System.out.println("\n¡ERROR!");
					System.out.println("- Te quedan: "+intentos+" intentos.");
					System.out.println("- Te quedan: "+(3-aciertos)+" mazapanes por encontrar.\n\n");

        }

		}

    if(aciertos==3) {
			System.out.println("¡Enhorabuena! has ganado.");
			System.out.println("Que pases felices fiestas.");
		} else {
			System.out.println("¡Lástima! has perdido.");
			System.out.println("Que pases felices fiestas.");
		}

    entrada.close();

	}

}

package t1.clases.clase241030;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuDeSeleccion {

  	public static void main(String[] args) {
        // Enunciado:
        // Escribe un programa que solicite al usuario elegir una opción de un menú:
        // 1. Saludar
        // 2. Despedirse
        // 3. Decir el día de la semana
        // 4. Salir
        // Dependiendo de la opción seleccionada, el programa debe imprimir el mensaje correspondiente.

		System.out.println("Hola usuario, elige una de estas 4 opciones (poniendo solo el número correspondiente):");
		System.out.println("1. Saludar");
		System.out.println("2. Despedirse");
		System.out.println("3. Decir el día de la semana");
		System.out.println("4. Salir");

		Scanner escaner = new Scanner(System.in);
		int opcion;

		do {

			opcion = escaner.nextInt();

			if(opcion==1) {
				System.out.println("Hola");
			} else if (opcion==2) {
				System.out.println("Adiós");
			} else if (opcion==3) {
				LocalDate fechaDeHoy = LocalDate.now();
				DayOfWeek diaDeLaSemana = fechaDeHoy.getDayOfWeek();
	//			String diaCastellano = diaDeLaSemana.getDisplayName(textStyle.FULL, new Locale("es", "ES"));
				System.out.println("Hoy es "+diaDeLaSemana);
			} else if (opcion==4) {
				System.out.println("Saliendo...");
			} else {
				System.out.println("Haz el favor y pon un número correcto la próxima vez, que son solo 4 números");
			}
		} while (opcion > 4 || opcion == 0);

		escaner.close();
	}

}

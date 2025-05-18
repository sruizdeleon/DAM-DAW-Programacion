package t3.simulacros.misolucion;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistroNombres {

  public static void main(String[] args) {
    Scanner escaner = new Scanner(System.in);
    String entrada = "";
    ArrayList<String> nombres = new ArrayList<>();

    while (true) {
      while (!entrada.equals("fin") || !entrada.equals("Fin")) {
        System.out.println("Escribe un nombre:");
        entrada = escaner.nextLine();

        if(entrada.equals("fin") || entrada.equals("Fin")) {
          break;
        } else if (nombres.contains(entrada)) {
          System.out.println("El nombre ya estaba en la lista");
        } else {
          nombres.add(entrada);
        }
      }

      int contador = 1;
      System.out.println("--- LISTA DE NOMBRES ---");
      for (String nombre : nombres) {
        System.out.println(contador + ". - " + nombre);
        contador++;
      }
      break;
    }
    escaner.close();
  }


}

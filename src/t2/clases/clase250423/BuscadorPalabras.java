package t2.clases.clase250423;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuscadorPalabras {

  @SuppressWarnings("ConvertToTryWithResources")
  public static void main(String[] args) throws FileNotFoundException {
    // Creamos un objeto scanner para leer de teclado (System.in)
    Scanner entrada = new Scanner(System.in);

    System.out.println("Introduce la palabra que quieres buscar:");
    String palabraBuscada = entrada.nextLine();

    String rutaFichero = "src\\t2\\clases\\clase250423\\palabrasParaBuscar.txt";

    // Creamos un objeto scanner para leer de un fichero (File)
    try(Scanner lectorFichero = new Scanner(new File(rutaFichero))) {
      int numeroLinea = 1;
      int contador = 0;

      while(lectorFichero.hasNextLine()) {
        // Guardamos la siguiente línea
        String linea = lectorFichero.nextLine();

        // Búsqueda de la palabra
        if(linea.contains(palabraBuscada)) {
          System.out.println("Línea: " + numeroLinea + "- \"" + linea + "\"");
          contador++;
        }
        numeroLinea++;
      }

      System.out.println();
      System.out.println("El número de veces que ha aparecido el texto \"" + palabraBuscada + "\": " + contador);

    }catch (FileNotFoundException e) {
      System.err.println("No se encontró el fichero:" + e.getMessage());
    }
    entrada.close();
  }
}

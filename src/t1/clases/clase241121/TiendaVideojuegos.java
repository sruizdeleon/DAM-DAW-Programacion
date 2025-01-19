package t1.clases.clase241121;

import java.util.Scanner;

public class TiendaVideojuegos {

  public static void main(String[] args) {
    /*
      * El inventario de la tienda comienza con los siguientes videojuegos:
      *    | Categoría | Videojuego 1 | Videojuego 2 | Videojuego 3 |
      *  |--------------------|--------------------|-----------------|-------------------|
      *  | Acción | Call of Duty | Halo | Battlefield |
      *  | Deportes | FIFA | NBA 2K | Madden NFL |
      *   | RPG | Final Fantasy | Zelda | Skyrim |
      */
    String[][] games = {
            {"call of duty", "halo", "battlefield"}, // Acción
            {"fifa","nba 2k", "madden nfl"},         // Deportes
            {"final fantasy", "zelda", "skyrim"}     // RPG
            };
    final String RESET = "\u001B[0m";
    final String FONDO_AZUL = "\u001B[44m";
    final String LETRA_BLANCA = "\u001B[97m";
    final String LETRA_ROJA = "\u001B[31m";
    final String LETRA_VERDE = "\u001B[32m";
    final String LETRA_AMARILLA = "\u001B[33m";

    Scanner entrada = new Scanner(System.in);
    int opcion;

    do {
      System.out.println("--- MENÚ PRINCIPAL ---\r\n"
              + "1. Mostrar inventario\r\n"
              + "2. Añadir o actualizar videojuego\r\n"
              + "3. Salir\r\n"
              + "Elige una opción: ");
      opcion = entrada.nextInt();


      switch (opcion) {
          case 1:
            System.out.println("\n--- INVENTARIO ---");
            System.out.printf(FONDO_AZUL + LETRA_BLANCA + "%-15s %-15s %-15s %n" + RESET,
                "Categoría 1",
                "Categoría 2",
                "Categoría 3");
            for(int fila = 0; fila < games.length; fila++) {
              System.out.printf(LETRA_ROJA+"%-15s"+LETRA_VERDE+"%-15s"+LETRA_AMARILLA+"%-15s"+RESET+"%n",
              games[fila][0].toLowerCase().trim(),
              games[fila][1].toLowerCase().trim(),
              games[fila][2].toLowerCase().trim());
            }

          case 2:
            System.out.println("\n--- ACTUALIZAR VIDEOJUEGO ---");
            System.out.println("\nDime la categoría (1-3):\n");
            int categoria = entrada.nextInt()-1;
            System.out.println("\nDime el índice (1-3):\n");
            int indice = entrada.nextInt()-1;
            System.out.println("\nIndica el nuevo nombre del juego");
            entrada.nextLine();
            String valor = entrada.nextLine().toLowerCase().trim();
            games[categoria][indice] = valor;


            System.out.println("\n--- INVENTARIO ---");
            System.out.printf(FONDO_AZUL + LETRA_BLANCA + "%-15s %-15s %-15s %n" + RESET,
                "Categoría 1",
                "Categoría 2",
                "Categoría 3");
            for(int fila = 0; fila < games.length; fila++) {
              System.out.printf(LETRA_ROJA+"%-15s"+LETRA_VERDE+"%-15s"+LETRA_AMARILLA+"%-15s"+RESET+"%n",
              games[fila][0].toLowerCase().trim(),
              games[fila][1].toLowerCase().trim(),
              games[fila][2].toLowerCase().trim());
            }

          case 3:
            System.out.println("Saliendo del manú...");
            break;

          default:
              System.out.println("Dame un número entre el 1 el 3, el resto no vale. Opción incorrecta.");

    }

    }  while(opcion != 3);

    entrada.close();


  }

}

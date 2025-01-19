package t1.clases.clase241120;

public class TablaProductos {

  public static void main(String[] args) {
    // Ejercicio 3: Formatear una tabla de productos
    // Imprime una tabla con columnas alineadas que muestre nombres de productos,
    // cantidades y precios. Utiliza printf y códigos de formato.

    final String FONDO_NEGRO = "\u001B[40m";
    final String NEGRO = "\u001B[30m";
    final String FONDO_BLANCO = "\u001B[47m";
    final String FONDO_VERDE = "\u001B[42m";
    final String VERDE = "\u001B[32m";
    final String FONDO_CELESTE = "\u001B[46m";
    final String CELESTE = "\u001B[36m";
    final String RESET = "\u001B[0m";


    System.out.printf(FONDO_NEGRO+"%-20s"+FONDO_CELESTE+"%-10s"+FONDO_VERDE+"%-10s"+RESET+"%n", "PRODUCTO", "CANTIDAD", "PRECIO");
      System.out.printf(FONDO_BLANCO+NEGRO+"%-20s"+CELESTE+"%6d Uds"+VERDE+"%8.2f €"+RESET+"%n", "Zapatillas", 30, 95.99);
      System.out.printf(FONDO_BLANCO+NEGRO+"%-20s"+CELESTE+"%6d Uds"+VERDE+"%8.2f €"+RESET+"%n", "Chandal", 14, 34.01);
      System.out.printf(FONDO_BLANCO+NEGRO+"%-20s"+CELESTE+"%6d Uds"+VERDE+"%8.2f €"+RESET+"%n", "Gorra", 62, 15.95);
      System.out.printf(FONDO_BLANCO+NEGRO+"%-20s"+CELESTE+"%6d Uds"+VERDE+"%8.2f €"+RESET+"%n", "Pantalon", 5, 32.0);
      System.out.printf(FONDO_BLANCO+NEGRO+"%-20s"+CELESTE+"%6d Uds"+VERDE+"%8.2f €"+RESET+"%n", "Cordones", 1000, 3.92);

  }




}

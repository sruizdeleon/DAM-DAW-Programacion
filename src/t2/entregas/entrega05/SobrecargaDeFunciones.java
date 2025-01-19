package t2.entregas.entrega05;

public class SobrecargaDeFunciones {

  /* ENUNCIADO */

  // Crea un programa que implemente una función sobrecargada llamada "calcular" que realice las siguientes operaciones dependiendo del tipo de parámetro recibido:

  // - Media (int[]): Calcula la media de un arreglo de números enteros.
  // - Moda (double[]): Encuentra el valor más frecuente en un arreglo de números decimales.
  // - Mediana (String[]): Determina la mediana (orden alfabético) de un arreglo de cadenas.

  /* Requisitos: */

  // - Implementa tres versiones de la función "calcular" para manejar enteros, decimales y cadenas.
  // - Muestra ejemplos para cada caso.

  public static void main(String[] args) {

    /* EJEMPLO PARA MEDIA */
    // Usar esta parte del código para comprobar la función de Calcular para media

    int[] media = {8, 8, 6};
    System.out.println("La media es: " + calcular(media));

    /* Fin de comprobación de media */



    /* EJEMPLO PARA MODA */
    // Usar esta parte del código para comprobar la función de Calcular para moda

    // double[] moda = {1, 1, 3, 5, 3, 5, 6};
    // System.out.println("El número más repetido es: " + calcular(moda));

    /* Fin de comprobación de moda */



    /* EJEMPLO PARA MEDIANA */
    // Usar esta parte del código para comprobar la función de Calcular para mediana

    // String[] mediana = {"AB", "AC", "AA", "AD"};
    // String[] resultado = calcular(mediana);
    // System.out.println("El resultado es:");
    // for (String item : resultado) {
    //     System.out.println(" "+item);
    // }

    /* Fin de comprobación de mediana */

  }

  public static float calcular(int[] listado) {
    float suma = 0;
    for (int i = 0; i < listado.length; i++) {
        suma += listado[i];
    }
    return suma / listado.length;
  }

  public static double calcular(double[] listado) {

    double[] numeroMasRepetido = {0, 0};
    for (double numero : listado) {
      double contador = 0;
        for (double numeroAux : listado) {
            if(numeroAux == numero) {
              contador++;
            }
        }
      if(contador>numeroMasRepetido[1]) {
        numeroMasRepetido[0] = numero;
        numeroMasRepetido[1] = contador;
      }
    }

    return numeroMasRepetido[0];
  }

  public static String[] calcular(String[] listado) {
    if(listado.length == 0) return listado;
    if(listado.length == 1) return listado;

    for (int i = 0; i < listado.length - 1; i++) {
      for (int j = 0; j < listado.length - 1; j++) {
        String palabraActual = listado[j].toUpperCase();
        String palabraSiguiente = listado[j+1].toUpperCase();

        if(palabraActual.compareTo(palabraSiguiente) > 0){
          String auxiliar = listado[j];
          listado[j] = listado[j+1];
          listado[j+1] = auxiliar;
        }
      }
    }

    for (String item : listado) {
      System.out.println(item);
    }

    if(listado.length % 2 == 0){
      String[] resultado = { listado[(listado.length/2)-1], listado[listado.length/2]};
      return resultado;
    } else {
      int posicionCentral = (int) Math.floor(listado.length/2);
      String[] resultado = { listado[posicionCentral]};
      return resultado;
    }

  }


}

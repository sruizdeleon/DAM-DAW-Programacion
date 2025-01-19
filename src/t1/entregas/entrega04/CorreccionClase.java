package t1.entregas.entrega04;

public class CorreccionClase {
  public static void main(String[] args) {

		final String ROJO = "\u001B[31m";
		final String AZUL = "\u001B[34m";
		final String RESET = "\u001B[0m";
		int[][] tablero = new int[5][5];
		int[][] tableroVisible = new int[5][5];

    System.out.println(ROJO + AZUL + RESET);
		System.out.println(tablero);
		System.out.println(tableroVisible);

	}
}

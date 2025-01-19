package t1.entregas.entrega04;

import java.util.Random;
import java.util.Scanner;

public class BatallaNavalSimplificada {

  	public static void main(String[] args) {
		
		
		/*
		 * Vas a programar una versión simplificada de Batalla Naval. El programa generará un tablero de 5x5 en el que se ocultarán barcos y el usuario intentará adivinar sus posiciones.
		 * Requisitos del Programa
		 * Generar el tablero:
		 * 
		 * Crea un array bidimensional de 5x5 que represente el tablero.
		 * Llena el tablero con ceros 0.
		 * Coloca aleatoriamente 3 barcos representados por el número 1.
		 * (OPCIONAL) Añade el nombre de cada fila y columna, usando para ello las opciones de formato que viste en clase el otro día. 
		 * Juego del usuario:
		 * 
		 * Pide al usuario que introduzca las coordenadas (fila y columna) para intentar "disparar" a un barco.
		 * Si acierta, muestra un mensaje como "¡Tocado!" y marca la posición con una X roja.
		 * Si falla, muestra "Agua" y marca la posición con un ~  (alt gr + 4) azul.
		 * (OPCIONAL) Por supuesto, si quieres adornarlo aún más, eres bienvenido de hacerlo. Lo valoraré positivamente para compensar posibles errores. 
		 * Condiciones:
		 * 
		 * El usuario tiene un máximo de 10 intentos.
		 * Si encuentra los 3 barcos antes de que se acaben los intentos, el juego termina y se muestra "¡Victoria!".
		 * Si se agotan los intentos sin encontrar todos los barcos, muestra "Derrota. Los barcos estaban en estas posiciones:" seguido del tablero con las posiciones reveladas.
		 * Salida del tablero:
		 * 
		 * Después de cada turno, muestra el tablero actualizado. Solo las posiciones que el usuario ha adivinado deben revelarse.
		 * */


		/* VARIABLES DE FORMATO */		

		// Formato de fondo
		String FONDO_ROJO = "\u001B[41m";
		String FONDO_VERDE = "\u001B[42m";
		String FONDO_BLANCO = "\u001B[47m";
		String FONDO_AMARILLO = "\u001B[43m";
		String FONDO_AZUL = "\u001B[46m";
		String FONDO_NEGRO = "\u001B[40m";
		// Formato de texto
		String TEXTO_NEGRO = "\u001B[30m";
		// Restaurar formato
		String RESET = "\u001B[0m";		


		/* VARIABLES DE FORMATO */

		// Entrada de usuario
		Scanner escaner = new Scanner(System.in);
		// Generar número aleatorio
		Random numeroAleatorio = new Random();
		// Control del programa activo
		boolean cerrarPrograma = false;
		
		
		/* INICIO DE PROGRAMA */
		
		while(!cerrarPrograma) {
			
			/* ESTABLECIMIENTO DE POSICIÓN BARCOS */
			
			int[] posicionesBarcos = new int[3]; // Creamos un array para guardar las 3 posiciones de los 3 barcos
			boolean posicionGuardada = false; // Flag para saber cuando ha finalizado el bucle
			
			// Por cada una de las 3 posiciones iteramos
			for(int index = 0; index < posicionesBarcos.length; index++) {
	
				posicionGuardada = false; // Flag para saber que la posición se ha guardado con éxito.
				
				// Hasta que no haya una posición nueva guardada no paro de generar posiciones aleatoria
				while (posicionGuardada == false) {

					int posiblePosicion = (numeroAleatorio.nextInt(25) + 1); // Aleatorio entre 1 y 25 empezando por filas de izquierda a derecha.
					boolean laPosicionYaExiste = false; // Flag para saber si el número posible ya está guardado o es nuevo
					
					// Comprobación que el número posible no esté ya guardad
					for(int index2 = 0; index2 < posicionesBarcos.length; index2++) {
						if(posicionesBarcos[index2] == posiblePosicion) {
							laPosicionYaExiste = true;
						}
					}
					
					
					if(laPosicionYaExiste) { // Si existe volvemos al inicio y generamos nuevo número aleatorio
						continue;
					} else { // Si no existe guardamos la posición
						posicionesBarcos[index] = posiblePosicion;
						// Si necesitamos un chivato para saber dónde están los barcos
						// System.out.println("Barco "+index+": "+posiblePosicion);
						posicionGuardada = true;
						break;
					}
					
				}
			}
			
			
			
			
			/* CREACIÓN DE TABLERO */
			
			char[][] tablero = new char[5][5]; // Matriz multidimensional de 5x5
			
			// Rellenamos la matriz con todo 0
			for(byte columna = 0; columna < tablero[0].length; columna++) {
				for(byte fila = 0; fila < tablero.length; fila++) {
					tablero[fila][columna] = '0';
				}
			}
			
			
			/* CARGA DE PARÁMETROS DEL PROGRAMA */
			
			boolean reiniciarPrograma = false; 	// Variable para el reinicio del programa
			String entradaUsuario; 				// Variable para guardar los input del usuario
			byte numeroIntentos = 10;			// Contador de intentos
			byte barcosVivos = 3;				// Contador de barcos vivos
			
			
			
			/* INICIO DEL JUEGO */
			
			while (!cerrarPrograma && !reiniciarPrograma) { // Mientras las flag de cerrarPrograma y reiniciarPrograma sean falsas
				
				// Mensaje inicial
				System.out.printf(FONDO_AZUL+"%-90s%n"+RESET, "¡Hola! Te damos la bienvenida a Batalla Naval.");
				System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-90s%n"+"%-90s%n"+"%-90s%n"+"%-90s%n"+"%-90s%n"+"%-90s%n"+"%-90s%n"+"%-90s%n%n"+RESET,
						"Deberás introducir las coordenadas de la posición a la que quieres mandar un proyectil.",
						"Para ello tienes que escribir una letra mayúscula entre la A-E y un número entre el 1-5.",
						"Puedes ayudarte del índice de las filas y columnas para crear esta posición.",
						"En cualquier momento podrás:",
						"- Escribir \"Reiniciar\" para reiniciar el juego.",
						"- Escribir \"Salir\" para cerrar el juego.",
						"",
						"Cuando estés preparado/a escribe \"Empezar\" para comenzar el juego.");
				
				// Entrada de usuario
				entradaUsuario = escaner.next();
				
				// Comandos control del programa
				if(entradaUsuario.equals("Salir")) {
					cerrarPrograma = true;
					continue;
				} else if (entradaUsuario.equals("Reiniciar")) {
					reiniciarPrograma = true;
					continue;
				} else if (entradaUsuario.equals("Empezar")) {
					
					/* USUARIO INICIA JUEGO */
					
					while (!cerrarPrograma && !reiniciarPrograma) {  // Mientras las flag de cerrarPrograma y reiniciarPrograma sean falsas
						

						/* IMPRESIÓN DEL TABLERO*/

						System.out.printf(FONDO_AZUL+"\n\n%-21s\n"+RESET, "       TABLERO       ");
						System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s%-3s%-3s%-3s%-3s%-3s%-3s\n"+RESET, "   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", "   ");
						for(byte fila = 0; fila < tablero.length; fila++) {
							String letra = "";
							switch(fila) {
								case 0:
									letra = "A";
									break;
								case 1:
									letra = "B";
									break;
								case 2:
									letra = "C";
									break;
								case 3:
									letra = "D";
									break;
								case 4:
									letra = "E";
									break;							
							}
								System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s"+RESET, " "+letra+" ");
							for(byte columna = 0; columna < tablero[0].length; columna++) {
								if(tablero[fila][columna] == '~') {
									System.out.printf(FONDO_AZUL+"%-3s"+RESET, "[~]");								
								} else if (tablero[fila][columna] == 'X') {
									System.out.printf(FONDO_ROJO+"%-3s"+RESET, "[X]");																
								} else {
									System.out.printf(FONDO_NEGRO+"%-3s"+RESET, "[0]");								
								};
								
								if(columna == 4) {
									System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s"+RESET, " "+letra+" ");
								}
							}
							System.out.printf("%n");						
						}
						System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s%-3s%-3s%-3s%-3s%-3s%-3s\n"+RESET, "   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", "   ");

						
						/* IMPRESIÓN DE INSTRUCCIONES */

						System.out.printf(FONDO_VERDE+"%n%-90s%n"+RESET, "INSTRUCCIONES:");
						System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-90s%n%-90s%n%-90s%n%n"+RESET,
								"Te quedan: "+numeroIntentos+" intentos y "+barcosVivos+" barcos por destruir.",
								"Introduce una posición con el formato letra mayúscula y número (Ej:\"A1\")",
								"o escribe Salir para finalizar el juego.");
	
						// Entrada de usuario - posición del tablero
						entradaUsuario = escaner.next();

						
						if(entradaUsuario.length() != 2) { // Comprobación longitud de coordenadas correcta
							if(entradaUsuario.equals("Salir")) { // Comprobación que el usuario quiera Salir
								cerrarPrograma = true;
								continue;
							} else if (entradaUsuario.equals("Reiniciar")) { // Comprobación que el usuario quiera Reiniciar
								reiniciarPrograma = true;
								continue;
							} else { // Mensaje de error
								System.out.printf(FONDO_ROJO+"%n%-6s"+FONDO_BLANCO+TEXTO_NEGRO+"%-84s"+RESET,
										"ERROR:",
										" no has introducido una posición correcta.");
							}
						} else { // Longitud correcta, comprobación de formato de letra y número correcto
							
							char letraPosicion = entradaUsuario.charAt(0); 	// Guardamos primer caracter
							char numeroPosicion = entradaUsuario.charAt(1); // Guardamos segundo caracter
							byte numeroFila = 0;							// Variable para guardar la fila de la letra
							byte numeroColumna = 0;							// Variable para guardar la columna del número
							boolean coordenadasCorrectas = true;			// Flag para saber si las coordenadas eran correctas
	
							// Transformación de letra en número de fila
							switch(letraPosicion) {
								case 'A':
									numeroFila = 0;
									break;
								case 'B':
									numeroFila = 1;
									break;
								case 'C':
									numeroFila = 2;
									break;
								case 'D':
									numeroFila = 3;
									break;
								case 'E':
									numeroFila = 4;
									break;
								default:
									coordenadasCorrectas = false; // Si no está en el rango la coordenada no es correcta
							}
							

							// Transformación de número en número de columna
							switch(numeroPosicion) {
								case '1':
									numeroColumna = 0;
									break;
								case '2':
									numeroColumna = 1;
									break;
								case '3':
									numeroColumna = 2;
									break;
								case '4':
									numeroColumna = 3;
									break;
								case '5':
									numeroColumna = 4;
									break;
								default:
									coordenadasCorrectas = false; // Si no está en el rango la coordenada no es correcta								
							}
							
							
							// Si las coordenadas están fuera de rango, mensaje de error
							if(!coordenadasCorrectas) {
								System.out.printf(FONDO_ROJO+"%n%-6s"+FONDO_BLANCO+TEXTO_NEGRO+"%-84s"+RESET,
										"ERROR:",
										" no has introducido una posición correcta.");
								continue;
							}
							

							// Comprobación que las coordenadas no se hayan introducido anteriormente
							if(tablero[numeroFila][numeroColumna] == '~' || tablero[numeroFila][numeroColumna] == 'X') {
								System.out.printf(FONDO_ROJO+"%n%-6s"+FONDO_BLANCO+TEXTO_NEGRO+"%-84s"+RESET,
										"ERROR:",
										" ya habías disparado en esa posición.");
								continue;							
							}
							
							
							// Determinar posición del disparo							
							byte posicionDisparo = (byte) ((numeroColumna + 1) + (numeroFila * 5));
							
							
							boolean disparoAcertado = false; // Flag para comprobar el acierto del disparo

							// Comprobar si acierta el disparo
							for(byte posicion = 0; posicion < posicionesBarcos.length; posicion++) {
								if(posicionesBarcos[posicion] == posicionDisparo) {
									disparoAcertado = true; // Si acierta
									break;
								}
							}

							
							if(disparoAcertado) { 									// Si ha acertado
								tablero[numeroFila][numeroColumna] = 'X';				// Guardamos la X en la posición
								numeroIntentos--;										// Reducimos los intentos
								barcosVivos--;											// Reducimos los barcos vivos
								System.out.printf(FONDO_ROJO+"¡TOCADO!"+RESET);		// Mensaje de Tocado
							} else {												// Si falla
								tablero[numeroFila][numeroColumna] = '~';				// Guardamos el ~ como fallo en la posición
								numeroIntentos--;										// Reducimos los intentos
								System.out.printf(FONDO_AZUL+"¡AGUA!"+RESET);			// Mensaje de Agua
							}
						}
						
						
						/* COMPROBACIÓN DE INTENTOS Y BARCOS */
						
						if(numeroIntentos == 0 || barcosVivos == 0) { // Si los intentos o barcos son 0
							
							// Si son los barcos los que han llegado a 0
							if(barcosVivos == 0) {
								// Mensaje de Victoria y enhorabuena
								System.out.printf(FONDO_VERDE+"\n\n¡VICTORIA!"+RESET);
								System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"\nEnhorabuena has ganado la partida."+RESET);
							}
							// Si son los intentos lo que han llegado a 0
							else {
								// Mensaje de Derrota
								System.out.printf(FONDO_ROJO+"\n\n¡DERROTA!"+RESET);
								System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"\nLos barcos estaban en estas posiciones:"+RESET);
								System.out.printf(FONDO_ROJO+"%n%-3s"+FONDO_BLANCO+TEXTO_NEGRO+"%-17s%n"+RESET, "[1]", ": aciertos conseguidos: "+(3-barcosVivos));
								System.out.printf(FONDO_AMARILLO+TEXTO_NEGRO+"%-3s"+FONDO_BLANCO+"%-17s%n"+RESET, "[1]", ": barcos no destruidos: "+barcosVivos);
								System.out.printf(FONDO_AZUL+"%-3s"+FONDO_BLANCO+TEXTO_NEGRO+"%-17s%n"+RESET, "[~]", ": disparos fallados.");

								
								// Desvelamos las posiciones de los barcos
								byte posicionEnElTablero = 1; // Variable para guardar la posición en número del bucle
								
								// Impresión del tablero
								// Titulo del tablero
								System.out.printf(FONDO_AZUL+"\n\n%-21s\n"+RESET, "       TABLERO       ");
								// Leyenda de columnas
								System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s%-3s%-3s%-3s%-3s%-3s%-3s\n"+RESET, "   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", "   ");
								for(byte fila = 0; fila < tablero.length; fila++) {
									
									// Leyenda de filas
									String letra = "";
									switch(fila) {
										case 0:
											letra = "A";
											break;
										case 1:
											letra = "B";
											break;
										case 2:
											letra = "C";
											break;
										case 3:
											letra = "D";
											break;
										case 4:
											letra = "E";
											break;							
									}
									
									// Impresión de letra de fila
									System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s"+RESET, " "+letra+" ");
									
									for(byte columna = 0; columna < tablero[0].length; columna++) {

										boolean hayBarcoEnLaPosicion = false;
										
										// Comprobación si hay barco en la posición actual
										for(byte posicionBarco = 0; posicionBarco < posicionesBarcos.length; posicionBarco++) {
											if(posicionesBarcos[posicionBarco] == posicionEnElTablero) {
												hayBarcoEnLaPosicion = true;
											}
										}
										
										// Casos de impresión
										switch(tablero[fila][columna]) {
											case '~':
												System.out.printf(FONDO_AZUL+"%-3s"+RESET, "[~]");								
												break;
											case 'X':
												System.out.printf(FONDO_ROJO+"%-3s"+RESET, "[1]");																
												break;
											default: {
												// Si hay barco lo colocamos como un 1
												if(hayBarcoEnLaPosicion) {
													System.out.printf(FONDO_AMARILLO+TEXTO_NEGRO+"%-3s"+RESET, "[1]"); // Imprimimos los restantes en amarillo								
												}
												// Si no hay barco lo colocamos como 0
												else {
													System.out.printf(FONDO_NEGRO+"%-3s"+RESET, "[0]");	
												}
											}												
										}
										
										posicionEnElTablero++;
										
										// Si es la columna 4 añadimos la leyenda de columnas del lado derecha
										if(columna == 4) {
											System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s"+RESET, " "+letra+" ");
										}
									}
									System.out.printf("%n");						
								}
								// Leyenda de columnas inferior
								System.out.printf(FONDO_BLANCO+TEXTO_NEGRO+"%-3s%-3s%-3s%-3s%-3s%-3s%-3s\n"+RESET, "   ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", "   ");
								
							}
							
							
							/* ACCIONES SI HA TERMINADO EL JUEGO */

							while(!cerrarPrograma && !reiniciarPrograma) {
								
								// Instrucciones
								System.out.printf(FONDO_AZUL+"%n%-90s%n"+RESET+FONDO_BLANCO+TEXTO_NEGRO+"%-90s%n%-90s%n%n"+RESET,
										"¿Quieres volver a jugar?",
										"Escribe \"Reiniciar\" si quieres volver a jugar.",
										"Escribe \"Salir\" si quieres cerrar el juego.");
								
								// Entrada de usuario
								entradaUsuario = escaner.next();
								
								// Opción de Salir
								if(entradaUsuario.equals("Salir")) {
									cerrarPrograma = true;
									continue;
								}
								// Opción de Reinicio
								else if (entradaUsuario.equals("Reiniciar")) {
									reiniciarPrograma = true;
									continue;
								}
								// Control de error del comando
								else {
									System.out.printf(FONDO_ROJO+"%n%-6s"+FONDO_BLANCO+TEXTO_NEGRO+"%-84s%n"+RESET,
											"ERROR:",
											" no has introducido un comando correcto.");
								}
								
							}
													
						}
					}		
					
				}
				// Control de error en el inicio del programa, fuera de las opciones Empezar o Salir
				else {
					System.out.printf(FONDO_ROJO+"%n%-6s"+FONDO_BLANCO+TEXTO_NEGRO+"%-84s%n%-90s%n%n"+RESET,
							"ERROR:",
							"parece que no has introducido uno de los dos comandos correctamente.",
							"Vuelve a leer las instrucciones e introduce el comando.");
				}
			};
		};
		
		// Cerramos la entrada de datos
		escaner.close();

		
	}


}

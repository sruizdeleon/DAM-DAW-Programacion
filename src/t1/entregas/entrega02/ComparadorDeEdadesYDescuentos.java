package t1.entregas.entrega02;

public class ComparadorDeEdadesYDescuentos {

      /**
    *
    * Declara cuatro variables de tipo int para representar las edades de cuatro personas.
    * Declara una variable double para representar el precio original de un producto, y una variable int para representar el descuento en porcentaje.
    * Usa operadores booleanos para comparar las edades de las personas y establecer quién es la más joven y quién es la mayor. (Asume que no hay edades iguales para simplificarlo.)
    * Aplica el descuento solo si al menos dos personas son mayores de 18 años. En caso contrario, el precio del producto queda sin descuento.
    * Realiza un casting explícito para convertir el descuento de int a double y luego aplica el descuento en el precio original.
    * Imprime el precio final del producto y menciona si el descuento fue aplicado o no.
    *
    */
    public static void main(String[] args) {

  // Grupo de personas
    int persona1 = 29;
    int persona2 = 14;
    int persona3 = 21;
    int persona4 = 23;

    // Detalle de precios
    double precio = 19.99;
    int descuento = 30;

    // Revisamos quien es la persona mas mayor e imprimimos su valor

    // Iniciamos con la persona1
    int elMasMayor = persona1;
    int nPersona = 1;

    // Vamos comparando con todas las personas, si son mayores se guarda el nuevo resultado. 
    if(persona2 > elMasMayor){
        elMasMayor = persona2;
        nPersona = 2;
    }
    if(persona3 > elMasMayor){
        elMasMayor = persona3;
        nPersona = 3;
    }
    if(persona1 > elMasMayor){
        elMasMayor = persona4;
        nPersona = 4;
    }

    System.out.println("La persona con más edad es la Persona" + nPersona + " y tiene: " + elMasMayor + " años.");

    // Revisamos quien es la persona mas joven e imprimimos su valor

    // Iniciamos con la persona1
    int elMasJoven = persona1;
    nPersona = 1;

    // Vamos comparando con todas las personas, si son menores se guarda el nuevo resultado. 
    if(persona2 < elMasJoven){
      elMasJoven = persona2;
        nPersona = 2;
    }
    if(persona3 < elMasJoven){
      elMasJoven = persona3;
        nPersona = 3;
    }
    if(persona4 < elMasJoven){
      elMasJoven = persona4;
        nPersona = 4;
    }

    System.out.println("La persona con menos edad es la Persona" + nPersona + " y tiene: " + elMasJoven + " años.");

    // Numero de mayores de edad

    int nMayoresEdad = 0;

    // Restamos 18 y comprobamos que el numero sea mayor o igual a 0 para sumar un mayor de edad
    if((persona1 - 18) >= 0) {
      ++nMayoresEdad;
    }
    if((persona2 - 18) >= 0) {
      ++nMayoresEdad;
    }
    if((persona3 - 18) >= 0) {
      ++nMayoresEdad;
    }
    if((persona4 - 18) >= 0) {
      ++nMayoresEdad;
    }

    // Si hay más de 2 personas aplicamos el descuento

    double precioFinal;

    // Comprobamos cuantas personas mayores de edad hay
    if(nMayoresEdad >= 2) {
      // Hacemos el casting y guardamos el descuento decimal
      double descuentoDecimal = ((double)descuento) / 100;

      //Calculamos el precio final
      precioFinal = precio * descuentoDecimal;

      // Imprimimos el precio final
      System.out.println("Se aplica el descuento porque hay " + nMayoresEdad + " personas mayores de edad, el precio final es: " + precioFinal + "€");
    } else {
      // No hay descuento e imprimimos el precio final
      System.out.println("No se aplica el descuento porque hay " + nMayoresEdad + " personas mayores de edad, el precio final es: " + precio + "€");
    }

  }


}

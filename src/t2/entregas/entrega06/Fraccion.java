package t2.entregas.entrega06;

/**
 * Clase Fracción

 * La clase Fracción representa una división entre los atributos numerador y denominador.
 * Tiene métodos getter y setter para establecer los atributos y el método obtenerFraccion para obtener el string formador por el numerador y denominador.
 *
 * Atributos:
 * - numerador: es el dividendo de la fracción.
 * - denominador: es el divisor de la fracción.
 *
 * Métodos:
 * - obtenerFraccion(): devuelve el String con el "numerador/denominador"
 * - getNumerador(): devuelve el numerador de la fracción.
 * - setNumerador(): devuelve el numerador de la fracción.
 * - getDenominador(): devuelve el denominador de la fracción.
 * - setDenominador(): establece el denominador de la fracción.
 *
 * @author Sergio Ruiz de León Almuedo
 * @version 1.0
 * @since 26/01/2025
 */

public class Fraccion {


  /***********************************/
  /*            ATRIBUTOS            */
  /***********************************/
  // Los atributos son privados porque queremos tener el control y validacción de lo que se asigna a los atributos, por eso sólo podemos establecer valores con los constructores o setters, controlando lo que añade el usuario.
  private int numerador;
  private int denominador;


  /***********************************/
  /*         CONSTRUCTORES           */
  /***********************************/

  /**
   * Constructor sin parámetros que genera un fracción básica 0/1
   */
  public Fraccion() {
    this.numerador = 0;
    this.denominador = 1;
  }

  /**
   * Constructor que recibe numerador y genera una fracción con numerador dado y denominador 1
   *
   * @param numerdador numerador que se quiere dividir entre 1
   */
  public Fraccion(int numerador) {
    this.numerador = numerador;
    this.denominador = 1;
  }

  /**
   * Constructor que recibe numerador, denominador y genera una fracción con el numerador y denominador dados
   * @param numerador numerador que se quiere dividir
   * @param denominador denominador por el que se quiere dividir (diferente de 0)
   */
  public Fraccion(int numerador, int denominador) {
    if(denominador == 0){
      System.out.println("Error: no puedes utilizar un denominador 0");
    }
    if(denominador < 0) {
      this.numerador = -numerador;
      this.denominador = -denominador;
    } else {
      this.numerador = numerador;
      this.denominador = denominador;
    }
    simplificar();
  }


  /***********************************/
  /*             MÉTODOS             */
  /***********************************/


  /* Numerador */

  /**
   * Asignar valor al numerador
   * @param numerador asigna el valor de tipo int
   */
  public void setNumerador(int numerador) {
    this.numerador = numerador;
    simplificar();
  }

  /**
   * Obtener valor del numerador
   * @return devuelve el valor actual del numerador en tipo int
   */
  public int getNumerador() {
    return numerador;
  }


  /* Denominador */

  /**
   * Asignar valor al denominador
   * @param numerador asigna el valor al denominador de tipo int
   */
  public void setDenominador(int denominador) {
    if(denominador == 0) {
      System.out.println("Error: no puedes asignar un denominador igual a 0");
    }
    if(denominador < 0) {
      this.numerador= -this.numerador;
      this.denominador= -this.denominador;
    } else {
      this.denominador = denominador;
    }
    simplificar();
  }

  /**
   * Obtener valor del denominador
   * @return devuelve el valor actual del denominador en tipo int
   */
  public int getDenominador() {
    return denominador;
  }



  /***********************************/
  /*         OTROS MÉTODOS           */
  /***********************************/

  /**
   * Método para obtener fracción en String
   * @return devuelve la fracción en un String en formato "numerador/denominador"
   */
  public String obtenerFraccion() {
    return (denominador == 1) ? String.valueOf(numerador) : numerador + "/" + denominador;
  }

  /**
   * Método privado para calcular el Mínimo Común Divisor de un entero numerador a y un entero denominador b
   * @param a numerador a simplificar
   * @param b denominador a simplificar
   * @return devuelve el entero mínimo común divisor
   */
  private int calcularMCD(int a, int b) {
    while (b!=0) {
      int temporal = b;
      b = a % b;
      a = temporal;
    }
    return a;
  }


  /**
   * Método para simplificar la fracción dividiendo numerador y denominador por su máximo común divisor.
   *
   */
  public void simplificar() {
    int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
    numerador /= mcd;
    denominador/= mcd;
  }

  /**
   * Método para sumar a la fracción actual, la fracción otraFraccion pasada por parámetro
   * @param otraFraccion fracción que se quieres sumar
   * @return devuelve una nueva fracción con la suma de ambas fracciones
   */
  public Fraccion sumar(Fraccion otraFraccion) {
    int nuevoNumerador = this.numerador * otraFraccion.denominador + otraFraccion.numerador * this.denominador;
    int nuevoDenominador = this.denominador * otraFraccion.denominador;
    return new Fraccion(nuevoNumerador, nuevoDenominador);
  }

  /**
   * Método para restarle a la fracción actual la fracción otraFraccion pasada por parámetro
   * @param otraFraccion fracción por la que se quiere restar
   * @return devuelve una nueva fracción con la resta de ambas fracciones
   */
  public Fraccion restar(Fraccion otraFraccion) {
    int nuevoNumerador = this.numerador * otraFraccion.denominador - otraFraccion.numerador * this.denominador;
    int nuevoDenominador = this.denominador * otraFraccion.denominador;
    return new Fraccion(nuevoNumerador, nuevoDenominador);
  }

  /**
   * Método para multiplicar la fracción actual, con la fracción otraFraccion pasada por parámetro
   * @param otraFraccion fracción por la que se quiere multiplicar
   * @return devuelve una nueva fracción con la multiplicación de ambas fracciones
   */
  public Fraccion multiplicar(Fraccion otraFraccion) {
    int nuevoNumerador = this.numerador * otraFraccion.numerador;
    int nuevoDenominador = this.denominador * otraFraccion.denominador;
    return new Fraccion(nuevoNumerador, nuevoDenominador);
  }

  /**
   * Método para dividir la fracción actual, entre la fracción otraFraccion pasada por parámetro
   * @param otraFraccion fracción por la que se quiere dividir
   * @return devuelve una nueva fracción con la división de ambas fracciones
   */
  public Fraccion dividir(Fraccion otraFraccion) {
    int nuevoNumerador = this.numerador * otraFraccion.denominador;
    int nuevoDenominador = this.denominador * otraFraccion.numerador;
    return new Fraccion(nuevoNumerador, nuevoDenominador);
  }




  /* PROGRAMA */
  // Programa para probar la clase
  public static void main(String[] args) {

    // Usamos los tres constructores
    Fraccion fraccionSinArgumentos = new Fraccion();
    Fraccion fraccionConNumerador = new Fraccion(10);
    Fraccion fraccionConNumeradorYDenominador = new Fraccion(10,5);
    Fraccion fraccionNegativa = new Fraccion(-10, -21);
    Fraccion fraccionDenominadorNegativo = new Fraccion(7,-9);

    // Mostramos por pantalla las fracciones ayudados del método obtenerFraccion
    System.out.println("Constructor sin argumentos: " + fraccionSinArgumentos.obtenerFraccion());
    System.out.println("Constructor con numerador: " + fraccionConNumerador.obtenerFraccion());
    System.out.println("Constructor con numerador y denominador: " + fraccionConNumeradorYDenominador.obtenerFraccion());
    System.out.println("Constructor con numerador negativo y denominador negativo: " + fraccionNegativa.obtenerFraccion());
    System.out.println("Constructor con numerador y denominador negativo: " + fraccionDenominadorNegativo.obtenerFraccion());


    // Mostramos las operaciones con gracciones
    System.out.println("Si sumamos la fracción "+fraccionConNumerador.obtenerFraccion()+" y la fracción "+fraccionConNumeradorYDenominador.obtenerFraccion()+" obtenemos: "+fraccionConNumerador.sumar(fraccionConNumeradorYDenominador).obtenerFraccion());
    System.out.println("Si restamos la fracción "+fraccionConNumerador.obtenerFraccion()+" y la fracción "+fraccionConNumeradorYDenominador.obtenerFraccion()+" obtenemos: "+fraccionConNumerador.restar(fraccionConNumeradorYDenominador).obtenerFraccion());
    System.out.println("Si multiplicamos la fracción "+fraccionConNumerador.obtenerFraccion()+" y la fracción "+fraccionConNumeradorYDenominador.obtenerFraccion()+" obtenemos: "+fraccionConNumerador.multiplicar(fraccionConNumeradorYDenominador).obtenerFraccion());
    System.out.println("Si dividimos la fracción "+fraccionConNumerador.obtenerFraccion()+" y la fracción "+fraccionConNumeradorYDenominador.obtenerFraccion()+" obtenemos: "+fraccionConNumerador.dividir(fraccionConNumeradorYDenominador).obtenerFraccion());
  }

}

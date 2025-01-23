package t2.clases.clase250122;

/**
 * La clase Coche representa un coche con atributos de marca, modelo y velocidad.
 * Proporciona métodos para obtener y establecer estos atributos, así como para
 * acelerar y frenar el coche.
 * 
 * Atributos:
 * - marca: La marca del coche.
 * - modelo: El modelo del coche.
 * - velocidad: La velocidad actual del coche en km/h.
 * 
 * Métodos:
 * - Coche(String marca, String modelo): Constructor que inicializa la marca y el modelo del coche, y establece la velocidad a 0.
 * - getMarca(): Devuelve la marca del coche.
 * - getModelo(): Devuelve el modelo del coche.
 * - getVelocidad(): Devuelve la velocidad actual del coche.
 * - setMarca(String marca): Establece la marca del coche.
 * - setModelo(String modelo): Establece el modelo del coche.
 * - setVelocidad(int velocidad): Establece la velocidad del coche.
 * - acelerar(int incremento): Aumenta la velocidad del coche en una cantidad específica.
 * - frenar(int decremento): Reduce la velocidad del coche en una cantidad específica.
 * 
 * Ejemplo de uso:
 * <pre>
 * {@code
 * Coche miCoche = new Coche("Renault", "Megane");
 * System.out.println("Mi coche es un " + miCoche.getMarca() + " " + miCoche.getModelo() + " y ahora va a " + miCoche.getVelocidad());
 * miCoche.setVelocidad(100);
 * System.out.println("Mi coche va a " + miCoche.getVelocidad() + "km/h.");
 * miCoche.frenar(40);
 * }
 * </pre>
 */
public class Coche {


  // Lo primero que tenemos que hacer es declarar qué atributos va a usar nuestra clase.
  private String marca;
  private String modelo;
  private int velocidad;

  // Ahora voy a crear el CONSTRUCTOR de la clase. ESTO es lo que de verdad me permite crear el objeto.

  public Coche(String marca, String modelo) {
    // Vamos a suponer que por defecto un coche está quieto y no incluimos la velocidad, por eso no lo incluimos en parámetros.
    // Para referirnos al atributo general del objeto, siempre tenemos que ponerle un this delante para referirnos a él
    this.marca = marca;
    this.modelo = modelo;
    this.velocidad = 0;
  }

  /* GETTER */
  // Ahora vamos a crear los getter, que nos servirá para que devuelva el valor actual del atributo

  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getVelocidad() {
    return velocidad;
  }


  /* SETTER */
  // Ahora vamos a crear los setter, para asegurarnos que el usuario mete la información con los criterios correctos

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }


  /* METODO */

  /**
   * Aumenta la velocidad del coche en una cantidad específica
   *
   * @param incremento  La cantidad de km/h a aumentar (debe ser número positivo)
   */
  public void acelerar(int incremento) {
    if(incremento>0){
      this.velocidad += incremento;
      System.out.println("El coche ahora va más rápido. Su velocidad actual es de "+ velocidad +"");
    } else {
      System.out.println("El incremento debe ser positivo, por lo que no ha cambiado la velocidad al intentar acelerar");
    }
  }
  
  /**
   * Reduce la velocidad del coche en una cantidad específica
   *
   * @param decremento La cantidad de km/h a reducir (debe ser número positivo)
   */
  public void frenar(int decremento) {
    if(decremento>0) {
      velocidad -= decremento;
      System.out.println("El coche ahora va más despacio. Su velocidad actual es de "+ velocidad +"");
    } else if(decremento > 0) {
      System.out.println("La velocidad no puede quedar en nçumeros negativos.");
    } else {
      System.out.println("El decremento debe ser positivo, por lo que no ha cambiado la velocidad al intentar decelerar");
    }
  }



  public static void main(String[] args) {

    Coche miCoche = new Coche("Renault", "Megane");

    System.out.println("Mi coche es un "+miCoche.getMarca()+" "+miCoche.getModelo()+" "+" y ahora va a "+miCoche.getVelocidad());

    miCoche.setVelocidad(100);

    System.out.println("Mi coche va a "+miCoche.getVelocidad()+"km/h.");

    miCoche.frenar(40);

  }
}

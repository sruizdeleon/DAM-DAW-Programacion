package t3.simulacros.misolucion;

/**
 * Clase DescuentoSobrePrecio
 * Siver para aplicar un % de descuento al precio original de un producto
 *
 * Constructor:
 * @param nombreProducto string con el nombre del producto.
 * @param precioOriginal double del precio original del producto.
 * @param descuento double porcentaje de descuento a aplicar.
 *
 * Métodos:
 * - precioFinalConDescuento: devuelve un double con el cálculo del descuento aplicado al precioOriginal.
 * - mostrarDetalles: imprime por pantalla los detalles del nombreProducto, precioOriginal, descuento y el cálculo que hace el  método de precioFinalConDescuento.
 */

 public class DescuentoSobrePrecio {
  private String nombreProducto;
  private double precioOriginal;
  private double descuento;

  public DescuentoSobrePrecio(String nomrbeProducto, double precioOriginal, double descuento) {
    this.nombreProducto = nomrbeProducto;
    this.precioOriginal = precioOriginal;
    this.descuento = descuento;
  }

  public double precioFinalConDescuento() {
    double precioConDescuento = precioOriginal - (precioOriginal * descuento) / 100;
    // precioConDescuento = Math.round(precioConDescuento * 100) / 100;
    return precioConDescuento;
  }

  public void mostrarDetalles() {
    System.out.println("- El nombre del producto: " + nombreProducto);
    System.out.printf("- El precio original: %.2f €\n", precioOriginal);
    System.out.printf("- El porcentaje de descuento: %.1f %%\n", descuento);
    System.out.printf("- El precio final con descuento: %.2f €\n\n", + precioFinalConDescuento());
  }

  public static void main(String[] args) {
    DescuentoSobrePrecio producto1 = new DescuentoSobrePrecio("Lavabajillas", 350.99, 19);
    DescuentoSobrePrecio producto2 = new DescuentoSobrePrecio("Horno", 420.99, 12);
    DescuentoSobrePrecio producto3 = new DescuentoSobrePrecio("Frigorífico", 799.99, 25);

    System.out.println("---- Producto 1 ----");
    producto1.mostrarDetalles();
    System.out.println("---- Producto 2 ----");
    producto2.mostrarDetalles();
    System.out.println("---- Producto 3 ----");
    producto3.mostrarDetalles();
  }

}
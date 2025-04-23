package t2.clases.clase250422;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerFichero {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src\\t2\\clases\\clase250422\\numeros.txt"))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                // hacer cosas con la línea leída
                System.out.println(linea);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("El fichero no existe. " + ex.getMessage());
        }
    }
}

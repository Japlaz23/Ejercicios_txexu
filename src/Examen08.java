import java.util.Scanner;

/**
 * ACTIVIDAD 8: ficha de un estudiante.
 *
 * <p>Actividad para practicar variables, tipos de datos, asignacion de
 * valores y operaciones basicas.</p>
 */
public class Examen08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cada variable guarda un dato diferente.
        String nombre;
        int edad;
        double altura;
        boolean esMayorDeEdad;

        System.out.print("Introduce tu nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Introduce tu edad: ");
        edad = scanner.nextInt();

        System.out.print("Introduce tu altura en metros: ");
        altura = scanner.nextDouble();

        // El valor de esta variable se obtiene mediante una comparacion.
        esMayorDeEdad = edad >= 18;

        System.out.println();
        System.out.println("--- Ficha del estudiante ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " anos");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Mayor de edad: " + esMayorDeEdad);

        // Una variable puede cambiar de valor despues de ser declarada.
        int edadDentroDeUnAno = edad + 1;
        System.out.println("Edad dentro de un ano: " + edadDentroDeUnAno);

        scanner.close();
    }
}

import java.util.Scanner;

/**
 * ACTIVIDAD 10: correccion de fallos.
 *
 * <p>Este programa esta corregido. En la explicacion se incluye una version
 * con errores para que el estudiante intente arreglarla.</p>
 */
public class Examen10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidad;
        System.out.print("Cuantas notas se van a introducir (1-5): ");
        cantidad = scanner.nextInt();

        while (cantidad < 1 || cantidad > 5) {
            System.out.println("La cantidad debe estar entre 1 y 5.");
            System.out.print("Cuantas notas se van a introducir (1-5): ");
            cantidad = scanner.nextInt();
        }

        int suma = 0;
        int aprobados = 0;

        for (int notaNumero = 1; notaNumero <= cantidad; notaNumero++) {
            int nota;
            System.out.print("Introduce la nota " + notaNumero + " (0-10): ");
            nota = scanner.nextInt();

            while (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
                System.out.print("Introduce la nota " + notaNumero + " (0-10): ");
                nota = scanner.nextInt();
            }

            suma = suma + nota;

            if (nota >= 5) {
                aprobados++;
            }
        }

        double media = (double) suma / cantidad;

        System.out.println("Suma de las notas: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Numero de aprobados: " + aprobados);

        scanner.close();
    }
}

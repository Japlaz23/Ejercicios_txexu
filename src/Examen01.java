import java.util.Scanner;

/**
 * Programa que registra la venta de entradas de un cine.
 *
 * <p>Para cada entrada se pide el tipo (general, estudiante o infantil),
 * se calcula su precio y, al final, se muestra un resumen con las cantidades
 * vendidas y el dinero recaudado.</p>
 */
public class Examen01 {

    public static boolean esTipoValido(int tipo) {
        return tipo >= 1 && tipo <= 3;
    }

    public static double precioEntrada(int tipo) {
        switch (tipo) {
            case 1:
                return 10.0;
            case 2:
                return 7.0;
            case 3:
                return 5.0;
            default:
                return 0.0;
        }
    }


    public static void mostrarResumen(int generales, int estudiantes, int infantiles,
                                      double recaudacion) {
        int totalEntradas = generales + estudiantes + infantiles;

        System.out.println("General: " + generales);
        System.out.println("Estudiante: " + estudiantes);
        System.out.println("Infantil: " + infantiles);
        System.out.println("Total de entradas: " + totalEntradas);
        System.out.println("Recaudacion: " + recaudacion + " \u20AC");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadEntradas;

        do {
            System.out.print("Cuantas entradas se venderan (1-20): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantas entradas se venderan (1-20): ");
            }
            cantidadEntradas = scanner.nextInt();
            if (cantidadEntradas < 1 || cantidadEntradas > 20) {
                System.out.println("La cantidad debe estar entre 1 y 20.");
            }
        } while (cantidadEntradas < 1 || cantidadEntradas > 20);

        int generales = 0;
        int estudiantes = 0;
        int infantiles = 0;
        double recaudacion = 0.0;

        for (int venta = 0; venta < cantidadEntradas; venta++) {
            int tipo;
            do {
                System.out.print("Tipo de entrada (1 general, 2 estudiante, 3 infantil): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El tipo debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Tipo de entrada (1 general, 2 estudiante, 3 infantil): ");
                }
                tipo = scanner.nextInt();
                if (!esTipoValido(tipo)) {
                    System.out.println("Tipo no valido. Introduce 1, 2 o 3.");
                }
            } while (!esTipoValido(tipo));

            switch (tipo) {
                case 1:
                    generales++;
                    break;
                case 2:
                    estudiantes++;
                    break;
                case 3:
                    infantiles++;
                    break;
                default:
                    break;
            }
            recaudacion += precioEntrada(tipo);
        }

        mostrarResumen(generales, estudiantes, infantiles, recaudacion);
        scanner.close();
    }
}

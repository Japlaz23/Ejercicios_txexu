import java.util.Scanner;

/**
 * Programa que calcula el coste de reservas de habitaciones de un hotel.
 *
 * <p>Para cada reserva se elige el tipo de habitación y el número de noches.
 * Después se aplica un descuento a las estancias largas y se muestra el
 * importe de cada reserva junto con un balance final.</p>
 */
public class Examen04 {

    public static boolean habitacionValida(int tipo) {
        return tipo >= 1 && tipo <= 3;
    }

    public static double precioNoche(int tipo) {
        switch (tipo) {
            case 1:
                return 50.0;
            case 2:
                return 80.0;
            case 3:
                return 120.0;
            default:
                return 0.0;
        }
    }

    public static boolean esEstanciaLarga(int noches) {
        return noches >= 5;
    }

    public static double costeReserva(int tipo, int noches) {
        double costeBase = precioNoche(tipo) * noches;

        if (esEstanciaLarga(noches)) {
            return costeBase * 0.85;
        }
        return costeBase;
    }

    public static void mostrarBalance(int reservas, int largas, double recaudacion) {
        double precioMedio = recaudacion / reservas;

        System.out.println("Recaudacion: " + recaudacion + " \u20AC");
        System.out.println("Estancias largas: " + largas);
        System.out.println("Precio medio por reserva: " + precioMedio + " \u20AC");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadReservas;

        do {
            System.out.print("Cuantas reservas se registraran (1-10): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantas reservas se registraran (1-10): ");
            }
            cantidadReservas = scanner.nextInt();
            if (cantidadReservas < 1 || cantidadReservas > 10) {
                System.out.println("La cantidad debe estar entre 1 y 10.");
            }
        } while (cantidadReservas < 1 || cantidadReservas > 10);

        int largas = 0;
        double recaudacion = 0.0;

        for (int reserva = 1; reserva <= cantidadReservas; reserva++) {
            int tipo;
            do {
                System.out.print("Tipo de habitacion (1 individual, 2 doble, 3 suite): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El tipo debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Tipo de habitacion (1 individual, 2 doble, 3 suite): ");
                }
                tipo = scanner.nextInt();
                if (!habitacionValida(tipo)) {
                    System.out.println("Tipo no valido. Introduce 1, 2 o 3.");
                }
            } while (!habitacionValida(tipo));

            int noches;
            do {
                System.out.print("Numero de noches (1-14): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Las noches deben ser un numero entero.");
                    scanner.next();
                    System.out.print("Numero de noches (1-14): ");
                }
                noches = scanner.nextInt();
                if (noches < 1 || noches > 14) {
                    System.out.println("Las noches deben estar entre 1 y 14.");
                }
            } while (noches < 1 || noches > 14);

            double costeBase = precioNoche(tipo) * noches;
            double coste = costeReserva(tipo, noches);
            double descuento = costeBase - coste;

            System.out.println("Reserva " + reserva + ":");
            System.out.println("Importe base: " + costeBase + " \u20AC");
            System.out.println("Descuento: " + descuento + " \u20AC");
            System.out.println("Importe final: " + coste + " \u20AC");

            recaudacion += coste;
            if (esEstanciaLarga(noches)) {
                largas++;
            }
        }

        mostrarBalance(cantidadReservas, largas, recaudacion);
        scanner.close();
    }
}

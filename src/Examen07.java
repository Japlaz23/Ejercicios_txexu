import java.util.Scanner;

/**
 * ACTIVIDAD 7: resumen de gastos semanales.
 *
 * <p>Esta actividad introduce los arrays. Un array guarda varios valores del
 * mismo tipo y permite procesarlos con un for.</p>
 */
public class Examen07 {

    /**
     * Un array se recibe como parametro usando double[].
     * Recorremos sus posiciones para sumar todos los gastos.
     */
    public static double calcularTotal(double[] gastos) {
        double total = 0.0;
        for (int posicion = 0; posicion < gastos.length; posicion++) {
            total += gastos[posicion];
        }
        return total;
    }

    public static double calcularMaximo(double[] gastos) {
        double maximo = gastos[0]; // Empezamos con el primer dato real.
        for (int posicion = 1; posicion < gastos.length; posicion++) {
            if (gastos[posicion] > maximo) {
                maximo = gastos[posicion];
            }
        }
        return maximo;
    }

    public static double calcularMinimo(double[] gastos) {
        double minimo = gastos[0];
        for (int posicion = 1; posicion < gastos.length; posicion++) {
            if (gastos[posicion] < minimo) {
                minimo = gastos[posicion];
            }
        }
        return minimo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadDias;
        do {
            System.out.print("Cuantos dias se registraran (1-7): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantos dias se registraran (1-7): ");
            }
            cantidadDias = scanner.nextInt();
            if (cantidadDias < 1 || cantidadDias > 7) {
                System.out.println("La cantidad debe estar entre 1 y 7.");
            }
        } while (cantidadDias < 1 || cantidadDias > 7);

        // new reserva espacio para cantidadDias valores de tipo double.
        double[] gastos = new double[cantidadDias];

        // El indice empieza en 0, por eso la posicion se muestra como dia + 1.
        for (int dia = 0; dia < gastos.length; dia++) {
            do {
                System.out.print("Gasto del dia " + (dia + 1) + " (0-200 EUR): ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("El gasto debe ser un numero.");
                    scanner.next();
                    System.out.print("Gasto del dia " + (dia + 1) + " (0-200 EUR): ");
                }
                gastos[dia] = scanner.nextDouble();
                if (gastos[dia] < 0 || gastos[dia] > 200) {
                    System.out.println("El gasto debe estar entre 0 y 200 EUR.");
                }
            } while (gastos[dia] < 0 || gastos[dia] > 200);
        }

        double total = calcularTotal(gastos);
        double media = total / gastos.length;

        System.out.println("Total gastado: " + total + " EUR");
        System.out.println("Gasto medio: " + media + " EUR");
        System.out.println("Gasto maximo: " + calcularMaximo(gastos) + " EUR");
        System.out.println("Gasto minimo: " + calcularMinimo(gastos) + " EUR");

        scanner.close();
    }
}

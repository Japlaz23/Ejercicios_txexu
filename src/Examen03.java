import java.util.Scanner;

/**
 * Programa que analiza varias lecturas de temperatura.
 *
 * <p>Valida que cada temperatura esté dentro del intervalo permitido,
 * cuenta las alertas de calor, calcula la media y busca la temperatura máxima,
 * la mínima y la amplitud entre ambas.</p>
 */
public class Examen03 {

    public static boolean temperaturaValida(int temperatura) {
        return temperatura >= -20 && temperatura <= 50;
    }

    public static boolean esAlertaCalor(int temperatura) {
        return temperatura >= 30;
    }

    public static int calcularAmplitud(int maxima, int minima) {
        return maxima - minima;
    }

    public static void mostrarInforme(int alertas, double media, int maxima,
                                      int minima, int amplitud) {
        System.out.println("Alertas de calor: " + alertas);
        System.out.println("Media: " + media);
        System.out.println("Maxima: " + maxima);
        System.out.println("Minima: " + minima);
        System.out.println("Amplitud: " + amplitud);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadLecturas;

        do {
            System.out.print("Cuantas lecturas se registraran (1-24): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantas lecturas se registraran (1-24): ");
            }
            cantidadLecturas = scanner.nextInt();
            if (cantidadLecturas < 1 || cantidadLecturas > 24) {
                System.out.println("La cantidad debe estar entre 1 y 24.");
            }
        } while (cantidadLecturas < 1 || cantidadLecturas > 24);

        int suma = 0;
        int alertas = 0;
        int maxima = 0;
        int minima = 0;

        for (int lectura = 0; lectura < cantidadLecturas; lectura++) {
            int temperatura;
            do {
                System.out.print("Introduce la temperatura (-20 a 50): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("La temperatura debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Introduce la temperatura (-20 a 50): ");
                }
                temperatura = scanner.nextInt();
                if (!temperaturaValida(temperatura)) {
                    System.out.println("Temperatura no valida. Introduce un valor entre -20 y 50.");
                }
            } while (!temperaturaValida(temperatura));

            suma += temperatura;
            if (esAlertaCalor(temperatura)) {
                alertas++;
            }

            if (lectura == 0) {
                maxima = temperatura;
                minima = temperatura;
            } else {
                if (temperatura > maxima) {
                    maxima = temperatura;
                }
                if (temperatura < minima) {
                    minima = temperatura;
                }
            }
        }

        double media = (double) suma / cantidadLecturas;
        int amplitud = calcularAmplitud(maxima, minima);
        mostrarInforme(alertas, media, maxima, minima, amplitud);
        scanner.close();
    }
}

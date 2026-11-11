import java.util.Scanner;

/**
 * Programa que analiza las notas de un grupo de estudiantes.
 *
 * <p>Comprueba que las notas estén entre 0 y 10, cuenta cuántos estudiantes
 * aprueban y suspenden, y calcula la media, la nota máxima, la mínima y su
 * clasificación.</p>
 */
public class Examen02 {

    public static boolean esNotaValida(int nota) {
        return nota >= 0 && nota <= 10;
    }

    public static boolean estaAprobado(int nota) {
        return nota >= 5;
    }

    public static String clasificarMedia(double media) {
        if (media < 5) {
            return "Suspenso";
        } else if (media < 7) {
            return "Aprobado";
        } else if (media < 9) {
            return "Notable";
        } else {
            return "Sobresaliente";
        }
    }

    public static void mostrarInforme(int aprobados, int suspensos, double media,
                                      int maximo, int minimo) {
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Suspensos: " + suspensos);
        System.out.println("Media: " + media);
        System.out.println("Maximo: " + maximo);
        System.out.println("Minimo: " + minimo);
        System.out.println("Clasificacion: " + clasificarMedia(media));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadNotas;

        do {
            System.out.print("Cuantas notas se introduciran (1-15): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantas notas se introduciran (1-15): ");
            }
            cantidadNotas = scanner.nextInt();
            if (cantidadNotas < 1 || cantidadNotas > 15) {
                System.out.println("La cantidad debe estar entre 1 y 15.");
            }
        } while (cantidadNotas < 1 || cantidadNotas > 15);

        int aprobados = 0;
        int suspensos = 0;
        int suma = 0;
        int maximo = 0;
        int minimo = 0;

        for (int estudiante = 0; estudiante < cantidadNotas; estudiante++) {
            int nota;
            do {
                System.out.print("Introduce la nota (0-10): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("La nota debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Introduce la nota (0-10): ");
                }
                nota = scanner.nextInt();
                if (!esNotaValida(nota)) {
                    System.out.println("Nota no valida. Introduce un valor entre 0 y 10.");
                }
            } while (!esNotaValida(nota));

            suma += nota;
            if (estaAprobado(nota)) {
                aprobados++;
            } else {
                suspensos++;
            }

            if (estudiante == 0) {
                maximo = nota;
                minimo = nota;
            } else {
                if (nota > maximo) {
                    maximo = nota;
                }
                if (nota < minimo) {
                    minimo = nota;
                }
            }
        }

        double media = (double) suma / cantidadNotas;
        mostrarInforme(aprobados, suspensos, media, maximo, minimo);
        scanner.close();
    }
}

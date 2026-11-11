import java.util.Scanner;

/**
 * Programa que calcula la factura del consumo de agua durante varios meses.
 *
 * <p>Obtiene el consumo a partir de las lecturas inicial y final, aplica una
 * tarifa por tramos, añade una cuota fija y, si corresponde, aplica la tarifa
 * social. Al terminar muestra el consumo y el importe total.</p>
 */
public class Examen05 {

    public static boolean lecturasValidas(int inicial, int fin) {
        return inicial >= 0 && fin >= inicial && fin - inicial <= 100;
    }

    public static int consumo(int inicial, int fin) {
        return fin - inicial;
    }

    public static double costeVariable(int metrosCubicos) {
        int primerTramo = Math.min(metrosCubicos, 10);
        int segundoTramo = Math.min(Math.max(metrosCubicos - 10, 0), 10);
        int tercerTramo = Math.max(metrosCubicos - 20, 0);

        return primerTramo * 1.0 + segundoTramo * 1.5 + tercerTramo * 2.0;
    }

    public static double importeMes(int metrosCubicos, boolean tarifaSocial) {
        double variable = costeVariable(metrosCubicos);
        if (tarifaSocial && metrosCubicos <= 10) {
            variable *= 0.80;
        }
        return variable + 5.0;
    }

    public static void mostrarResumen(int meses, int consumoTotal, double importeTotal) {
        System.out.println("Consumo total: " + consumoTotal + " m3");
        System.out.println("Recaudacion total: " + importeTotal + " \u20AC");
        System.out.println("Coste medio mensual: " + importeTotal / meses + " \u20AC");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meses;

        do {
            System.out.print("Numero de meses (1-6): ");
            while (!scanner.hasNextInt()) {
                System.out.println("El numero de meses debe ser entero.");
                scanner.next();
                System.out.print("Numero de meses (1-6): ");
            }
            meses = scanner.nextInt();
            if (meses < 1 || meses > 6) {
                System.out.println("El numero de meses debe estar entre 1 y 6.");
            }
        } while (meses < 1 || meses > 6);

        int opcionSocial;
        do {
            System.out.print("Dispone de tarifa social (1 si, 0 no): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La opcion debe ser 1 o 0.");
                scanner.next();
                System.out.print("Dispone de tarifa social (1 si, 0 no): ");
            }
            opcionSocial = scanner.nextInt();
            if (opcionSocial != 0 && opcionSocial != 1) {
                System.out.println("La opcion debe ser 1 o 0.");
            }
        } while (opcionSocial != 0 && opcionSocial != 1);

        boolean tarifaSocial = opcionSocial == 1;
        int consumoTotal = 0;
        double importeTotal = 0.0;

        for (int mes = 1; mes <= meses; mes++) {
            int inicial;
            int fin;

            do {
                System.out.print("Lectura inicial del mes " + mes + ": ");
                while (!scanner.hasNextInt()) {
                    System.out.println("La lectura debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Lectura inicial del mes " + mes + ": ");
                }
                inicial = scanner.nextInt();

                System.out.print("Lectura final del mes " + mes + ": ");
                while (!scanner.hasNextInt()) {
                    System.out.println("La lectura debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Lectura final del mes " + mes + ": ");
                }
                fin = scanner.nextInt();

                if (!lecturasValidas(inicial, fin)) {
                    System.out.println("Lecturas no validas: la inicial debe ser no negativa y "
                            + "el consumo debe estar entre 0 y 100 m3.");
                }
            } while (!lecturasValidas(inicial, fin));

            int metrosCubicos = consumo(inicial, fin);
            double variable = costeVariable(metrosCubicos);
            double importe = importeMes(metrosCubicos, tarifaSocial);
            double descuento = 0.0;
            if (tarifaSocial && metrosCubicos <= 10) {
                descuento = variable * 0.20;
            }

            System.out.println("Mes " + mes + ": consumo " + metrosCubicos + " m3");
            System.out.println("Coste variable: " + variable + " \u20AC");
            if (descuento > 0) {
                System.out.println("Descuento: " + descuento + " \u20AC");
            }
            System.out.println("Cuota fija: 5.0 \u20AC");
            System.out.println("Importe total: " + importe + " \u20AC");

            consumoTotal += metrosCubicos;
            importeTotal += importe;
        }

        mostrarResumen(meses, consumoTotal, importeTotal);
        scanner.close();
    }
}

import java.util.Scanner;

/**
 * Actividad: registro sencillo de envios.
 *
 * <p>Practica variables, if, for, do-while, contadores y acumuladores.</p>
 */
public class Examen09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidadEnvios;

        // Pedimos la cantidad hasta que este entre 1 y 20.
        System.out.print("Cuantos envios se registraran (1-20): ");
        cantidadEnvios = scanner.nextInt();
        while (cantidadEnvios < 1 || cantidadEnvios > 20) {
            System.out.println("La cantidad debe estar entre 1 y 20.");
            System.out.print("Cuantos envios se registraran (1-20): ");
            cantidadEnvios = scanner.nextInt();
        }

        int paquetesPesados = 0;
        int recaudacionTotal = 0;

        // Repetimos el proceso una vez por cada envio.
        for (int envio = 1; envio <= cantidadEnvios; envio++) {
            int peso;

            // Pedimos el peso hasta que sea correcto.
            System.out.print("Peso del envio " + envio + " (1-30 kg): ");
            peso = scanner.nextInt();
            while (peso < 1 || peso > 30) {
                System.out.println("El peso debe estar entre 1 y 30 kg.");
                System.out.print("Peso del envio " + envio + " (1-30 kg): ");
                peso = scanner.nextInt();
            }

            int destino;

            // 1 es peninsula, 2 son islas y 3 es internacional.
            System.out.print("Destino (1 peninsula, 2 islas, 3 internacional): ");
            destino = scanner.nextInt();
            while (destino < 1 || destino > 3) {
                System.out.println("El destino debe ser 1, 2 o 3.");
                System.out.print("Destino (1 peninsula, 2 islas, 3 internacional): ");
                destino = scanner.nextInt();
            }

            int tarifa;

            // Primero convertimos el peso en un tipo de tarifa.
            int tipoTarifa;
            if (peso <= 2) {
                tipoTarifa = 1;
            } else if (peso <= 5) {
                tipoTarifa = 2;
            } else {
                tipoTarifa = 3;
            }

            // El switch elige el precio de la tarifa.
            switch (tipoTarifa) {
                case 1:
                    tarifa = 4;
                    break;
                case 2:
                    tarifa = 7;
                    break;
                default:
                    tarifa = 10;
                    break;
            }

            int suplemento;

            // El switch elige el suplemento segun el destino.
            switch (destino) {
                case 1:
                    suplemento = 0;
                    break;
                case 2:
                    suplemento = 3;
                    break;
                default:
                    suplemento = 8;
                    break;
            }

            int importe = tarifa + suplemento;

            System.out.println("Importe del envio: " + importe + " euros");

            // Un paquete es pesado si pesa mas de 5 kg.
            if (peso > 5) {
                paquetesPesados++;
            }

            // Sumamos el importe al total de la jornada.
            recaudacionTotal += importe;
        }

        System.out.println();
        System.out.println("--- Resumen de la jornada ---");
        System.out.println("Cantidad de envios: " + cantidadEnvios);
        System.out.println("Paquetes pesados: " + paquetesPesados);
        System.out.println("Recaudacion total: " + recaudacionTotal + " euros");

        scanner.close();
    }
}

import java.util.Scanner;

/**
 * ACTIVIDAD 6: caja de una cafeteria.
 *
 * <p>En esta actividad se practica como mostrar un menu, validar una opcion,
 * repetir una operacion varias veces y acumular un total.</p>
 */
public class Examen06 {

    /**
     * Comprueba que la opcion pertenece al menu.
     * Devuelve true si es valida y false en caso contrario.
     */
    public static boolean opcionValida(int opcion) {
        return opcion >= 1 && opcion <= 4;
    }

    /**
     * Devuelve el precio asociado a cada producto.
     * El switch permite elegir un resultado distinto segun la opcion.
     */
    public static double precioProducto(int opcion) {
        switch (opcion) {
            case 1:
                return 1.50; // Cafe
            case 2:
                return 2.00; // Te
            case 3:
                return 2.50; // Zumo
            case 4:
                return 3.00; // Bocadillo
            default:
                return 0.0; // No deberia ocurrir si validamos antes.
        }
    }

    /**
     * Devuelve el nombre del producto para que el ticket sea legible.
     */
    public static String nombreProducto(int opcion) {
        switch (opcion) {
            case 1:
                return "Cafe";
            case 2:
                return "Te";
            case 3:
                return "Zumo";
            case 4:
                return "Bocadillo";
            default:
                return "Desconocido";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // El numero de productos controla cuantas veces se repite el for.
        int cantidadProductos;
        do {
            System.out.print("Cuantos productos se compraran (1-10): ");
            while (!scanner.hasNextInt()) {
                System.out.println("La cantidad debe ser un numero entero.");
                scanner.next();
                System.out.print("Cuantos productos se compraran (1-10): ");
            }
            cantidadProductos = scanner.nextInt();
            if (cantidadProductos < 1 || cantidadProductos > 10) {
                System.out.println("La cantidad debe estar entre 1 y 10.");
            }
        } while (cantidadProductos < 1 || cantidadProductos > 10);

        double total = 0.0;
        int productosBaratos = 0;

        // Cada vuelta representa una linea de la compra.
        for (int producto = 1; producto <= cantidadProductos; producto++) {
            int opcion;
            do {
                System.out.println("1. Cafe (1.50 EUR)");
                System.out.println("2. Te (2.00 EUR)");
                System.out.println("3. Zumo (2.50 EUR)");
                System.out.println("4. Bocadillo (3.00 EUR)");
                System.out.print("Elige un producto para la compra " + producto + ": ");

                while (!scanner.hasNextInt()) {
                    System.out.println("La opcion debe ser un numero entero.");
                    scanner.next();
                    System.out.print("Elige un producto para la compra " + producto + ": ");
                }
                opcion = scanner.nextInt();
                if (!opcionValida(opcion)) {
                    System.out.println("Opcion no valida. Elige entre 1 y 4.");
                }
            } while (!opcionValida(opcion));

            double precio = precioProducto(opcion);
            total += precio; // Acumulador: suma el precio de cada producto.
            if (precio < 2.50) {
                productosBaratos++; // Contador: aumenta cuando se cumple la condicion.
            }
            System.out.println("Anadido: " + nombreProducto(opcion)
                    + " - " + precio + " EUR");
        }

        // La division calcula el precio medio despues de sumar toda la compra.
        double precioMedio = total / cantidadProductos;
        System.out.println("Total: " + total + " EUR");
        System.out.println("Precio medio: " + precioMedio + " EUR");
        System.out.println("Productos de menos de 2.50 EUR: " + productosBaratos);

        scanner.close();
    }
}

# Actividades explicadas

Este documento explica las actividades `Examen06` y `Examen07`. La idea es
que el estudiante pueda leer primero la explicación y después completar o
modificar el código paso a paso.

## Cómo ejecutar las actividades

Desde la carpeta del proyecto se pueden compilar los programas con:

```bash
javac -d out src/Examen06.java src/Examen07.java
```

Después se ejecuta una actividad con:

```bash
java -cp out Examen06
```

o:

```bash
java -cp out Examen07
```

---

## Actividad 6: caja de una cafetería

Archivo: `src/Examen06.java`

### Objetivo

Crear un programa que permita registrar varios productos de una cafetería.
El programa debe:

1. Preguntar cuántos productos se van a comprar.
2. Mostrar un menú.
3. Pedir un producto para cada compra.
4. Comprobar que la opción sea correcta.
5. Calcular el precio total.
6. Calcular el precio medio.
7. Contar cuántos productos cuestan menos de 2,50 euros.

### 1. Importar `Scanner`

```java
import java.util.Scanner;
```

`Scanner` permite leer datos escritos por el usuario en la consola. Para
utilizarlo se crea un objeto:

```java
Scanner scanner = new Scanner(System.in);
```

`System.in` representa la entrada de datos del teclado.

### 2. Crear métodos

Un método es un bloque de código que realiza una tarea concreta. Dividir el
programa en métodos facilita su lectura y evita repetir código.

```java
public static boolean opcionValida(int opcion) {
    return opcion >= 1 && opcion <= 4;
}
```

Este método recibe un número entero y devuelve un `boolean`, es decir,
`true` o `false`. La expresión comprueba que la opción esté entre 1 y 4.

El método `precioProducto` utiliza un `switch`:

```java
switch (opcion) {
    case 1:
        return 1.50;
    case 2:
        return 2.00;
    default:
        return 0.0;
}
```

`switch` permite ejecutar una parte distinta del código según el valor de una
variable. `return` devuelve el resultado del método y termina su ejecución.

### 3. Validar una cantidad

La estructura `do-while` sirve para repetir una pregunta al menos una vez:

```java
do {
    cantidadProductos = scanner.nextInt();
} while (cantidadProductos < 1 || cantidadProductos > 10);
```

La condición se comprueba después de ejecutar el bloque. Por eso el usuario
siempre verá la pregunta al menos una vez.

También se utiliza:

```java
while (!scanner.hasNextInt()) {
    scanner.next();
}
```

`hasNextInt()` comprueba si el siguiente dato es un entero. El símbolo `!`
significa “no”. Por tanto, el bucle se ejecuta mientras el dato no sea un
entero. `scanner.next()` elimina el dato incorrecto para poder volver a
preguntar.

### 4. Repetir una compra

```java
for (int producto = 1; producto <= cantidadProductos; producto++) {
    // Leer y procesar un producto
}
```

El `for` se utiliza cuando sabemos cuántas veces queremos repetir algo:

- `int producto = 1`: valor inicial.
- `producto <= cantidadProductos`: condición para continuar.
- `producto++`: aumenta el contador en una unidad.

### 5. Acumuladores y contadores

```java
double total = 0.0;
total += precio;
```

`total` es un acumulador: guarda una suma que va creciendo en cada vuelta.
La expresión `total += precio` equivale a escribir
`total = total + precio`.

```java
int productosBaratos = 0;

if (precio < 2.50) {
    productosBaratos++;
}
```

`productosBaratos` es un contador. Solo aumenta cuando se cumple la
condición. El operador `++` suma uno.

### 6. Calcular una media

```java
double precioMedio = total / cantidadProductos;
```

La media se obtiene dividiendo el total entre el número de elementos. Se usa
`double` porque el resultado puede tener decimales.

### Propuestas para ampliar la actividad

- Añadir cantidades, por ejemplo, comprar tres cafés en una sola operación.
- Aplicar un descuento si el total supera 10 euros.
- Mostrar el producto más caro.
- Preguntar si el cliente quiere realizar otra compra.

---

## Actividad 7: resumen de gastos semanales

Archivo: `src/Examen07.java`

### Objetivo

Crear un programa que guarde los gastos de varios días y calcule:

1. El gasto total.
2. El gasto medio.
3. El gasto máximo.
4. El gasto mínimo.

En esta actividad se introduce el concepto de **array**.

### 1. Qué es un array

Un array es una variable que puede almacenar varios valores del mismo tipo.
Por ejemplo:

```java
double[] gastos = new double[cantidadDias];
```

- `double[]` indica que es un array de números decimales.
- `gastos` es el nombre del array.
- `new` reserva memoria.
- `cantidadDias` indica cuántas posiciones tendrá.

Si `cantidadDias` vale 7, el array tendrá siete posiciones. Sin embargo, las
posiciones empiezan en 0:

```text
Índice:  0      1      2      3      4      5      6
Día:     1      2      3      4      5      6      7
```

### 2. Guardar datos en el array

```java
for (int dia = 0; dia < gastos.length; dia++) {
    gastos[dia] = scanner.nextDouble();
}
```

`gastos[dia]` representa la posición actual del array. `length` devuelve el
número de posiciones que tiene el array.

Aunque el índice empieza en 0, se muestra `dia + 1` al usuario porque las
personas contamos los días desde 1:

```java
System.out.println("Gasto del dia " + (dia + 1));
```

### 3. Recorrer y sumar los valores

```java
public static double calcularTotal(double[] gastos) {
    double total = 0.0;

    for (int posicion = 0; posicion < gastos.length; posicion++) {
        total += gastos[posicion];
    }

    return total;
}
```

El array se pasa al método como `double[]`. El `for` recorre todas sus
posiciones y suma cada gasto al acumulador `total`.

### 4. Buscar el máximo

```java
double maximo = gastos[0];

for (int posicion = 1; posicion < gastos.length; posicion++) {
    if (gastos[posicion] > maximo) {
        maximo = gastos[posicion];
    }
}
```

Se empieza usando el primer gasto como máximo provisional. Después se compara
cada elemento con ese valor. Si se encuentra uno mayor, se actualiza
`maximo`.

No se debe comenzar con `maximo = 0` si los datos pudieran ser negativos,
porque el resultado podría ser incorrecto. Usar el primer elemento es una
forma segura de iniciar la búsqueda.

### 5. Buscar el mínimo

La búsqueda del mínimo funciona igual, pero se cambia la comparación:

```java
double minimo = gastos[0];

for (int posicion = 1; posicion < gastos.length; posicion++) {
    if (gastos[posicion] < minimo) {
        minimo = gastos[posicion];
    }
}
```

Si el gasto actual es menor que el mínimo guardado, se sustituye el valor.

### 6. Validar números decimales

```java
while (!scanner.hasNextDouble()) {
    System.out.println("El gasto debe ser un numero.");
    scanner.next();
}
```

`hasNextDouble()` comprueba si el usuario ha escrito un número decimal.
Después se comprueba que el valor esté dentro del intervalo permitido:

```java
if (gastos[dia] < 0 || gastos[dia] > 200) {
    System.out.println("El gasto debe estar entre 0 y 200 EUR.");
}
```

El operador `||` significa “o”. La condición es verdadera si el gasto es
menor que 0 o mayor que 200.

### Propuestas para ampliar la actividad

- Mostrar qué día tuvo el gasto máximo.
- Contar cuántos días se gastaron más de 50 euros.
- Guardar también una descripción del gasto.
- Ordenar los gastos de menor a mayor.
- Permitir introducir los gastos de varios estudiantes y comparar sus medias.

---

## Conceptos que aparecen en las dos actividades

| Concepto | Significado |
|---|---|
| Variable | Espacio donde se guarda un dato. |
| `int` | Número entero, sin decimales. |
| `double` | Número que puede tener decimales. |
| `boolean` | Valor lógico: `true` o `false`. |
| Método | Bloque reutilizable que realiza una tarea. |
| `if` | Ejecuta código cuando se cumple una condición. |
| `for` | Repite código un número conocido de veces. |
| `while` | Repite código mientras una condición sea verdadera. |
| `do-while` | Ejecuta el bloque al menos una vez y después comprueba la condición. |
| `switch` | Selecciona una opción entre varios casos. |
| Array | Colección de valores del mismo tipo. |
| Acumulador | Variable que va sumando resultados. |
| Contador | Variable que cuenta cuántas veces ocurre algo. |

---

## Actividad 8: ficha de un estudiante

Archivo: `src/Examen08.java`

### Objetivo

Practicar cómo se crean y utilizan variables de distintos tipos. El programa
solicita el nombre, la edad y la altura de un estudiante y después muestra
una ficha con los datos introducidos.

### 1. Declarar variables

```java
String nombre;
int edad;
double altura;
boolean esMayorDeEdad;
```

Declarar una variable significa indicar qué tipo de dato guardará y darle un
nombre:

- `String` guarda texto.
- `int` guarda números enteros.
- `double` guarda números con decimales.
- `boolean` guarda `true` o `false`.

En este momento las variables están declaradas, pero todavía no tienen un
valor introducido por el usuario.

### 2. Asignar valores

```java
nombre = scanner.nextLine();
edad = scanner.nextInt();
altura = scanner.nextDouble();
```

El signo `=` asigna el resultado de la derecha a la variable de la izquierda.
Por ejemplo, `edad = scanner.nextInt()` guarda en `edad` el número entero
que escribe el usuario.

### 3. Crear un valor booleano

```java
esMayorDeEdad = edad >= 18;
```

La expresión `edad >= 18` es una comparación. Su resultado solo puede ser
`true` si la edad es 18 o más, o `false` si es menor de 18. Ese resultado se
guarda en la variable `esMayorDeEdad`.

### 4. Utilizar una variable en un mensaje

```java
System.out.println("Nombre: " + nombre);
```

El operador `+` une el texto con el contenido de la variable. Esto se llama
concatenación cuando se utiliza con texto.

### 5. Crear otra variable a partir de una existente

```java
int edadDentroDeUnAno = edad + 1;
```

Aquí se declara la variable, se calcula una expresión y se guarda el
resultado. La variable `edad` no cambia: se crea otra variable con su valor
incrementado en uno.

### Retos para el estudiante

1. Añadir una variable `String` para guardar la ciudad.
2. Añadir una variable `double` para guardar el peso.
3. Calcular el año de nacimiento a partir de la edad.
4. Crear una variable `boolean` llamada `esMenorDeEdad`.
5. Mostrar una frase que combine el nombre, la ciudad y la edad.
6. Cambiar el programa para pedir dos asignaturas y sus notas.

### Qué practicar

- Diferencia entre declarar y asignar una variable.
- Elección del tipo de dato adecuado.
- Lectura de texto, enteros y decimales.
- Operaciones aritméticas.
- Comparaciones que producen valores booleanos.
- Concatenación de texto y variables.

---

## Actividad 9: registro de envíos

Archivo: `src/Examen09.java`

### Objetivo

Registrar varios envíos de una oficina de mensajería. Cada envío tiene un
peso y un destino. El programa valida ambos datos, calcula una tarifa por
peso, añade el suplemento del destino y muestra un resumen de la jornada.

### Datos y validación

La cantidad de envíos se valida para que esté entre 1 y 20. Después, cada
peso se valida entre 1 y 30 kg y cada destino entre 1 y 3. Como el peso y el
destino se solicitan en bucles `while` separados, si uno es incorrecto solo se
vuelve a pedir ese dato. En esta versión se utilizan directamente `if`,
`while` y `switch`, sin crear métodos auxiliares.

### Calcular la tarifa

Primero se guarda en `tipoTarifa` si el paquete pertenece al primer, segundo o
tercer tramo. Después, un `switch` convierte ese tipo en un precio:

```java
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
```

Las condiciones se comprueban de menor a mayor. Si el peso no está en los dos
primeros intervalos, necesariamente pertenece al intervalo de 6 a 30 kg,
porque ya se ha validado antes.

### Calcular el suplemento

Se utiliza un segundo `switch` para relacionar cada destino con su suplemento:

- Península: 0 euros.
- Islas: 3 euros.
- Internacional: 8 euros.

En un `switch`, `case` indica una opción y `break` evita que se ejecuten los
casos siguientes. `default` se utiliza cuando no coincide ningún caso
concreto.

El importe final se calcula sumando las dos partes:

```java
int importe = tarifa + suplemento;
```

### Contar y acumular

```java
if (esPesado(peso)) {
    paquetesPesados++;
}
recaudacionTotal += importe;
```

`paquetesPesados` es un contador que aumenta si el peso supera los 5 kg.
`recaudacionTotal` es un acumulador que suma el importe de cada envío.

### Retos para el estudiante

1. Contar cuántos envíos son internacionales.
2. Calcular el importe medio de los envíos.
3. Mostrar cuál ha sido el importe más alto.
4. Añadir un descuento de 2 euros para los envíos de la península.
5. Mostrar la recaudación separada por destino.

---

## Actividad 10: corrección de fallos

Archivo de solución: `src/Examen10.java`

### Objetivo

Aprender a encontrar y corregir errores sencillos en un programa Java. El
programa debe pedir varias notas, calcular su suma y su media, y contar
cuántos estudiantes han aprobado.

Antes de mirar la solución de `src/Examen10.java`, copia este código en un
archivo llamado `Examen10Fallos.java` y corrige los errores:

```java
import java.util.Scanner;

public class Examen10Fallos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidad;
        System.out.print("Cuantas notas se van a introducir (1-5): ");
        cantidad = scanner.nextInt();

        while (cantidad < 1 && cantidad > 5) {
            System.out.println("La cantidad debe estar entre 1 y 5.");
            cantidad = scanner.nextInt();
        }

        int suma = 0;
        int aprobados = 0;

        for (int notaNumero = 1; notaNumero < cantidad; notaNumero++) {
            System.out.print("Introduce la nota " + notaNumero + " (0-10): ");
            int nota = scanner.nextInt();

            while (nota < 0 || nota > 10) {
                System.out.println("La nota debe estar entre 0 y 10.");
            }

            suma = nota;

            if (nota > 5) {
                aprobados++;
            }
        }

        double media = suma / cantidad;
        System.out.println("Suma de las notas: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Numero de aprobados: " + aprobados);

        scanner.close();
    }
}
```

### Fallos que debe encontrar el estudiante

1. La condición `cantidad < 1 && cantidad > 5` nunca puede cumplirse. Hay que
   utilizar `||`, porque la cantidad es incorrecta si está por debajo de 1 o
   por encima de 5.
2. El `while` de la cantidad debe volver a mostrar la pregunta antes de leer
   otro valor.
3. En el `for`, la condición debe ser `notaNumero <= cantidad` para procesar
   también la última nota.
4. El `while` de la nota no vuelve a pedir una nota después de detectar un
   valor incorrecto. Hay que mostrar la pregunta y leer otra vez.
5. `suma = nota` sustituye la suma anterior. Debe ser `suma = suma + nota`.
6. Una nota de 5 está aprobada, por eso la comparación correcta es `nota >= 5`.
7. La división debe producir un decimal. Hay que convertir `suma` a `double`
   antes de dividir.

### Cómo corregir y comprobar

Corrige un fallo cada vez y compila después de cada cambio. Al terminar,
prueba estos casos:

| Datos introducidos | Resultado esperado |
|---|---|
| `5`, `5`, `6`, `7`, `4`, `10` | Suma 32, media 6.4 y 4 aprobados |
| `1`, `5` | Suma 5, media 5.0 y 1 aprobado |
| Cantidad `0` y después `2` | Vuelve a pedir la cantidad |
| Nota `12` y después `8` | Vuelve a pedir solo esa nota |

### Conceptos practicados

- Errores de sintaxis: impiden compilar el programa.
- Errores de lógica: el programa compila, pero produce un resultado incorrecto.
- Bucles `while` y `for`.
- Operadores `&&` y `||`.
- Acumuladores.
- Contadores.
- División entera y división decimal.

## Orden recomendado para resolverlas

1. Leer el objetivo y subrayar los datos que hay que pedir.
2. Decidir qué variables hacen falta y de qué tipo será cada una.
3. Crear métodos pequeños para las operaciones principales.
4. Añadir la lectura de datos con `Scanner`.
5. Validar los datos antes de utilizarlos.
6. Implementar el bucle que procesa los datos.
7. Mostrar los resultados.
8. Probar valores normales y también valores incorrectos.

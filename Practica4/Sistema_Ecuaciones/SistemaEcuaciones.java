/**
 * @file menu.java
 * @author Brayan Lucero Molina
 * @brief Programa en Java que resuelve sistemas de ecuaciones lineales
 *        utilizando el metodo de eliminacion de Gauss y el metodo de Cramer.
 * @version 0.1
 * @date 2025-10-19
 */

import java.util.Scanner;

public class SistemaEcuaciones {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;

    // Pido al usuario el numero de ecuaciones (y variables)
    System.out.print("Ingresa el numero de ecuaciones (y variables): ");
    n = sc.nextInt();

    // Defino la matriz de coeficientes A y el vector de terminos independientes b
    double[][] A = new double[n][n];
    double[] b = new double[n];

    // Solicito los datos del sistema
    System.out.println("\nIngresa los coeficientes del sistema:");
    for (int i = 0; i < n; i++) {
        System.out.println("Ecuacion " + (i + 1) + ":");
        for (int j = 0; j < n; j++) {
            System.out.print("a[" + i + "][" + j + "]: ");
            A[i][j] = sc.nextDouble();
        }
        System.out.print("Termino independiente b[" + i + "]: ");
        b[i] = sc.nextDouble();
    }

    int opcion;
    // Ciclo principal del menu
    do {
        System.out.println("\n==============================");
        System.out.println("   SISTEMA DE ECUACIONES  ");
        System.out.println("==============================");
        System.out.println("1. Mostrar sistema ingresado");
        System.out.println("2. Resolver por metodo de Gauss");
        System.out.println("3. Resolver por metodo de Cramer (solo si 3x3)");
        System.out.println("0. Salir");
        System.out.print("Elige una opcion: ");
        opcion = sc.nextInt();

        // Uso de switch para seleccionar la operacion
        switch (opcion) {

            case 1 -> {
                // Muestra el sistema que el usuario introdujo
                System.out.println("\nSistema de ecuaciones:");
                mostrarSistema(A, b);
                pausa(sc);
            }

            case 2 -> {
                // Resuelve el sistema usando eliminacion de Gauss
                System.out.println("\nResolviendo por metodo de Gauss:");
                double[] xGauss = gauss(A, b);
                System.out.println("Solucion (Gauss):");
                imprimirVector(xGauss);
                pausa(sc);
            }

            case 3 -> {
                // Resuelve por metodo de Cramer (solo si es 3x3)
                if (n == 3) {
                    System.out.println("\nResolviendo por metodo de Cramer:");
                    double[] xCramer = cramer(A, b);
                    System.out.println("Solucion (Cramer):");
                    imprimirVector(xCramer);
                } else {
                    System.out.println("El metodo de Cramer solo funciona con sistemas 3x3.");
                }
                pausa(sc);
            }

            case 0 -> System.out.println("\nGracias por usar el sistema de ecuaciones.");

            default -> {
                // Opcion no valida
                System.out.println("\nOpcion invalida, intenta de nuevo.");
                pausa(sc);
            }
        }

    } while (opcion != 0); // Repite hasta que el usuario elija salir
}

/**
 * Muestra el sistema de ecuaciones de forma legible.
 */
public static void mostrarSistema(double[][] A, double[] b) {
    for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[0].length; j++) {
            System.out.print(A[i][j] + "x" + (j + 1));
            if (j < A[0].length - 1) System.out.print(" + ");
        }
        System.out.println(" = " + b[i]);
    }
}

/**
 * Metodo de Eliminacion de Gauss.
 * Convierte la matriz en forma triangular superior y luego aplica sustitucion regresiva.
 */
public static double[] gauss(double[][] A, double[] b) {
    int n = A.length;

    // Clono las matrices para no modificar las originales
    double[][] M = new double[n][n];
    double[] B = new double[n];
    for (int i = 0; i < n; i++) {
        System.arraycopy(A[i], 0, M[i], 0, n);
        B[i] = b[i];
    }

    // Etapa de eliminacion hacia adelante
    for (int k = 0; k < n; k++) {
        // Busco el pivote mas grande en la columna
        double max = Math.abs(M[k][k]);
        int filaMax = k;
        for (int i = k + 1; i < n; i++) {
            if (Math.abs(M[i][k]) > max) {
                max = Math.abs(M[i][k]);
                filaMax = i;
            }
        }

        // Intercambio de filas si es necesario (pivoteo)
        double[] temp = M[k];
        M[k] = M[filaMax];
        M[filaMax] = temp;
        double t = B[k];
        B[k] = B[filaMax];
        B[filaMax] = t;

        // Eliminacion de las variables inferiores
        for (int i = k + 1; i < n; i++) {
            double factor = M[i][k] / M[k][k];
            for (int j = k; j < n; j++) {
                M[i][j] -= factor * M[k][j];
            }
            B[i] -= factor * B[k];
        }
    }

    // Sustitucion regresiva
    double[] x = new double[n];
    for (int i = n - 1; i >= 0; i--) {
        double suma = B[i];
        for (int j = i + 1; j < n; j++) {
            suma -= M[i][j] * x[j];
        }
        x[i] = suma / M[i][i];
    }
    return x;
}

/**
 * Metodo de Cramer (solo para sistemas 3x3).
 * Usa determinantes para calcular cada variable.
 */
public static double[] cramer(double[][] A, double[] b) {
    double detA = determinante3x3(A);
    if (detA == 0) {
        System.out.println("El sistema no tiene solucion unica.");
        return new double[3];
    }

    // Creo matrices reemplazando las columnas por el vector b
    double[][] Ax = reemplazarColumna(A, b, 0);
    double[][] Ay = reemplazarColumna(A, b, 1);
    double[][] Az = reemplazarColumna(A, b, 2);

    // Calculo las variables
    double[] x = new double[3];
    x[0] = determinante3x3(Ax) / detA;
    x[1] = determinante3x3(Ay) / detA;
    x[2] = determinante3x3(Az) / detA;

    return x;
}

/**
 * Reemplaza una columna de la matriz A por el vector b.
 */
public static double[][] reemplazarColumna(double[][] A, double[] b, int col) {
    double[][] M = new double[3][3];
    for (int i = 0; i < 3; i++) {
        System.arraycopy(A[i], 0, M[i], 0, 3);
        M[i][col] = b[i];
    }
    return M;
}

/**
 * Calcula el determinante de una matriz 3x3.
 */
public static double determinante3x3(double[][] m) {
    return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
         - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
         + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
}

/**
 * Imprime el vector solucion en pantalla.
 */
public static void imprimirVector(double[] x) {
    for (int i = 0; i < x.length; i++) {
        System.out.println("x" + (i + 1) + " = " + x[i]);
    }
}

/**
 * Espera que el usuario presione Enter antes de continuar.
 */
public static void pausa(Scanner sc) {
    System.out.println("\nPresiona Enter para continuar...");
    sc.nextLine();
    sc.nextLine();
}

}
